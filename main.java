package org.smultron.framework.planning;

import org.smultron.framework.info.Quest;
import org.smultron.framework.planning.facts.Condition;
import org.smultron.framework.planning.search.Planner;
import org.smultron.framework.planning.worldstate.Domain;
import org.smultron.framework.planning.worldstate.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {

        World worldState = new Domain(
                Arrays.asList(RunescapeFact.values()),
                Arrays.asList(RunescapeAction.values())
        );

        List<Condition> goal = new ArrayList<>();
        goal.add(Condition.isTrue(RunescapeFact.QuestDone, Quest.DRAGON_SLAYER_II));
        goal.add(Condition.isTrue(RunescapeFact.QuestDone, Quest.DRAGON_SLAYER_II));

        System.out.println(Planner.BFS(worldState, goal));
    }
}

