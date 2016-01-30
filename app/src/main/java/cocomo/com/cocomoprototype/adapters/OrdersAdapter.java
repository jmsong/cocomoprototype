package cocomo.com.cocomoprototype.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import cocomo.com.cocomoprototype.R;
import cocomo.com.cocomoprototype.objects.DealsItem;
import cocomo.com.cocomoprototype.objects.OrdersItem;

/**
 * Created by tungtm on 1/30/16.
 */
public class OrdersAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final ArrayList<OrdersItem> dataSource;

    public OrdersAdapter(LayoutInflater inflater, ArrayList<OrdersItem> dataSource) {
        this.inflater = inflater;
        this.dataSource = dataSource;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public OrdersItem getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.list_item_orders, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        OrdersItem item = getItem(position);

        holder.spaImage.setImageResource(item.getSpaImage());

        return view;
    }

    static class ViewHolder {
        @Bind(R.id.spa_image) ImageView spaImage;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
