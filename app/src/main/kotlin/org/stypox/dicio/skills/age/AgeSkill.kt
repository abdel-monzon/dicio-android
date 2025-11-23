package org.stypox.dicio.skills.age

import org.dicio.skill.context.SkillContext
import org.dicio.skill.skill.Skill
import org.dicio.skill.skill.SkillOutput
import org.dicio.skill.skill.Specificity
import org.dicio.skill.standard.StandardScore
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class AgeSkill : Skill<Unit>(AgeInfo, Specificity.HIGH) {
    
    override fun score(ctx: SkillContext, input: String): Pair<StandardScore, Unit> {
        // Detectar si la entrada es sobre edad/días/vida
        val ageKeywords = listOf("age", "años", "días", "viv", "old", "tiempo", "how long", "cuántos", "cuanto")
        val containsAgeWord = ageKeywords.any { keyword -> 
            input.contains(keyword, ignoreCase = true) 
        }
        
        return if (containsAgeWord) {
            // Score alto cuando detecta palabras relacionadas con edad
            Pair(StandardScore(
                userMatched = 1.0f,
                userWeight = 1.0f, 
                refMatched = 1.0f,
                refWeight = 1.0f,
                capturingGroups = null
            ), Unit)
        } else {
            // Score bajo cuando no detecta palabras relacionadas
            Pair(StandardScore.EMPTY, Unit)
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
