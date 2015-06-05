package com.home.games.bowling;

import java.util.Map.Entry;

public class BowlingImpl implements IBowling {

    private BowlingScoreBoard bowlingScoreBoard = null;

    public BowlingImpl() {
        this.bowlingScoreBoard = new BowlingScoreBoard();
    }

    public void roll(Integer noOfPins) {
        Bowling bowling = null;
        if (this.bowlingScoreBoard.getBonusChances() == 0 && (this.bowlingScoreBoard.getFrameCount() == -1
                || (this.bowlingScoreBoard.getBoardMap().size() == IBowling.MAX_FRAMES+1 ))) {
            System.out.println("Game Over");
        } else if (this.bowlingScoreBoard.getFrameCount() == 0) {
            bowling = new Bowling();
            bowling.setTotalAttempt(1);
            bowling.getScoreList().add(noOfPins);
            this.bowlingScoreBoard.getBoardMap().put(1, bowling);
            if (noOfPins == IBowling.MAX_PINS) {
                if(GameState.STRIKE  == this.bowlingScoreBoard.getGameState() && this.bowlingScoreBoard.getBonusChances() > 0){
                    this.bowlingScoreBoard.setBonusChances(this.bowlingScoreBoard.getBonusChances()-1);
                    bowling.getScoreList().add(noOfPins);
                }else{
                    this.bowlingScoreBoard.setFrameCount(1);
                    this.bowlingScoreBoard.setBonusChances(2);
                    this.bowlingScoreBoard.setGameState(GameState.STRIKE);
                }
            } else {
                this.bowlingScoreBoard.setFrameCount(1);
                this.bowlingScoreBoard.setGameState(GameState.NONE);
            }
        } else if (this.bowlingScoreBoard.getFrameCount() != this.bowlingScoreBoard.getBoardMap().size()) {
            bowling = new Bowling();
            bowling.setTotalAttempt(1);
            bowling.getScoreList().add(noOfPins);
            this.bowlingScoreBoard.getBoardMap().put(this.bowlingScoreBoard.getFrameCount(), bowling);
            if (noOfPins == IBowling.MAX_PINS) {
                this.bowlingScoreBoard.setFrameCount(this.bowlingScoreBoard.getFrameCount() + 1);
                this.bowlingScoreBoard.setGameState(GameState.STRIKE);
            } else {
                this.bowlingScoreBoard.setGameState(GameState.NONE);
            }
        } else {
            bowling = this.bowlingScoreBoard.getBoardMap().get(this.bowlingScoreBoard.getFrameCount());
            bowling.setTotalAttempt(2);
            bowling.getScoreList().add(noOfPins);
            if (bowling.getScore() == IBowling.MAX_PINS) {
                this.bowlingScoreBoard.setFrameCount(this.bowlingScoreBoard.getFrameCount() + 1);
                this.bowlingScoreBoard.setGameState(GameState.SPARE);
            } else {
                this.bowlingScoreBoard.setFrameCount(-1);
                this.bowlingScoreBoard.setGameState(GameState.NONE);
            }
        }
    }

    public Integer score() {
        Integer totalScore = 0;
        if (this.bowlingScoreBoard.getBoardMap() != null) {
            for (Entry<Integer, Bowling> entry : this.bowlingScoreBoard.getBoardMap().entrySet()) {
                Bowling bowling = entry.getValue();
                totalScore += bowling.getScore();
            }
        }
        return totalScore;
    }
}
