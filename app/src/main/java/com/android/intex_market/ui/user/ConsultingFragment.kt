package com.android.intex_market.ui.user

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.intex_market.R
import com.android.intex_market.databinding.FragmentConsultingBinding
import com.android.intex_market.model.ConsultingModel
import com.android.intex_market.networking.ApiClient
import com.android.intex_market.ui.BaseFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class ConsultingFragment : BaseFragment(R.layout.fragment_consulting) {
    private lateinit var binding: FragmentConsultingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConsultingBinding.inflate(inflater, container, false);
        initViews()
        return binding.root
    }

    private fun initViews() {

        binding.apply {
            bookBtn.setOnClickListener {
                val activity = false
                val name = nameEdt.text.toString()
                val number = numberEdt.text.toString()
                val d = Date()
                val date = DateFormat.format("MMMM d, yyyy ", d.time).toString()
                val consult = ConsultingModel(activity, date, name, number)
                Log.d("@@@@", consult.toString())
                apiSendConsultation(consult)
            }
        }

    }

    private fun apiSendConsultation(consult: ConsultingModel) {
        ApiClient.apiService.takeConsultation(consult)
            .enqueue(object : Callback<ConsultingModel> {
                override fun onResponse(
                    call: Call<ConsultingModel>,
                    response: Response<ConsultingModel>
                ) {
                    showSuccessfulDialog()
                }

                override fun onFailure(call: Call<ConsultingModel>, t: Throwable) {
                    toasty("Something is wrong")
                }

            })
    }
}

