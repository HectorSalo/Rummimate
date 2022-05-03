package com.skysam.hchirinos.rummimate.ui

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.skysam.hchirinos.rummimate.R
import com.skysam.hchirinos.rummimate.databinding.FragmentHomeBinding
import com.skysam.hchirinos.rummimate.viewModels.MainViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()
    private var image: Bitmap? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadViewModels()

        binding.btnSend.setOnClickListener {
            if (image != null) {
                binding.imageView.visibility = View.GONE
                binding.btnSend.visibility = View.GONE
                binding.textviewFirst.visibility = View.GONE
                viewModel.visibilityFab(false)
                binding.lottieAnimationView.visibility = View.VISIBLE
                binding.lottieAnimationView.playAnimation()
                lifecycleScope.launch {
                    delay(2000)
                    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                }
            }
        }
    }

    private fun loadViewModels() {
        viewModel.imageTaked.observe(viewLifecycleOwner) {
            if (_binding != null) {
                if (it != null) {
                    binding.imageView.setImageBitmap(it)
                    binding.btnSend.visibility = View.VISIBLE
                    image = it
                } else {
                    binding.imageView.setImageResource(R.drawable.ic_image_72)
                    binding.btnSend.visibility = View.GONE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}