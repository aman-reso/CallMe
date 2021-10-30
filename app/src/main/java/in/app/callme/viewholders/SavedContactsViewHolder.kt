package `in`.app.callme.viewholders

import `in`.app.callme.R
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SavedContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var savedNameTextView: TextView = itemView.findViewById(R.id.saved_contacts_saved_name)
    var savedMobileTextView: TextView = itemView.findViewById(R.id.saved_contacts_mobile_number)
   fun setData(name: String, mobileNum: String) {
        savedNameTextView.text = name
    }
}