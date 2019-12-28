package org.smultron.planning;

import org.smultron.planning.facts.Effect;
import org.smultron.planning.facts.Operation;
import org.smultron.planning.facts.Precondition;
import org.smultron.planning.worldstate.Action;
import org.smultron.planning.worldstate.ActionInfo;

public enum ExampleActions implements Action
{

    INCREASE(
        Effect.newEffect(
            Operation.add(2, ExampleFacts.MyNumber, null)
        ),
        Precondition.none()
    )

    ;

    private ActionInfo ai;

    ExampleActions(Effect effect, Precondition precondition) {
        this.ai = new ActionInfo(name(), effect, precondition);
    }

    @Override public ActionInfo getActionInfo() {
        return ai;
    }
}
