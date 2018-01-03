package com.example.adil.shopify_challenge;

/**
 * Created by Adil on 2017-12-23.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Adil on 2017-12-16.
 */

public interface ShopifyAPI {

    @GET(" admin/products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Call<ShopifyProducts> getProducts();

    @GET(" admin/products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Call<ShopifyProducts> getImages();
}


