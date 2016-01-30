package cocomo.com.cocomoprototype.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import cocomo.com.cocomoprototype.fragments.OrdersFragment;

/**
 * Created by tungtm on 1/31/16.
 */
public class OrdersPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "ALL", "EXPIRED", "CONFIRMED", "COMPLETED" };

    public OrdersPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return OrdersFragment.newInstance();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}