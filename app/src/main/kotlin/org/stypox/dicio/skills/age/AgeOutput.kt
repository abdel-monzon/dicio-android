package org.stypox.dicio.skills.age

import org.dicio.skill.context.SkillContext
import org.stypox.dicio.io.graphical.HeadlineSpeechSkillOutput

class AgeOutput(
    private val years: Int,
    private val months: Int,
    private val days: Int
) : HeadlineSpeechSkillOutput {
    
    override fun getSpeechOutput(ctx: SkillContext): String {
        return if (years > 0) {
            "Has vivido $years años, $months meses y $days días"
        } else if (months > 0) {
            "Has vivido $months meses y $days días"
        } else {
            "Has vivido $days días"
        }
    }
}
