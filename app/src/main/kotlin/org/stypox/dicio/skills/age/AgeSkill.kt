package org.stypox.dicio.skills.age

import org.dicio.skill.context.SkillContext
import org.dicio.skill.skill.SkillInfo
import org.dicio.skill.skill.SkillOutput
import org.dicio.skill.standard.StandardRecognizerData
import org.dicio.skill.standard.StandardRecognizerSkill
import org.stypox.dicio.sentences.Sentences.Age
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class AgeSkill(
    correspondingSkillInfo: SkillInfo,
    data: StandardRecognizerData<Age>
) : StandardRecognizerSkill<Age>(correspondingSkillInfo, data) {
    
    override suspend fun generateOutput(ctx: SkillContext, inputData: Age): SkillOutput {
        // Fecha de nacimiento de ejemplo - luego puedes extraerla del input del usuario
        val birthDate = LocalDate.of(2000, 1, 1)
        val today = LocalDate.now()
        
        val years = ChronoUnit.YEARS.between(birthDate, today).toInt()
        val months = ChronoUnit.MONTHS.between(birthDate, today).toInt() % 12
        val days = ChronoUnit.DAYS.between(birthDate, today).toInt()
        
        return AgeOutput(years, months, days)
    }
}
