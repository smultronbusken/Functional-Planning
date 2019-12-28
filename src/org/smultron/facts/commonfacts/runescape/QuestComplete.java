package org.smultron.framework.planning.facts.commonfacts.runescape;

import org.smultron.framework.info.Quest;
import org.smultron.framework.planning.facts.Fact;

public class QuestComplete extends Fact<Quest, Boolean> {

    public QuestComplete() {
        super(false);
    }

    @Override
    public QuestComplete clone() {
        QuestComplete qc = new QuestComplete();
        qc.setName(name);
        values.forEach(qc::set);
        return qc;
    }

}
