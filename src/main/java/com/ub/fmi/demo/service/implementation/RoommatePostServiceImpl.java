package com.ub.fmi.demo.service.implementation;

import com.ub.fmi.demo.domain.RoommatePost;
import com.ub.fmi.demo.domain.User;
import com.ub.fmi.demo.repository.RoommatePostRepository;
import com.ub.fmi.demo.repository.UserRepository;
import com.ub.fmi.demo.service.RoommatePostService;
import com.ub.fmi.demo.utils.GenderEnum;
import com.ub.fmi.demo.web.rest.dto.MatchingScoreDto;
import com.ub.fmi.demo.web.rest.dto.RoommatePostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoommatePostServiceImpl implements RoommatePostService {

    @Autowired
    private RoommatePostRepository roommatePostRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<RoommatePostDTO> findAllPosts() {
        List<RoommatePost> roommatePosts = roommatePostRepository.findAll();
        List<RoommatePostDTO> roommatePostDTOs = new ArrayList<>();
        for (RoommatePost roommatePost : roommatePosts) {
            User user = userRepository.findByRoommatePost(roommatePost).orElse(null);
            if (user != null) {
                roommatePostDTOs.add(new RoommatePostDTO(roommatePost, user));
            }
        }
        return roommatePostDTOs;
    }

    @Override
    public RoommatePost assignRoommatePostToUser(RoommatePost roommatePost, String username) {
        System.out.println(username);
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            roommatePost.setHasGender(user.getGender());
            user.setRoommatePost(createRoommatePost(roommatePost));
            userRepository.save(user);
            return roommatePost;
        }
        return null;
    }

    @Override
    public List<MatchingScoreDto> findRoommatesByPreferences(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        List<MatchingScoreDto> matchingScoreDtos = new ArrayList<>();
        if (user != null) {
            if (user.getRoommatePost() != null) {
                List<RoommatePost> roommatePosts = roommatePostRepository.findAll();
                roommatePosts.remove(user.getRoommatePost());
                roommatePosts = filterByHasApartment(roommatePosts, user.getRoommatePost().isHasApartment());
                roommatePosts = filterByCity(roommatePosts, user.getRoommatePost().getCity());
                roommatePosts = filterByAcceptGender(roommatePosts, user.getRoommatePost().getRoommateGenderPreference());
                roommatePosts = filterByHasGender(roommatePosts, user.getRoommatePost().getHasGender());
                for (RoommatePost roommatePost : roommatePosts) {
                    User postOwner = userRepository.findByRoommatePost(roommatePost).orElse(null);
                    if (postOwner != null) {
                        RoommatePostDTO roommatePostDTO = new RoommatePostDTO(roommatePost, postOwner);
                        Integer score = calculateMatchingScore(roommatePostDTO, user);
                        matchingScoreDtos.add(new MatchingScoreDto(roommatePostDTO, score));
                    }
                }
            }
            Comparator<MatchingScoreDto> comparatorFunction = (o1,o2) -> {
                if (o1.getScore() > o2.getScore())
                    return -1;
                if (o1.getScore() < o2.getScore())
                    return 1;
                return 0;
            };
            matchingScoreDtos.sort(comparatorFunction);
            return matchingScoreDtos;
        }
        return null;
    }

    public Integer calculateMatchingScore(RoommatePostDTO roommatePostDTO, User user) {
        Integer score = 0;
        if (roommatePostDTO.getHasAge() < user.getRoommatePost().getRoommateMaxAgePreference() && roommatePostDTO.getHasAge() > user.getRoommatePost().getRoommateMinAgePreference()){
            score++;
        }
        if (user.getRoommatePost().getHasAge() > roommatePostDTO.getRoommateMinAgePreference() && user.getRoommatePost().getHasAge() < roommatePostDTO.getRoommateMaxAgePreference()){
            score++;
        }
        if (!roommatePostDTO.isSmoker() || user.getRoommatePost().isAcceptSmoker()) {
            score++;
        }
        if (roommatePostDTO.isAcceptSmoker() || !user.getRoommatePost().isSmoker()){
            score++;
        }
        if (user.getRoommatePost().isAcceptPets() || !roommatePostDTO.isHasPets()) {
            score++;
        }
        if (roommatePostDTO.isAcceptPets() || !user.getRoommatePost().isHasPets()) {
            score++;
        }
        if (user.getRoommatePost().isAcceptNotWorking() || roommatePostDTO.isWorking()) {
            score++;
        }
        if (roommatePostDTO.isAcceptNotWorking() || user.getRoommatePost().isWorking()) {
            score++;
        }
        if (user.getRoommatePost().isAcceptUnorganized() || roommatePostDTO.isOrganized()) {
            score++;
        }
        if (roommatePostDTO.isAcceptUnorganized() || user.getRoommatePost().isOrganized()) {
            score++;
        }
        if (user.getRoommatePost().isAcceptNotResponsible() || roommatePostDTO.isResponsible()) {
            score++;
        }
        if (roommatePostDTO.isAcceptNotResponsible() || user.getRoommatePost().isResponsible()) {
            score++;
        }
        if (user.getRoommatePost().isAcceptUncommunicative() || roommatePostDTO.isCommunicative()) {
            score++;
        }
        if (roommatePostDTO.isAcceptUncommunicative() || user.getRoommatePost().isCommunicative()) {
            score++;
        }
        if (user.getRoommatePost().isAcceptNotPatient() || roommatePostDTO.isPatient()) {
            score++;
        }
        if (roommatePostDTO.isAcceptNotPatient() || user.getRoommatePost().isPatient()) {
            score++;
        }
        if (user.getRoommatePost().isAcceptNotFriendly() || roommatePostDTO.isFriendly()) {
            score++;
        }
        if (roommatePostDTO.isAcceptNotFriendly() || user.getRoommatePost().isFriendly()) {
            score++;
        }
        if (user.getRoommatePost().isAcceptPartyingRoommate() || !roommatePostDTO.isLikesParties()) {
            score++;
        }
        if (roommatePostDTO.isAcceptPartyingRoommate() || !user.getRoommatePost().isLikesParties()) {
            score++;
        }
        if (user.getRoommatePost().isAcceptHomeParties() || !roommatePostDTO.isHasHomeParties()) {
            score++;
        }
        if (roommatePostDTO.isAcceptHomeParties() || !user.getRoommatePost().isHasHomeParties()) {
            score++;
        }
        if (user.getRoommatePost().isAcceptGuests() || !roommatePostDTO.isHasGuests()) {
            score++;
        }
        if (roommatePostDTO.isAcceptGuests() || !user.getRoommatePost().isHasGuests()) {
            score++;
        }
        if (roommatePostDTO.isLookingForAFriend() == user.getRoommatePost().isLookingForAFriend()) {
            score++;
        }

        System.out.println(score);
        return 4 * score;
    }


    public List<RoommatePost> filterByAcceptGender(List<RoommatePost> roommatePosts, GenderEnum roommateGenderPreference) {
        if (roommateGenderPreference != GenderEnum.Any) {
            roommatePosts = roommatePosts.stream()
                    .filter(roommatePost -> roommatePost.getHasGender() == roommateGenderPreference)
                    .collect(Collectors.toList());
        }
        return roommatePosts;
    }

    public List<RoommatePost> filterByHasGender(List<RoommatePost> roommatePosts, GenderEnum hasGender) {
        roommatePosts = roommatePosts.stream()
                .filter(roommatePost -> roommatePost.getRoommateGenderPreference() == hasGender || roommatePost.getRoommateGenderPreference() == GenderEnum.Any)
                .collect(Collectors.toList());
        return  roommatePosts;
    }

//    public List<RoommatePost> filterByHasPets(List<RoommatePost> roommatePosts, Boolean hasPets) {
//        if (hasPets) {
//            roommatePosts = roommatePosts.stream()
//                    .filter(roommatePost -> roommatePost.isAcceptPets() == true)
//                    .collect(Collectors.toList());
//        }
//        return roommatePosts;
//    }

//    public List<RoommatePost> filterByAcceptPets(List<RoommatePost> roommatePosts, Boolean acceptPets) {
//        if (!acceptPets) {
//            roommatePosts = roommatePosts.stream()
//                    .filter(roommatePost -> !roommatePost.isHasPets())
//                    .collect(Collectors.toList());
//        }
//        return roommatePosts;
//    }

    public List<RoommatePost> filterByHasApartment(List<RoommatePost> roommatePosts, Boolean hasApartment) {
        if (hasApartment) {
            roommatePosts = roommatePosts.stream()
                    .filter(roommatePost -> !roommatePost.isHasApartment())
                    .collect(Collectors.toList());
        }
        return roommatePosts;
    }

    public List<RoommatePost> filterByCity(List<RoommatePost> roommatePosts, String city) {
        roommatePosts = roommatePosts.stream()
                .filter(roommatePost -> roommatePost.getCity().compareTo(city) == 0)
                .collect(Collectors.toList());
        return roommatePosts;
    }

    public RoommatePost createRoommatePost(RoommatePost roommatePost) {
        return roommatePostRepository.save(roommatePost);
    }
}
