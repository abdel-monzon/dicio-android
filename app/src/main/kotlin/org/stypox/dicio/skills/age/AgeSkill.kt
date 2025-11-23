package org.stypox.dicio.skills.age

import org.dicio.skill.context.SkillContext
import org.dicio.skill.skill.Skill
import org.dicio.skill.skill.SkillOutput
import org.dicio.skill.skill.Score
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class AgeSkill : Skill<Unit>(AgeInfo, Score(0.8f)) {
    
    override fun score(ctx: SkillContext, input: String): Pair<Score, Unit> {
        // Por ahora, siempre devolvemos un score de 0.8 para cualquier input
        return Pair(Score(0.8f), Unit)
    }
    
    override suspend fun generateOutput(ctx: SkillContext, inputData: Unit): SkillOutput {
        // Fecha de nacimiento de ejemplo
        val birthDate = LocalDate.of(2000, 1, 1)
        val today = LocalDate.now()
        
        val years = ChronoUnit.YEARS.between(birthDate, today).toInt()
        val months = ChronoUnit.MONTHS.between(birthDate, today).toInt() % 12
        val days = ChronoUnit.DAYS.between(birthDate, today).toInt()
        
        return AgeOutput(years, months, days)
    }
}
