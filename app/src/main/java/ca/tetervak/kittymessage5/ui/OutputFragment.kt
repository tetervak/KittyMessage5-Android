package ca.tetervak.kittymessage5.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ca.tetervak.kittymessage5.R
import ca.tetervak.kittymessage5.databinding.FragmentOutputBinding
import ca.tetervak.kittymessage5.domain.Envelope

class OutputFragment : Fragment() {

    private var _binding: FragmentOutputBinding? = null
    private val binding get() = _binding!!

    private val safeArgs: OutputFragmentArgs by navArgs()

    private lateinit var envelope: Envelope

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOutputBinding.inflate(inflater, container, false)
        envelope = safeArgs.envelope
        showEnvelope()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            val action = OutputFragmentDirections.actionOutputToInput()
            findNavController().navigate(action)
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