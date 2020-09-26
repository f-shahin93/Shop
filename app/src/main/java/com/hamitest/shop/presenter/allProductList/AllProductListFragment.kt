package com.hamitest.shop.presenter.allProductList

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hamitest.shop.MainActivity
import com.hamitest.shop.R
import com.hamitest.shop.data.di.module.ViewModelFactory
import com.hamitest.shop.presenter.EndlessRecyclerViewScrollListener
import javax.inject.Inject


class AllProductListFragment : Fragment() {

    val ARG_STATUS_LIST = "Arg_Status"
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AllProductListAdapter
    private var statusMap: HashMap<String, String> = hashMapOf()

    @Inject
    lateinit var allProductViewModel: AllProductListViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var endlessRecyclVScrollListener: EndlessRecyclerViewScrollListener
    private var pageNumber = 1


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainActivitySubComponent.inject(this)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            /** set param from newInstance */
            //statusMap = it.getSerializable(ARG_STATUS_LIST) as HashMap<String, String>

            statusMap = it.getSerializable(ARGS_QUERY_MAP) as HashMap<String, String>

            /** use safe args */
            //statusMap = AllProductListFragmentArgs.fromBundle(it).queryMap
        }

        allProductViewModel =
            ViewModelProvider(this, viewModelFactory).get(AllProductListViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root: View = inflater.inflate(R.layout.fragment_all_product_list, container, false)
        recyclerView = root.findViewById(R.id.recycler_view_all_product_list)
        recyclerView.layoutManager = LinearLayoutManager(context)

        allProductViewModel.getProductsOfSubCategory(statusMap)
            .observe(viewLifecycleOwner, Observer {
                setupAdapter(it)
            })


        return root
    }

    fun setupAdapter(list: List<AllProductListItem>) {
        adapter = AllProductListAdapter(list)
        recyclerView.adapter = adapter
    }

    companion object {
        val tagAllProductListFragment =
            "com.hamitest.shop.presenter.AllProductList.AllProductListFragment"
        val ARGS_QUERY_MAP = "Args_query_map"

        @JvmStatic
        fun newInstance(statusMap: HashMap<String, String>) =
            AllProductListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_STATUS_LIST, statusMap)
                }
            }
    }
}