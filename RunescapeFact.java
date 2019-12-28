package org.smultron.framework.planning;

import org.smultron.framework.planning.facts.Fact;
import org.smultron.framework.planning.facts.commonfacts.runescape.QuestComplete;
import org.smultron.framework.planning.facts.commonfacts.runescape.SkillLevel;
import org.smultron.framework.planning.worldstate.FactDescription;
import org.smultron.framework.planning.worldstate.FactDescriptionInfo;

import java.util.function.Supplier;

public enum RunescapeFact implements FactDescription {

    QuestDone(QuestComplete::new),

    SkillLevel(SkillLevel::new)

    ;

    private FactDescriptionInfo domainFact;

    RunescapeFact(Supplier<Fact> fact) {
        domainFact = new FactDescriptionInfo(fact, name());
    }

    public FactDescriptionInfo getDomainFactInfo() {
        return domainFact;
    }

}
