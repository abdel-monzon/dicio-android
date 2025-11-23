package org.stypox.dicio.skills.age

import org.stypox.dicio.skills.Skill
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class AgeSkill : Skill<AgeOutput>() {
    
    override suspend fun generateOutput(input: String): AgeOutput {
        // Fecha de nacimiento de ejemplo
        val birthDate = LocalDate.of(2000, 1, 1)
        val today = LocalDate.now()
        
        val years = ChronoUnit.YEARS.between(birthDate, today).toInt()
        val months = ChronoUnit.MONTHS.between(birthDate, today).toInt() % 12
        val days = ChronoUnit.DAYS.between(birthDate, today).toInt()
        
        return AgeOutput(years, months, days)
    }
}
