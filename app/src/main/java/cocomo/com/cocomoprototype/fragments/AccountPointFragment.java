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
public class AccountPointFragment extends Fragment {
    @Bind(R.id.list_orders)
    ListView listView;

    private ArrayList<OrdersItem> dataSource;

    public static AccountPointFragment newInstance() {
        AccountPointFragment fragment = new AccountPointFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataSource = new ArrayList<>(3);
        OrdersItem item1 = new OrdersItem();
        item1.setSpaImage(R.drawable.point_0);

        OrdersItem item2 = new OrdersItem();
        item2.setSpaImage(R.drawable.point_1);

        OrdersItem item3 = new OrdersItem();
        item3.setSpaImage(R.drawable.point_2);

        OrdersItem item4 = new OrdersItem();
        item4.setSpaImage(R.drawable.point_3);

        dataSource.add(item1);
        dataSource.add(item2);
        dataSource.add(item3);
        dataSource.add(item4);
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
