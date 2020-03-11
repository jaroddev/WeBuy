package com.example.webay2.ui.store_promotion;

import androidx.lifecycle.ViewModel;

import com.example.webay2.StoreData;

public class ProductListViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    StoreData magasinData;
    public ProductListViewModel(StoreData magasinData)
    {
        this.magasinData = magasinData;
    }

    public StoreData getMagasinData() {
        return magasinData;
    }
}
