package `in`.app.callme

import `in`.app.callme.adapter.SavedContactsAdapter
import `in`.app.callme.adapter.VerticalAlphabetAdapter
import `in`.app.callme.databinding.ActivityMainBinding
import `in`.app.callme.databinding.AnalysisNoOfCallSectionBinding
import `in`.app.callme.utils.AppCustomToast
import android.os.Bundle
import android.provider.CallLog
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Long
import java.util.*
import kotlin.collections.ArrayList


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    var activityBinding: ActivityMainBinding? = null
    var btmNavView: BottomNavigationView? = null
    var dashBoardImgView: ImageView? = null
    var addIconImageView: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //initialize view components
        activityBinding?.let { mainBinding ->
            setUpComponentBindings(mainBinding)
        }
        setUpListener()

    }

    private fun setUpComponentBindings(activityBinding: ActivityMainBinding) {
        btmNavView = activityBinding.bottomNavigationView
        addIconImageView = activityBinding.addImageHome
    }

    private fun setUpListener() {
        btmNavView?.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_home -> {
                setUpFragment(HOME)
            }
            R.id.menu_analysis -> {
                setUpFragment(ANALYSIS)
            }
            R.id.menu_contacts -> {
                setUpFragment(CONTACTS)
            }
        }
        return true
    }

    private fun setUpFragment(tag: String) {
        AppCustomToast.showToast(tag)
    }
}

const val HOME = "home"
const val ANALYSIS = "analysis"
const val CONTACTS = "contacts"

/*
*
* Cookies
* Toast
* Bread
* Credit
* Dew
* Cash
*
*/