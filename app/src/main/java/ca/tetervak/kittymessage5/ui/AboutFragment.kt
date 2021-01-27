package ca.tetervak.kittymessage5.ui

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import ca.tetervak.kittymessage5.R


class AboutFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val builder = AlertDialog.Builder(requireContext())
            builder
                .setTitle(R.string.app_name)
                .setMessage(R.string.author)
                .setPositiveButton(android.R.string.ok,null)
            return builder.create()
    }
}