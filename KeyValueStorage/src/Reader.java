import java.io.*;
import java.util.*;
public class Reader {
	
	static String readTheValue(String key, File file) {
		
		
		String output = "";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String line = reader.readLine();
			
			while (line != null) {
				
				String[] arr = line.split("#");
				if (arr[0].equals(key)) {
					output = arr[1];
					break;
				}
				
				line = reader.readLine();
			}
			
			reader.close();
		} catch (IOException exception) {
			
			return "An error has been occurred while accessing the file, Please try again..";
		}
		
		
		return output;
	}
	
	
	
	static boolean readAllTheKey(File file, Set<String> keySet) {
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String line = reader.readLine();
			
			while (line != null) {
				
				String[] arr = line.split("#");
				keySet.add(arr[0]);
				line = reader.readLine();
			}
			
			reader.close();
		} catch (IOException exception) {
			keySet = new HashSet<String>();
			return false;
		}
		
		return true;
	}
	
	
	static String deleteTheGivenKey(File file, String key) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			File tmp = new File("tmp.txt");
			tmp.delete();
			String line = reader.readLine();
			
			while (line != null) {
				
				String[] arr = line.split("#");
				
				if (!arr[0].equals(key)) {
					String status = Writer.appendTheDataInFile(line, tmp);
					if (!status.equals("Successfully added to file")) {
						reader.close();
						throw new IOException();
					}
				}
				line = reader.readLine();
			}
			
			PrintWriter writer = new PrintWriter(file);
			writer.print("");
			writer.close();
			reader.close();
			
			reader = new BufferedReader(new FileReader(tmp));
            
			line = reader.readLine();
			
			while (line != null) {
				
				String status = Writer.appendTheDataInFile(line, file);
				if (!status.equals("Successfully added to file")) {
					reader.close();
					throw new IOException();
				}
				line = reader.readLine();
			}
			
			reader.close();
			
			tmp.delete();
			
		} catch (IOException exception) {
			return "An error has been occurred while accessing the file, Please try again..";
		}
		
		
		return "The Key has been deleted Successfully";
	}
	
	
}
