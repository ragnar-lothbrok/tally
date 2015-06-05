package com.home.games.bowling;

public class TestClass {

    
    public static void main(String[] args) {
        
        BowlingImpl bowlingImpl = new BowlingImpl();
        bowlingImpl.roll(10);
        bowlingImpl.roll(5);
        bowlingImpl.roll(5);
        
        bowlingImpl.roll(10);
        bowlingImpl.roll(5);
        bowlingImpl.roll(5);
        
        bowlingImpl.roll(10);
        bowlingImpl.roll(5);
        bowlingImpl.roll(5);
        
        bowlingImpl.roll(10);
        bowlingImpl.roll(5);
        bowlingImpl.roll(4);
        
        bowlingImpl.roll(10);
        bowlingImpl.roll(5);
        bowlingImpl.roll(5);
        
        bowlingImpl.roll(5);
        
        System.out.println(bowlingImpl.score());
        
    }
}
