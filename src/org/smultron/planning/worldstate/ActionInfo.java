package org.smultron.planning.worldstate;

import org.smultron.planning.facts.Effect;
import org.smultron.planning.facts.Precondition;

public final class ActionInfo {

    private final Effect effect;
    private final Precondition precondition;
    private final int cost;
    private final String name;

    public ActionInfo(String name, Effect effects, Precondition preconditions) {
        this.effect = effects;
        this.precondition = preconditions;
        cost = 1;
        this.name = name;
    }

    public ActionInfo(String name, Effect effects, Precondition preconditions, int cost) {
        this.effect = effects;
        this.precondition = preconditions;
        this.cost = cost;
        this.name = name;
    }

    public int cost() {
        return cost;
    }

    public Effect effect() {
        return effect;
    }

    public Precondition precondition() {
        return precondition;
    }

    public static Action NO_OP() {
        return new Action() {
            @Override
            public ActionInfo getActionInfo() {
                return new ActionInfo("NO_OP", Effect.none(), Precondition.none(), 0);
            }
        };
    }

    @Override
    public String toString() {
        return name;
    }
}
