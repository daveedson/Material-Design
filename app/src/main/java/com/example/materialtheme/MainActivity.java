package com.example.materialtheme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        //initializing of Member variable ToolBar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initialize drawerLayout
        drawerLayout = findViewById(R.id.drawer_layout);

        //initialize navigationView
        navigationView = findViewById(R.id.Navigation_view);


        //backButton on action bar
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Object Creation for ActionBar DrawerToogle.....
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.setDrawerListener(toogle);

        toogle.syncState();


        //intializing of NavigationView.setNavigationItemSelectedListener

        navigationView.setNavigationItemSelectedListener(this);
    }


    //Method to inflate menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.my_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {

            case R.id.AboutUs_myMenu:
                Toast.makeText(this, "About Us Clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.settings_myMenu:
                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Users_myMenu:
                Toast.makeText(this, "Users clicked", Toast.LENGTH_SHORT).show();

            case R.id.search_myMenu:
                Toast.makeText(this, "Search Icon is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cart_myMenu:
                Toast.makeText(this, "Cart Icon is clicked", Toast.LENGTH_SHORT).show();

                break;

            //Back button to  finish the application.
            case android.R.id.home:
                finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Inbox_id:
                Toast.makeText(MainActivity.this, "Inbox is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Sent_id:
                Toast.makeText(this, "Sent is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Starred_id:
                Toast.makeText(this, "Starred is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Draft_id:
                Toast.makeText(this, "Draft is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.All_Emails:
                Toast.makeText(this, "All Emails is clicked", Toast.LENGTH_SHORT).show();
            case R.id.Trash_id:
                Toast.makeText(this, "Trash is clicked", Toast.LENGTH_SHORT).show();
            case R.id.Spam_id:
                Toast.makeText(this, "Spam is clicked", Toast.LENGTH_SHORT).show();
        }


        //Method to close drawer at click of any item withing the drawerLayout
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    //method to use back button to drawer in the Drawerlayout
    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {

            drawerLayout.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();

        }


    }


    //Method to hide keyboard when RootLayout is tapped.....
    public void rootLayoutTapped(View view) {


        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
