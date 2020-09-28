package ca.tetervak.kittymessage5.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import ca.tetervak.kittymessage5.R
import ca.tetervak.kittymessage5.databinding.FragmentInputBinding
import ca.tetervak.kittymessage5.model.Envelope
import ca.tetervak.kittymessage5.ui.OutputFragment.Companion.ENVELOPE

class InputFragment : Fragment() {

    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInputBinding.inflate(inflater, container, false)

        binding.sendButton.setOnClickListener { send() }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
    }

    override fun onResume() {
        super.onResume()
        // reset the inputs to the defaults from the settings
        reset()
    }

    private fun send(){
        // get urgent flag value
        val isUrgent: Boolean = binding.urgentCheckBox.isChecked
        // get the selected message text
        val textMessage = when (binding.messageGroup.checkedRadioButtonId) {
            R.id.purr_button -> getString(R.string.cat_purr)
            R.id.mew_button -> getString(R.string.cat_mew)
            R.id.hiss_button -> getString(R.string.cat_hiss)
            else -> getString(R.string.undefined)
        }
        val arguments = Bundle()
        arguments.putSerializable(ENVELOPE, Envelope(isUrgent, textMessage))
        navController.navigate(
            R.id.action_input_to_output,
            arguments
        )
    }

    private fun reset(){
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)

        val urgent = preferences.getBoolean(getString(R.string.urgent_key), true)
        binding.urgentCheckBox.isChecked = urgent

        val message = preferences.getString(
            getString(R.string.message_text_key),
            getString(R.string.default_message_value)
        )

        when(message){
            "purr" -> binding.messageGroup.check(R.id.purr_button)
            "mew" -> binding.messageGroup.check(R.id.mew_button)
            "hiss" -> binding.messageGroup.check(R.id.hiss_button)
        }
    }

}