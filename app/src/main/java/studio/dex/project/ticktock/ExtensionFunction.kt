package studio.dex.project.ticktock

import android.util.Log
import android.widget.Toast


fun String.log() {
    Log.e("tick-tock", this)

}

fun String.toast() {
    Toast.makeText(App.context, this, Toast.LENGTH_SHORT).show()
}
