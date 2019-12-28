package org.smultron.planning.worldstate;

import org.smultron.planning.facts.Condition;
import org.smultron.planning.facts.Fact;

import java.util.List;

public interface World extends Cloneable {

    /**
     * @return Every {@link Fact} of this state
     */
    public List<Fact> getState();

    /**
     * @return Every applicable action in this state.
     */
    public List<Action> getLegalActions();

    /**
     * @return True if every {@link FactContent} in this state is also true in {@code other}.
     */
    public boolean conditionsAreMet(List<Condition> conditions);

    /**
     * Applies the effect of an {@link ActionInfo} to this state.
     * @param action the action which should be used
     */
    public void doAction(ActionInfo action);

    /**
     * @return a deep copy of this object.
     */
    public World clone();

}
