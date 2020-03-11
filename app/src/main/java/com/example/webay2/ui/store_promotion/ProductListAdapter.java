package com.example.webay2.ui.store_promotion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webay2.ProductData;
import com.example.webay2.R;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter <ProductListViewHolder>
{
    private Context context;
    List<ProductData> productDataList;

    public ProductListAdapter(Context context, List<ProductData> productDataList, ProductListFragment storetListFragment) {
        this.context = context;
        this.productDataList = productDataList;
    }

    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_product, parent, false);
        return new ProductListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListViewHolder holder, int position) {

        holder.getImage().setImageResource(productDataList.get(position).getImages().get(0).intValue());
        holder.getTitle().setText(productDataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return productDataList.size();
    }
}
