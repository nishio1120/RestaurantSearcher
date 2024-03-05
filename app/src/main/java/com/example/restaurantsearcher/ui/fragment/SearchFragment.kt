package com.example.restaurantsearcher.ui.fragment

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantsearcher.R
import com.example.restaurantsearcher.databinding.FragmentSearchBinding
import com.example.restaurantsearcher.adapter.RangeListAdapter

//キーワードと検索範囲入力画面

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    //RangeListをクリックした時の処理を変数に格納
    private val rangeItemClickListener =
        object : RangeListAdapter.OnRangeItemClickListener {
            override fun onRangeItemClick(range: Int) {
                navigateToSearchLocationFragment(range)
            }
        }

    private val adapter by lazy {
        RangeListAdapter(rangeItemClickListener)
    }

    private var inputText = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.credit.movementMethod = LinkMovementMethod.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSearchInputClick()
        setupRecyclerView()
    }

    private fun setupSearchInputClick() {
        binding.searchInputEditText.doAfterTextChanged { input ->
            val inputString = input.toString()
            inputText = inputString
        }
    }

    private fun setupRecyclerView() {
        //RecyclerViewのレイアウトを設定
        val layoutManager = LinearLayoutManager(requireContext())
        //RecyclerViewの区切り線を設定
        val dividerItemDecoration =
            DividerItemDecoration(requireContext(), layoutManager.orientation)

        val rangeList = resources.getStringArray(R.array.range_array).toList()
        adapter.submitList(rangeList)

        binding.resultListRecyclerView.also {
            it.layoutManager = layoutManager
            it.addItemDecoration(dividerItemDecoration)
            it.adapter = adapter
        }
    }


    //ResultListFragmentに遷移
    private fun navigateToSearchLocationFragment(range: Int) {
        val action =
            SearchFragmentDirections.actionSearchFragmentToLoadFragment(
                inputText,
                range
            )
        findNavController().navigate(action)
        clearKeywordInputText()
    }

    private fun clearKeywordInputText() {
        //EditTextの入力をクリア
        binding.searchInputEditText.text?.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.resultListRecyclerView.adapter = null
        _binding = null
    }
}