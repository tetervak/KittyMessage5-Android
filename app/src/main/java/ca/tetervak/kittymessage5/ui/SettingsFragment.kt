package ca.tetervak.kittymessage5.ui

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceFragmentCompat
import ca.tetervak.kittymessage5.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let{
            view.setBackgroundColor(ContextCompat.getColor(it,R.color.Lime200 ))
        }
    }

}