package org.stypox.dicio.skills.age

import org.dicio.skill.context.SkillContext
import org.dicio.skill.skill.Skill
import org.dicio.skill.skill.SkillOutput
import org.dicio.skill.skill.Score
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class AgeSkill : Skill<Unit>(AgeInfo, Score.GOOD) {
    
    override fun score(ctx: SkillContext, input: String): Pair<Score, Unit> {
        // Si la entrada contiene palabras relacionadas con edad/días/vivir, devolvemos GOOD
        val ageKeywords = listOf("age", "años", "días", "viv", "old", "tiempo", "how long")
        val containsAgeWord = ageKeywords.any { keyword -> 
            input.contains(keyword, ignoreCase = true) 
        }
        
        return if (containsAgeWord) {
            Pair(Score.GOOD, Unit)
        } else {
            Pair(Score.BAD, Unit)
        }
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
