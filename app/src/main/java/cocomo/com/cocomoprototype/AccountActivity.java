package cocomo.com.cocomoprototype;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;

import butterknife.Bind;
import butterknife.ButterKnife;
import cocomo.com.cocomoprototype.adapters.AccountPagerAdapter;
import cocomo.com.cocomoprototype.adapters.OrdersPagerAdapter;

/**
 * Created by tungtm on 1/30/16.
 */
public class AccountActivity extends FragmentActivity {
    @Bind(R.id.viewpager)
    ViewPager viewPager;

    @Bind(R.id.tabs)
    PagerSlidingTabStrip tabStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        viewPager.setAdapter(new AccountPagerAdapter(getSupportFragmentManager()));
        tabStrip.setViewPager(viewPager);
    }
}
