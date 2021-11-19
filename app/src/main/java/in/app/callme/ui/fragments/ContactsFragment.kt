package `in`.app.callme.ui.fragments

import `in`.app.callme.R
import `in`.app.callme.adapter.SavedContactsAdapter
import `in`.app.callme.databinding.FragmentContactsBinding
import `in`.app.callme.localDb.models.UserContacts
import `in`.app.callme.viewmodel.UserContactsViewModel
import android.annotation.SuppressLint
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.LinearLayout.VERTICAL
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.system.measureNanoTime


@AndroidEntryPoint
class ContactsFragment : Fragment() {

    private var contactsFragmentBinding: FragmentContactsBinding? = null

    private val userContactsViewModel: UserContactsViewModel by viewModels()
    private var savedContactsRecyclerView: RecyclerView? = null
    private val savedContactsAdapter: SavedContactsAdapter by lazy { SavedContactsAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contactsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contacts, container, false)
        setUpViews()
        return contactsFragmentBinding?.root
    }

    private fun setUpViews() {
        savedContactsRecyclerView = contactsFragmentBinding?.userSavedContactsRecyclerView
        savedContactsRecyclerView?.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = savedContactsAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpLiveObserver()
    }

    @SuppressLint("Range")
    private fun setUpLiveObserver() {
        var list = arrayListOf<UserContacts>()
        val phones: Cursor? = activity?.contentResolver?.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )
        phones?.let { it ->
            while (it.moveToNext()) {
                val name = it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val phoneNumber = it.getString(it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                list.add(
                    UserContacts(
                        fullName = name,
                        mobileNumber = phoneNumber
                    )
                )
                println("phone->$phoneNumber")
            }
            it.close()
            userContactsViewModel.insertUserContacts(list)
        }

        lifecycleScope.launch {
            userContactsViewModel.fetchUserContactsAsync().collect {
                savedContactsAdapter.setData(it)
            }

        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ContactsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
/**

 */