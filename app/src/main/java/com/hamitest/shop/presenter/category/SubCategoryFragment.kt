package com.hamitest.shop.presenter.category

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hamitest.shop.MainActivity
import com.hamitest.shop.R
import com.hamitest.shop.data.di.module.ViewModelFactory
import com.hamitest.shop.presenter.allproductlist.AllProductListFragment
import javax.inject.Inject


class SubCategoryFragment : Fragment(), SubCategoryAdapter.CreateFragmentCallBackSubToAllProList {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var mCategoryViewModel: CategoryViewModel
    val ARG_ID_CATEGORY = "Arg idCategory"
    private val mDisplaySubCategory = "subcategories"
    private var mIdParentCategory: Int = 0
    private lateinit var mRecyclerView: RecyclerView


    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity() as MainActivity).mainActivitySubComponent.inject(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mIdParentCategory = it.getInt(ARG_ID_CATEGORY)
        }

        mCategoryViewModel =
            ViewModelProvider(this, viewModelFactory).get(CategoryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_sub_category, container, false)

        initRecyclerView(root)
        mCategoryViewModel.getSubCategory(mIdParentCategory).observe(viewLifecycleOwner, Observer {
            setupAdapter(it)
        })


        return root
    }

    private fun initRecyclerView(root: View) {
        mRecyclerView = root.findViewById(R.id.recycler_view_sub_categories_frag_viewp)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun setupAdapter(list: List<SubCategoryItem>) {
        if (isAdded) {
            mRecyclerView.adapter = SubCategoryAdapter(list, this)
        }
    }


    companion object {
        val tagSubCategoryFragment = "com.hamitest.shop.presenter.category.SubCategoryFragment"

        @JvmStatic
        fun newInstance(idParentCategory: Int) =
            SubCategoryFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ID_CATEGORY, idParentCategory)
                }
            }
    }

    override fun navigateFragment(queryMap: HashMap<String, String>) {

        //use safe args
//        val action = SubCategoryFragmentDirections
//            .actionNavigationSubCategoryToNavigationAllProductList(queryMap)
//        findNavController().navigate(action)

        //unUse safe Args
        val bundle = Bundle()
        bundle.apply { putSerializable(AllProductListFragment.ARGS_QUERY_MAP, queryMap) }
        findNavController().navigate(R.id.navigation_all_product_list, bundle)
    }


}