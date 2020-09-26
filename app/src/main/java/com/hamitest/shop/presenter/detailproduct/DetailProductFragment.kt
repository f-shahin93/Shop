package com.hamitest.shop.presenter.detailproduct

import android.content.Context
import android.graphics.Paint
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.hamitest.shop.MainActivity
import com.hamitest.shop.R
import com.hamitest.shop.data.di.component.DaggerApplicationComponent
import com.hamitest.shop.data.di.module.ViewModelFactory
import com.hamitest.shop.data.model.product.Attribute
import com.hamitest.shop.data.model.product.Product
import com.hamitest.shop.databinding.FragmentDetailBinding
import com.hamitest.shop.presenter.allProductList.AllProductListFragment
import com.hamitest.shop.presenter.home.HomeViewModel
import javax.inject.Inject


class DetailProductFragment : Fragment() {

    val ARG_PRODUCT = "Arg product"

    @Inject
    lateinit var mDetailProViewModel: DetailProductViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var mProductId = 0
    private lateinit var mProduct: Product
    private lateinit var mBinding: FragmentDetailBinding


    companion object {

        @JvmStatic
        fun newInstance(productId: Int): DetailProductFragment =
            DetailProductFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PRODUCT, productId)
                }
            }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).mainActivitySubComponent.inject(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mProductId = DetailProductFragmentArgs.fromBundle(it).productId
        }

        mDetailProViewModel =
            ViewModelProvider(this, viewModelFactory).get(DetailProductViewModel::class.java)

        mDetailProViewModel.getProductLiveData(mProductId).observe(this, Observer { product ->
            mDetailProViewModel.mProduct = product
            mProduct = product
            initUI()
            setupSlider()
        })


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        mBinding.activityProductDetailsAddToCartBtnLayout.setOnClickListener {
            MainActivity.isNavigateTOShoppingCart = true
            requireActivity().finish()
            //  mDetailProViewModel.addProduct(mProduct)
            //startActivity(ShoppingCartActivity.newIntent(context))
        }



        return mBinding.root
    }


    private fun initUI() {
        mBinding.tvProductDetailsMainTitle.text = mProduct.name
        if (mProduct.shortDescription == null || mProduct.shortDescription.equals("")) {
            mBinding.tvProductDetailsSecondaryTitle.setVisibility(View.GONE)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) mBinding.tvProductDetailsSecondaryTitle.setText(
                Html.fromHtml(mProduct.shortDescription, Html.FROM_HTML_MODE_LEGACY)
            ) else {
                val sp = Html.fromHtml(mProduct.shortDescription)
                mBinding.tvProductDetailsSecondaryTitle.setText(sp)
            }
        }
        if (!mProduct.status.equals("publish")) {
            mBinding.activityProductDetailsConfigLayout.setVisibility(View.GONE)
            mBinding.tvProductDetailsNotExist.setVisibility(View.VISIBLE)
        } else {
            if (mProduct.attributes != null && mProduct.attributes.size > 0) {
                if (mProduct.attributes.get(0).name.equals("رنگ")) {
                    initUIColorText(mProduct.attributes.get(0))
                } else {
                    initUISizeText(mProduct.attributes.get(0))
                }
                if (mProduct.attributes.size > 1) {
                    if (mProduct.attributes.get(1).name.equals("رنگ")) {
                        initUIColorText(mProduct.attributes.get(1))
                    } else {
                        initUISizeText(mProduct.attributes.get(1))
                    }
                }
            }
            for (i in 0 until mProduct.categories.size) {
                if (mProduct.categories.get(i).name.equals("خوردنی و آشامیدنی")) {
                    mBinding.tvProductDetailsSentFresh.visibility = View.VISIBLE
                    mBinding.tvProductDetailsSentFrom.visibility = View.GONE
                    break
                } else {
                    mBinding.tvProductDetailsSentFresh.visibility = View.GONE
                    mBinding.tvProductDetailsSentFrom.visibility = View.VISIBLE
                }
            }
            if (mProduct.regularPrice != null && mProduct.regularPrice !== "") {
                mBinding.tvProductDetailsPayablePrice.setText(
                    mProduct.regularPrice.toString() + " تومان"
                )
                mBinding.tvProductDetailsRealPrice.setText(mProduct!!.price + " تومان")
                mBinding.tvProductDetailsRealPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG)
            } else {
                mBinding.tvProductDetailsPayablePrice.setText(mProduct!!.price + " تومان")
                mBinding.tvProductDetailsRealPrice.setVisibility(View.GONE)
            }
            mBinding.progressBarProductDetailsAddToCart.hide()
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mBinding.tvDescriptorDetailProduct.setText(
                Html.fromHtml(
                    mProduct.description,
                    Html.FROM_HTML_MODE_LEGACY
                )
            )
        } else {
            val sp = Html.fromHtml(mProduct.description)
            mBinding.tvDescriptorDetailProduct.text = sp
        }
        mBinding.tvRateDetailProduct.setText(mProduct.averageRating)
        mBinding.activityProductDetailsRlCommentBtn.setOnClickListener { view ->
//            startActivity(
//                ReviewActivity.newIntent(context, mProductId, mProduct!!.name)
//            )
        }
    }

    private fun setupSlider() {
        val url_maps: HashMap<String, String> = HashMap()

//        for (ImagesItem imagesItem : mProduct.getImages()) {
//            url_maps.put("", imagesItem.getSrc());
//        }
        for (i in mProduct!!.images.indices) {
            url_maps[mProduct!!.images[i].name] = mProduct!!.images[i].src
        }
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
            mBinding.sliderDetailProduct.addSlider(textSliderView)
        }
        mBinding.sliderDetailProduct.setPresetTransformer(SliderLayout.Transformer.Accordion)
        mBinding.sliderDetailProduct.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        mBinding.sliderDetailProduct.setDuration(5000)
    }

    fun initUIColorText(attribute: Attribute) {
        mBinding.tvProductDetailsColor.setVisibility(View.VISIBLE)
        mBinding.tvProductDetailsColorCount.setVisibility(View.VISIBLE)
        mBinding.tvProductDetailsColorShow.setVisibility(View.VISIBLE)
        val countColor: Int = attribute.options.size
        mBinding.tvProductDetailsColorCount.setText("$countColor رنگ")
        var namesColor: String = attribute.options.get(0)
        for (i in 1 until countColor) {
            namesColor += " , " + attribute.options.get(i)
        }
        mBinding.tvProductDetailsColorShow.text = namesColor
    }

    fun initUISizeText(attribute: Attribute) {
        mBinding.tvProductDetailsSizeCount.setVisibility(View.VISIBLE)
        mBinding.tvProductDetailsSize.setVisibility(View.VISIBLE)
        mBinding.tvProductDetailsSizeShow.setVisibility(View.VISIBLE)
        val countSize: Int = attribute.options.size
        mBinding.tvProductDetailsSizeCount.setText("$countSize سایز")
        var namesSize: String = attribute.options.get(0)
        for (i in 1 until countSize) {
            namesSize += " , " + attribute.options.get(i)
        }
        mBinding.tvProductDetailsSizeShow.setText(namesSize)
    }


}