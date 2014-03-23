package com.satyendra.development.android.fileManager;

import android.annotation.SuppressLint;
import java.io.File;
import java.util.ArrayList;


public class FileExploreModel {

	public String label;
	public FileType type = FileType.FILE_TYPE;
	public long size;
	public String filePath;
	
	@SuppressLint("NewApi")
	public FileExploreModel(String filePath)
	{
		
		File f = new File(filePath);
		label = f.getName();
		type = FileType.getFileType(f);
		size = f.getTotalSpace();
		this.filePath = filePath;
		
	
	}
	
	
	
}
