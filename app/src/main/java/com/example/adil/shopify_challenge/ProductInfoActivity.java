package com.example.adil.shopify_challenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Adil on 2017-12-31.
 */

public class ProductInfoActivity extends AppCompatActivity{

    ImageView image;
    TextView title;
    TextView body;
    TextView vendor;
    TextView product_type;
    TextView tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_info_activity);

        image = (ImageView) findViewById(R.id.profilePicID) ;
        title = (TextView) findViewById(R.id.titleID);
        body = (TextView) findViewById(R.id.bodyID);
        vendor = (TextView) findViewById(R.id.vendorID);
        product_type = (TextView) findViewById(R.id.product_typeID);
        tags = (TextView) findViewById(R.id.tagsID);

        Product product = (Product)getIntent().getSerializableExtra("Product");

        title.setText(product.getTitle());
        body.setText(product.getBody_html());
        vendor.setText(product.getVendor());
        product_type.setText(product.getProduct_type());
        tags.setText(product.getTags());

        Picasso.with(getApplicationContext()).load(product.getImage().getSrc()).into(image);




    }
}
