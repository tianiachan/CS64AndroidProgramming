package com.example.customstylelab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button btnForward, btnQuit;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnForward = (Button)findViewById(R.id.buttonForward);
		btnQuit = (Button)findViewById(R.id.buttonQuit);
	}

	public void onClick(View view)
	{
		switch(view.getId())
		{
		case  R.id.buttonForward:// go to next scree
			Intent second = new Intent(this, SecondActivity.class);
			startActivity(second);
			break;
		case R.id.buttonQuit://quit app
			this.finish();
			break;
		default: // default case
			break;
		}
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
