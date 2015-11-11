package com.example.fragmenttest;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class FragmentTwo extends ListFragment implements OnItemClickListener
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		//inflate the layout for this fragment
		View view = inflater.inflate(R.layout.activity_fragment_two, container, false);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.STCaptains, android.R.layout.simple_list_item_1);
		setListAdapter(adapter);
		getListView().setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id)
	{
		Toast.makeText(getActivity(), "Clicked on item: " + (position + 1), Toast.LENGTH_SHORT).show();
	}
}
