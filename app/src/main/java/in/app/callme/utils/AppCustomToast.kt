package `in`.app.callme.utils

import `in`.app.callme.BuildConfig
import `in`.app.callme.CallMeApplication
import android.widget.Toast

object AppCustomToast {
    fun showToast(message: String) {
        if (BuildConfig.DEBUG) {
            Toast.makeText(CallMeApplication.getApplicationContext(), message, Toast.LENGTH_LONG)
                .show()
        } else {
        }
    }
}