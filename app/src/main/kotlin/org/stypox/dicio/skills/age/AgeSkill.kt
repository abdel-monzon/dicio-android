package org.stypox.dicio.skills.age

import org.dicio.skill.context.SkillContext
import org.dicio.skill.skill.Skill
import org.dicio.skill.skill.SkillOutput
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class AgeSkill : Skill<Unit>(AgeInfo, org.dicio.skill.skill.Score.GOOD) {
    
    override fun score(ctx: SkillContext, input: String): Pair<org.dicio.skill.skill.Score, Unit> {
        return Pair(org.dicio.skill.skill.Score.GOOD, Unit)
    }
    
    override suspend fun generateOutput(ctx: SkillContext, inputData: Unit): SkillOutput {
        val birthDate = LocalDate.of(2000, 1, 1)
        val today = LocalDate.now()
        
        val years = ChronoUnit.YEARS.between(birthDate, today).toInt()
        val months = ChronoUnit.MONTHS.between(birthDate, today).toInt() % 12
        val days = ChronoUnit.DAYS.between(birthDate, today).toInt()
        
        return AgeOutput(years, months, days)
    }
}
