package `in`.app.callme.viewholders

import `in`.app.callme.R
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VerticalAlphabetHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var singleVerticalAlphabetTV: TextView = itemView.findViewById(R.id.single_vertical_alphabet_tv)
    fun setAlphabet(eachAlphabet: String) {
        singleVerticalAlphabetTV.apply {
            text = eachAlphabet
        }
    }
}