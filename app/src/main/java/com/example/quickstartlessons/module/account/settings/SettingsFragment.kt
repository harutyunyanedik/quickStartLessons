package com.example.quickstartlessons.module.account.settings

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quickstartlessons.MainActivity
import com.example.quickstartlessons.R

import com.example.quickstartlessons.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolBar.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.appLanguage.setOnClickListener {
            showDialogChangeLanguage()
        }
        binding.signOut.setOnClickListener{
        showDialogSingOut()
        }
    }

    private fun showDialogChangeLanguage() {
        val dialog = AppLanguageFragment()
        dialog.show(childFragmentManager, getString(R.string.show_dialog))
    }
  private  fun showDialogSingOut() {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.apply {
            setMessage(getString(R.string.exit))

                .setPositiveButton(getString(R.string.ok)) { dialog, _ ->
                    dialog.dismiss()
                  requireActivity().finish()
                }
                .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                 dialog.dismiss()
                }
            val exitDialog: AlertDialog = dialog.create()
            if (exitDialog.isShowing) {
                exitDialog.show()

            }
        }
    }

}
