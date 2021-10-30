package `in`.app.callme.adapter

import `in`.app.callme.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import `in`.app.callme.viewholders.SavedContactsViewHolder
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class SavedContactsAdapter(var context: Context) :
    RecyclerView.Adapter<SavedContactsViewHolder>() {
    var list = arrayListOf<String>()

    fun setData(list: List<String>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedContactsViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.saved_contacts_itemview, parent, false)
        return SavedContactsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SavedContactsViewHolder, position: Int) {
        val st = list[position]
        holder.setData(st, "------")
    }

    override fun getItemCount(): Int {
        return list.size
    }
}