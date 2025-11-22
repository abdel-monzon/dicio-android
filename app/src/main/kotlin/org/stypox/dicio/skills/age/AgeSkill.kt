package org.stypox.dicio.skills.age

import org.dicio.skill.standard.RecognizerSkill
import org.dicio.skill.standard.StandardRecognizerData
import org.dicio.skill.skill.SkillOutput
import org.dicio.skill.context.SkillContext
import org.stypox.dicio.sentences.Sentences.Age
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class AgeSkill(
    correspondingSkillInfo: SkillInfo,
    data: StandardRecognizerData<Age>
) : RecognizerSkill<Age>(correspondingSkillInfo, data) {
    
    override suspend fun generateOutput(data: Age): SkillOutput {
        // TODO: Extraer fecha de nacimiento de 'data'
        // Por ahora, usa una fecha fija de prueba
        val birthDate = LocalDate.of(2000, 1, 1)
        val today = LocalDate.now()
        val days = ChronoUnit.DAYS.between(birthDate, today)
        
        return AgeOutput(days.toInt())
    }
}
