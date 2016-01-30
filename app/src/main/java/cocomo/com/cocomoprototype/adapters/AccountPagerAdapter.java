package cocomo.com.cocomoprototype.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.astuetz.PagerSlidingTabStrip;

import cocomo.com.cocomoprototype.R;
import cocomo.com.cocomoprototype.fragments.AccountFavoriteFragment;
import cocomo.com.cocomoprototype.fragments.AccountPointFragment;
import cocomo.com.cocomoprototype.fragments.OrdersFragment;

/**
 * Created by tungtm on 1/31/16.
 */
public class AccountPagerAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
    final int PAGE_COUNT = 3;
    private int tabIcons[] = {R.drawable.ic_acc_point, R.drawable.ic_acc_fav, R.drawable.ic_acc_review};

    public AccountPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AccountPointFragment.newInstance();

            case 1:
                return AccountFavoriteFragment.newInstance();
        }

        return AccountPointFragment.newInstance();
    }

    @Override
    public int getPageIconResId(int position) {
        return tabIcons[position];
    }
}