package org.smultron.framework.planning;


import org.rspeer.runetek.api.component.tab.Skill;
import org.smultron.framework.info.Quest;
import org.smultron.framework.planning.facts.Condition;
import org.smultron.framework.planning.facts.Effect;
import org.smultron.framework.planning.facts.Operation;
import org.smultron.framework.planning.facts.Precondition;
import org.smultron.framework.planning.worldstate.Action;
import org.smultron.framework.planning.worldstate.ActionInfo;

public enum RunescapeAction implements Action {
    COMPLETE_COOKS_ASSISTANT(
            Effect.newEffect(
                    Operation.makeTrue(RunescapeFact.QuestDone, Quest.COOKS_ASSISTANT)
            ),
            Precondition.newPrecondition(
                    Condition.isNotTrue(RunescapeFact.QuestDone, Quest.COOKS_ASSISTANT)
            )
    ),

    COMPLETE_DRAGON_SLAYERII(
            Effect.newEffect(
                    Operation.makeTrue(RunescapeFact.QuestDone, Quest.DRAGON_SLAYER_II)
            ),
            Precondition.newPrecondition(
                    Condition.greaterThan(RunescapeFact.SkillLevel, 100, Skill.ATTACK),
                    Condition.isTrue(RunescapeFact.QuestDone, Quest.DRAGON_SLAYER),
                    Condition.isNotTrue(RunescapeFact.QuestDone, Quest.DRAGON_SLAYER_II)
            )
    ),

    COMPLETE_DRAGON_SLAYER(
            Effect.newEffect(
                    Operation.makeTrue(RunescapeFact.QuestDone, Quest.DRAGON_SLAYER)
            ),
            Precondition.newPrecondition(
                    Condition.greaterThan(RunescapeFact.SkillLevel, 70, Skill.ATTACK),
                    Condition.isNotTrue(RunescapeFact.QuestDone, Quest.DRAGON_SLAYER)
            )
    ),

    COMPLETE_DORICS_QUEST(
            Effect.newEffect(
                    Operation.add(50, RunescapeFact.SkillLevel, Skill.ATTACK),
                    Operation.makeTrue(RunescapeFact.QuestDone, Quest.DORICS_QUEST)
            ),
            Precondition.newPrecondition(
                    Condition.isNotTrue(RunescapeFact.QuestDone, Quest.DORICS_QUEST)
            )
    ),

    KILL_GOBLIN(
            Effect.newEffect(
                    Operation.add(20, RunescapeFact.SkillLevel, Skill.ATTACK)
            ),
            Precondition.none()
    ),

    NOTHIN(
            Effect.none(),
            Precondition.none()
    )

    ;

    ActionInfo actionInfo;


    RunescapeAction(Effect effects, Precondition preconditions) {
        this.actionInfo = new ActionInfo(name(), effects, preconditions);
    }

    @Override
    public ActionInfo getActionInfo() {
        return actionInfo;
    }
}
