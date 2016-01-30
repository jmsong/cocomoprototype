package cocomo.com.cocomoprototype;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * @author Adil Soomro
 */
@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {
	TabHost tabHost;
	/** Called when the activity is first created. */
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tabHost = getTabHost();
		setTabs();
	}
	private void setTabs()
	{
		addTab("Home", R.drawable.btn_book, MapsActivity.class);
		addTab("Deals", R.drawable.btn_deals, DealsActivity.class);
		addTab("Fake", R.drawable.tab_search, OtherActivity.class);
		addTab("Order", R.drawable.btn_orders, OrdersActivity.class);
		addTab("Account", R.drawable.btn_account, OtherActivity.class);
	}
	private void addTab(String labelId, int drawableId, Class<?> c)
	{
		Intent intent = new Intent(this, c);
		TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);
		tabHost.getTabWidget().setDividerDrawable(null);
		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
		TextView title = (TextView) tabIndicator.findViewById(R.id.title);
		title.setText(labelId);
		ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
		icon.setImageResource(drawableId);		
		spec.setIndicator(tabIndicator);
		spec.setContent(intent);
		tabHost.addTab(spec);
	}
	public void openCameraActivity(View b)
	{
		Intent intent = new Intent(this, MapsActivity.class);
		startActivity(intent);
	}
}