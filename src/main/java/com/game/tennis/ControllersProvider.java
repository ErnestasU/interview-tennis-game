package com.game.tennis;

import com.game.tennis.resolver.Resolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ControllersProvider {

    public static final List<Resolver> RESOLVERS = Collections.unmodifiableList(init());
    public static final Resolver DEFAULT = new Resolver.OtherResolver();

    private ControllersProvider() {
        throw new IllegalStateException("Please, don't use reflection to instantiate it!");
    }

    /** this place should be the one who initializes all controllers except DEFAULT*/
    private static List<Resolver> init() {
        List<Resolver> result = new ArrayList<>();
        result.add(new Resolver.AdvantageResolver());
        result.add(new Resolver.DeuceResolver());
        result.add(new Resolver.VictoryResolver());
        return result;
    }
}
