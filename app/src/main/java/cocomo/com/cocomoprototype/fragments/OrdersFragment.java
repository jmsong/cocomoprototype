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
import cocomo.com.cocomoprototype.adapters.DealsAdapter;
import cocomo.com.cocomoprototype.adapters.OrdersAdapter;
import cocomo.com.cocomoprototype.objects.OrdersItem;
import cocomo.com.cocomoprototype.objects.OrdersItem;

/**
 * Created by tungtm on 1/31/16.
 */
public class OrdersFragment extends Fragment {
    @Bind(R.id.list_orders)
    ListView listView;

    private ArrayList<OrdersItem> dataSource;

    public static OrdersFragment newInstance() {
        OrdersFragment fragment = new OrdersFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataSource = new ArrayList<>(3);
        OrdersItem item1 = new OrdersItem();
        item1.setSpaImage(R.drawable.order_0);
        item1.setType("response");

        OrdersItem item2 = new OrdersItem();
        item2.setSpaImage(R.drawable.order_1);
        item2.setType("expired");

        OrdersItem item3 = new OrdersItem();
        item3.setSpaImage(R.drawable.order_2);
        item3.setType("confirmed");

        OrdersItem item4 = new OrdersItem();
        item4.setSpaImage(R.drawable.order_3);
        item4.setType("completed");

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
