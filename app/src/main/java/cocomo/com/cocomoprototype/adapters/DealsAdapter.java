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

/**
 * Created by tungtm on 1/30/16.
 */
public class DealsAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private final ArrayList<DealsItem> dataSource;

    public DealsAdapter(Context context, ArrayList<DealsItem> dataSource) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.dataSource = dataSource;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public DealsItem getItem(int position) {
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
            view = inflater.inflate(R.layout.list_item_deals, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        DealsItem item = getItem(position);

        holder.spaImage.setImageResource(item.getSpaImage());
        holder.spaName.setText(item.getSpaName());
        holder.spaDate.setText(item.getSpaDate());
        holder.spaTitle.setText(item.getSpaTitle());

        return view;
    }

    static class ViewHolder {
        @Bind(R.id.spa_image) ImageView spaImage;
        @Bind(R.id.spa_name) TextView spaName;
        @Bind(R.id.spa_date) TextView spaDate;
        @Bind(R.id.spa_title) TextView spaTitle;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
