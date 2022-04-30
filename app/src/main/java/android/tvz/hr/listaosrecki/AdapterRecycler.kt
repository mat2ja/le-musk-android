package android.tvz.hr.listaosrecki

import android.content.Intent
import android.tvz.hr.listaosrecki.parceable.VehicleObject
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AdapterRecycler : RecyclerView.Adapter<AdapterRecycler.ViewHolder>() {

    private var names = arrayOf(
        "Prvi",
        "Drugi",
        "Treci",
        "Cetvrti",
        "Peti",
        "Sesti",
        "Sedmi",
        "Osmi",
        "Deveti",
        "Deseti"
    )

    private var image = R.drawable.electric_car;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.vehicle_card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageResource(image)
        holder.itemName.text = names[position]
    }

    fun selectVehicle(itemView: View) {
        val intent = Intent(itemView.context, VehicleDetailsActivity::class.java)

        val vehicle = VehicleObject("Tesla Model S Plaid", 2021, 95000.00, 1.99, 500)
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
                    val clickedDataItem = names[position]

                    selectVehicle(itemView)
                }
            })
        }
    }
}
