package org.smultron.planning;

import org.smultron.planning.facts.Fact;
import org.smultron.planning.facts.commonfacts.Number;
import org.smultron.planning.worldstate.FactDescription;
import org.smultron.planning.worldstate.FactDescriptionInfo;

import java.util.function.Supplier;

public enum ExampleFacts implements FactDescription
{

    MyNumber(
        () -> new Number(10)
    )

    ;

    private FactDescriptionInfo fdi;

    ExampleFacts(final Supplier<Fact> fact) {
        this.fdi = new FactDescriptionInfo(fact, name());
    }

    @Override public FactDescriptionInfo getDomainFactInfo() {
        return fdi;
    }
}
