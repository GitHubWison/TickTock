package studio.dex.project.ticktock

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import java.util.*

@Entity
data class TicktockBean(
    var uuid: String,
    var hour: Int?,
    var min: Int?,
    var sec: Int?,
    var name: String?,
    var createTime: Long?
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    constructor(source: Parcel) : this(
        source.readString(),
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readValue(Int::class.java.classLoader) as Int?,
        source.readString(),
        source.readValue(Long::class.java.classLoader) as Long?
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(uuid)
        writeValue(hour)
        writeValue(min)
        writeValue(sec)
        writeString(name)
        writeValue(createTime)
    }

    companion object {
        fun generate(hour: Int, min: Int, sec: Int, name: String): TicktockBean {
            return TicktockBean(UUID.randomUUID().toString(), hour, min, sec, name, Date().time)
        }

        @JvmField
        val CREATOR: Parcelable.Creator<TicktockBean> = object : Parcelable.Creator<TicktockBean> {
            override fun createFromParcel(source: Parcel): TicktockBean = TicktockBean(source)
            override fun newArray(size: Int): Array<TicktockBean?> = arrayOfNulls(size)
        }
    }
}