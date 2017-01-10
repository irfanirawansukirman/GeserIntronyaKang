package com.iriras.simpleonboarding;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseIntArray;

import java.util.ArrayList;

/**
 * Created by irfan on 09/01/17.
 */

public class IntroScreenPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<BaseIntroFragment> mFragments = new ArrayList<>();
    private SparseIntArray mBackgorundColor = new SparseIntArray();

    public IntroScreenPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Add a Fragment to the PagerAdapter.
     * @param fragment BaseIntroFragment to add.
     * @param backgroundColor Background color for the Fragment to add.
     */
    public void addFragment(BaseIntroFragment fragment, int backgroundColor){
        mBackgorundColor.put(mFragments.size(), backgroundColor);
        mFragments.add(fragment);
    }

    /**
     * Return the background color of the page for a given position.
     * @param page Page position
     * @return Background color for the page or <code>0</code> if no match.
     */
    public int getBackgroundColorForPage(int page){
        return mBackgorundColor.get(page);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
