package com.example.jlopez.platzigram;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jlopez.platzigram.view.ContainerActivity;
import com.example.jlopez.platzigram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goCreateAccount(View view) {
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);

    }

    public void goLogin(View view) {
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }

    public void goTowebPage(View view) {
        String url = "https://platzi.com/";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(url));
        startActivity(browserIntent);

        /*
        // Map point based on address
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        // Or map point based on latitude/longitude
        // Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
        */
    }
}
