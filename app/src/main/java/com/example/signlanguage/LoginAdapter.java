package com.example.signlanguage;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class LoginAdapter extends FragmentStateAdapter {

    private Context context;
    private int totalPages;
    public LoginAdapter( FragmentActivity fragmentActivity, Context context,int totalPages) {
        super(fragmentActivity);

        this.context=context;
        this.totalPages=totalPages;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new LoginTabFragment();
            case 1:
                return new SignupTabFragment();

            default:
                return null;

        }

    }

    @Override
    public int getItemCount() {
        return totalPages;
    }
}
