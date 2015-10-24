package com.example.cs64assign4calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText display;
	Button btnClear, btn7, btn8, btn9, btn4, btn5, btn6, btn1, btn2, btn3, btn0, btnPeriod, btnQuit;
	String btnClicked = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//class activity, can change
		display = (EditText)findViewById(R.id.editTextEnterBox);
		display.setText("");
		btnClear = (Button)findViewById(R.id.buttonClear);
		btn7 = (Button)findViewById(R.id.button7);
		btn8 = (Button)findViewById(R.id.button8);
		btn9 = (Button)findViewById(R.id.button9);
		btn4 = (Button)findViewById(R.id.button4);
		btn5 = (Button)findViewById(R.id.button5);
		btn6 = (Button)findViewById(R.id.button6);
		btn1 = (Button)findViewById(R.id.button1);
		btn2 = (Button)findViewById(R.id.button2);
		btn3 = (Button)findViewById(R.id.button3);
		btn0 = (Button)findViewById(R.id.button0);
		btnPeriod = (Button)findViewById(R.id.buttonPeriod);
		btnQuit = (Button)findViewById(R.id.buttonQuit);
		
		/*btnClear.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View view) {
				display.setText("#############");
				return true;//if button is held, this will process
			}
		});*/
		

	}
	
	public void btnClicked(View view)
	{
		
		switch(view.getId())
		{
		case R.id.button0:
			btnClicked += "0";
			display.setText(btnClicked);
			break;
		case R.id.button1:
			btnClicked += "1";
			display.setText(btnClicked);
			break;
		case R.id.button2:
			btnClicked += "2";
			display.setText(btnClicked);
			break;
		case R.id.button3:
			btnClicked += "3";
			display.setText(btnClicked);
			break;
		case R.id.button4:
			btnClicked += "4";
			display.setText(btnClicked);
			break;
		case R.id.button5:
			btnClicked += "5";
			display.setText(btnClicked);
			break;
		case R.id.button6:
			btnClicked += "6";
			display.setText(btnClicked);
			break;
		case R.id.button7:
			btnClicked += "7";
			display.setText(btnClicked);
			break;
		case R.id.button8:
			btnClicked += "8";
			display.setText(btnClicked);
			break;
		case R.id.button9:
			btnClicked += "9";
			display.setText(btnClicked);
			break;
		case R.id.buttonPeriod:
			btnClicked += ".";
			display.setText(btnClicked);
			break;
		case R.id.buttonClear:
			btnClicked = "";
			display.setText(btnClicked);
			break;
		case R.id.buttonQuit:
			this.finish();
			break;
		default:
			display.setText("Error: Wrong button");
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
