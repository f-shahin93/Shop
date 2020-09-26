package com.hamitest.shop.presenter.shoppingcart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamitest.shop.R
import com.hamitest.shop.databinding.FragmentShoppingCartBinding

class ShoppingCartFragment : Fragment() {

    private lateinit var mShoppingCartViewModel: ShoppingCartViewModel
    private lateinit var mBinding: FragmentShoppingCartBinding
    private lateinit var mShopCartAdapter: ShoppingCartAdapter
    private lateinit var mProductList: List<CartProductItem>

    /*
    private TextView mTvTotalPriceOfCartProducts;
    //private TextView mTvConfirmShopping;
    pr
     */

    companion object {

        fun newInstance(): ShoppingCartFragment =
            ShoppingCartFragment().apply {
                arguments = Bundle().apply {

                }
            }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mShoppingCartViewModel =
            ViewModelProvider(this).get(ShoppingCartViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shopping_cart, container, false)

        mBinding.recyclerViewShoppingCart.layoutManager = LinearLayoutManager(context)



        return mBinding.root
    }


    /*
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (mDetailProViewModel.getTotalPrice().getValue() == null)
            mTvTotalPriceOfCartProducts.setText(0 + " تومان");
        else
            mTvTotalPriceOfCartProducts.setText(String.valueOf(mDetailProViewModel.getTotalPrice().getValue()));
        mDetailProViewModel.getTotalPrice().observe(this, aDouble ->
                mTvTotalPriceOfCartProducts.setText(aDouble + " تومان"));

        mDetailProViewModel.setProductListRepo();
        mDetailProViewModel.getListShoppingCart().observe(this, list -> {
            Log.d("TagProduct", "getListShoppingCart().observe : ");
            mProductList = list;
            setupAdapter();
        });


        mDetailProViewModel.getIsClickDeleteItemLiveData().observe(this, aBoolean -> {
            if (aBoolean) {
                mProductList = mDetailProViewModel.getListShoppingCart().getValue();
                setupAdapter();
            }
        });

        mDetailProViewModel.getIsChangingItemCartLiveData().observe(this, aBoolean -> {
            if (aBoolean) {
                mTvTotalPriceOfCartProducts.setText(String.valueOf(mDetailProViewModel.getTotalPrice()));
            }
        });

        mTvConfirmShopping.setOnClickListener(view1 ->{
            mDetailProViewModel.postOrders(mProductList).observe(this, aBoolean -> {
                if(aBoolean){
                    Toast.makeText(getContext(), "خرید نهایی شد!", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getContext(), "مجددا تلاش کنید!", Toast.LENGTH_SHORT).show();
            });
                });


        return view;
    }





    private void setupAdapter() {
        if (isAdded()) {
            mAdapter = new ProductShoppingCartAdapter(getContext(), mProductList);
            mRecyclerView.setAdapter(mAdapter);
//            if (mAdapter != null) {
//                mAdapter.setListadapter(mProductList);
//                mAdapter.notifyDataSetChanged();
//
//            } else {
//                mAdapter = new ProductShoppingCartAdapter(getContext(), mProductList);
//                mRecyclerView.setAdapter(mAdapter);
//            }
        }
    }
     */

}