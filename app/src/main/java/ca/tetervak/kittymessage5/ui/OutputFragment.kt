package ca.tetervak.kittymessage5.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ca.tetervak.kittymessage5.R
import ca.tetervak.kittymessage5.databinding.FragmentOutputBinding
import ca.tetervak.kittymessage5.domain.Envelope

class OutputFragment : Fragment() {

    companion object{
        const val ENVELOPE = "envelope"
    }

    private var _binding: FragmentOutputBinding? = null
    private val binding get() = _binding!!

    private lateinit var envelope: Envelope

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOutputBinding.inflate(inflater, container, false)
        envelope = arguments?.getSerializable(ENVELOPE) as Envelope
        showEnvelope()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_output_to_input)
        }
    }

    private fun showEnvelope(){
        binding.isUrgentOutput.text =
            if (envelope.isUrgent) {
                getString(R.string.urgent)
            } else {
                getString(R.string.not_urgent)
            }
        binding.messageText.text = envelope.textMessage
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}