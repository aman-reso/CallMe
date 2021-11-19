package `in`.app.callme.viewholders.useranalysisfragment

import `in`.app.callme.R
import `in`.app.callme.utils.GlobalVariable.COLOR_BLUE
import `in`.app.callme.utils.GlobalVariable.COLOR_GREEN
import `in`.app.callme.utils.GlobalVariable.COLOR_RED
import `in`.app.callme.utils.GlobalVariable.COLOR_YELLOW
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat


class DynamicallyAddPieChartDesc {
    fun setData(tag: String, colorName: String, context: Context): View {
        val pieChartDescLayout: View =
            LayoutInflater.from(context).inflate(R.layout.pie_chart_discription, null, false)
        val tagText: TextView = pieChartDescLayout.findViewById(R.id.pie_chart_desc_tag)
        tagText.text = tag

        val colorRepView: View = pieChartDescLayout.findViewById(R.id.pie_chart_desc_colorview)
        try {
            var colorID = R.color.black
            when (colorName) {
                COLOR_BLUE -> {
                    colorID = R.color.light_blue
                }
                COLOR_RED -> {
                    colorID = R.color.red
                }
                COLOR_GREEN -> {
                    colorID = R.color.green
                }
                COLOR_YELLOW -> {
                    colorID = R.color.yellow_dark
                }
            }
            colorRepView.backgroundTintList = ContextCompat.getColorStateList(context, colorID)
        } catch (e: Exception) {
            println("color unable to parse"+e.message)
        }
        return pieChartDescLayout
    }

}