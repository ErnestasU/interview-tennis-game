package com.game.tennis;

import java.io.Serializable;

/**
 * @author Ernestas
 * <p>
 *  Could have additional information if needed e.g. game duration
 * </p>
 */
public final class Result implements Serializable {

    private final String res;

    public Result(String res) {
        this.res = res;
    }

    public String getResult() {
        return res;
    }
}
