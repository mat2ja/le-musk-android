package android.tvz.hr.listaosrecki

import android.os.Bundle
import android.tvz.hr.listaosrecki.databinding.ActivityVehicleImageBinding
import androidx.appcompat.app.AppCompatActivity

class VehicleImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVehicleImageBinding

    private var wasAnimated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVehicleImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val vehicleImage: Int? = intent.getIntExtra("vehicleImage", 0)
            if (vehicleImage != null) {
                vehicleImageLarge.setImageResource(vehicleImage)
            }


            vehicleImageLarge.setOnClickListener() {
                if (wasAnimated) {
                    vehicleImageLarge.animate().apply {
                        duration = 500
                        translationY(0f)
                    }.start()
                    wasAnimated = false
                } else {
                    vehicleImageLarge.animate().apply {
                        duration = 500
                        translationY(400f)
                    }.start()
                    wasAnimated = true
                }
            }
        }
    }


}