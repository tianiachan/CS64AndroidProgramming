package com.example.assign6scrollview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnGestureListener	
{
	private TextView display;
	private Button btnClear;
	private String eventStr;
	private GestureDetector detector;
	
	public void onClear(View view)
	{
		display.setText("");
	}
	public void onQuit(View view)
	{
		this.finish();
	}
	@Override
	public boolean onTouchEvent(MotionEvent event)//event contains x y coordinates
	{ //return false means dont recognize touch and wont return
		
		return detector.onTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent arg0) //when finger presses touchscreen
	{
		eventStr = String.format("onDown:(%f, %f)\n", arg0.getX(), arg0.getY());
		display.setText(display.getText() + eventStr);
		//Log.d("down", "reached down");
		//display.setText("going down\n");
		return true;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) //like scroll but screen will continue to move for a bit
	{
		eventStr = String.format("onFling: (%f, %f), (%f, %f)\n\tdX=%f, dY=%f\n", e1.getX(), e2.getY(),  e1.getX(), e2.getY(), velocityX, velocityY);
		display.setText(display.getText() + eventStr);
		//display.setText("fling\n");
		return true;
	}

	@Override
	public void onLongPress(MotionEvent e) //press and hold on screen
	{
		eventStr = String.format("onLongPress: (%f, %f)\n", e.getX(), e.getY());
		display.setText(display.getText() + eventStr);	
		//display.setText("LongPress\n");
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)//drag finger in direction 
	{
		eventStr = String.format("onScroll: (%f, %f), (%f, %f)\n\tdX=%f, dY=%f\n", e1.getX(), e2.getY(),  e1.getX(), e2.getY(), distanceX, distanceY);
		display.setText(display.getText() + eventStr);
		//display.setText("Scroll\n");
		return true;
	}

	@Override
	public void onShowPress(MotionEvent e) //shows press on screen
	{
		eventStr = String.format("onShowPress:(%f, %f, args)\n", e.getX(), e.getY());
		display.setText(display.getText() + eventStr);
		//display.setText("showpress\n");
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) //touch and quickly lift
	{
		eventStr = String.format("onSingleTapConfirmed: (%f, %f)\n", e.getX(), e.getY());
		display.setText(display.getText() + eventStr);
		//display.setText("SingleTap\n");
		return true;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		display = (TextView)findViewById(R.id.textView1);
		btnClear = (Button)findViewById(R.id.buttonClear);
		detector = new GestureDetector(this, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) 
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

}
