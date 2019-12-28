package org.smultron.planning.facts.commonfacts;

import org.smultron.planning.facts.NonParametirizedFact;

public class Number extends NonParametirizedFact<Integer> {

    public Number(Integer startValue) {
        super(startValue);
    }

    @Override
    public Number clone() {
        Number clone = new Number(values().get(0));
        clone.setName(name);
        return clone;
    }
}
