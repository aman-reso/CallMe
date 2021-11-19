package `in`.app.callme.localDb.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.util.*

@Entity(tableName = "user_table")
data class UserContacts(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,

    @ColumnInfo(name = "contact_name") val fullName: String? = null,
    @ColumnInfo(name = "country_code") val countryCode: String? = "+91",
    @NotNull
    @ColumnInfo(name = "mobile_number") val mobileNumber: String,
    @ColumnInfo(name = "email_id") val emailId: String? = null,
    @ColumnInfo(name = "address_line") val addressLine: String? = null,
    @ColumnInfo(name = "pincode") val pincode: String? = null,
    @ColumnInfo(name = "date") val dob: String? = null,
    @ColumnInfo(name = "isFavourite") val isFav: Boolean? = false,
    @ColumnInfo(name = "instagramId") val instagram: String? = null,
    @ColumnInfo(name = "facebookId") val faceBookId: String? = null,
    @ColumnInfo(name = "twitter") val twitter: String? = null,
    @ColumnInfo(name = "orgName") val orgName: String? = null,
)

