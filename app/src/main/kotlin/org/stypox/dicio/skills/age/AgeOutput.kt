package org.stypox.dicio.skills.age

import org.dicio.skill.context.SkillContext
import org.dicio.skill.skill.SkillOutput

class AgeOutput(
    private val years: Int,
    private val months: Int,
    private val days: Int
) : SkillOutput {
    
    override fun speak(ctx: SkillContext): String {
        return if (years > 0) {
            "Has vivido $years años, $months meses y $days días"
        } else if (months > 0) {
            "Has vivido $months meses y $days días"
        } else {
            "Has vivido $days días"
        }
    }
    
    override fun display(ctx: SkillContext): String {
        return speak(ctx)
    }
}
