package `in`.app.callme.viewmodel

import `in`.app.callme.localDb.models.UserCallTypeModel
import `in`.app.callme.utils.AppCustomToast
import `in`.app.callme.utils.otherImp.CustomMapComparator
import android.app.Activity
import android.provider.CallLog
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Long
import java.util.*
import kotlin.Comparator
import kotlin.Exception
import kotlin.IllegalArgumentException
import kotlin.Int
import kotlin.String
import kotlin.let


class UserAnalysisViewModel : ViewModel() {
    var userCallCountLLiveData = MutableLiveData<UserCallTypeModel>()

    fun getCallDetails(activity: Activity) {
        val topCallLogs: PriorityQueue<Int> = PriorityQueue<Int>()
        var frequencyMap = HashMap<String, Int>()
        var incomingCallListCount = 0
        var outGoingCallCount = 0
        var missedCallCount = 0
        var blockNumberCount = 0
        var managedCursor = activity.contentResolver.query(CallLog.Calls.CONTENT_URI, null, null, null, null)
        val number = managedCursor?.getColumnIndex(CallLog.Calls.NUMBER)
        val type = managedCursor?.getColumnIndex(CallLog.Calls.TYPE)
        val date = managedCursor?.getColumnIndex(CallLog.Calls.DATE)
        val duration = managedCursor?.getColumnIndex(CallLog.Calls.DURATION)

        try {
            while (managedCursor?.moveToNext() == true) {
                val phNumber = number?.let { managedCursor!!.getString(it) } // mobile number
                val callDate = date?.let { managedCursor!!.getString(it) } // call date
                val callDayTime = Date(Long.valueOf(callDate))
                val callDuration = duration?.let { managedCursor!!.getString(it) }
                val callType = type?.let { managedCursor!!.getString(it) } // call type
                phNumber?.let { it ->
                    if (frequencyMap.containsKey(it)) {
                        var alreadyCount: Int? = frequencyMap[it]
                        if (alreadyCount != null) {
                            frequencyMap[it] = alreadyCount + 1
                        }
                    } else {
                        frequencyMap[phNumber] = 0;
                    }
                }

                when (callType?.toInt()) {
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
            managedCursor?.close()
            userCallCountLLiveData.postValue(
                UserCallTypeModel(
                    incomingCallListCount,
                    outGoingCallCount,
                    blockNumberCount,
                    missedCallCount = missedCallCount
                )
            )
        } catch (e: IllegalArgumentException) {
            Log.e("While getting path for", e.toString())
        } finally {
            try {
                if (!managedCursor?.isClosed!!) {
                    managedCursor.close()
                }
                managedCursor = null
            } catch (e: Exception) {
                Log.e("While closing cursor", e.toString())
            }
        }
        var list: MutableList<Map.Entry<String, Int>> = ArrayList(frequencyMap.entries)
        Collections.sort(
            list, CustomMapComparator()
        )
        list.reverse()
        var x = list.chunked(10)
        var m = ""
        for (e in x) {
            System.out.println("e -->$e")
        }
    }
}

