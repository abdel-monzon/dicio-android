package org.stypox.dicio.skills.age

import org.dicio.skill.context.SkillContext
import org.stypox.dicio.ui.graphic.HeadlineSpeechSkillOutput

class AgeOutput(private val days: Int) : HeadlineSpeechSkillOutput(
    speechText = "Has vivido $days días"
) {
    // Opcional: si usas strings.xml
    // override fun getSpeechOutput(ctx: SkillContext): String {
    //     return ctx.getString(R.string.skill_age_result, days)
    // }
}
