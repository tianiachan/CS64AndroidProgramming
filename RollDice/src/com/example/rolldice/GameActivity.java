package com.example.rolldice;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends Activity {

	private Button btnRoll;
	private TextView tvWelcome, tvGameRandom, tvResult;
	private Random random;
	private int winCount = 0, loseCount = 0;

	public void quit(View view)
	{
		Intent returnIntent = getIntent();//need to create carrier to give result back to MainActivity
		String result = "You have won " + winCount + " times, and lost " + loseCount + " times.";
		returnIntent.putExtra("result", result);// pass back the win and lose count
		setResult(Activity.RESULT_OK, returnIntent);//grant permission to deliver back , can use result cancelled if no data
		this.finish();
	}

	public void onRollClicked(View view)
	{
		int gameRand = random.nextInt(10)+ 2;// get range between 2 to 12
		tvGameRandom.setText("Game random number: " + gameRand);// random number for host
		int playerRand = random.nextInt(10)+ 2;// get range between 2 to 12
		if(playerRand > gameRand)
		{
			tvResult.setText("Your number is " + playerRand + ". You win!");// player win
			winCount++;
		}
		else
		{
			tvResult.setText("You number is " + playerRand + ". You lose.");//if player lose
			loseCount++;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {//acts like a constructor?
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		btnRoll = (Button)findViewById(R.id.btnRollDice);
		tvWelcome = (TextView)findViewById(R.id.tvwelcome);
		tvGameRandom = (TextView)findViewById(R.id.tvgamerandom);
		tvResult = (TextView)findViewById(R.id.tvresult);
		random = new Random();
		Bundle extra = getIntent().getExtras();//gets the package from first activity aka the key value
		String name = extra.getString("playerName");//get the player name by using the key
		tvWelcome.setText(name + "! " + tvWelcome.getText());// use get text to get text to add to the beginning of the welcome message
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
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
