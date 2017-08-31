package com.game.tennis.resolver;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Ernestas
 *
 * @see #init()
 */
public final class Score {

    private static String[] SCORE_VALUES;
    public static final Map<Integer, String> SCORES_MAP = Collections.unmodifiableMap(init());

    /** VALID IDX VALUES */
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    /** initializes all artifacts */
   private static Map<Integer, String> init() {
       SCORE_VALUES = new String[]{"LOVE", "FIFTEEN", "THIRTY", "FORTY"};
       return IntStream.range(0, SCORE_VALUES.length).boxed().collect(Collectors.toMap(Function.identity(), i -> SCORE_VALUES[i]));
   }

   /** helps to access SCORE_VALUE from outside world, but prevents from state change
    * @param idx should be valid
    *
    * @see #LOVE
    * @see #FIFTEEN
    * @see #THIRTY
    * @see #FORTY
    */
   public static String getScoreDisplayValue(int idx) {
       try {
           return SCORE_VALUES[idx];
       } catch (Exception e) {
           // TODO Ernestas: log ERROR
           throw new IllegalArgumentException(String.format("Wrong index (\"%s\")!", idx));
       }
   }

}
