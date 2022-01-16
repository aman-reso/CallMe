package `in`.app.callme.utils

class Utils {
    companion object{
        public fun validateIsEmptyOrNull(inputString: String?): Boolean {
            if (inputString.isNullOrEmpty()) {
                return true
            }
            return false
        }
    }

}