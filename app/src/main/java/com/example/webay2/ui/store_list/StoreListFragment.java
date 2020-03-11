package com.example.webay2.ui.store_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webay2.StoreData;
import com.example.webay2.R;

import java.util.ArrayList;
import java.util.List;

public class StoreListFragment extends Fragment {

    private StoreListViewModel homeViewModel;
    RecyclerView storeListRecyclerView;
    List<StoreData> storeList;
    StoreData store;
    LayoutInflater inflater;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        this.inflater = inflater;

        View root = this.inflater.inflate(R.layout.fragment_store_list, container, false);


        storeListRecyclerView = root.findViewById(R.id.recyclerview_store_list_res);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(root.getContext(), 2);
        storeListRecyclerView.setLayoutManager(mGridLayoutManager);
       // storeListRecyclerView.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false));

        storeList = new ArrayList<>();
        store = new StoreData("Carrefour", getString(R.string.description_magasin_carrefour),
                R.drawable.carrefour);
        storeList.add(store);
        store = new StoreData("Lidl", getString(R.string.description_magasin_lidl),
                R.drawable.lidl);
        storeList.add(store);
        store = new StoreData("Casino", getString(R.string.description_magasin_casino),
                R.drawable.casino);
        storeList.add(store);
        store = new StoreData("Intermarché", getString(R.string.description_magasin_intermarche),
                R.drawable.intermarche);
        storeList.add(store);


        store = new StoreData("Carrefour", getString(R.string.description_magasin_carrefour),
                R.drawable.carrefour);
        storeList.add(store);
        store = new StoreData("Lidl", getString(R.string.description_magasin_lidl),
                R.drawable.lidl);
        storeList.add(store);
        store = new StoreData("Casino", getString(R.string.description_magasin_casino),
                R.drawable.casino);
        storeList.add(store);
        store = new StoreData("Intermarché", getString(R.string.description_magasin_intermarche),
                R.drawable.intermarche);
        storeList.add(store);
        store = new StoreData("Carrefour", getString(R.string.description_magasin_carrefour),
                R.drawable.carrefour);
        storeList.add(store);
        store = new StoreData("Lidl", getString(R.string.description_magasin_lidl),
                R.drawable.lidl);
        storeList.add(store);


        StoreListAdapter myAdapter = new StoreListAdapter(root.getContext(), storeList, this);
        storeListRecyclerView.setAdapter(myAdapter);


        return root;
    }
}