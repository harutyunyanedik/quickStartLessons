package com.example.quickstartlessons.android.dialogs

import android.app.AlertDialog
import android.content.DialogInterface
import android.icu.text.CaseMap.Title
import androidx.fragment.app.Fragment

fun Fragment.showAlertDialog( title:String, massage:String,onItemClick:(Boolean)->Unit) {
    val alertDialogBuilder = AlertDialog.Builder(requireContext())
    alertDialogBuilder.setTitle(title)
    alertDialogBuilder.setMessage(massage)

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