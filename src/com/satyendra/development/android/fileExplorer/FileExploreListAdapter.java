package com.satyendra.development.android.fileExplorer;

import java.util.ArrayList;

import com.satyendra.development.android.fileExplorer.Styles.FontManager;
import com.satyendra.development.android.fileManager.FileExploreModel;
import com.satyendra.development.android.fileManager.FileType;
import com.satyendra.development.android.fileManager.MyFileManager;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

public class FileExploreListAdapter extends  BaseAdapter {

	public ArrayList<FileExploreModel> dataProvider;

	Context mContext;

	FontManager fntMngr;
	public FileExploreListAdapter(Context con)
	{
		mContext = con;
		fntMngr = FontManager.getInstance(mContext.getApplicationContext());
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dataProvider !=null ? dataProvider.size() : 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return dataProvider.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		View v = convertView;
		TextView txt;
		ImageView img;
		FileExploreModel model = dataProvider.get(position);
		
		
		if(convertView==null)
		{
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.fileexplorelistitem, null);
			v = (View)viewGroup;
		}

		
		txt = (TextView)v.findViewById(R.id.title);
		txt.setTypeface(fntMngr.FONT_NORMAL);
		img = (ImageView)v.findViewById(R.id.icon);
		
		
		
		txt.setText(model.label);
		if(model.type == FileType.FILE_TYPE)
		{
			img.setImageResource(R.drawable.file);
		}
		else
		{
			img.setImageResource(R.drawable.folder);
		}
		return v;
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled(int position) {
		// TODO Auto-generated method stub
		return true;
	}

}
