package android.tvz.hr.listaosrecki

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.tvz.hr.listaosrecki.broadcast.LowBatteryReceiver
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        registerReceivers();
    }

    fun registerReceivers() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(
            Intent.ACTION_BATTERY_LOW)

        val lbReceiver = LowBatteryReceiver()

        registerReceiver(lbReceiver, intentFilter)
    }
}