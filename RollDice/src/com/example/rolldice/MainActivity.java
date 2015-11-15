package com.example.rolldice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button btnPlay, btnQuitGame;
	private TextView tvDisplay;
	private EditText editPlayerName;
	static final int REQUEST_CODE_ONE = 1;//request code for activity, if have more than one activity then can have more than one request code
	AlertDialog.Builder builder;
	
	public void quitGame(View view)
	{
		this.finish();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnPlay = (Button)findViewById(R.id.btnPlay);
		btnQuitGame = (Button)findViewById(R.id.btnQuitGame);
		tvDisplay = (TextView)findViewById(R.id.tvDisplay);
		editPlayerName = (EditText)findViewById(R.id.editPlayerName);
	}
	
	@Override
	protected void onActivityResult(int requestcode, int resultCode, Intent data)
	{
		if(requestcode == REQUEST_CODE_ONE)// if the result code passed back in is correct
		{
			if(resultCode == Activity.RESULT_OK)
			{
				String resultStr = data.getStringExtra("result");//get the string
				tvDisplay.setText(resultStr + "! thank you for playing the game.");//set the string!
			}
		}
	}
	
	public void onPlayClicked(View view)
	{
		Intent gameIntent = new Intent(this, GameActivity.class);//create object to go to second page
		String playername = editPlayerName.getText().toString();//gets text from player entered
		gameIntent.putExtra("playerName", playername );//passes in values that we need first part is a key, second is value
		// if you have more data, you can continue to call put Extra
		startActivityForResult(gameIntent, REQUEST_CODE_ONE);//expecting result so that you can start it and then send back result
		//startActivity(gameIntent);//start it
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
