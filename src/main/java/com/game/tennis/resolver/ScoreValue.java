package com.game.tennis.resolver;


import java.io.Serializable;

/**
 * @author Ernestas
 * <p>
 *  simple POJO containing primitives
 * </p>
*/
public class ScoreValue implements Serializable {

    private final int pp1;
    private final int pp2;

    public ScoreValue(int pp1, int pp2) {
        this.pp1 = pp1;
        this.pp2 = pp2;
    }

    public int getPp1() {
        return pp1;
    }

    public int getPp2() {
        return pp2;
    }
}