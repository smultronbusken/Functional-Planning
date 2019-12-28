package org.smultron.framework.planning.facts;

import org.smultron.framework.planning.worldstate.FactDescription;

import java.util.List;
import java.util.function.Predicate;

public class Condition<T, R, F extends Fact<T, R>> {

    private FactDescription domainFact;
    private Predicate<R> predicate;
    private T argument;

    public Condition(FactDescription domainFact, Predicate<R> predicate, T argument) {
        this.predicate = predicate;
        this.argument = argument;
        this.domainFact = domainFact;

    }

    public boolean test(List<Fact> facts) {
        Fact fact = Fact.getFact(facts, domainFact.getDomainFactInfo().name());
        return predicate.test((R) fact.get(argument));
    }

    public static Condition<?, Integer, ? extends Fact<?, Integer>> greaterThan(FactDescription f, int value, Object argument) {
        Predicate<Integer> pred = n -> n > value;
        return new Condition<>(f, pred, argument);
    }

    public static Condition<?, Boolean, ? extends Fact<?, Boolean>> isTrue(FactDescription f, Object argument) {
        Predicate<Boolean> pred = n -> n;
        return new Condition<>(f, pred, argument);
    }

    public static Condition<?, Boolean, ? extends Fact<?, Boolean>> isNotTrue(FactDescription f, Object argument) {
        Predicate<Boolean> pred = n -> !n;
        return new Condition<>(f, pred, argument);
    }
}
