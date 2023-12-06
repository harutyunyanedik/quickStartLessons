package com.example.quickstartlessons.android.activity

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

 fun AppCompatActivity.showAlertDialog(onItemClick:(Boolean) -> Unit) {

    val alertDialogBuilder = AlertDialog.Builder(this)

    alertDialogBuilder.setTitle("Completion")
    alertDialogBuilder.setMessage("Delete this fragment.")

    alertDialogBuilder.setPositiveButton("OK") { _: DialogInterface, _: Int ->
        onItemClick.invoke(true)
    }
    alertDialogBuilder.setNegativeButton("Cancel") { _: DialogInterface, _: Int ->
        onItemClick.invoke(false)
    }

    val alertDialog: AlertDialog = alertDialogBuilder.create()
    if (!alertDialog.isShowing) {
        alertDialog.show()
    }
}