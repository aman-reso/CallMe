package `in`.app.callme

import `in`.app.callme.adapter.SavedContactsAdapter
import `in`.app.callme.databinding.ActivityMainBinding
import android.annotation.SuppressLint
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlin.system.measureNanoTime

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var activityBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var recyclerView: RecyclerView? = activityBinding?.recyclerView
        val adapters: SavedContactsAdapter by lazy {
            SavedContactsAdapter(this)
        }
        recyclerView?.adapter = adapters
        var list= arrayListOf<String>()
        for (i in 0..200) {
            list.add("String Aman")
        }
        adapters.setData(list)
    }

}