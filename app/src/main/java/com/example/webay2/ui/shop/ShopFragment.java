package com.example.webay2.ui.shop;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webay2.*;
import com.example.webay2.entities.Shop;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {
    private ShopViewModel homeViewModel;
    RecyclerView shopsRecyclerView;
    List<Shop> shopList;
    LayoutInflater inflater;


    public static ArrayList<Shop> getAllStores() {
        ArrayList<Shop> shops = new ArrayList<>();
        // Effectuer la requete on utilisant l'url , la réponse est une chaîne JSON

        String api_url = BaseWeBuy.api_url+"/shops";
        HttpHandler httpApi = new HttpHandler();
        String jsonApiResponse = httpApi.makeServiceCall(api_url);

        Log.e("TAG", "Réponse Serveur: " +api_url +"  "+ jsonApiResponse);

        if (jsonApiResponse != null) {
            try {new JSONArray(jsonApiResponse);
                // Récuperer le tableau des magasins
                JSONArray shopsJsonArray = new JSONArray(jsonApiResponse);
                // Pour tous les magasins
                for (int i = 0; i < shopsJsonArray.length(); i++)
                {

                    // récupérer les valeurs de chaque propriété
                    JSONObject shopJsonObject = shopsJsonArray.getJSONObject(i);
                    Gson gsonPaeser = new Gson();
                    // créer un objet magasin en lui rajoutant les propriétés récupérées par json
                    Shop shop = gsonPaeser.fromJson(shopJsonObject.toString(), Shop.class);
                    // réjouter le magasin à la liste des magasins
                    shops.add(shop);
                }
            }
            catch (final JSONException e)
            {
                Log.e("TAG", "Erreur de parsing JSON : " + e.getMessage());

            }
        }
        else
        {
            Log.e("TAG", "Réponse vide !, pas de JSON");
        }
        return shops;
    }

    private class GetAllMagasinsTask extends AsyncTask<Void, Void, Void> {
        private ProgressDialog progressDialog;

        private ShopFragment fragment;

        public GetAllMagasinsTask(ShopFragment f)
        {
            this.fragment = f;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage("Chargement des magasins...");
            progressDialog.setCancelable(false);
            progressDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params)
        {
            shopList = ShopFragment.getAllStores();
            Log.i("ShopFragment", "shopsList.size = " + shopList.size());
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... progress)
        {
            super.onProgressUpdate(progress);
            progressDialog.setProgress(1);
        }

        @Override
        protected void onPostExecute(Void result)
        {
            super.onPostExecute(result);
            if (progressDialog.isShowing())
                progressDialog.dismiss();
            ShopAdapter myAdapter = new ShopAdapter(getContext(), shopList, ShopFragment.this);
            shopsRecyclerView.setAdapter(myAdapter);
        }

    }


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        this.inflater = inflater;

        View root = this.inflater.inflate(R.layout.fragment_store_list, container, false);


        shopsRecyclerView = root.findViewById(R.id.recyclerview_store_list_res);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(root.getContext(), 2);
        shopsRecyclerView.setLayoutManager(mGridLayoutManager);
       // storeListRecyclerView.setLayoutManager(new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false));
/*
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
        storeList.add(store);*/

/*
        storeList =  getAllStores();
        StoreListAdapter myAdapter = new StoreListAdapter(getContext(),storeList, StoreListFragment.this);
        storeListRecyclerView.setAdapter(myAdapter);
*/
        GetAllMagasinsTask task = new GetAllMagasinsTask(ShopFragment.this);
        task.execute();

        return root;
    }
}