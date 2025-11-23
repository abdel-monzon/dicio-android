package org.stypox.dicio.skills.age

import org.stypox.dicio.skills.SkillOutput
import android.content.Context
import org.stypox.dicio.R

class AgeOutput(
    private val years: Int,
    private val months: Int, 
    private val days: Int
) : SkillOutput {
    
    override fun speak(context: Context): String {
        return if (years > 0) {
            "Has vivido $years años, $months meses y $days días"
        } else if (months > 0) {
            "Has vivido $months meses y $days días"  
        } else {
            "Has vivido $days días"
        }
    }
    
    override fun display(context: Context): String {
        return speak(context) // Puedes personalizar esto diferente si quieres
    }
}
