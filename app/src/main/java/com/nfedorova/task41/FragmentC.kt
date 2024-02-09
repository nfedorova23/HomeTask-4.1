package com.nfedorova.task41

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nfedorova.task41.databinding.FragmentCBinding


class FragmentC : Fragment() {
    private lateinit var binding: FragmentCBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val message = arguments?.getString(KEY)

        with(binding) {
            message?.let {
                textViewC.text = it
            }

            btnCD.setOnClickListener {
                (requireActivity() as? NextButtonClickListener)?.onNextButtonClicked()
            }

            btnCA.setOnClickListener {
                (requireActivity() as MainActivity).back(FragmentA.TAG_A)
            }
        }
    }

    interface NextButtonClickListener{
        fun onNextButtonClicked()
    }

    companion object {
        const val KEY = "KEY"
        const val TAG_C = "TAG_C"

        fun newInstance(bundle: Bundle) = FragmentC().apply {
            arguments = bundle
        }
    }

}