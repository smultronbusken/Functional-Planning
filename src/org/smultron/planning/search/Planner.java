package org.smultron.planning.search;

import org.smultron.planning.facts.Condition;
import org.smultron.planning.facts.Fact;
import org.smultron.planning.worldstate.Action;
import org.smultron.planning.worldstate.ActionInfo;
import org.smultron.planning.worldstate.World;

import java.util.*;

public class Planner {

    /**
     * Performs BFS-search
     * @return A list of actions which if executed in order will make the {@link World} meet its goal conditions.
     */
    public static List<Action> BFS(World worldState, List<Condition> goalConditions){



        List<List<Fact>> visited = new ArrayList<>();
        Deque<Node> frontier = new ArrayDeque<>();

        // Declare the start node with no parent
        Node startNode = new Node(worldState, null, ActionInfo.NO_OP(), 0);
        frontier.add(startNode);

        while (!frontier.isEmpty()) {
            // Get the next node to check
            Node node = frontier.pop();

            if(node.state.conditionsAreMet(goalConditions)) {
                return buildPlan(node);
            }

            // Get all the available actions in that state.
            List<Action> actions = node.state.getLegalActions();

            // Make a new node for each available action in this state.
            for (Action actionDelegate : actions) {
                ActionInfo action = actionDelegate.getActionInfo();
                World p = node.state.clone();
                p.doAction(action);

                Node child = new Node(p, node, actionDelegate, action.cost());

                // Only add this state if we havent previously checked that state
                if(!visited.contains(p.getState())) {
                    visited.add(p.getState());
                    frontier.add(child);
                }
            }
        }
        System.out.println("No plan could be found!");
        return null;
    };

    /**
     * @param node The starting node
     * @return A list of each node´s action.
     */
    private static List<Action> buildPlan(Node node) {
        List<Action> plan = new ArrayList<>();
        while(node.parent != null){
            plan.add(node.action);
            node = node.parent;
        }
        Collections.reverse(plan);
        return plan;
    }

}
