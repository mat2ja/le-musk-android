package android.tvz.hr.listaosrecki.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.tvz.hr.listaosrecki.R
import android.widget.Toast

class LowBatteryReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(
            context,
            R.string.low_battery_message,
            Toast.LENGTH_LONG
        ).show()
    }
}