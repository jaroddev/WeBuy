package com.example.webay2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.webay2.entities.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    User user= null;

    public static User getUserByAuthentification(String email, String password)
    {
        User userAuth = null;
        String api_url = BaseWeBuy.api_url+"/users"+"/"+email+"/"+password;
        HttpHandler httpApi = new HttpHandler();
        String jsonApiResponse = httpApi.makeServiceCall(api_url);

        Log.e("TAG", "Réponse Serveur: " +api_url +"  "+ jsonApiResponse);

        if (jsonApiResponse != null) {



                    // récupérer les valeurs de chaque propriété

                    Gson gsonPaeser = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                   // Log.e("user json to string", userJsonObject.toString());
                    // créer un objet user en lui rajoutant les propriétés récupérées par json
                    userAuth = gsonPaeser.fromJson(jsonApiResponse, User.class);
                    Log.e("TAG", userAuth.getPhoneNumber() +" "+userAuth.getName());


        }
        else
        {
            Log.e("TAG", "Réponse vide !, pas de JSON");
        }
        return userAuth;
    }

    private class GetUserByAuthentification extends AsyncTask<Void, Void, Void> {
        private ProgressDialog progressDialog;


        private LoginActivity loginActivity;
        private View v;

        public GetUserByAuthentification(LoginActivity loginActivity, View v)
        {
            this.loginActivity = loginActivity;
            this.v = v;

        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setMessage("Chargement des utilisateurs...");
            progressDialog.setCancelable(false);
            progressDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params)
        {
            user = LoginActivity.getUserByAuthentification(this.loginActivity.getLoginET(), this.loginActivity.getPasswordET());
//            Log.i("LoginActivity", "userName = " + user.getName());
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
           /* ShopAdapter myAdapter = new ShopAdapter(getContext(), shopList, ShopFragment.this);
            shopsRecyclerView.setAdapter(myAdapter);*/

            if(checkLoginBtn())
            {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                intent.putExtra("previousActivity", "LoginActivity") ;
                intent.putExtra("loginUser", getLoginET()) ;
                intent.putExtra("passwordUser", getPasswordET()) ;
                startActivity(intent);
            }
            else
            {
                popUp("erreur login : "+getLoginET()+" "+getPasswordET());
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sign_in);
        Button loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoginActivity.GetUserByAuthentification task = new GetUserByAuthentification(LoginActivity.this, v);
                task.execute();
                /*if(checkLoginBtn())
                {
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    intent.putExtra("previousActivity", "LoginActivity") ;
                    intent.putExtra("loginUser", getLoginET()) ;
                    intent.putExtra("passwordUser", getPasswordET()) ;
                    startActivity(intent);
                }
                else
                {
                    popUp("erreur login : "+getLoginET()+" "+getPasswordET());
                }*/
            }
        });

    }
    public void popUp(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public boolean checkLoginBtn()
    {
        if(user != null) {
            if (this.getLoginET().equals(user.getEmail()) && this.getPasswordET().equals(user.getPassword()))
                return true;
        }
        return false;
    }
    public String getLoginET() {
        EditText loginET = (EditText) findViewById(R.id.loginET);
        return loginET.getText().toString();
    }
    public String getPasswordET() {
        EditText passwordET = (EditText) findViewById(R.id.passwordET);
        return passwordET.getText().toString();
    }

}
