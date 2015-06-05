package com.home.games.bowling;

import java.util.ArrayList;
import java.util.List;

public class Bowling {

    private Integer totalAttempt;
    private List<Integer> scoreList;

    public Integer getTotalAttempt() {
        return totalAttempt;
    }

    public void setTotalAttempt(Integer totalAttempt) {
        this.totalAttempt = totalAttempt;
    }

    public List<Integer> getScoreList() {
        if (this.scoreList == null)
            this.scoreList = new ArrayList<Integer>();
        return scoreList;
    }

    public void setScoreList(List<Integer> scoreList) {
        this.scoreList = scoreList;
    }

    public Integer getScore() {
        Integer totalScore = 0;
        if (this.scoreList != null) {
            for (Integer score : scoreList) {
                totalScore += score;
            }
        }
        return totalScore;
    }

}
