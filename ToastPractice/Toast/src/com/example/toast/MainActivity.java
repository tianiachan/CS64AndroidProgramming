package com.example.toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText editText;
	private TextView tv;
	private Button btnSave, btnQuit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText)findViewById(R.id.editText1);
		tv = (TextView)findViewById(R.id.textView1);
		btnSave = (Button)findViewById(R.id.btnSave);
		btnQuit = (Button)findViewById(R.id.btnQuit);
		editText.setClickable(true); // makes clickable
	}
	
	public void clicked(View view)
	{
		String message = "";
		switch(view.getId())
		{
		case R.id.editText1:
			message = ((EditText)view).getText().toString();
			break;
		case R.id.textView1:
			message = ((TextView)view).getText().toString();
			break;
		default:
			message = ((Button)view).getText().toString();
		}
		
		Toast myToast = Toast.makeText(this, message, Toast.LENGTH_LONG);
		myToast.setGravity(Gravity.CENTER_VERTICAL,0,0);//sets where message displays
		myToast.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
