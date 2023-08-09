package cl.awakelabs.ejercicio8m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.awakelabs.ejercicio4mod6.R
import cl.awakelabs.ejercicio4mod6.databinding.FragmentRaceBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RaceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RaceFragment : Fragment() {
   lateinit var binding: FragmentRaceBinding
   private val raceViewModel: RaceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =FragmentRaceBinding.inflate(layoutInflater, container, false)
        initAdapter()
        raceViewModel.getAllRace()
        return binding.root
    }

    private fun initAdapter() {
        val adapter = AdapterRace()
        binding.recyclerView.adapter = adapter
        raceViewModel.raceLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }

    }

}