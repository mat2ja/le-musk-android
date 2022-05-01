package android.tvz.hr.listaosrecki

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.tvz.hr.listaosrecki.databinding.ActivityMainBinding
import android.tvz.hr.listaosrecki.parceable.Vehicle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class VehicleDetailsActivity : AppCompatActivity() {

    // TODO: view binding
    lateinit var binding: ActivityMainBinding

    var vehicle: Vehicle? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_vehicle_details)

        vehicle = intent.extras!!.getParcelable("vehicle")
        if (vehicle != null) {
            findViewById<ImageView>(R.id.vehicle_details_image).setImageResource(vehicle!!.image)
            findViewById<TextView>(R.id.vehicle_details_name).text = vehicle!!.name
            findViewById<TextView>(R.id.vehicle_year).text = vehicle!!.year.toString()
            findViewById<TextView>(R.id.vehicle_price).text = formatPrice(vehicle!!.price)
            findViewById<TextView>(R.id.vehicle_acceleration).text =
                formatAcceleration(vehicle!!.acceleration)
            findViewById<TextView>(R.id.vehicle_range).text = formatRange(vehicle!!.range)

        }

    }

    private fun formatPrice(price: Double): String {
        val dec = DecimalFormat("$#,###.##")
        return dec.format(price)
    }

    private fun formatAcceleration(acceleration: Double): String {
        val dec = DecimalFormat("#.##")
        return dec.format(acceleration) + " s"
    }

    private fun formatRange(range: Int): String {
        return "$range km"
    }

    fun openWebsite(view: android.view.View) {
        val url = "https://www.carwow.co.uk/"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(
                applicationContext,
                R.string.website_intent_error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun openImage(view: android.view.View) {
        val intent = Intent(applicationContext, VehicleImageActivity::class.java)
        intent.putExtra("vehicleImage", vehicle!!.image)
        startActivity(intent)
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
        Toast.makeText(this, R.string.share_broadcast_msg, Toast.LENGTH_SHORT).show()
    }

}
