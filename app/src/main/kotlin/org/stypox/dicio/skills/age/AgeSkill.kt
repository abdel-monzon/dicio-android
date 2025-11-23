package org.stypox.dicio.skills.age

import org.stypox.dicio.skills.Skill
import org.stypox.dicio.skills.SkillOutput
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class AgeSkill : Skill<AgeOutput>() {
    
    override suspend fun generateOutput(input: String): AgeOutput {
        // Por ahora usa una fecha fija de prueba
        // Más adelante puedes extraer la fecha del input del usuario
        val birthDate = LocalDate.of(2000, 1, 1)
        val today = LocalDate.now()
        
        val years = ChronoUnit.YEARS.between(birthDate, today).toInt()
        val months = ChronoUnit.MONTHS.between(birthDate, today).toInt() % 12
        val days = ChronoUnit.DAYS.between(birthDate, today).toInt()
        
        return AgeOutput(years, months, days)
    }
}
