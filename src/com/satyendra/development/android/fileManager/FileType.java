package com.satyendra.development.android.fileManager;

import java.io.File;

public enum FileType {

	FOLDER_TYPE, FILE_TYPE, ROOT,NONE;
	
	public static FileType getFileType(File f)
	{
		if (f!=null) {
		
			if(f.isDirectory())
			{
				return FOLDER_TYPE;
				
			}else if (f.isFile()) {
				return FILE_TYPE;
				
			}
			
		}
		
		return NONE;
		
	}
}
