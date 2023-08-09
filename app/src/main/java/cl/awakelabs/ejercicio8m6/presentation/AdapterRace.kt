package cl.awakelabs.ejercicio8m6.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import cl.awakelabs.ejercicio4mod6.R
import cl.awakelabs.ejercicio4mod6.databinding.ActivityMainBinding
import cl.awakelabs.ejercicio4mod6.databinding.FragmentRaceBinding
import cl.awakelabs.ejercicio4mod6.databinding.ItemLayoutBinding
import cl.awakelabs.ejercicio8m6.data.local.RaceEntity
import kotlinx.coroutines.NonDisposableHandle.parent

class AdapterRace: RecyclerView.Adapter<AdapterRace.ItemRaceViewHolder>() {
    lateinit var binding: ItemLayoutBinding
    private val listItemRace = mutableListOf<RaceEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): AdapterRace.ItemRaceViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemRaceViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return listItemRace.size
    }
    override fun onBindViewHolder(holder: AdapterRace.ItemRaceViewHolder, position: Int) {
       val race = listItemRace[position]
       holder.bind(race)

    }

    fun setData(races: List<RaceEntity>){//plural
        this.listItemRace.clear()
        this.listItemRace.addAll(races)
        notifyDataSetChanged()
    }

    class ItemRaceViewHolder(val raceView: ItemLayoutBinding): RecyclerView.ViewHolder(raceView.root) {
        fun bind(race: RaceEntity ){
           raceView.txRace.text = race.race
           raceView.cardList.setOnClickListener {
                Navigation.findNavController(raceView.root).navigate(R.id.action_raceFragment_to_detailFragment)
            }
        }

    }


}