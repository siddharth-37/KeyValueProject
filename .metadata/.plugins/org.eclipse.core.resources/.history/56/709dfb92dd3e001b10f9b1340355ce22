import java.io.*;



public class Writer {
	
	static String appendTheDataInFile(String data, File file) {		
		
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			
			writer.println(data);
			
			writer.flush();
			writer.close();
		} catch (IOException expection) {
			return "An Error has been occurred while accessing the file, Please try again..";
		}
		
		return "Successfully added to file";
	}
	
}
