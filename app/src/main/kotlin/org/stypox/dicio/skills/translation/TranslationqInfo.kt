package org.stypox.dicio.skills.translation

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Translate
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import org.dicio.skill.context.SkillContext
import org.dicio.skill.skill.Skill
import org.dicio.skill.skill.SkillInfo
import org.stypox.dicio.R
import org.stypox.dicio.sentences.Sentences

object TranslationInfo : SkillInfo("translation") {
    override fun name(context: Context): String = 
        context.getString(R.string.skill_translation_name)

    override fun sentenceExample(context: Context): String = 
        context.getString(R.string.skill_translation_example)

    @Composable
    override fun icon() = rememberVectorPainter(Icons.Default.Translate)

    override fun isAvailable(ctx: SkillContext): Boolean {
        return Sentences.Translation[ctx.sentencesLanguage] != null
    }

    override fun build(ctx: SkillContext): Skill<*> {
        return TranslationSkill()
    }
}
