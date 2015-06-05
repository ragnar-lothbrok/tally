package com.home.games.bowling;

public interface IBowling {

    final public static Integer MAX_TRY = 2;
    final public static Integer MAX_FRAMES = 10;
    final public static Integer MAX_PINS = 10;

    void roll(Integer noOfPins);

    Integer score();

}
