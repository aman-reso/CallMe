package `in`.app.callme.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.app.callme.R
import android.provider.CallLog
import androidx.compose.ui.graphics.Color
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Long
import java.util.*
import kotlin.collections.ArrayList

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun getCallDetails() {
        var incomingCallListCount = 0
        var outGoingCallCount = 0
        var missedCallCount = 0
        var blockNumberCount = 0
        val managedCursor =
            requireActivity().managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, null)
        val number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER)
        val type = managedCursor.getColumnIndex(CallLog.Calls.TYPE)
        val date = managedCursor.getColumnIndex(CallLog.Calls.DATE)
        val duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION)

        while (managedCursor.moveToNext()) {
            val phNumber = managedCursor.getString(number) // mobile number
            val callType = managedCursor.getString(type) // call type
            val callDate = managedCursor.getString(date) // call date
            val callDayTime = Date(Long.valueOf(callDate))
            val callDuration = managedCursor.getString(duration)
            System.out.println("Phone number" + phNumber + "--" + callType.toInt() + "==" + callDate)
            when (callType.toInt()) {
                CallLog.Calls.OUTGOING_TYPE -> {
                    outGoingCallCount++
                }
                CallLog.Calls.INCOMING_TYPE -> {
                    incomingCallListCount++
                }
                CallLog.Calls.MISSED_TYPE -> {
                    missedCallCount++
                }
                CallLog.Calls.BLOCKED_TYPE -> {
                    blockNumberCount++
                }
            }

        }
        managedCursor.close()

        val arrayList = ArrayList<PieEntry>()
        arrayList.add(PieEntry(incomingCallListCount.toFloat(), "Incoming ", Color.Yellow))
        arrayList.add(PieEntry(outGoingCallCount.toFloat(), "Outgoing", Color.Blue))
        arrayList.add(PieEntry(missedCallCount.toFloat(), "Missed", Color.Black))
        arrayList.add(PieEntry(blockNumberCount.toFloat(), "Block", Color.Red))

        val pieDataSet = PieDataSet(arrayList, "Call Count")
        val pieData = PieData(pieDataSet)
        //pieData.setValueFormatter(PercentFormatter(pieChart))
        pieDataSet.setColors(
            android.graphics.Color.YELLOW,
            android.graphics.Color.BLUE,
            android.graphics.Color.BLACK,
            android.graphics.Color.RED
        );
        pieData.setDrawValues(true)
        //pieChart?.data = pieData

    }

}
