package org.stypox.dicio.skills.age

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import org.stypox.dicio.R
import org.stypox.dicio.skills.SkillInfo
import org.stypox.dicio.skills.Skill

object AgeInfo : SkillInfo() {
    override fun name(context: Context): String = context.getString(R.string.skill_age_name)
    
    override fun sentenceExample(context: Context): String = context.getString(R.string.skill_age_example)
    
    @Composable
    override fun icon() = rememberVectorPainter(Icons.Default.Cake)
    
    override fun skill(): Skill<*> = AgeSkill()
}
