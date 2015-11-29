package net.cloud95.android.lession.sensor03;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class OrientationDemo extends Activity implements SensorEventListener {
	private SensorManager sensorManager;
	private MySurfaceView view;
	private Object[] orientation = {
			"Rotate X-axis Orientation", "Rotate Y-axis Orientation","Rotate Z-axis Orientation",
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
	}
}

