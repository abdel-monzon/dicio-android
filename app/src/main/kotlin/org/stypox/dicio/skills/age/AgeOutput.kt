package org.stypox.dicio.skills.age

import org.dicio.skill.context.SkillContext
import org.stypox.dicio.ui.graphic.HeadlineSpeechSkillOutput
import org.stypox.dicio.util.getString

class AgeOutput(
    private val days: Int
) : HeadlineSpeechSkillOutput(
    speechText = "Has vivido $days días" // Texto directo para prueba
) {
    // Si tienes string resources, usa:
    // speechText = ctx.getString(R.string.skill_age_result, days)
}
