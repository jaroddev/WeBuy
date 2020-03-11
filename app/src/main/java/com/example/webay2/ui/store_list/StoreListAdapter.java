package com.example.webay2.ui.store_list;

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
import com.example.webay2.StoreData;
import com.example.webay2.ui.store_promotion.ProductListFragment;

import java.util.List;

public class StoreListAdapter extends RecyclerView.Adapter <StoreListViewHolder>
{
    private Context context;
    private List<StoreData> storeDataList;
    Fragment prevFragment;

    public StoreListAdapter(Context context, List<StoreData> storeDataList, Fragment homeFragment) {
        this.context = context;
        this.storeDataList = storeDataList;
        this.prevFragment = homeFragment;


    }

    @NonNull
    @Override
    public StoreListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_store, parent, false);
        return new StoreListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final StoreListViewHolder holder, final int position) {
        holder.getImage().setImageResource(storeDataList.get(position).getImage());
        holder.getTitle().setText(storeDataList.get(position).getName());




        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {

                ProductListFragment magasinFragment = new ProductListFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable("magasin", storeDataList.get(position));
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
        return storeDataList.size();
    }
}
