package com.milon.nav;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bnv);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

       //toolbar
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        nav=(NavigationView)findViewById(R.id.navdrawermenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,new HomeFragment()).commit();
        nav.setCheckedItem(R.id.menu_home);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment temp;
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.menu_kyc:
                        temp=new KYCFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,temp).addToBackStack(null).commit();

                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_refer:
                        temp=new ReferFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,temp).addToBackStack(null).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu_profile:
                        temp=new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,temp).addToBackStack(null).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_logout:

                        break;
                }
                 getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,temp).commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment=null;
            switch (item.getItemId())
            {
                case R.id.menu_home:
                    fragment=new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,fragment).addToBackStack("tag").commit();
                    break;

                case R.id.menu_findloads:
                    fragment=new YourTrucksFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,fragment).addToBackStack(null).commit();
                    break;

                case R.id.menu_calls:
                    fragment=new CallFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,fragment).addToBackStack(null).commit();
                    break;

                case R.id.menu_orders:
                    fragment=new LoadDetailsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,fragment).addToBackStack(null).commit();
                    break;

                case R.id.menu_money:
                    fragment=new MoneyFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,fragment).addToBackStack(null).commit();
                    break;


            }
            return true;
        }
    };


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment fragment=new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.my_nav_host_fragment,fragment).addToBackStack(null).commit();

    }
}