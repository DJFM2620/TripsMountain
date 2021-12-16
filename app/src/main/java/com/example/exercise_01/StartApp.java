package com.example.exercise_01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class StartApp extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.start_app, container, false);

        MaterialButton nextButton = view.findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                ((NavigationHost) getActivity()).NavigateTo(new MountainGridFragment(), false);
            }
        });
        return view;
    }
}
