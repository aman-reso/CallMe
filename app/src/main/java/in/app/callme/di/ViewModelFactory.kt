package `in`.app.callme.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Provider
//
//class ViewModelFactory @Inject constructor(private val providers: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>) :
//    ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        var provider = providers[modelClass]
//        if (provider == null) {
//            for ((key, value) in providers) {
//                if (modelClass.isAssignableFrom(key)) {
//                    provider = value
//                    break
//                }
//            }
//        }
//        if (provider == null) {
//            throw IllegalStateException("unknown model class $modelClass")
//        }
//
//        return provider.get() as T
//    }
//}
