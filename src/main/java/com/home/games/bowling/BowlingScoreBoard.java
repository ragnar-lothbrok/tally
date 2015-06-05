package com.home.games.bowling;

import java.util.LinkedHashMap;
import java.util.Map;

public class BowlingScoreBoard {

    private Integer frameCount = 0;

    private Integer bonusChances;

    private GameState gameState = GameState.NONE;

    Map<Integer, Bowling> boardMap = null;

    public BowlingScoreBoard() {
    }

    public Map<Integer, Bowling> getBoardMap() {
        if (boardMap == null)
            boardMap = new LinkedHashMap<Integer, Bowling>();
        return boardMap;
    }

    public void setBoardMap(Map<Integer, Bowling> boardMap) {
        this.boardMap = boardMap;
    }

    public Integer getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(Integer frameCount) {
        this.frameCount = frameCount;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Integer getBonusChances() {
        return bonusChances;
    }

    public void setBonusChances(Integer bonusChances) {
        this.bonusChances = bonusChances;
    }

}
