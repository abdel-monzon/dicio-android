package org.stypox.dicio.skills.age // Paquete correcto en inglés

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cake // Icono más apropiado
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import org.dicio.skill.context.SkillContext
import org.dicio.skill.skill.Skill
import org.stypox.dicio.sentences.Sentences

object AgeInfo : SkillInfo("age") {
    override fun name(context: Context) = "Calculadora de edad"
    
    override fun exampleSentence(context: Context) = "Cuántos días tengo"
    
    @Composable
    override fun icon() = rememberVectorPainter(Icons.Default.Cake)
    
    override fun isAvailable(ctx: SkillContext): Boolean {
        return Sentences.Age[ctx.sentencesLanguage] != null
    }
    
    override fun build(ctx: SkillContext): Skill<*> {
        return AgeSkill(AgeInfo, Sentences.Age[ctx.sentencesLanguage]!!)
    }
}
