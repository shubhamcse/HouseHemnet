package com.assignment.househemnet.propertiesList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.househemnet.databinding.ActivityMainBinding
import com.assignment.househemnet.utils.ListViewModelFactory
import com.assignment.househemnet.utils.Status

class ListActivity : AppCompatActivity() {

    private val listViewModel: ListViewModel by lazy {
        ViewModelProviders.of(
            this,
            ListViewModelFactory(ListRepository())
        ).get(ListViewModel::class.java)
    }

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val listAdapter: ListAdapter by lazy {
        ListAdapter(onItemClicked = {
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
        }, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setRecyclerView()
        listViewModel.getProperties().observe(this, {
            it?.let { result ->
                when (result.status) {
                    Status.LOADING -> {
                        showLoadingView()
                    }
                    Status.SUCCESS -> {
                        setDataOnRecyclerView(result.data?.items)
                    }
                    Status.ERROR -> {
                        //can show error screen here & retry option
                    }
                }
            }
        })
    }
    private fun setRecyclerView() {
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        with(binding) {
            recyclerView.layoutManager = manager
            recyclerView.adapter = listAdapter
        }
    }

    private fun showLoadingView() {
        with(binding) {
            indeterminateBar.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        }
    }

    private fun setDataOnRecyclerView(result: List<Item>?) {
        with(binding) {
            indeterminateBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
        Log.i("TAG", "setDataOnRecyclerView: "+result.toString())
        result?.let { listAdapter.setData(it) }
    }

}
