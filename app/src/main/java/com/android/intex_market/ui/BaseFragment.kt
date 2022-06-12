package com.android.intex_market.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.intex_market.utils.BookingDialog
import com.android.intex_market.utils.SuccessfulDialog

abstract class BaseFragment(private val layoutRes: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(layoutRes, container, false)
    }

    protected fun showBookingDialog() {
        val dialog = BookingDialog()
        dialog.onClickListener = {
           dialog.showSuccessfulDialog()
        }
        dialog.show(childFragmentManager, "booking_dialog")
    }

    fun showSuccessfulDialog() {
        val dialog = SuccessfulDialog()
        dialog.onClickListener ={
            dialog.dismiss()
        }

        dialog.show(childFragmentManager, "successful_dialog")
    }



    fun showKeyboard(editText: EditText) {
        editText.requestFocus()
        val content =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        content.showSoftInput(editText, 0)
        content.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
        )
    }

    fun hideKeyboard() {
        val manage =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manage.hideSoftInputFromWindow(requireView().windowToken, 0)
    }

    fun toaster(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun toasty(msg:String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}