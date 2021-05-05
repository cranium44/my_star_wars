package live.adabe.mystarwars.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import live.adabe.mystarwars.R
import live.adabe.mystarwars.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        arguments?.let{bundle ->
            binding.apply {
                nameDisplay.text = bundle.getString(Constants.NAME)
                genderDisplay.text = bundle.getString(Constants.GENDER)
                heightDisplay.text = bundle.getString(Constants.HEIGHT)
            }
            requireActivity().title = "Details for: ${bundle.getString(Constants.NAME)}"
        }
        return binding.root
    }
}