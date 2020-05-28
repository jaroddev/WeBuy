package com.example.webay2.ui.offer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.webay2.entities.Shop;
import com.example.webay2.R;
import com.example.webay2.entities.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductListFragment extends Fragment
{
    RecyclerView productListRecyclerView;
    List<Product> productList;

    LayoutInflater inflater;
    private ProductListViewModel mViewModel;
    Toolbar mToolbar;
    ImageView mImage;
    TextView mDescription;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Bundle mBundle = getArguments();

        View root = inflater.inflate(R.layout.fragment_store_product_list, container, false);
        productListRecyclerView = root.findViewById(R.id.recyclerview_product_list_res);
        mToolbar = root.findViewById(R.id.toolbar);
        mImage = root.findViewById(R.id.ivImage);
        mDescription = root.findViewById(R.id.tvDescription);

        productListRecyclerView.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.VERTICAL, false));
        productList = new ArrayList<>();

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.carrefour);
        images = new ArrayList<>();
        images.add(R.drawable.lidl);


        ProductListAdapter myAdapter = null;

        if (mBundle != null) {
            Shop shop = (Shop) mBundle.getSerializable("magasin");
            mToolbar.setTitle(shop.getAddress().getCity()+" "+shop.getAddress().getDepartment());
            Picasso.get().load(shop.getShopGroup().getLogo().getUrlImage()).into(mImage);
            //Picasso.get().load(shop.getImages().getImages().get(0).getUrlImage()).into(mImage);
            //mImage.setImageResource(storeData.getImage());
            mDescription.setText(shop.getShopGroup().getName());

            myAdapter = new ProductListAdapter(root.getContext(), new ArrayList<>(shop.getProducts()), this);
            
        }
        productListRecyclerView.setAdapter(myAdapter);
        return root;

    }


}
