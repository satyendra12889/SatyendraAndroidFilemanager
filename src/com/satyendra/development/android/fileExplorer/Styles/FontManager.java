package com.satyendra.development.android.fileExplorer.Styles;

import android.content.Context;
import android.graphics.Typeface;

public class FontManager {
	
	// TODO Create multiton manager with the different xmls. xmls contain the font paths of the different fonts
	public 	Typeface FONT_NORMAL;
	public  Typeface FONT_BOLD;
	public  Typeface FONT_ITL;
	public  Typeface FONT_BLDITL;
	
	
	protected String fontPathNormal;
	protected String fontPathBold;
	protected String fontPathItalic;
	protected String fontPathBLDITL;
	
	public static volatile FontManager manager;
	
	public static FontManager getInstance(Context con)
	{
		if(manager == null){
			synchronized (FontManager.class) {
				if(manager == null){
					manager = new FontManager(con);
				}
				else
				{
					return manager;
				}
			}
		}
		else
		{
			return manager;
		}
		return manager;
		
	}
	
	private FontManager(Context context)
	{
		

		fontPathNormal = "fonts/Aller_Rg.ttf";	
		fontPathBold = "fonts/Aller_Bd.ttf";	
		fontPathItalic = "fonts/Aller_It.ttf";	
		fontPathBLDITL = "fonts/Aller_BdIt.ttf";	
		
		if(fontPathNormal != null && !fontPathNormal.equals(""))
		{
			FONT_NORMAL = Typeface.createFromAsset(context.getAssets(), fontPathNormal);
		}
		if(fontPathBold != null && !fontPathBold.equals(""))
		{
			FONT_BOLD = Typeface.createFromAsset(context.getAssets(), fontPathBold);
		}
		if(fontPathItalic != null && !fontPathItalic.equals(""))
		{
			FONT_ITL = Typeface.createFromAsset(context.getAssets(), fontPathItalic);
		}
		if(fontPathBLDITL != null && !fontPathBLDITL.equals(""))
		{
			FONT_BLDITL = Typeface.createFromAsset(context.getAssets(), fontPathBLDITL);
		}
	}
	
	
	
	

}
