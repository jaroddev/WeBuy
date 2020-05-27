package com.example.webay2.ui.offer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webay2.entities.Product;
import com.example.webay2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter <ProductListViewHolder>
{
    private Context context;
    List<Product> productList;

    public ProductListAdapter(Context context, List<Product> productList, ProductListFragment storetListFragment) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_product, parent, false);
        return new ProductListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListViewHolder holder, int position) {

       // Picasso.get().load(productList.get(position).getImages().getImages().get(0).getUrlImage()).into(holder.getImage());
        holder.getImage().setImageResource(R.drawable.carrefour);

        holder.getTitle().setText(productList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
