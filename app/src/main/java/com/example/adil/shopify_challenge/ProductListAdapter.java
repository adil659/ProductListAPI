package com.example.adil.shopify_challenge;

import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;


        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by Adil on 2017-12-16.
 */

public class ProductListAdapter extends ArrayAdapter {

    private final Context context;
    private ArrayList<Product> myProducts;

    public ProductListAdapter(Context context, ArrayList<Product> choreList) {
        super(context, R.layout.product_item_layout, choreList);
        this.context = context;
        this.myProducts = choreList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.product_item_layout, parent, false);


            TextView name = (TextView) rowView.findViewById(R.id.productName);

            ((TextView) rowView.findViewById(R.id.productName)).setText(myProducts.get(position).getTitle());

            TextView choreDescriptionTextField = (TextView) rowView.findViewById(R.id.productDescription);
            choreDescriptionTextField.setText(myProducts.get(position).getBody_html());
            ImageView choreImage = (ImageView) rowView.findViewById(R.id.productIcon);

             Picasso.with(context).load(myProducts.get(position).getImage().getSrc()).into(choreImage);





        return rowView;
    }


}
