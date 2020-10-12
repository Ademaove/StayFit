package com.example.stayfit;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PageAdapter# newInstance} factory method to
 * create an instance of this fragment.
 */

public class PageAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link PageAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public PageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new WorkOutFragment();
        } else if (position == 1) {
            return new MeditationFragment();
        } else if (position == 2) {
            return new FitnessNewsFragment();
        } else if (position == 3) {
            return new ShopFragment();
        }else {
            return new ProfileFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
//        if (position == 0) {
//            return mContext.getString(R.string.category_exercises);
//        } else if (position == 1) {
//            return mContext.getString(R.string.category_meditation);
//        } else if (position == 2) {
//            return mContext.getString(R.string.category_journal);
//        } else if (position == 3) {
//            return mContext.getString(R.string.category_shop);
//        }else {
//            return mContext.getString(R.string.category_profile);
//        }
    }
}