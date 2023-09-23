package net.flow9.thisiskotlin.myapplication1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import net.flow9.thisiskotlin.myapplication1.databinding.FragmentSearchBinding


class Search : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var mContext: Context
    private lateinit var adapter: SearchAdapter
    private lateinit var gridmanager: StaggeredGridLayoutManager

    private var resItems: ArrayList<Model> = ArrayList()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        setupViews()
        setupListeners()

        return binding.root
    }
    private fun setupViews() {
        gridmanager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvSearchResult.layoutManager = gridmanager

        adapter = SearchAdapter(mContext)
        binding.rvSearchResult.adapter = adapter
        binding.rvSearchResult.itemAnimator = null

        val lastSearch = Utils.getLastSearch(requireContext())
        binding.etSearch.setText(lastSearch)
    }

    private fun setupListeners() {
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        binding.tvSearch.setOnClickListener {
            val query = binding.etSearch.text.toString()
            if (query.isNotEmpty()) {
                Utils.saveLastSearch(requireContext(), query)
                adapter.clearItem()
            } else {
                Toast.makeText(mContext, "검색어를 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }


            imm.hideSoftInputFromWindow(binding.etSearch.windowToken, 0)
        }
    }
}