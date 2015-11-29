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

public class CompassDemo extends Activity implements SensorEventListener {
	private SensorManager sensorManager;
	private MySurfaceView view;// 宣告一個自己定義的surfaceView
	private Object[] orientation = { "Rotate X-axis Orientation",
			"Rotate Y-axis Orientation", "Rotate Z-axis Orientation", };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		view = new MySurfaceView(this);// 自己建一個surfaceView
		setContentView(view);
	}

	@Override
	protected void onResume() {
		super.onResume();
		// 列出有多少個Sensor.TYPE_ORIENTATION
		List<Sensor> sensors = sensorManager
				.getSensorList(Sensor.TYPE_ORIENTATION);
		if (sensors.size() > 0) {
			sensorManager.registerListener(this, sensors.get(0),
					SensorManager.SENSOR_DELAY_NORMAL);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		sensorManager.unregisterListener(this);
	}

	// sensoreventlistener要改寫的方法,由此類別自己實作介面
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	// 當sensor改變則呼叫此方法
	public void onSensorChanged(SensorEvent event) {
		view.onValueChanged(event.values);// float[]當參數傳入
	}

	class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
		private Bitmap bitmap, curBitmap;
		private float x, y, z, delta = -8;// 要把圖轉正的角度
		private int curWidth, curHeight;

		public MySurfaceView(Context context) {
			super(context);
			getHolder().addCallback(this);//會自動呼叫下面的方法
			bitmap = BitmapFactory.decodeResource(getResources(),
					R.drawable.compass);
		}
		//第一次將holder的圖放入surfaceView
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			x = getWidth() / 2;
			y = getHeight() / 2;
			onValueChanged(new float[3]);// 都是0
		}

		public void surfaceCreated(SurfaceHolder holder) {

		}

		public void surfaceDestroyed(SurfaceHolder holder) {
		}

		@SuppressWarnings("static-access")
		void onValueChanged(float[] values) {
			Canvas canvas = getHolder().lockCanvas();
			if (canvas != null) {
				Paint paint = new Paint();
				paint.setAntiAlias(true);
				paint.setColor(Color.BLUE);
				paint.setTextSize(18);
				canvas.drawColor(Color.WHITE);// 畫布底色
				canvas.save();
				// 可將圖移動旋轉縮放
				Matrix matrix = new Matrix();
				curWidth = (int) (bitmap.getWidth() * 1);
				curHeight = (int) (bitmap.getHeight() * 1);
				curBitmap = bitmap.createScaledBitmap(bitmap, curWidth,
						curHeight, false);
				matrix.setRotate(-values[0] + delta, x, y);// 旋轉原圖
				canvas.setMatrix(matrix);
				canvas.drawBitmap(curBitmap, x - curWidth / 2, y - curHeight
						/ 2, null);// 找到圖的左上角的點
				canvas.restore();
				for (int i = 0; i < values.length; i++) {
					canvas.drawText(orientation[i] + ":" + values[i], 0,
							paint.getTextSize() * (i + 1), paint);
				}
				getHolder().unlockCanvasAndPost(canvas);// 把畫布放到SurfaceView裡
			}
		}
	}
}
