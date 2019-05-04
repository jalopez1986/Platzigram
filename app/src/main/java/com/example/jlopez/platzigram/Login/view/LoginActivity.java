package com.example.jlopez.platzigram.Login.view;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jlopez.platzigram.Login.presenter.LoginPresenter;
import com.example.jlopez.platzigram.Login.presenter.LoginPresenterImpl;
import com.example.jlopez.platzigram.R;
import com.example.jlopez.platzigram.view.ContainerActivity;
import com.example.jlopez.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private TextInputEditText username;
    private TextInputEditText password;
    private Button login;
    private TextView createHere;
    private ProgressBar progressBarLogin;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        createHere = findViewById(R.id.createHere);

        progressBarLogin = findViewById(R.id.progressbarLogin);
        hideProgressBar();

        loginPresenter = new LoginPresenterImpl(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().isEmpty() && password.getText().toString().isEmpty()) {
                    loginError("Ingresa tus datos");
                }
                else if (username.getText().toString().isEmpty()) {
                    loginError("Ingrese el usuario");
                }
                else if (password.getText().toString().isEmpty()) {
                    loginError("Ingrese el password");
                }
                else {
                    loginPresenter.SignIn(username.getText().toString(), password.getText().toString());
                }
            }
        });

        createHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goCreateAccount();
            }
        });





    }


    @Override
    public void enableInputs() {
        username.setEnabled(true);
        password.setEnabled(true);
        login.setEnabled(true);
    }

    @Override
    public void disableInputs() {
        username.setEnabled(false);
        password.setEnabled(false);
        login.setEnabled(false);
    }

    @Override
    public void showProgressBar() {
        progressBarLogin.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressBar() {
        progressBarLogin.setVisibility(View.GONE);

    }

    @Override
    public void loginError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();

    }

    @Override
    public void goCreateAccount() {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);

    }

    @Override
    public void goHome() {
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);

    }
}
