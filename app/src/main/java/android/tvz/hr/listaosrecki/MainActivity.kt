package android.tvz.hr.listaosrecki

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.tvz.hr.listaosrecki.broadcast.LowBatteryReceiver
import android.tvz.hr.listaosrecki.databinding.ActivityMainBinding
import android.tvz.hr.listaosrecki.parceable.VehicleObject
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

            vehiclesRecycllerView.layoutManager = layoutManager

            adapter = AdapterRecycler()
            vehiclesRecycllerView.adapter = adapter
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_share -> {
                startShareAlert()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun startShareAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.share)
        builder.setMessage(R.string.share_dialog_content)
            .setPositiveButton(R.string.yes) { dialog, which -> sendShareBroadcast(); }
            .setNegativeButton(R.string.no) { dialog, which -> dialog.cancel() }
            .create()
            .show()

    }

    private fun sendShareBroadcast() {
        val broadcastShare = Intent()
        broadcastShare.action = "hr.android.tvz.listaosrecki.SHARE"
        sendBroadcast(broadcastShare)
        Toast.makeText(this, "Share broadcast sent", Toast.LENGTH_SHORT).show()
    }


}