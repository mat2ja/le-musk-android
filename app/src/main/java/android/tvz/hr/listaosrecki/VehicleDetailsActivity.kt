package android.tvz.hr.listaosrecki

import android.os.Bundle
import android.tvz.hr.listaosrecki.parceable.VehicleObject
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class VehicleDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_details)

        val vehicle: VehicleObject? = intent.extras!!.getParcelable("vehicle")
        if (vehicle != null) {
            Toast.makeText(this, vehicle.name, Toast.LENGTH_LONG).show()
        }
    }
}
