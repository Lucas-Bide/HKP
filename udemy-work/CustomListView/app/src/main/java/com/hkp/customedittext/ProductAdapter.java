package com.hkp.customedittext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {
    private final Context context;
    private final ArrayList<Product> values;

    public ProductAdapter(@NonNull Context context, ArrayList<Product> values) {
        super(context, R.layout.row_layout, values);
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_layout, parent, false);

        TextView tvProduct = rowView.findViewById(R.id.tvProduct);
        TextView tvPrice = rowView.findViewById(R.id.tvPrice);
        TextView tvDescription = rowView.findViewById(R.id.tvDescription);
        ImageView ivProduct = rowView.findViewById(R.id.ivProduct);
        ImageView ivSale = rowView.findViewById(R.id.ivSale);

        Product product = values.get(position);

        tvProduct.setText(product.getTitle());
        tvPrice.setText(String.format("$%s", Double.toString(product.getPrice())));
        tvDescription.setText(product.getDescription());

        switch (product.getType())
        {
            case "laptop":
                ivProduct.setImageResource(R.mipmap.laptop_foreground);
                break;
            case "memory":
                ivProduct.setImageResource(R.mipmap.memory_foreground);
                break;
            case "hdd":
                ivProduct.setImageResource(R.mipmap.hdd_foreground);
                break;
            case "screen":
                ivProduct.setImageResource(R.mipmap.screen_foreground);
                break;
        }

        if (product.getSale()) {
            ivSale.setImageResource(R.mipmap.on_sale_foreground);
        }
        else {
            ivSale.setImageResource(R.mipmap.best_price_foreground);
        }

        return rowView;
    }
}
