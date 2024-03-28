package uz.uzum.tezkor.courier.basic_types

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@JvmInline
@Parcelize
value class HtmlMarkup(
    val htmlString: String,
) : Parcelable
