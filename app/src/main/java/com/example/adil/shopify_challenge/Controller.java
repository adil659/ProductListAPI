package com.example.adil.shopify_challenge;

import android.widget.ArrayAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SocketHandler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Adil on 2017-12-23.
 */
public class Controller implements Callback<ShopifyProducts> {

    static final String BASE_URL = "https://shopicruit.myshopify.com/";
    private ArrayList<ArrayList<String>> productList = new ArrayList<>();
    private ProductListAdapter adapter;
    private static Retrofit retrofit = null;

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ShopifyAPI shopifyAPI = retrofit.create(ShopifyAPI.class);
        System.out.println("Hello");
        Call<ShopifyProducts> call = shopifyAPI.getProducts();
        call.enqueue(this);

    }
    @Override
    public void onResponse(Call<ShopifyProducts> call, Response<ShopifyProducts> response) {
        System.out.println("did we get in response?");
        System.out.println(response);
        if(response.isSuccessful()) {
            System.out.println("What is successful?");
            ShopifyProducts changesList = response.body();
            for(int i=0;i<changesList.products.size();i++) {
            //    System.out.println(changesList.products.get(i).getBody_html());
                ArrayList<String> tmp = new ArrayList<>();
               // tmp.add(changesList.products.get(i).getTitle());
               // tmp.add(changesList.products.get(i).getBody_html());
                productList.add(tmp);
            }
        } else {
            System.out.println(response.errorBody());
        }
    }
    @Override
    public void onFailure(Call<ShopifyProducts> call, Throwable t) {
        t.printStackTrace();
    }
}
