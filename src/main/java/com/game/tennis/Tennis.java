package com.game.tennis;

import com.game.tennis.resolver.ScoreValue;

/**
 * @author Ernestas
 */
public final class Tennis {

    private Tennis() {
        throw new IllegalStateException("Please, don't use reflection to instantiate it!");
    }

    /** 'template' method */
    public static Result start(int pp1, int pp2) {
        if (Math.min(pp1, pp2) < 0) {
            throw new IllegalArgumentException("All scores should be positive!");
        }
        final ScoreValue val = new ScoreValue(pp1, pp2);

        final String result = ControllersProvider.RESOLVERS.stream().filter(controller -> controller.applicable(val))
                               .map(controller -> controller.getResult(val)).findAny().orElseGet(() -> ControllersProvider.DEFAULT.getResult(val));
        // TODO Ernestas: log relevant information within TRACE level
        return new Result(result);
    }
}
