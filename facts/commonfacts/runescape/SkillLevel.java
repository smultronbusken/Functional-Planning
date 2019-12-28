package org.smultron.framework.planning.facts.commonfacts.runescape;

import org.rspeer.runetek.api.component.tab.Skill;
import org.smultron.framework.planning.facts.Fact;

public class SkillLevel  extends Fact<Skill, Integer> {

    public SkillLevel() {
        super(1);
    }

    @Override
    public SkillLevel clone() {
        SkillLevel qc = new SkillLevel();
        qc.setName(name);
        values.forEach(qc::set);
        return qc;
    }
}
