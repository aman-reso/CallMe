package `in`.app.callme

import `in`.app.callme.databinding.ActivityMainBinding
import `in`.app.callme.ui.fragments.ContactsFragment
import `in`.app.callme.ui.fragments.HomeFragment
import `in`.app.callme.ui.fragments.UserAnalysisFragment
import `in`.app.callme.utils.AppCustomToast
import `in`.app.callme.utils.GlobalVariable.ANALYSIS
import `in`.app.callme.utils.GlobalVariable.CONTACTS
import `in`.app.callme.utils.GlobalVariable.HOME
import `in`.app.callme.viewmodel.HomeFragViewModel
import `in`.app.callme.viewmodel.UserContactsViewModel
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener,
    View.OnClickListener {
    private var activityBinding: ActivityMainBinding? = null
    private var btmNavView: BottomNavigationView? = null
    private var dashBoardImgView: ImageView? = null
    private var addIconImageView: ImageView? = null

    private val exampleViewModel: HomeFragViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //initialize view components
        activityBinding?.let { mainBinding ->
            setUpComponentBindings(mainBinding)
        }
        setUpListener()
        showHomeFragment()

    }

    private fun setUpComponentBindings(activityBinding: ActivityMainBinding) {
        btmNavView = activityBinding.bottomNavigationView
        addIconImageView = activityBinding.addImageHome
        dashBoardImgView = activityBinding.dashBoardHomePage
    }

    private fun setUpListener() {
        btmNavView?.setOnNavigationItemSelectedListener(this)
        dashBoardImgView?.setOnClickListener(this)
        addIconImageView?.setOnClickListener(this)
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
        //AppCustomToast.showToast(tag)
        when (tag) {
            HOME -> {
                showHomeFragment()
            }
            ANALYSIS -> {
                showAnalysisFragment()
            }
            CONTACTS -> {
                showContactsFragment()
            }
        }
    }


    private fun showHomeFragment() {
        val tag = HomeFragment::class.java.name
        val fragmentIfAlready: Fragment? = supportFragmentManager.findFragmentByTag(tag)
        supportFragmentManager.popBackStackImmediate()
        if (fragmentIfAlready == null) {
            openFragment(HomeFragment.newInstance("", ""), tag)
        } else {
            showAlreadyAddedFragment(fragment = fragmentIfAlready)
        }

    }

    private fun showAnalysisFragment() {
        val tag = UserAnalysisFragment::class.java.name
        val fragmentIfAlready = supportFragmentManager.findFragmentByTag(tag)
        supportFragmentManager.popBackStackImmediate()

        if (fragmentIfAlready == null) {
            openFragment(UserAnalysisFragment.newInstance("", ""), tag)
        } else {
            showAlreadyAddedFragment(fragment = fragmentIfAlready)
        }
    }

    private fun showContactsFragment() {
        val tag = ContactsFragment::class.java.name
        val fragmentIfAlready = supportFragmentManager.findFragmentByTag(tag)
        supportFragmentManager.popBackStackImmediate()
        if (fragmentIfAlready == null) {
            openFragment(ContactsFragment.newInstance("", ""), tag)
        } else {
            showAlreadyAddedFragment(fragment = fragmentIfAlready)
        }
    }

    private fun openFragment(fragment: Fragment, tag: String) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.homeFragmentContainer, fragment, tag)
        transaction.commit()
    }


    private fun showAlreadyAddedFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        for (i in supportFragmentManager.fragments.indices) {
            val f = supportFragmentManager.fragments[i]
            transaction.hide(f)
        }
        transaction.show(fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.dashBoardHomePage -> {

            }
            R.id.addImageHome -> {

            }
        }
    }
}


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