package com.example.stayfit;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        // Create an adapter that knows which fragment should be shown on each page
        PageAdapter adapter = new PageAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.getTabAt(0).setIcon(R.drawable.exercises);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.baseline_fitness_center_white_48dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.baseline_self_improvement_white_48dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.baseline_import_contacts_white_48dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.baseline_shopping_cart_white_48dp);
        tabLayout.getTabAt(4).setIcon(R.drawable.baseline_person_white_48dp);
        this.setTitle("StayFit WELLNESS");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}