package com.game.tennis.resolver;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Ernestas
 */
public abstract class Resolver {

    /** Predicate to check whether controller is applicable for a case*/
    private Predicate<ScoreValue> checkIfApplicable;
    /** if input went through the predicate, then this one should return appropriate result */
    private Function<ScoreValue, String> scoreValueFunction;

    public Resolver(Predicate<ScoreValue> checkIfApplicable, Function<ScoreValue, String> scoreValueFunction) {
        this.checkIfApplicable = checkIfApplicable;
        this.scoreValueFunction = scoreValueFunction;
    }

    public final boolean applicable(ScoreValue s) {
        return checkIfApplicable.test(s);
    }

    public String getResult(ScoreValue s) {
        return scoreValueFunction.apply(s);
    }

    /** IMPLEMENTATIONS */

    /** Match ends with DRAW */
    public static class DeuceResolver extends Resolver {

        private static Predicate<ScoreValue> EQUALS_AND_GREATER_EQ_3 = s -> s.getPp1() == s.getPp2() && s.getPp1() > 3;

        public DeuceResolver() {
            super(EQUALS_AND_GREATER_EQ_3,  s -> "DEUCE");
        }
    }

    /** Someone has an advantage over opponent*/
    public static class AdvantageResolver extends Resolver {

        private static Predicate<ScoreValue> GREATER_THAN_3 = s -> s.getPp1() >= 3;
        private static Predicate<ScoreValue> DIFF_EQ_1 =  s -> Math.abs(s.getPp1()-s.getPp2()) == 1;

        public AdvantageResolver() {
            super(GREATER_THAN_3.and(DIFF_EQ_1), (s) -> s.getPp1() > s.getPp2() ? "Advantage Player1" : "Advantage Player2");
        }
    }

    /** Someone has won */
    public static class VictoryResolver extends Resolver {

        private static Predicate<ScoreValue> GREATER_EQ_4 = s -> (s.getPp1() >= 4 || s.getPp2() >= 4);
        private static Predicate<ScoreValue> DIFF_GREATER_EQ_2 =  s -> Math.abs(s.getPp2()-s.getPp1()) >=2;

        public VictoryResolver() {
            super(GREATER_EQ_4.and(DIFF_GREATER_EQ_2), s->s.getPp1()-s.getPp2() >=2 ? "Won Player1" : "Won Player2");
        }
    }

    /** Used to handle other cases */
    public static class OtherResolver extends Resolver {

        private static String resolve(int s) {
            return Optional.ofNullable(Score.SCORES_MAP.get(s)).orElseThrow(IllegalArgumentException::new);
        }

        public OtherResolver() {
            super(s -> true, s -> resolve(s.getPp1()) + "-" + resolve(s.getPp2()));
        }
    }
}
