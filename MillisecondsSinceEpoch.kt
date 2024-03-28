package uz.uzum.tezkor.courier.basic_types

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.OffsetDateTime

/**
 * Represents milliseconds since midnight, January 1, 1970 UTC.
 * @see System.currentTimeMillis
 */
@JvmInline
@Parcelize
value class MillisecondsSinceEpoch private constructor(private val millis: Long) :
    Parcelable,
    Comparable<MillisecondsSinceEpoch> {

    companion object {

        fun getCurrent(): MillisecondsSinceEpoch {
            return MillisecondsSinceEpoch(
                millis = System.currentTimeMillis(),
            )
        }

        fun fromOffsetDateTime(dateTime: OffsetDateTime): MillisecondsSinceEpoch {
            return MillisecondsSinceEpoch(
                millis = dateTime.toInstant().toEpochMilli()
            )
        }

        @UnsafeTimeConversion
        fun fromRawMillisecondsSinceEpoch(millisecondsSinceEpoch: Long): MillisecondsSinceEpoch {
            return MillisecondsSinceEpoch(millisecondsSinceEpoch)
        }
    }

    fun millisecondsUntil(until: MillisecondsSinceEpoch): Long {
        return until.millis - this.millis
    }

    fun plusMilliseconds(delta: Long): MillisecondsSinceEpoch {
        return MillisecondsSinceEpoch(this.millis + delta)
    }

    fun minusMilliseconds(delta: Long): MillisecondsSinceEpoch {
        return MillisecondsSinceEpoch(this.millis - delta)
    }

    @UnsafeTimeConversion
    fun getRawMillisecondsSinceEpoch(): Long {
        return this.millis
    }

    override fun compareTo(other: MillisecondsSinceEpoch): Int {
        return this.millis.compareTo(other.millis)
    }
}
