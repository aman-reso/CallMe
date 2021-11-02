package `in`.app.callme.adapter

import `in`.app.callme.R
import `in`.app.callme.viewholders.VerticalAlphabetHolder
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class VerticalAlphabetAdapter(var context: Context) :
    RecyclerView.Adapter<VerticalAlphabetHolder>() {
    var alphabetList = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalAlphabetHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.vertical_single_alphabet_itemview, parent, false)
        return VerticalAlphabetHolder(view)
    }

    override fun onBindViewHolder(holder: VerticalAlphabetHolder, position: Int) {
        val eachAlphabet = alphabetList[position]
        holder.setAlphabet(eachAlphabet = eachAlphabet)
    }

    override fun getItemCount(): Int {
        return this.alphabetList.size
    }

    fun receiveAlphabetInPaginated(receivedList: List<String>) {
        val alreadyExistItem = alphabetList.size
        if (receivedList.isNotEmpty()) {
            val newItemAddedSize = receivedList.size
            this.alphabetList.addAll(receivedList)
            notifyItemRangeChanged(alreadyExistItem, alreadyExistItem + newItemAddedSize)
        }
    }
}