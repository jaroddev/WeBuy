package com.example.webay2.ui.store_promotion;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webay2.R;

class ProductListViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    private TextView title;

    CardView cardView;
    public ProductListViewHolder(@NonNull View itemView) {
        super(itemView);
        this.image = itemView.findViewById(R.id.productImageIV);
        this.title = itemView.findViewById(R.id.productTitleTV);
        this.cardView = itemView.findViewById(R.id.card_view_product_res);
    }

    public ImageView getImage() {
        return image;
    }

    public TextView getTitle() {
        return title;
    }

    public CardView getCardView() {
        return cardView;
    }
}
