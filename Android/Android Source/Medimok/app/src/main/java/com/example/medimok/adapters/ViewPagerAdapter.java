package com.example.medimok.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ArrayList<String> pageHeader = new ArrayList<>();
    public List<Fragment> pageBody = new ArrayList<>();

    public void addPager(ArrayList<String> pageHeader, List<Fragment> pageBody) {
        this.pageHeader = pageHeader;
        this.pageBody = pageBody;
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return pageBody.get(position);
    }

    @Override
    public int getCount() {
        return pageBody.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageHeader.get(position);
    }
}
