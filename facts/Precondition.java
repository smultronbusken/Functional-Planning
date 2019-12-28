package org.smultron.framework.planning.facts;

import java.util.List;

public final class Precondition {

    public Condition<?, ?, ?>[] getConditions() {
        return conditions;
    }

    private Condition<?, ?, ?>[] conditions;

    private Precondition(Condition<?, ?, ?>... conditions) {
        this.conditions = conditions;
    }

    public static Precondition none() {
        return new Precondition();
    }

    public boolean test(List<Fact> facts) {
        for (Condition<?, ?, ?> condition : conditions) {
            if (!condition.test(facts))
                return false;
        }
        return true;
    }

    public static Precondition newPrecondition(Condition<?, ?, ?>... conditions) {
        return new Precondition(conditions);
    }
}
