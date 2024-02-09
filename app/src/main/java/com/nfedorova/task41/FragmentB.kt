package com.nfedorova.task41

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nfedorova.task41.databinding.FragmentBBinding


class FragmentB : Fragment() {
    private lateinit var binding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnBC.setOnClickListener {
                val bundle = Bundle()
                bundle.putString(KEY, STRING)
                (requireActivity() as MainActivity).next(FragmentC.TAG_C, bundle)
            }

            btnBA.setOnClickListener {
                (requireActivity() as MainActivity).back(FragmentA.TAG_A)
            }
        }
    }

    companion object {
        const val STRING = "Hello Fragment C"
        const val KEY = "KEY"
        const val TAG_B = "TAG_B"

        fun newInstance() = FragmentB()
    }
}