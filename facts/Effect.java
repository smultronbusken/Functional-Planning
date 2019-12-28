package org.smultron.framework.planning.facts;

import java.util.Arrays;
import java.util.List;

public final class Effect {

    private Operation[] operations;

    private Effect(Operation... operations) {
        this.operations = operations;
    }

    public static Effect none() {
        return new Effect();
    }

    public void applyEffects(List<Fact> facts) {
        Arrays.stream(operations).forEach(op -> op.apply(facts));
    }

    public static Effect newEffect(Operation... operations) {
        return new Effect(operations);
    }

}
