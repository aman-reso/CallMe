package `in`.app.callme.ui.fragments

import `in`.app.callme.R
import `in`.app.callme.databinding.FragmentUserAnalysisBinding
import `in`.app.callme.localDb.models.UserCallTypeModel
import `in`.app.callme.utils.GlobalVariable.COLOR_BLUE
import `in`.app.callme.utils.GlobalVariable.COLOR_GREEN
import `in`.app.callme.utils.GlobalVariable.COLOR_RED
import `in`.app.callme.utils.GlobalVariable.COLOR_YELLOW
import `in`.app.callme.viewholders.useranalysisfragment.DynamicallyAddPieChartDesc
import `in`.app.callme.viewmodel.UserAnalysisViewModel
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import app.futured.donut.DonutProgressView
import app.futured.donut.DonutSection


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class UserAnalysisFragment : Fragment() {
    private var noOfCallPieChart: DonutProgressView? = null
    private var userAnaFragBinding: FragmentUserAnalysisBinding? = null
    private var callChartDescContainer: LinearLayout? = null
    private val userAnalysisViewModel: UserAnalysisViewModel by lazy {
        ViewModelProviders.of(this)[UserAnalysisViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userAnaFragBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_user_analysis, container, false)
        setUpViewComponent()

        return userAnaFragBinding?.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
        setUpData()
    }

    private fun setUpViewComponent() {
        noOfCallPieChart = userAnaFragBinding?.numberOfCallsPieChart
        callChartDescContainer = userAnaFragBinding?.callChartDescContainer

    }


    private fun setUpData() {
        val tagList = arrayListOf<Pair<String, String>>()
        tagList.add(Pair("Incoming", COLOR_BLUE))
        tagList.add(Pair("Outgoing", COLOR_YELLOW))
        tagList.add(Pair("Missed", COLOR_GREEN))
        tagList.add(Pair("Blocked", COLOR_RED))

        for (e in tagList) {
            val view = DynamicallyAddPieChartDesc().setData(e.first, e.second, requireContext())
            callChartDescContainer?.addView(view)
        }
    }


    private fun setUpObserver() {
        userAnalysisViewModel.getCallDetails(requireActivity())
        userAnalysisViewModel.userCallCountLLiveData.observe(viewLifecycleOwner) {
            createChangeablePieChart(it)
        }
    }

    private fun createChangeablePieChart(userCallTypeModel: UserCallTypeModel) {
        val section1 = DonutSection(
            name = "Incoming",
            color = android.graphics.Color.BLUE,
            amount = userCallTypeModel.incomingCallCount.toFloat()
        )
        val section2 = DonutSection(
            name = "Outgoing",
            color = android.graphics.Color.YELLOW,
            amount = userCallTypeModel.outGoingCallCount.toFloat()
        )
        val section3 = DonutSection(
            name = "Missed",
            color = android.graphics.Color.GREEN,
            amount = userCallTypeModel.missedCallCount.toFloat()
        )
        val section4 = DonutSection(
            name = "Blocked",
            color = android.graphics.Color.RED,
            amount = userCallTypeModel.blockedCallCount.toFloat()
        )
        noOfCallPieChart?.cap = 1f
        noOfCallPieChart?.submitData(listOf(section1, section2, section3, section4))
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserAnalysisFragment().apply {

            }
    }


    override fun onResume() {
        super.onResume()
    }

}
