package cocomo.com.cocomoprototype.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import cocomo.com.cocomoprototype.R;
import cocomo.com.cocomoprototype.adapters.OrdersAdapter;
import cocomo.com.cocomoprototype.objects.OrdersItem;

/**
 * Created by tungtm on 1/31/16.
 */
public class AccountFavoriteFragment extends Fragment {
    @Bind(R.id.list_orders)
    ListView listView;

    private ArrayList<OrdersItem> dataSource;

    public static AccountFavoriteFragment newInstance() {
        AccountFavoriteFragment fragment = new AccountFavoriteFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataSource = new ArrayList<>(3);
        OrdersItem item1 = new OrdersItem();
        item1.setSpaImage(R.drawable.fav_0);

        OrdersItem item2 = new OrdersItem();
        item2.setSpaImage(R.drawable.fav_1);

        dataSource.add(item1);
        dataSource.add(item2);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orders, container, false);
        ButterKnife.bind(this, view);

        // Orders list
        listView.setAdapter(new OrdersAdapter(inflater, dataSource));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
