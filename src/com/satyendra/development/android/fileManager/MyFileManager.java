package com.satyendra.development.android.fileManager;

import java.io.File;
import java.util.ArrayList;

import android.os.AsyncTask;
import android.widget.TextView;

import com.satyendra.development.android.fileExplorer.FileExploreListAdapter;

public class MyFileManager 
{

	public ArrayList<FileExploreModel> dataProvider;

	public FileExploreListAdapter adapter;

	public void setCurrentPath(String path)
	{
		dataProvider = new ArrayList<FileExploreModel>();
		File f = new File(path);
		String[] list = f.list();

		for (int i = 0; list != null && i < list.length; i++) 
		{
			String correctpath;

			if(path.equals("/"))
			{
				correctpath = path +list[i];
			}
			else
			{
				correctpath = path +"/" +list[i];;
			}
			FileExploreModel model = new FileExploreModel(correctpath);
			dataProvider.add(model);
		}

		if(adapter != null)
		{
			adapter.dataProvider = dataProvider;
			adapter.notifyDataSetChanged();
		}

	}


	private class LongOperation extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.interrupted();
				}
			}
			return "Executed";
		}

		@Override
		protected void onPostExecute(String result) 
		{
			
			//	            TextView txt = (TextView) findViewById(R.id.output);
			//	            txt.setText("Executed"); // txt.setText(result);
			// might want to change "executed" for the returned string passed
			// into onPostExecute() but that is upto you
		}

		@Override
		protected void onPreExecute() {
			
		}

		@Override
		protected void onProgressUpdate(Void... values) {
			
		}
	}

}
