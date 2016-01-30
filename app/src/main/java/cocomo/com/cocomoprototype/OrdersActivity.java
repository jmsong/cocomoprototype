package cocomo.com.cocomoprototype;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cocomo.com.cocomoprototype.adapters.DealsAdapter;
import cocomo.com.cocomoprototype.adapters.OrdersPagerAdapter;
import cocomo.com.cocomoprototype.objects.DealsItem;

/**
 * Created by tungtm on 1/30/16.
 */
public class OrdersActivity extends FragmentActivity {
    @Bind(R.id.viewpager)
    ViewPager viewPager;

    @Bind(R.id.tabs)
    PagerSlidingTabStrip tabStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        viewPager.setAdapter(new OrdersPagerAdapter(getSupportFragmentManager()));
        tabStrip.setViewPager(viewPager);
    }
}
