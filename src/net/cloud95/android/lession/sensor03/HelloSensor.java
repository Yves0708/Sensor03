package net.cloud95.android.lession.sensor03;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class HelloSensor extends Activity {
	private Object[] activities = { "Compass", CompassDemo.class,
			"Orientation", OrientationDemo.class, "Accelerometer",
			AccelerometerDemo.class, "Magnetic Field", MagneticFieldDemo.class,
			"Temperature", TemperatureDemo.class, };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		CharSequence[] list = new CharSequence[activities.length / 2];// 取到陣列的字串
		for (int i = 0; i < list.length; i++) {
			list[i] = (String) activities[i * 2];
		}
		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(
				this, android.R.layout.simple_list_item_1);
		ListView listView = (ListView) findViewById(R.id.ListView01);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent inten = new Intent(HelloSensor.this,
						(Class<?>) activities[position * 2 + 1]);
			}
		});
	}
}
