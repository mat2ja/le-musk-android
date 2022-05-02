package android.tvz.hr.listaosrecki

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.tvz.hr.listaosrecki.broadcast.LowBatteryReceiver
import android.tvz.hr.listaosrecki.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        registerReceivers();

        binding.apply {
            layoutManager = LinearLayoutManager(applicationContext)

            vehiclesRecyclerView.layoutManager = layoutManager

            adapter = AdapterRecycler()
            vehiclesRecyclerView.adapter = adapter
        }
    }

    private fun registerReceivers() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(
            Intent.ACTION_BATTERY_LOW
        )
        val lbReceiver = LowBatteryReceiver()

        registerReceiver(lbReceiver, intentFilter)
    }
}