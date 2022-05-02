package android.tvz.hr.listaosrecki

import android.content.Intent
import android.tvz.hr.listaosrecki.parceable.Vehicle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRecycler : RecyclerView.Adapter<AdapterRecycler.ViewHolder>() {

    private val vehicles: MutableList<Vehicle> = arrayListOf(
        Vehicle("Tesla Model S Plaid", 2022, 135000.00, 1.99, 560, R.drawable.tesla_s),
        Vehicle("Tesla Model X Plaid", 2022, 125000.00, 2.6, 536, R.drawable.tesla_x),
        Vehicle("Tesla Model 3 Performance", 2022, 60000.00, 3.3, 505, R.drawable.tesla_3),
        Vehicle("Tesla Model Y", 2022, 45000.00, 3.7, 488, R.drawable.tesla_y),
        Vehicle("Tesla Cybertruck", 2023, 40000.00, 3.0, 600, R.drawable.tesla_cybertruck),
        Vehicle("Rivian R1T", 2022, 67500.00, 3.3, 507, R.drawable.rivian_r1t),
        Vehicle("Lucid Air", 2021, 139000.00, 3.4, 774, R.drawable.lucid_air),
        Vehicle("Kia EV6", 2021, 58500.00, 3.5, 441, R.drawable.kia_ev6),
        Vehicle("Hyundai Ioniq 5", 2021, 50600.00, 5.2, 412, R.drawable.hyundai_ioniq5),
        Vehicle("Porsche Taycan Turbo S", 2022, 187000.00, 2.8, 346, R.drawable.porsche_taycan),
        Vehicle("Mercedes EQS", 2022, 119000.00, 3.4, 547, R.drawable.mercedes_eqs),
        Vehicle("Polestar 2", 2020, 49000.00, 4.7, 401, R.drawable.polestar_2),
        Vehicle("Audi e-tron GT", 2022, 142000.00, 3.3, 383, R.drawable.audi_etron),
        Vehicle(
            "Volkswagen ID.4", 2021, 44000.00, 6.2, 401, R.drawable.vw_id4
        ),
    )

    private var image = R.drawable.electric_car;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.vehicle_card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return vehicles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageResource(image)
        holder.itemName.text = vehicles[position].name
    }

    fun selectVehicle(itemView: View, vehicle: Vehicle) {
        val intent = Intent(itemView.context, VehicleDetailsActivity::class.java)

        intent.putExtra("vehicle", vehicle)

        itemView.context.startActivity(intent)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView
        val itemName: TextView

        init {
            itemImage = itemView.findViewById(R.id.vehicle_image)
            itemName = itemView.findViewById(R.id.vehicle_name)

            itemView.setOnClickListener(View.OnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val selectedVehicle = vehicles[position]
                    selectVehicle(itemView, selectedVehicle)
                }
            })
        }
    }
}
