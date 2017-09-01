import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class MoveFiles {


	private String source = "";
	private String destination = "";
	private String keyword = "";
	
    private File folder;
	private File[] sourceFiles;

	private String pathKeyword = "";
	private String pathSource = "";
	private String pathDestination = "";

	
	
	public static void main(String[] args) {

//		MoveFiles move = new MoveFiles();
////		move.saveCode();
//		System.out.println(move.readCode());
////		move.saveSource();
//		System.out.println(move.readSource());
////		move.saveDestination();
//		System.out.println(move.readDestination());
////		move.move();

	}

	// constructors
	/**
	 * 
	 * @param codeWord
	 *            if codeWord is identical with the beginning of the name of the
	 *            file it triggers the moving process
	 */

	
	public MoveFiles(String pathSource, String pathKeyword, String pathDestination){
		this.source = readSource();
		this.keyword = readKey();
		this.destination = readDestination();
		
		this.pathSource = pathSource;
		this.pathKeyword = pathKeyword;
		this.pathDestination = pathDestination;
		
	}

	// setter methods

	public void setNewKeyWord(String code) {
		this.keyword = code;
	}

	/**
	 * 
	 * @param source
	 *            in this folder the codeWord will be searched and if the
	 *            filename contains the code word then it can be moved with
	 *            move()
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * 
	 * @param destination
	 *            the folder to which the files will be moved
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	// getter methods
	public String getSource() {
		return this.source;
	}

	public String getDestination() {
		return this.destination;
	}

	public String getKeyWord() {
		return this.keyword;
	}

	//Methods
	/**
	 * Moves the files containing the codeword from the source folder to the
	 * destination folder
	 */
	public void move() {
		folder = new File(source);
		sourceFiles = folder.listFiles();
		boolean equal;
		try {
			for (int i = 0; i < sourceFiles.length; i++) {
				if (sourceFiles[i].isFile()) {
					String fileName = sourceFiles[i].getName();
					System.out.println("Check: " + fileName);
					equal = true;
					for (int j = 0; j < keyword.length(); j++) {
//						System.out.println("Compare " + fileName.charAt(j) + " to " + keyword.charAt(j));
//						System.out.println("Equal? " + (fileName.charAt(j) == keyword.charAt(j)));
						if (fileName.charAt(j) != keyword.charAt(j)) {
//							System.out.println("set the boolean to false+\n");
							equal = false;
						}

					}
					if (equal) {
						sourceFiles[i].renameTo(new File(destination + "/" + fileName));
						System.out.println("The files have been moved:" + fileName);
					} else {
						System.out.println("Nothing happened");
					}

				}
			}
		} catch (Exception e) {
			System.out.println("An error occured");
		}
	}
	
	
	
	//Methods to save and read the code word, the source and the destination in a txt document 
	//in the background
	public void saveKeyword(){
		try{
		FileWriter writer = new FileWriter(pathKeyword);
		writer.write(this.keyword);
		writer.flush();
		writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void saveKey(String s){
		try{
		FileWriter writer = new FileWriter(pathKeyword);
		writer.write(s);
		writer.flush();
		writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public String readKey(){

		 try{
	    BufferedReader reader = new BufferedReader(new FileReader(pathKeyword));
	    String s = reader.readLine();
		reader.close();
		return s;
		 }
		 catch(Exception e){
			 
		 }
		 return "";
	
	}
	
	public void saveSource(){
		try{
		FileWriter writer = new FileWriter(pathSource);
		writer.write(this.source);
		writer.flush();
		writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void saveSource(String s){
		try{
		FileWriter writer = new FileWriter(pathSource);
		writer.write(s);
		writer.flush();
		writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String readSource(){

		 try{
	    BufferedReader reader = new BufferedReader(new FileReader(pathSource));
//		System.out.println(reader.readLine());
	    String s = reader.readLine();
		reader.close();
		return s;
		 }
		 catch(Exception e){
			 
		 }
		 return "";

	}
	
	
	public void saveDestination(){
		try{
		FileWriter writer = new FileWriter(pathDestination);
		writer.write(this.destination);
		writer.flush();
		writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void saveDestination(String s){
		try{
		FileWriter writer = new FileWriter(pathDestination);
		writer.write(s);
		writer.flush();
		writer.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String readDestination(){

		 try{
	    BufferedReader reader = new BufferedReader(new FileReader(pathDestination));
	    String s = reader.readLine();
		reader.close();
		return s;
		 }
		 catch(Exception e){
			 
		 }
		 return "";

	}

}
