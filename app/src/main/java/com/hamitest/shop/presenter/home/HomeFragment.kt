package com.hamitest.shop.presenter.home

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.hamitest.shop.MainActivity
import com.hamitest.shop.R
import com.hamitest.shop.data.di.module.ViewModelFactory
import com.hamitest.shop.databinding.FragmentHomeBinding
import com.hamitest.shop.presenter.allProductList.AllProductListFragment
import javax.inject.Inject

class HomeFragment : Fragment(), ProductHpAdapter.CreateFragmentCallBackHomeToDetail {

    private lateinit var mCategoryAdapter: CategoryHomeAdapter
    private lateinit var mProductHpAdapter: ProductHpAdapter
    private lateinit var mBinding: FragmentHomeBinding

    @Inject
    lateinit var mHomeViewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    fun newInstance(): HomeFragment {
        val fragment = HomeFragment()
        val args = Bundle()
        fragment.arguments = args
        return fragment
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainActivitySubComponent.inject(this)

    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        activity?.window?.decorView?.layoutDirection = View.LAYOUT_DIRECTION_RTL

        //mHomeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        mHomeViewModel = ViewModelProvider(requireActivity(),viewModelFactory).get(HomeViewModel::class.java)

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        setupSlider()
        setupObservers()
        setupRecyclerView()
        setupListener()
        provideCategories()

        return mBinding.root
    }


    private fun provideCategories() {
        mHomeViewModel.getAllCategories()
    }

    private fun setupListener() {

        mBinding.tvSeeAllLatestProducts.setOnClickListener {
            navigateToAllProductListFragment(hashMapOf("orderby" to "date"))

        }

        mBinding.tvSeeAllMostPointsProducts.setOnClickListener {
            navigateToAllProductListFragment(hashMapOf("orderby" to "rating"))
        }

        mBinding.tvSeeAllMostViewedProducts.setOnClickListener {
            navigateToAllProductListFragment(hashMapOf("orderby" to "popularity"))
        }
    }

    private fun navigateToAllProductListFragment(queryMap: HashMap<String, String>) {
        val bundle = Bundle()
        bundle.apply { putSerializable(AllProductListFragment.ARGS_QUERY_MAP, queryMap) }
        findNavController().navigate(R.id.navigation_all_product_list, bundle)
    }

    private fun setupRecyclerView() {
        mBinding.recyclerViewCategoryHomePage.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        mBinding.recViewNewestProductsListHome.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        mBinding.recViewMostViewedProductsListHome.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        mBinding.recViewMostPointsProductsListHome.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        mBinding.recyclerViewCategoryHomePage.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

    }

    private fun setupObservers() {

        mHomeViewModel.getListCategoryMutableLiveData()
            .observe(viewLifecycleOwner, Observer { list ->
                mCategoryAdapter = CategoryHomeAdapter(list)
                mBinding.recyclerViewCategoryHomePage.adapter = mCategoryAdapter
            })

        mHomeViewModel.getListNewestProMutableLiveData()
            .observe(viewLifecycleOwner, Observer { list ->
                setupProductAdapter(list, mBinding.recViewNewestProductsListHome)
            })

        mHomeViewModel.getListPopularProMutableLiveData()
            .observe(viewLifecycleOwner, Observer { list ->
                setupProductAdapter(list, mBinding.recViewMostViewedProductsListHome)
            })

        mHomeViewModel.getListMostPointProMutableLiveData()
            .observe(viewLifecycleOwner, Observer { list ->
                setupProductAdapter(list, mBinding.recViewMostPointsProductsListHome)
            })

    }


    private fun setupProductAdapter(
        list: List<ProductItem>,
        recyclerView: RecyclerView
    ) {
        mProductHpAdapter = ProductHpAdapter(list, this)
        recyclerView.adapter = mProductHpAdapter
    }


/*
        mBanner = new Banner.Builder(getContext())
                .setParent(mBinding.llCategoryHomePage)
                .setIcon(R.drawable.ic_wifi)
                .setMessage("You have lost connection to the Internet. This app is offline.")
                .setLeftButton("Dismiss", new BannerInterface.OnClickListener() {
                    @Override
                    public void onClick(BannerInterface banner) {
                        mBanner.dismiss();
                    }
                })
                .setRightButton("Turn on wifi", new BannerInterface.OnClickListener() {
                    @Override
                    public void onClick(BannerInterface banner) {
                        if (isOnline(getContext())) {
                            mBanner.setVisibility(View.GONE);
                            mBanner.dismiss();
                            //recreate();
                        } else {
                            mBanner.show();
                            mBanner.setVisibility(View.VISIBLE);
                        }
                    }
                })
                .create();

        if (isOnline(getContext())) {
            mBanner.setVisibility(View.GONE);
            mBanner.dismiss();
            //recreate();
        } else {
            mBinding.sliderPicApp.setVisibility(View.INVISIBLE);
            mBanner.show();
            mBanner.setVisibility(View.VISIBLE);

        }*/

    private fun setupSlider() {
        val url_maps =
            HashMap<String, String>()
        url_maps["عطر و ادکلن مردانه"] =
            "https://woocommerce.maktabsharif.ir/wp-content/uploads/2020/01/1000016881.jpg"
        url_maps["سوپرمارکت"] =
            "https://woocommerce.maktabsharif.ir/wp-content/uploads/2020/01/1000016197.jpg"
        url_maps["گجت آشپزخانه"] =
            "https://woocommerce.maktabsharif.ir/wp-content/uploads/2020/01/1000016913.jpg"
        url_maps["انواع لباس زنانه"] =
            "https://woocommerce.maktabsharif.ir/wp-content/uploads/2020/01/1000016833.jpg"
        url_maps["لوازم پخت و پز"] =
            "https://woocommerce.maktabsharif.ir/wp-content/uploads/2020/01/1000016887.jpg"
        url_maps["کامان"] =
            "https://woocommerce.maktabsharif.ir/wp-content/uploads/2020/01/1000017104.jpg"
        url_maps["انواع کفش مردانه"] =
            "https://woocommerce.maktabsharif.ir/wp-content/uploads/2020/01/1000016859.jpg"
        for (name in url_maps.keys) {
            val textSliderView = TextSliderView(context)
            // initialize a SliderLayout
            textSliderView
                .description(name)
                .image(url_maps[name]).scaleType = BaseSliderView.ScaleType.Fit

            //add your extra information
            textSliderView.bundle(Bundle())
            textSliderView.bundle
                .putString("extra", name)
            mBinding.sliderPicApp.addSlider(textSliderView)
        }
        mBinding.sliderPicApp.setPresetTransformer(SliderLayout.Transformer.Accordion)
        mBinding.sliderPicApp.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        mBinding.sliderPicApp.setDuration(5000)
    }

    override fun navigateFragment(productId: Int) {
        //use safe args
        val action = HomeFragmentDirections.actionNavigationHomeToNavigationDetailProduct(productId)
        findNavController().navigate(action)
    }


}