package android.tvz.hr.listaosrecki

import android.os.Bundle
import android.tvz.hr.listaosrecki.parceable.Vehicle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class VehicleImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_image)

        val vehicleImage: Int? = intent.getIntExtra("vehicleImage", 0)
        if (vehicleImage != null) {
            findViewById<ImageView>(R.id.vehicle_image_large).setImageResource(vehicleImage)
        }
    }


}