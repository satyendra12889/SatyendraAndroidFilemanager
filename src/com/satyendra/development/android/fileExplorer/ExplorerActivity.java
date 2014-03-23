package com.satyendra.development.android.fileExplorer;

import java.util.EmptyStackException;
import java.util.Stack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.satyendra.development.android.fileExplorer.Styles.FontManager;
import com.satyendra.development.android.fileManager.FileExploreModel;
import com.satyendra.development.android.fileManager.FileType;
import com.satyendra.development.android.fileManager.MyFileManager;

public class ExplorerActivity extends Activity implements OnItemClickListener, OnClickListener, OnLongClickListener {

	MyFileManager manager;
	EditText pathText;
	Button openBtn;
	ListView list;
	Button backBtn;
	String currentPath;
	String lastPath;
	Stack<String> lastPaths;
	Button downloadManager;

	// font manager
	FontManager fntMngr;

	


	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.file_explorer);

		fntMngr = FontManager.getInstance(getApplicationContext());
		
		list = (ListView) findViewById(R.id.fileList);
		openBtn = (Button) findViewById(R.id.OpenBtn);
		pathText = (EditText) findViewById(R.id.pathTxt);
		backBtn = (Button) findViewById(R.id.backBtn);
		downloadManager = (Button) findViewById(R.id.downloadManagerBtn);

		openBtn.setTypeface(fntMngr.FONT_NORMAL);
		pathText.setTypeface(fntMngr.FONT_NORMAL);
		backBtn.setTypeface(fntMngr.FONT_NORMAL);
		downloadManager.setTypeface(fntMngr.FONT_NORMAL);



		openBtn.setOnClickListener(this);
		backBtn.setOnClickListener(this);
		downloadManager.setOnClickListener(this);

		manager = new MyFileManager();

		lastPaths = new Stack<String>();
		currentPath = "/";
		pathText.setText(currentPath);
		FileExploreListAdapter  adapter = new FileExploreListAdapter(this.getBaseContext());
		manager.adapter = adapter;
		
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
		list.setOnLongClickListener(this);
		list.setLongClickable(true);


		manager.setCurrentPath(currentPath);

	}

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		if(v == openBtn)
		{
			openButtonOnClick();
		} 
		else if(v == backBtn)
		{
			backButtonOnClick();
		}
		else if(v == downloadManager)
		{
			downloadManagerClicked();
		}
	}

	public void downloadManagerClicked()
	{
		Intent intent = new Intent(this, BlueToothActivity.class);
		startActivity(intent);
	}

	public void backButtonOnClick(){

		//TO DO check for correct path or not and display error

		//		currentPath = lastPath;
		try {

			String path = lastPaths.pop();
			if(path !=null)
			{
				currentPath = path;
				manager.setCurrentPath(currentPath);
			}
		} catch (EmptyStackException e) {
			//TODO: handle exception
			Toast.makeText(getBaseContext(), "you are at the root !!!", Toast.LENGTH_SHORT).show();

		}
	}
	public void openButtonOnClick(){

		//TO DO check for correct path or not and display error
		lastPath = currentPath;
		lastPaths.push(currentPath);
		currentPath = pathText.getText().toString();
		manager.setCurrentPath(currentPath);
	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		FileExploreModel model = manager.dataProvider.get(position);
		if(model.type != FileType.FILE_TYPE)
		{
			lastPaths.push(currentPath);
			currentPath = model.filePath;

			manager.setCurrentPath(currentPath);
			pathText.setText(currentPath);
		}
		else
		{
			Toast.makeText(getBaseContext(), "This is file you cann't drill into it!!!", Toast.LENGTH_SHORT).show();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.explorer, menu);
		return true;
	}

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub

		if(v == list)
		{
			System.out.println("log pressed clicked");
			return true;
		}
		return false;
	}

}
