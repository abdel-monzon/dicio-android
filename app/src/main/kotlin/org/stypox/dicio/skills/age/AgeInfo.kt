package org.stypox.dicio.skills.age

import org.stypox.dicio.sentences.Sentences
import org.stypox.dicio.skills.SkillContext
import org.stypox.dicio.skills.SkillInfo
import org.stypox.dicio.skills.StandardRecognizerData

object AgeInfo : SkillInfo("age") {
    override fun name(ctx: SkillContext) = "Age Calculator"
    override fun sentenceExample(ctx: SkillContext) = "How many days do I have?"
    override fun icon(ctx: SkillContext) = org.stypox.dicio.R.drawable.ic_calculator

    override fun isAvailable(ctx: SkillContext): Boolean {
        return Sentences.Age[ctx.sentencesLanguage] != null
    }

    override fun build(ctx: SkillContext) = AgeSkill(this, Sentences.Age[ctx.sentencesLanguage]!!)
}
