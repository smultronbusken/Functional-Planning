package org.smultron.framework.planning.facts;

import org.smultron.framework.planning.worldstate.FactDescription;

import java.util.List;
import java.util.function.BiFunction;

/**
 *
 * @param <R>
 * @param <F>
 */
@SuppressWarnings("ALL")
public class Operation<T, R, F extends Fact<T, R>> {

    private FactDescription domainFact;
    private BiFunction<T, F, R> op;
    private T argument;

    public Operation(FactDescription domainFact, BiFunction<T, F, R> op, T argument) {
        this.op = op;
        this.domainFact = domainFact;
        this.argument = argument;
    }

    public R apply(List<Fact> facts) {
        F fact = (F) Fact.getFact(facts, domainFact.getDomainFactInfo().name()); // Get the correct Fact
        R value = op.apply(argument, fact); // Do the operation on the correct Fact value
        fact.set(argument, value); // Update the Fact value
        return value;
    }

    /**
     * @return An operation which adds a number
     */
    public static Operation add(int value, FactDescription f, Object arg) {
        BiFunction<?, ? extends Fact<?, Integer>, Integer> func = (argument, fact) -> fact.get(argument) + value;
        return new Operation(f, func, arg);
    }


    /**
     * @return An operation which minus a number
     */
    public static Operation minus(int value, FactDescription f, Object arg) {
        BiFunction<?, ? extends Fact<?, Integer>, Integer> func = (argument, fact) -> fact.get(argument) - value;
        return new Operation(f, func, arg);
    }

    /**
     * @return An operation which multiplies a number
     */
    public static Operation multiplication(int value, FactDescription f, Object arg) {
        BiFunction<?, ? extends Fact<?, Integer>, Integer> func = (argument, fact) -> fact.get(argument) * value;
        return new Operation(f, func, arg);
    }

    /**
     * @return An operation which makes a fact value true
     */
    public static Operation makeTrue(FactDescription f, Object arg) {
        BiFunction<?, ?, Boolean> func = (argument, fact) -> true;
        return new Operation(f, func, arg);
    }

    /**
     * @return An operation which makes a fact value false
     */
    public static Operation makeFalse(FactDescription f, Object arg) {
        BiFunction<?, ?, Boolean> func = (argument, fact) -> false;
        return new Operation(f, func, arg);
    }
}
