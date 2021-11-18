package com.ub.fmi.demo.security;

import com.ub.fmi.demo.domain.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

//import static io.jsonwebtoken.Jwts.parserBuilder;

@Component
public class JwtTokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
    public static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String INVITATION_TOKEN_ISSUER = "DATC";
    private static final long TOKEN_VALIDITY_ONE_MONTH_IN_SECONDS = 259200 * 10;

    // @Value("")
    private static String base64Secret =
            "NDg0NTlkZDZlYTViZmEzZjhjNWYxMmUxNTNiM2Q3NWY3MzYwZWYzMTQyYTEwMGE5YWU4ZTRjYzI5MjEyNDExODZkZTdmZTU0Mzk4ZjVmNzg4ZGEzMzM0MWUzNjQ2ZDQyZGQwOGZmN2Y5YTY3ZjFiODg3YTVjN2E1NDhjMmJkNGQ=";

    private static Key key;

    public JwtTokenProvider() {
        JwtTokenProvider.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(base64Secret));
    }

    public static String createToken(User user) {

        Map<String, String> tokenClaims = new HashMap<>();

        String role = user.getRole().getName();
        tokenClaims.put("role", role);


        LocalDateTime expirationDateTime =
                LocalDateTime.now().plusSeconds(TOKEN_VALIDITY_ONE_MONTH_IN_SECONDS);
        Date validity = Date.from(expirationDateTime.atZone(ZoneId.systemDefault()).toInstant());

        return buildToken(user.getUsername(), tokenClaims, validity);
    }

    public static Authentication getAuthentication(String token) {
        if (token != null && token.length() > 0) {
            try {
                Claims claims = parseAndVerifyJwtToken(token).getBody();

                List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority(claims.get("role").toString()));

                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(claims.getSubject(), token, authorities);
                authenticationToken.setDetails(claims);

                return authenticationToken;
            } catch (Exception e) {
                logger.debug("Error parsing the access token resource access keys", e);
            }
        }
        return null;
    }

    private static Jws<Claims> parseAndVerifyJwtToken(String authToken) throws Exception {
        JwtParser jwtParser = Jwts.parser().setSigningKey(key);
        return jwtParser.parseClaimsJws(authToken);
    }

    private static String buildToken(String subject, Map<String, String> claims, Date validity) {
        // Create a JWT Token
        JwtBuilder jwt =
                Jwts.builder().setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                        .signWith(SignatureAlgorithm.HS512, key).setExpiration(validity)
                        .setIssuer(INVITATION_TOKEN_ISSUER).setId(UUID.randomUUID().toString());

        // Add claims to JWT Token
        for (String claimsKey : claims.keySet()) {
            jwt.claim(claimsKey, claims.get(claimsKey));
        }

        return jwt.compact();
    }

}
