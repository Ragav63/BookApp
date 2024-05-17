package com.example.task3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.health.connect.datatypes.Metadata;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    //private ActionBarDrawerToggle actionBarDrawerToggle;
    private ImageButton toggleBtn, homeUserIconBtn;

    private TextView userMailTv;
    private BottomNavigationView bottomNavigationView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String UserEmail=getIntent().getStringExtra("loginemail");

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.menuNView);
        toggleBtn = findViewById(R.id.btnToggle);

        homeUserIconBtn=findViewById(R.id.homeUsericon);

        View headerView = navigationView.getHeaderView(0);

        userMailTv=headerView.findViewById(R.id.headerUseremail);
        userMailTv.setText(UserEmail);

        bottomNavigationView=findViewById(R.id.homeBotmnav);

        // Set the default fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();


        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(navigationView)) {

                    drawerLayout.closeDrawer(navigationView);
                } else {
                    drawerLayout.openDrawer(navigationView);
                }
            }
        });

        homeUserIconBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(HomeActivity.this, "User Details :"+UserEmail, Toast.LENGTH_SHORT).show();
                showPopupMenu(v);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Fragment selectedFragment=null;
                switch (id) {
                    case R.id.nav_home:
                        Toast.makeText(HomeActivity.this, "Home Activity", Toast.LENGTH_SHORT).show();
                        selectedFragment= new HomeFragment();
                        break;
                    case R.id.nav_category:
                        Toast.makeText(HomeActivity.this, "Category Activity", Toast.LENGTH_SHORT).show();
                        selectedFragment= new CategoryFragment();
                        break;
                    case R.id.nav_rank:
                        Toast.makeText(HomeActivity.this, "Rank Activity", Toast.LENGTH_SHORT).show();
                        selectedFragment=new RankFragment();
                        break;
                    case R.id.nav_certificate:
                        Toast.makeText(HomeActivity.this, "Certificate Activity", Toast.LENGTH_SHORT).show();
                        selectedFragment=new CertificateFragment();
                        break;
                    case R.id.nav_search:
                        Toast.makeText(HomeActivity.this, "Search Activity", Toast.LENGTH_SHORT).show();
                        selectedFragment=new SearchFragment();
                        break;

                    case R.id.nav_logout:
                        Toast.makeText(HomeActivity.this, "Logout -> Login Activity", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                        break;
                }
                if (selectedFragment != null) {
                    FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, selectedFragment);
                    transaction.commit();
                }
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment=null;
                int id = item.getItemId();
                switch (id) {
                    case R.id.btmNavmenuHome:
                        Toast.makeText(HomeActivity.this, "Home Fragment", Toast.LENGTH_SHORT).show();
                        selectedFragment=new HomeFragment();
                        break;
                    case R.id.btmNavmenuCategory:
                        Toast.makeText(HomeActivity.this, "Category Fragment", Toast.LENGTH_SHORT).show();
                        selectedFragment= new CategoryFragment();
                        break;
                    case R.id.btmNavmenuRank:
                        Toast.makeText(HomeActivity.this, "Rank Fragment", Toast.LENGTH_SHORT).show();
                        selectedFragment=new RankFragment();
                        break;
                    case R.id.btmNavmenuCertificate:
                        Toast.makeText(HomeActivity.this, "Certificate Fragment", Toast.LENGTH_SHORT).show();
                        selectedFragment=new CertificateFragment();
                        break;
                    case R.id.btmNavmenuSearch:
                        Toast.makeText(HomeActivity.this, "Search Fragment", Toast.LENGTH_SHORT).show();
                        selectedFragment=new SearchFragment();
                        break;

                }
                if (selectedFragment != null) {
                    FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.fragment_container, selectedFragment);
                            transaction.commit();
                }
                return true;
            }
        });
       bottomNavigationView.setSelectedItemId(R.id.btmNavmenuHome);
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        //popupMenu.getMenu().findItem(R.id.icon_profile).setIcon(R.drawable.usericonrosera16px);

        // Assuming you have a menu resource named toolbar_menu.xml
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
         @Override
         public boolean onMenuItemClick(MenuItem item) {
             // Handle menu item clicks
             switch (item.getItemId()) {
                 case R.id.icon_profile:
                     // Handle profile menu item click
                     Toast.makeText(HomeActivity.this, "User Details :" + userMailTv.getText().toString(), Toast.LENGTH_SHORT).show();
                     return true;
                 case R.id.icon_settings:
                     // Handle settings menu item click
                     Toast.makeText(HomeActivity.this, "Settings Menu :", Toast.LENGTH_SHORT).show();
                     return true;

                 case R.id.icon_downloadinfo:
                     Toast.makeText(HomeActivity.this, "Info of User :" + userMailTv, Toast.LENGTH_SHORT).show();
                     return true;

                 case R.id.icon_help:
                     Toast.makeText(HomeActivity.this, "Contact :9545553241", Toast.LENGTH_SHORT).show();
                     return true;

                 default:
                     return false;
             }
         }
     });

        popupMenu.inflate(R.menu.toolbar_icon_menu_items);



        try {
            Field fieldMPopup=PopupMenu.class.getDeclaredField("mPopup");
            fieldMPopup.setAccessible(true);
            Object mPopup=fieldMPopup.get(popupMenu);
            Class<?>popupClass=mPopup.getClass();
            Method setForceShowIcon=popupClass.getDeclaredMethod("setForceShowIcon",boolean.class);
            setForceShowIcon.invoke(mPopup,true);

        }catch (Exception e){

            Log.e("aaa","error",e);

        }finally {
            popupMenu.show();
        }
    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            //the process of the below code denotes the the three dot menu icon button in the toolbar or the screen
            //by removing it we can act the image button as drop down menu list of items
            //getMenuInflater().inflate(R.menu.toolbar_icon_menu_items, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            // Handle other menu item clicks here if needed
            return super.onOptionsItemSelected(item);
        }
}