package com.example.quickstartlessons

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.showAlertDialog() {
    val alertDialogBuilder = AlertDialog.Builder(this)

    alertDialogBuilder.setTitle("Alert Dialog")
    alertDialogBuilder.setMessage("Do you want to close the application")

    alertDialogBuilder.setPositiveButton("YES") { _: DialogInterface, _: Int ->


    }
    alertDialogBuilder.setNegativeButton("NO") { _: DialogInterface, _: Int ->

    }

    val alertDialog: AlertDialog = alertDialogBuilder.create()
    if (!alertDialog.isShowing) {
        alertDialog.show()
    }
}