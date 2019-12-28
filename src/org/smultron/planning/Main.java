package org.smultron.planning;

import org.smultron.planning.facts.Condition;
import org.smultron.planning.search.Planner;
import org.smultron.planning.worldstate.Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args) {

        Domain domain = new Domain(
            Arrays.asList(ExampleFacts.values()),
            Arrays.asList(ExampleActions.values())
        );

        List<Condition> goal = new ArrayList<>();
        goal.add(Condition.greaterThan(ExampleFacts.MyNumber, 20,null));

        System.out.println(Planner.BFS(domain, goal));

    }
}

