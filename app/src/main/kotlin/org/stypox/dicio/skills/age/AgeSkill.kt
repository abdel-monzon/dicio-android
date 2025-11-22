package org.stypox.dicio.skills.age

import org.dicio.skill.standard.RecognizerSkill
import org.dicio.skill.standard.StandardRecognizerData
import org.dicio.skill.skill.SkillOutput
import org.stypox.dicio.sentences.Sentences.Age
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class AgeSkill(
    correspondingSkillInfo: SkillInfo,
    data: StandardRecognizerData<Age>
) : RecognizerSkill<Age>(correspondingSkillInfo, data) {
    
    override suspend fun generateOutput(data: Age): SkillOutput {
        // Usa la fecha de nacimiento extraída de 'data'
        val birthDate = LocalDate.of(2000, 1, 1) // Temporal: reemplaza con data.birthDate
        
        val today = LocalDate.now()
        val days = ChronoUnit.DAYS.between(birthDate, today)
        
        return AgeOutput(days.toInt())
    }
}
