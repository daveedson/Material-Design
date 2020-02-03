package com.example.materialtheme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //backButton on action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    //Method to inflate menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.my_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){

            case R.id.AboutUs_myMenu:
                Toast.makeText(this, "About Us Clicked", Toast.LENGTH_SHORT).show();
                break;

            case  R.id.settings_myMenu:
                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.Users_myMenu:
                Toast.makeText(this, "Users clicked", Toast.LENGTH_SHORT).show();

            case R.id.search_myMenu:
                Toast.makeText(this, "Search Icon is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cart_myMenu:
                Toast.makeText(this, "Cart Icon is clicked", Toast.LENGTH_SHORT).show();

                break;
            case android.R.id.home:
                finish();
                break;
        }



        return super.onOptionsItemSelected(item);
    }
}
