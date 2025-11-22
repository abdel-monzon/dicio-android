package org.stypox.dicio.skills.age

import org.stypox.dicio.sentences.Sentences.Age
import org.stypox.dicio.skills.StandardRecognizerSkill
import org.stypox.dicio.skills.SkillContext
import org.stypox.dicio.skills.SkillOutput
import org.stypox.dicio.skills.SkillInfo
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class AgeSkill(
    correspondingSkillInfo: SkillInfo,
    data: StandardRecognizerData<Age>
) : StandardRecognizerSkill<Age>(correspondingSkillInfo, data) {

    override suspend fun generateOutput(
        ctx: SkillContext,
        inputData: Age
    ): SkillOutput {
        val birthDate = LocalDate.of(2000, 1, 1)
        val today = LocalDate.now()
        val days = ChronoUnit.DAYS.between(birthDate, today)
        return AgeOutput(days.toInt())
    }
}
