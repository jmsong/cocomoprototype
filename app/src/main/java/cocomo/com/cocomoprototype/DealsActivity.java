package cocomo.com.cocomoprototype;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cocomo.com.cocomoprototype.adapters.DealsAdapter;
import cocomo.com.cocomoprototype.objects.DealsItem;

/**
 * Created by tungtm on 1/30/16.
 */
public class DealsActivity extends Activity {
    @Bind(R.id.spinner_services) Spinner spinnerServices;
    @Bind(R.id.spinner_areas) Spinner spinnerAreas;
    @Bind(R.id.list_deals) ListView listView;

    private ArrayList<DealsItem> dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        // Deals list
        dataSource = new ArrayList<>(3);
        DealsItem item1 = new DealsItem();
        item1.setSpaImage(R.drawable.deals_0);
        item1.setSpaName("Amandhara Spa");
        item1.setSpaDate("Till 31 Mar 2016");
        item1.setSpaTitle("50% off facials on Wednesdays!");

        DealsItem item2 = new DealsItem();
        item2.setSpaImage(R.drawable.deals_1);
        item2.setSpaName("Evian Spa");
        item2.setSpaDate("Till 20 Jan 2016");
        item2.setSpaTitle("Body scrub treatment for $120");

        DealsItem item3 = new DealsItem();
        item3.setSpaImage(R.drawable.deals_2);
        item3.setSpaName("Armani Spa");
        item3.setSpaDate("Till 1 Feb 2016");
        item3.setSpaTitle("35% off body scrub treatment");

        dataSource.add(item1);
        dataSource.add(item2);
        dataSource.add(item3);

        listView.setAdapter(new DealsAdapter(this, dataSource));

        // Spinner Services
        List<String> services = new ArrayList<>();
        services.add("All services");
        services.add("Foot Massage");
        services.add("Body Massage");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, services);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerServices.setAdapter(dataAdapter);

        // Spinner Areas
        List<String> areas = new ArrayList<>();
        areas.add("All areas");
        areas.add("Area 1");
        areas.add("Area 2");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, areas);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerAreas.setAdapter(dataAdapter1);
    }
}
