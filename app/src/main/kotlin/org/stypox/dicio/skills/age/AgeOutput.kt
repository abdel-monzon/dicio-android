package org.stypox.dicio.skills.age

import androidx.compose.runtime.Composable
import org.stypox.dicio.skills.SkillContext
import org.stypox.dicio.skills.SkillOutput

data class AgeOutput(val days: Int) : SkillOutput {
    override fun getSpeechOutput(ctx: SkillContext): String =
        "You have lived $days days"

    @Composable
    override fun GraphicalOutput(ctx: SkillContext) {
        /* UI simple; por ahora vacía */
    }
}
