package com.example.webay2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        Button loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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
        });

    }
    public void popUp(String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
    public boolean checkLoginBtn()
    {
        if(this.getLoginET().equals("user") && this.getPasswordET().equals("1234"))
            return true;
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
