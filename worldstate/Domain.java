package org.smultron.framework.planning.worldstate;

import org.smultron.framework.planning.facts.Condition;
import org.smultron.framework.planning.facts.Effect;
import org.smultron.framework.planning.facts.Fact;
import org.smultron.framework.planning.facts.Precondition;

import java.util.ArrayList;
import java.util.List;

public class Domain implements World {

    private final List<Action> actions;
    private List<Fact> state;

    private Domain(List<Action> actions) {
        this.actions = actions;
    }

    /**
     *
     */
    public Domain(List<FactDescription> domainFacts, List<Action> actions) {
        this.actions = actions;
        state = new ArrayList<>();
        for (FactDescription value : domainFacts) {
            state.add(value.getDomainFactInfo().getFact());
        }
    }

    @Override
    public List<Fact> getState() {
        return state;
    }

    /**
     * @return A {@link List< ActionInfo >} containing all actions whos {@link Precondition}s are met.
     */
    @Override
    public List<Action> getLegalActions() {
        List<Action> legalActions = new ArrayList<>();
        for (Action actionDelegate : actions) {
            // Only add the actions whos precondition is met in this state
            ActionInfo action = actionDelegate.getActionInfo();
            if (action.precondition().test(state)) {
                legalActions.add(actionDelegate);
            }
        }
        return legalActions;
    }

    /**
     * @return True if every goal condition is met
     */
    @Override
    public boolean conditionsAreMet(List<Condition> conditions) {
        for (Condition goalCondition : conditions) {
            if (!goalCondition.test(state)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds an {@link ActionInfo} {@link Effect}s to this state. The actions {@link Precondition}s must be met.
     * @param action the action which should be used
     */
    @Override
    public void doAction(ActionInfo action) {
        if (action.precondition().test(state))
            action.effect().applyEffects(state);
    }

    @Override
    public World clone() {
        Domain p = new Domain(actions);
        p.state = new ArrayList<>();
        for (Fact value : state) {
            p.state.add(value.clone());
        }
        return p;
    }

    @Override
    public String toString() {
        return "actions=" + actions + "\n" +
                "facts=" + state + "\n";
    }
}
