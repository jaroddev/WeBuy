package com.example.webuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.webuy.data.model.Magasin;

import java.util.ArrayList;

public class MagasinsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    // Handle the data and create an element
    private MonRecyclerViewAdapter mAdapter;

    // Handle the data and create a layout with elements (Grid, Linear ...)
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magasins);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MonRecyclerViewAdapter(getDataSource());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }

    private ArrayList<Magasin> getDataSource() {
        ArrayList results = new ArrayList<Magasin>();
        for (int index = 0; index < 10; index++) {
            Magasin obj = new Magasin(12,"Carrefour", );
            results.add(index, obj);
        }
        return results;
    }

}
