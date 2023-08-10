package cl.awakelabs.ejercicio8m6.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelabs.ejercicio4mod6.databinding.ItemDetailBinding
import cl.awakelabs.ejercicio8m6.data.local.RaceDetailEntity
import coil.load

class AdapterDetail: RecyclerView.Adapter<AdapterDetail.ItemDetailViewHolder>()  {
    lateinit var binding: ItemDetailBinding
    private val listDetailDog = mutableListOf<RaceDetailEntity>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterDetail.ItemDetailViewHolder {
        binding = ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemDetailViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listDetailDog.size
    }

    override fun onBindViewHolder(holder: AdapterDetail.ItemDetailViewHolder, position: Int) {
        val dog = listDetailDog[position]
        holder.bind(dog)
    }

    fun setDataDetail(detail: List<RaceDetailEntity>){
        this.listDetailDog.clear()
        this.listDetailDog.addAll(detail)
        notifyDataSetChanged()
    }

    class ItemDetailViewHolder(val viewDog: ItemDetailBinding): RecyclerView.ViewHolder(viewDog.root) {
        fun bind(detail: RaceDetailEntity){
            viewDog.imageDogsDetail.load(detail.url)
        }
    }
}