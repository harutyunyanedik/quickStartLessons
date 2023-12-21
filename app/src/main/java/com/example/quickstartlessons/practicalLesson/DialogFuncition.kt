package com.example.quickstartlessons.practicalLesson

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.showAlertDialog(onItemClick: (Boolean) -> Unit) {
    val alertDialogBuilder = AlertDialog.Builder(this)
    alertDialogBuilder.setTitle("Confirmation")
    alertDialogBuilder.setMessage("Are you want to delete this item")

    alertDialogBuilder.setPositiveButton("YES") { _: DialogInterface, _: Int ->
        onItemClick.invoke(true)

    }
    alertDialogBuilder.setNegativeButton("NO") { _: DialogInterface, _: Int ->
        onItemClick.invoke(false)

    }

    val alertDialog: AlertDialog = alertDialogBuilder.create()
    if (!alertDialog.isShowing) {
        alertDialog.show()
    }
}