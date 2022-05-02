package android.tvz.hr.listaosrecki

import android.os.Bundle
import android.tvz.hr.listaosrecki.databinding.ActivityVehicleImageBinding
import androidx.appcompat.app.AppCompatActivity

class VehicleImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVehicleImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVehicleImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vehicleImage: Int? = intent.getIntExtra("vehicleImage", 0)
        if (vehicleImage != null) {
            binding.apply {
                vehicleImageLarge.setImageResource(vehicleImage)
            }
        }
    }


}