package com.example.exercise_01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.toolbox.NetworkImageView;
import com.example.exercise_01.network.MountainEntry;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

public class MountainGridFragment extends Fragment{

    private Toolbar toolbar;
    CardView cardView;

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        //setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.mountain_grid_fragment, container, false);

        //setUpToolbar(view);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, recyclerView.HORIZONTAL, false));

        MountainCardRecyclerViewAdapter adapter = new MountainCardRecyclerViewAdapter(MountainEntry.initMountainEntryList(getResources()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void setUpToolbar(View view) {

        toolbar = view.findViewById(R.id.app_bar);

        /*AppCompatActivity activity = (AppCompatActivity) getActivity();
        if(activity != null) {
            activity.setSupportActionBar(toolbar);
        }*/
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){

        menuInflater.inflate(R.menu.toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}
