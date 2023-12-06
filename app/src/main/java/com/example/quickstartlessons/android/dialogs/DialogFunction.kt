package com.example.quickstartlessons.android.dialogs

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.fragment.app.Fragment

fun Fragment.showAlertDialog(onItemClick:(Boolean)->Unit) {
    val alertDialogBuilder = AlertDialog.Builder(requireContext())
    alertDialogBuilder.setTitle("Confirmation")
    alertDialogBuilder.setMessage("Do you want to delete the text?")

    alertDialogBuilder.setPositiveButton("OK") { _: DialogInterface, _: Int ->
     onItemClick.invoke(true)
    }
    alertDialogBuilder.setNegativeButton("Cancel") { _: DialogInterface, _: Int ->
      onItemClick(false)
    }

    val alertDialog: AlertDialog = alertDialogBuilder.create()
    if (!alertDialog.isShowing) {
        alertDialog.show()
    }
}