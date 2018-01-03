package com.example.adil.shopify_challenge;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listViewProducts;
    private List<Product> products;
    ShopifyAPI shopifyAPI;
    private ProductListAdapter adapter;
    ShopifyProducts changesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewProducts = (ListView) findViewById(R.id.productList);

      //  Controller controller = new Controller();
      //  controller.start();

         shopifyAPI = APIClient.getClient().create(ShopifyAPI.class);
         Call call = shopifyAPI.getProducts();
         call.enqueue(new Callback(){
             @Override
             public void onResponse(Call call, Response response) {
                 if(response.isSuccessful()) {
                     System.out.println("What is successful?");
                      changesList = (ShopifyProducts) response.body();
                     for(int i=0;i<changesList.products.size();i++) {
                         System.out.println(changesList.products.get(i).getBody_html());
                        // System.out.println(changesList.images.size());
                        // ArrayList<String> tmp = new ArrayList<>();
                         //tmp.add(changesList.products.get(i).getTitle());
                         //tmp.add(changesList.products.get(i).getBody_html());
                         adapter= new ProductListAdapter(getApplicationContext(),changesList.products);  // setting up adapter
                         listViewProducts.setAdapter(adapter);
                     }
                 } else {
                     System.out.println(response.errorBody());
                 }
             }

             @Override
             public void onFailure(Call call, Throwable t) {

             }
         });

        listViewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                Intent editorLaunchInterest = new Intent(getApplicationContext(), ProductInfoActivity.class); // what happens when you press on a profile
                editorLaunchInterest.putExtra("Product", changesList.products.get(position));
                startActivity(editorLaunchInterest);
            }
        });

    }
}
