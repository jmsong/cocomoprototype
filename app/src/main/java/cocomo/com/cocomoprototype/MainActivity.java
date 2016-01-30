package cocomo.com.cocomoprototype;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

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
		addTab("", R.drawable.btn_book, MapsActivity.class);
		addTab("", R.drawable.btn_deals, DealsActivity.class);
		addTab("", R.drawable.ico_trans, OtherActivity.class);
		addTab("", R.drawable.btn_orders, OtherActivity.class);
		addTab("", R.drawable.btn_account, OtherActivity.class);
	}
	private void addTab(String labelId, int drawableId, Class<?> c)
	{
		Intent intent = new Intent(this, c);
		TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);
		tabHost.getTabWidget().setDividerDrawable(null);
		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
//		TextView title = (TextView) tabIndicator.findViewById(R.id.title);
//		title.setText(labelId);
		ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
		icon.setImageResource(drawableId);
		spec.setIndicator(tabIndicator);
		spec.setContent(intent);
		tabHost.addTab(spec);

		tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
			@Override
			public void onTabChanged(String tabId) {
				int i = getTabHost().getCurrentTab();
				switch (i){
					case 0:
						Log.d("Hungtm","tab 0");
						break;
					case 1:
						Log.d("Hungtm","tab 1");
						break;
					case 2:
						Log.d("Hungtm","tab 2");
						break;
					case 3:
						Log.d("Hungtm","tab 3");
						break;
					case 4:
						Log.d("Hungtm","tab 4");
						break;
					case 5:
						Log.d("Hungtm","tab 5");
						break;
				}

			}
		});
	}

	public void openCameraActivity(View b)
	{
		Intent intent = new Intent(this, MapsActivity.class);
		startActivity(intent);
	}
}