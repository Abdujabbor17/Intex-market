package com.android.intex_market.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.android.intex_market.R
import com.android.intex_market.databinding.ViewDialogBookingBinding
import com.android.intex_market.ui.BaseFragment

class BookingDialog : DialogFragment() {

    lateinit var onClickListener: (() -> Unit)
    private var _bn: ViewDialogBookingBinding? = null
    private val bn get() = _bn!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.CustomDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bn = ViewDialogBookingBinding.inflate(inflater, container, false)
        return bn.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = false

        bn.apply {

            cancelBtn.setOnClickListener {
                dismiss()
            }

            bookBtn.setOnClickListener {
                onClickListener.invoke()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _bn = null
    }

     fun showSuccessfulDialog() {
        val dialog = SuccessfulDialog()
         dialog.onClickListener ={
             dismiss()
         }

        dialog.show(childFragmentManager, "successful_dialog")
    }
}