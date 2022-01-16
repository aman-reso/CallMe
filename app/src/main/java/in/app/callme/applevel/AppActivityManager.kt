package `in`.app.callme.applevel

import `in`.app.callme.CallMeApplication
import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class AppActivityManager(meApplication: CallMeApplication) : Application.ActivityLifecycleCallbacks {
    private var resumedActivityName: Activity? = null

    init {
        meApplication.registerActivityLifecycleCallbacks(this)
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {

    }

    override fun onActivityStarted(p0: Activity) {
    }

    override fun onActivityResumed(p0: Activity) {
        this.resumedActivityName = p0 as? AppCompatActivity?

    }

    override fun onActivityPaused(p0: Activity) {
    }

    override fun onActivityStopped(p0: Activity) {

    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {

    }

    override fun onActivityDestroyed(p0: Activity) {
    }

}