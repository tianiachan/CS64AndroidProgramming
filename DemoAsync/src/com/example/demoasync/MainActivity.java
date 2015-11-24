package com.example.demoasync;

import java.util.ArrayList;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity
{
   ListView listView;
   String[] list;
   
   private void populateList()
   {
      list = new String[100];
      for(int i = 0; i < list.length; i++)
      {
         list[i] = String.valueOf( i + 1 );
      }
   }
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      requestWindowFeature(Window.FEATURE_PROGRESS);// calls built in progress bar must call before setcontent view otherwise wont work
      setContentView(R.layout.activity_main);
      listView=(ListView)findViewById(R.id.list);
      populateList();//populate the list with stuff
      ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, new ArrayList());
      listView.setAdapter(adapter);//set adapter
      listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {

         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id)
         {
            String item =listView.getItemAtPosition(position).toString();
            Toast.makeText(MainActivity.this, "You clicked " + item, 
                  Toast.LENGTH_SHORT).show();
            
         }
      });
      myAsyncTask myTask = new myAsyncTask();//create object of the async class
      myTask.execute();//call execute to execute the class becuase everything is aleady inside, if add something, it will not match
      
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
   
   class myAsyncTask extends AsyncTask<Void, String, Void>
   {
      ArrayAdapter<String> adapter;
      int count = 0;// keep track of progress
      
      //traverse list and call method to pass item to it, try to make thread sleep for 200 milisecond
      @Override
      protected Void doInBackground(Void... params)//means a group of objects instead of just one string
      {
         for(String item : list)
         {
            publishProgress(item);
            try
            {
               Thread.sleep(200); //sleep for 200ms
            } 
            catch (InterruptedException e)
            {
               e.printStackTrace();
            }
         }
         return null;
      }

      /* (non-Javadoc)
       * @see android.os.AsyncTask#onPreExecute()
       */
      @Override
      protected void onPreExecute()
      {
         
         adapter = (ArrayAdapter<String>)listView.getAdapter();//put adapter from list view into adapter and type cast
         setProgressBarVisibility(true);// this is the plce for progres bar tomake visible
         setProgressBarIndeterminate(false);// if set to true, will show an infinite, so instead want progres bar to show  based on progress
      }

      /* (non-Javadoc)
       * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
       */
      @Override
      protected void onPostExecute(Void result)
      {//called when background thread is finished running
         setProgressBarVisibility(false);//hide progress bar after finished
         Toast.makeText(MainActivity.this, "All items loaded. ", Toast.LENGTH_LONG).show();
      }

      /* (non-Javadoc)
       * @see android.os.AsyncTask#onProgressUpdate(java.lang.Object[])
       */
      @Override
      protected void onProgressUpdate(String... values)
      {
         count++;
         adapter.add(values[0]);//gives a single string of list item being passed in
         setProgress((count*10000)/100);//will decide how much to advance based on number
         if(count%20 == 0)
         {
            Toast.makeText(MainActivity.this, count + "% data loaded", 
                  Toast.LENGTH_SHORT).show();
         }
      }

   }
}
