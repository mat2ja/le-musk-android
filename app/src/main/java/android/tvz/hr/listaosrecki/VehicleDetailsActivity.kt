package android.tvz.hr.listaosrecki

import android.os.Bundle
import android.tvz.hr.listaosrecki.databinding.ActivityMainBinding
import android.tvz.hr.listaosrecki.parceable.Vehicle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class VehicleDetailsActivity : AppCompatActivity() {

    // TODO: view binding
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_vehicle_details)


        val vehicle: Vehicle? = intent.extras!!.getParcelable("vehicle")
        if (vehicle != null) {
            findViewById<TextView>(R.id.vehicle_details_name).text = vehicle.name
            findViewById<TextView>(R.id.vehicle_year).text = vehicle.year.toString()
            findViewById<TextView>(R.id.vehicle_price).text = formatPrice(vehicle.price)
            findViewById<TextView>(R.id.vehicle_acceleration).text =
                formatAcceleration(vehicle.acceleration)
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
}
