package com.example.exercise_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationHost{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){

            getSupportFragmentManager().beginTransaction().add(R.id.container, new StartApp()).commit();
        }
    }

    @Override
    public void NavigateTo(Fragment fragment, boolean addToBackStack){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment);

        if(addToBackStack){

            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}