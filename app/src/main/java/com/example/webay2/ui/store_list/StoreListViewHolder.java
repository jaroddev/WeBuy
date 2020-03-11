package com.example.webay2.ui.store_list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webay2.R;

public class StoreListViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    private TextView title;

    CardView cardView;

    public StoreListViewHolder(View itemView) {
        super(itemView);
         this.image = itemView.findViewById(R.id.ivImage);
         this.title = itemView.findViewById(R.id.tvTitle);
         this.cardView = itemView.findViewById(R.id.card_view_store_res);

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
