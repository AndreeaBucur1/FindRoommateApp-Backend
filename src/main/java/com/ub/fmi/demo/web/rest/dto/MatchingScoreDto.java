package com.ub.fmi.demo.web.rest.dto;

public class MatchingScoreDto {

    private RoommatePostDTO roommatePostDTO;

    private Integer score;

    public MatchingScoreDto(RoommatePostDTO roommatePostDTO, Integer score) {
        this.roommatePostDTO = roommatePostDTO;
        this.score = score;
    }

    public RoommatePostDTO getRoommatePostDTO() {
        return roommatePostDTO;
    }

    public void setRoommatePostDTO(RoommatePostDTO roommatePostDTO) {
        this.roommatePostDTO = roommatePostDTO;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
