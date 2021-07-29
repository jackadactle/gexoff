package game.gex.gexoff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SettingsManager {

	public static String getSettings() {
		// get file
		String appdata = System.getenv("APPDATA");
		File dir = new File(appdata+"\\Gexoff");
		// make dir if doesnt exist
		if (!dir.exists()) dir.mkdir();
		
		// make file and write to it if doesnt exist
		File settingsFile = new File(dir.getAbsolutePath()+"\\UserSettings.xml");
		if (!settingsFile.exists()) {
			try {
				settingsFile.createNewFile();
				FileWriter w = new FileWriter(settingsFile.getAbsolutePath());
				w.write("hi");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// read file
		String data = "";
		try {
			Scanner reader = new Scanner(settingsFile);
			while (reader.hasNextLine()) {
				data += reader.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}
	
}
