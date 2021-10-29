package `in`.app.callme

import android.app.Application
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.Executor

@HiltAndroidApp
class CallMeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun createAttributionContext(attributionTag: String?): Context {
        return super.createAttributionContext(attributionTag)
    }

    override fun onTerminate() {
        super.onTerminate()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }

    override fun registerOnProvideAssistDataListener(callback: OnProvideAssistDataListener?) {
        super.registerOnProvideAssistDataListener(callback)
    }

    override fun unregisterOnProvideAssistDataListener(callback: OnProvideAssistDataListener?) {
        super.unregisterOnProvideAssistDataListener(callback)
    }

    override fun getOpPackageName(): String {
        return super.getOpPackageName()
    }

    override fun checkCallingOrSelfPermission(permission: String): Int {
        return super.checkCallingOrSelfPermission(permission)
    }

    override fun checkCallingOrSelfUriPermission(uri: Uri?, modeFlags: Int): Int {
        return super.checkCallingOrSelfUriPermission(uri, modeFlags)
    }

    override fun checkCallingPermission(permission: String): Int {
        return super.checkCallingPermission(permission)
    }

    override fun checkCallingUriPermission(uri: Uri?, modeFlags: Int): Int {
        return super.checkCallingUriPermission(uri, modeFlags)
    }

    override fun checkPermission(permission: String, pid: Int, uid: Int): Int {
        return super.checkPermission(permission, pid, uid)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun checkSelfPermission(permission: String): Int {
        return super.checkSelfPermission(permission)
    }

    override fun checkUriPermission(uri: Uri?, pid: Int, uid: Int, modeFlags: Int): Int {
        return super.checkUriPermission(uri, pid, uid, modeFlags)
    }

    override fun bindIsolatedService(
        service: Intent,
        flags: Int,
        instanceName: String,
        executor: Executor,
        conn: ServiceConnection
    ): Boolean {
        return super.bindIsolatedService(service, flags, instanceName, executor, conn)
    }

    override fun checkUriPermission(
        uri: Uri?,
        readPermission: String?,
        writePermission: String?,
        pid: Int,
        uid: Int,
        modeFlags: Int
    ): Int {
        return super.checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags)
    }

    override fun enforceCallingOrSelfPermission(permission: String, message: String?) {
        super.enforceCallingOrSelfPermission(permission, message)
    }

    override fun enforceCallingOrSelfUriPermission(uri: Uri?, modeFlags: Int, message: String?) {
        super.enforceCallingOrSelfUriPermission(uri, modeFlags, message)
    }

    override fun enforceCallingPermission(permission: String, message: String?) {
        super.enforceCallingPermission(permission, message)
    }


    override fun enforceCallingUriPermission(uri: Uri?, modeFlags: Int, message: String?) {
        super.enforceCallingUriPermission(uri, modeFlags, message)
    }

    override fun enforcePermission(permission: String, pid: Int, uid: Int, message: String?) {
        super.enforcePermission(permission, pid, uid, message)
    }

    override fun enforceUriPermission(
        uri: Uri?,
        pid: Int,
        uid: Int,
        modeFlags: Int,
        message: String?
    ) {
        super.enforceUriPermission(uri, pid, uid, modeFlags, message)
    }

    override fun enforceUriPermission(
        uri: Uri?,
        readPermission: String?,
        writePermission: String?,
        pid: Int,
        uid: Int,
        modeFlags: Int,
        message: String?
    ) {
        super.enforceUriPermission(uri,
            readPermission,
            writePermission,
            pid,
            uid,
            modeFlags,
            message)
    }

    override fun grantUriPermission(toPackage: String?, uri: Uri?, modeFlags: Int) {
        super.grantUriPermission(toPackage, uri, modeFlags)
    }

    override fun revokeUriPermission(uri: Uri?, modeFlags: Int) {
        super.revokeUriPermission(uri, modeFlags)
    }

    override fun revokeUriPermission(targetPackage: String?, uri: Uri?, modeFlags: Int) {
        super.revokeUriPermission(targetPackage, uri, modeFlags)
    }

    override fun startInstrumentation(
        className: ComponentName,
        profileFile: String?,
        arguments: Bundle?
    ): Boolean {
        return super.startInstrumentation(className, profileFile, arguments)
    }

    override fun checkCallingOrSelfUriPermissions(
        uris: MutableList<Uri>,
        modeFlags: Int
    ): IntArray {
        return super.checkCallingOrSelfUriPermissions(uris, modeFlags)
    }

    override fun moveDatabaseFrom(sourceContext: Context?, name: String?): Boolean {
        return super.moveDatabaseFrom(sourceContext, name)
    }

    override fun moveSharedPreferencesFrom(sourceContext: Context?, name: String?): Boolean {
        return super.moveSharedPreferencesFrom(sourceContext, name)
    }

    override fun checkUriPermissions(
        uris: MutableList<Uri>,
        pid: Int,
        uid: Int,
        modeFlags: Int
    ): IntArray {
        return super.checkUriPermissions(uris, pid, uid, modeFlags)
    }

    override fun checkCallingUriPermissions(uris: MutableList<Uri>, modeFlags: Int): IntArray {
        return super.checkCallingUriPermissions(uris, modeFlags)
    }
}