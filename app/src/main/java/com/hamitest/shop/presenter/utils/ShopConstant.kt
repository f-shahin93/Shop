package com.hamitest.shop.presenter.utils

import android.util.Log
import javax.inject.Inject

class ShopConstant @Inject constructor() {

    companion object {

        fun showError(error: com.hamitest.shop.data.model.Error) {
            Log.d("Tag", "showError() called  with: error = [$error]")
        }

    }

}