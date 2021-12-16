package com.example.exercise_01;

import androidx.fragment.app.Fragment;

public interface NavigationHost {

    void NavigateTo(Fragment fragment, boolean addToBackStack);
}