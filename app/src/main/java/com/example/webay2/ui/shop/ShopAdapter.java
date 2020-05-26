package com.example.webay2.ui.shop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webay2.R;
import com.example.webay2.entities.Shop;
import com.example.webay2.ui.offer.ProductListFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter <ShopViewHolder>
{
    private Context context;
    private List<Shop> shopList;
    Fragment prevFragment;

    public ShopAdapter(Context context, List<Shop> shopList, Fragment homeFragment) {
        this.context = context;
        this.shopList = shopList;
        this.prevFragment = homeFragment;


    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_store, parent, false);
        return new ShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ShopViewHolder holder, final int position) {
        //holder.getImage().setImageResource(storeDataList.get(position).getImage());
        Picasso.get().load(shopList.get(position).getShopGroup().getLogo().getUrlImage()).into(holder.getImage());
        holder.getTitle().setText(shopList.get(position).getShopGroup().getName());




        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {

                ProductListFragment magasinFragment = new ProductListFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable("magasin", shopList.get(position));
                //bundle.putSerializable("inflater", (Serializable) LayoutInflater.from(context));
                magasinFragment.setArguments(bundle);
                ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()
                        .replace(prevFragment.getId(), magasinFragment)
                        .commitNow();


               /* Intent mIntent = new Intent(context, DetailMagasinActivity.class);
                mIntent.putExtra("Title", storeList.get(position).getName());
                mIntent.putExtra("Description", storeList.get(position).getDescription());
                mIntent.putExtra("Image", storeList.get(position).getImage());
                context.startActivity(mIntent);*/
            }
        });
    }


    private View.OnClickListener cardListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

        }
    };

    @Override
    public int getItemCount() {
        return shopList.size();
    }
}
