package uz.uzum.tezkor.courier.basic_types

import android.os.Parcelable
import android.os.SystemClock
import kotlinx.parcelize.Parcelize

/**
 * Represents milliseconds since boot, including time spent in sleep.
 * @see android.os.SystemClock.elapsedRealtime
 */
@JvmInline
@Parcelize
value class MillisecondsSinceBoot(private val millis: Long) : Parcelable {

    companion object {

        fun getCurrent(): MillisecondsSinceBoot {
            return MillisecondsSinceBoot(
                millis = SystemClock.elapsedRealtime(),
            )
        }
    }

    fun plusMilliseconds(millisToAdd: Long): MillisecondsSinceBoot {
        return MillisecondsSinceBoot(this.millis + millisToAdd)
    }

    fun millisecondsUntil(untilMillis: MillisecondsSinceBoot): Long {
        return untilMillis.millis - this.millis
    }

    fun toMillisecondsSinceEpoch(): MillisecondsSinceEpoch {
        return MillisecondsSinceEpoch.getCurrent()
            .minusMilliseconds(this.millisecondsUntil(getCurrent()))
    }

    operator fun compareTo(other: MillisecondsSinceBoot): Int {
        return this.millis.compareTo(other.millis)
    }
}
