package org.smultron.planning.search;

import org.smultron.planning.worldstate.Action;
import org.smultron.planning.worldstate.ActionInfo;
import org.smultron.planning.worldstate.World;

public class Node {

    public World state;
    public Action action;
    public Node parent;
    public int cost;

    /**
     *
     * @param state Which {@link World} we ended up in after executing {@code action} in {@code parent}´s {@link World}
     * @param parent The previous node
     * @param action Which {@link ActionInfo} was used on the {@code parent}
     * @param cost The step cost from {@code parent} to this node.
     */
    public Node(World state, Node parent, Action action, int cost) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.cost = cost;
    }


}
