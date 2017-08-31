package com.game.tennis;

/**
 * @author Ernestas
 */
public class TennisBootstrap {

    public static void main(String[] args) {
        int pp1;
        int pp2;
        try {
            pp1 = Integer.valueOf(args[0]);
            pp2 =Integer.valueOf(args[1]);
        } catch (Exception e) {
            throw new IllegalStateException("Passed bad parameters!", e);
        }
        Tennis.start(pp1, pp2);
    }
}
