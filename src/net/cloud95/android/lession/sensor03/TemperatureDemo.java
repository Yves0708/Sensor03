package net.cloud95.android.lession.sensor03;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class TemperatureDemo extends Activity implements SensorEventListener {
	private SensorManager sensorManager;
	private MySurfaceView view;
	private String vendor = "UNKNOWN";
	private String name = "UNKNOWN";
	private int version = 0;
	private Object[] temperature = {
			"Temperature", "No Data","No Data",
	};
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	@Override
	protected void onResume() {
		super.onResume();
	}
	@Override
	protected void onPause() {
		super.onPause();
	}
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}
	public void onSensorChanged(SensorEvent event) {
	}
	class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
		public MySurfaceView(Context context) {
			super(context);
		}
		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		}
		public void surfaceCreated(SurfaceHolder holder) {
		}
		public void surfaceDestroyed(SurfaceHolder holder) {
		}
		void onValueChanged(float[] values) {
		}
	}
}

