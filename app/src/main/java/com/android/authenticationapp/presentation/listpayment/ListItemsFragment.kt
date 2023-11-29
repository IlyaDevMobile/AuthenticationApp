package com.android.authenticationapp.presentation.listpayment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.authenticationapp.R
import com.android.authenticationapp.databinding.FragmentListItemsBinding
import com.android.authenticationapp.presentation.recyclerview.PaymentInformationAdapter
import kotlinx.coroutines.launch


class ListItemsFragment : Fragment() {


    private var _binding: FragmentListItemsBinding? = null
    private val binding: FragmentListItemsBinding
        get() = _binding ?: throw RuntimeException("FragmentListItemsBinding is null")


    private lateinit var adapter: PaymentInformationAdapter

    private val viewModel: ListItemsFragmentViewModel by viewModels()


    private val args by navArgs<ListItemsFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListItemsBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadData()
        viewModel.result.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        binding.logout.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }


    }

    private fun setupRecyclerView() {
        val layout = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layout
        adapter = PaymentInformationAdapter()
        binding.recyclerView.adapter = adapter
    }

    private fun loadData() {
        val token = args.token
        viewModel.viewModelScope.launch {
            viewModel.getPaymentInformation(token)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}

