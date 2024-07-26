package com.guarage.configue.www;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class DatabaseRoots {
	public static FileInputStream finf = null;
	static{
		File f = new File(".");
		
		String path = (f.getAbsolutePath().substring(0, f.getAbsolutePath().length()-1))+"src\\database.properties";
		try {
			finf = new FileInputStream(path) ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
