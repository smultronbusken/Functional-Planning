package org.smultron.framework.planning.worldstate;


import org.smultron.framework.planning.facts.Fact;

import java.util.function.Supplier;

public final class FactDescriptionInfo {

    private Supplier<Fact> fact;
    private String name;

    public FactDescriptionInfo(Supplier<Fact> fact, String name) {
        this.fact = fact;
        this.name = name;
    }

    public Fact getFact() {
        Fact f = fact.get();
        f.setName(name);
        return f;
    }

    public String name() {
        return name;
    }

}
