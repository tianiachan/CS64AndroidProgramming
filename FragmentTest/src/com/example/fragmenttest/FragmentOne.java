package com.example.fragmenttest;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentOne extends Fragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		//inflate the layout for this fragment
		View view = inflater.inflate(R.layout.activity_fragment_one, container, false);
		//create image view object
		ImageView iv = (ImageView)view.findViewById(R.id.imageview1);
		//create textview object
		TextView tv = (TextView)view.findViewById(R.id.textview1);
		//set image
		iv.setImageResource(R.drawable.download);
		//set text
		tv.setText("Live long and prosper!");
		//return the view for use
		return view;
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}
}
