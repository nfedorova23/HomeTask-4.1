package com.nfedorova.task41

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nfedorova.task41.databinding.FragmentDBinding


class FragmentD : Fragment() {
    private lateinit var binding: FragmentDBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDB.setOnClickListener {
            (requireActivity() as MainActivity).back(FragmentB.TAG_B)
        }
    }

    companion object {
        const val TAG_D = "TAG_D"

        fun newInstance() = FragmentD()
    }
}