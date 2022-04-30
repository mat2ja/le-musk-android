package android.tvz.hr.listaosrecki.broadcast
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class SystemReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(
            context,
            "Action: " + intent!!.action,
            Toast.LENGTH_LONG
        ).show()
    }
}