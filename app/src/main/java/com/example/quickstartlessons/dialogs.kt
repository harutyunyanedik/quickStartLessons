package com.example.quickstartlessons

import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.quickstartlessons.databinding.ItemBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Calendar

private fun AppCompatActivity.showAlertDialog() {
    val alertDialogBuilder = AlertDialog.Builder(this)

    alertDialogBuilder.setTitle("Alert Title")
    alertDialogBuilder.setMessage("This is an example alert message.")

    alertDialogBuilder.setPositiveButton("OK") { _: DialogInterface, _: Int ->

    }
    alertDialogBuilder.setNegativeButton("Cancel") { _: DialogInterface, _: Int ->

    }

    val alertDialog: AlertDialog = alertDialogBuilder.create()
    if (!alertDialog.isShowing) {
        alertDialog.show()
    }
}

private fun showProgressDialog() {
    // create simple progress bar in layout and visible gone imitate
}

private fun Activity.showDatePickerDialog(supportFragmentManager: FragmentManager) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        this, { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
            val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            Toast.makeText(this, "Selected Date: $selectedDate", Toast.LENGTH_SHORT).show()
        },
        year,
        month,
        day
    )
    datePickerDialog.show()
}

private fun Activity.showTimePickerDialog() {
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    val timePickerDialog = TimePickerDialog(
        this, { _: TimePicker, selectedHour: Int, selectedMinute: Int ->
            val selectedTime = "$selectedHour:$selectedMinute"
            Toast.makeText(this, "Selected Time: $selectedTime", Toast.LENGTH_SHORT).show()
        },
        hour,
        minute,
        true // Set true for 24-hour format, false for 12-hour format
    )

    timePickerDialog.show()
}

private fun AppCompatActivity.showDialogFragment() {
    val dialogFragment = MyDialogFragment()
    dialogFragment.show(supportFragmentManager, "MyDialogFragment")
}

private fun AppCompatActivity.showBottomSheetDialog() {
    val bottomSheetFragment = BottomSheetFragment()
    bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
}

fun AppCompatActivity.showFullScreenDialog() {
    val bottomSheetFragment = FullScreenDialogFragment()
    bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
}


class MyDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Dialog Title")
            .setMessage("This is a custom DialogFragment.")
            .setPositiveButton("OK") { _, _ ->
                // Handle positive button click
            }
            .setNegativeButton("Cancel") { _, _ ->
                // Handle negative button click or do nothing
            }
            .create()
    }
}

class BottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: ItemBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }
}

class FullScreenDialogFragment : DialogFragment() {

    private lateinit var binding: ItemBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}