package `in`.app.callme.adapter

import `in`.app.callme.R
import `in`.app.callme.localDb.models.UserContacts
import `in`.app.callme.viewholders.SavedContactsViewHolder
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class SavedContactsAdapter() :
    RecyclerView.Adapter<SavedContactsViewHolder>() {
    var list = arrayListOf<UserContacts>()

    fun setData(list: List<UserContacts>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedContactsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.saved_contacts_itemview, parent, false)
        return SavedContactsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SavedContactsViewHolder, position: Int) {
        val fullName = list[position].fullName
        val mobileNum = list[position].mobileNumber
        if (fullName != null) {
            holder.setData(fullName, mobileNum = mobileNum)
        } else {
            holder.setData("", mobileNum = mobileNum)
        }
        holder.itemView.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:${mobileNum.trim()}")
                it.context.startActivity(intent)
            } catch (e: Exception) {
                print("msg" + e.message)
            }


        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}