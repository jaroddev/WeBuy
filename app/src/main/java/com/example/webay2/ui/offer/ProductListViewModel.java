package com.example.webay2.ui.offer;

import androidx.lifecycle.ViewModel;

import com.example.webay2.entities.Shop;

public class ProductListViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    Shop magasinData;
    public ProductListViewModel(Shop magasinData)
    {
        this.magasinData = magasinData;
    }

    public Shop getMagasinData() {
        return magasinData;
    }
}
