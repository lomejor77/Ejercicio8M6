package cl.awakelabs.ejercicio8m6.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.awakelabs.ejercicio4mod6.R
import cl.awakelabs.ejercicio4mod6.databinding.FragmentDetailBinding
import cl.awakelabs.ejercicio4mod6.databinding.FragmentRaceBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "id"


/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding: FragmentDetailBinding
    private val raceViewModel: RaceViewModel by activityViewModels()
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        initAdapter()
        raceViewModel.getDetail(param1.toString())
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initAdapter() {
        val adapter = AdapterDetail()
        binding.recyclerDetail.adapter = adapter
        raceViewModel.detailLiveData(param1.toString()).observe(viewLifecycleOwner){
            adapter.setDataDetail(it)
        }
    }


}