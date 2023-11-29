package com.android.authenticationapp.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.authenticationapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding ?: throw RuntimeException("FragmentLoginBinding is null")

    private val viewModel: LoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.login.setOnClickListener {
            val username = binding.username.text.toString().trim()
            val password = binding.password.text.toString().trim()
            viewModel.authenticate(username, password)
        }

        viewModel.loginResult.observe(viewLifecycleOwner) { result ->
            if (result) {
                val token = viewModel.token.value
                if (token != null) {
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToListItemsFragment2(
                            token.toString()
                        )
                    )
                }
            } else {
                Toast.makeText(requireContext(), "ошибка", Toast.LENGTH_SHORT).show()
            }
        }

    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}



