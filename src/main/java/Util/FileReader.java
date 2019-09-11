package Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FileReader {

	// get file from classpath, resources folder
	public File getFileFromResources(String fileName) {

//    	String fileName = "config/sample.txt";
		ClassLoader classLoader = new FileReader().getClass().getClassLoader();

		File file = new File(classLoader.getResource(fileName).getFile());

		// File is found
		System.out.println("File Found : " + file.exists());

		return file;

	}

}
