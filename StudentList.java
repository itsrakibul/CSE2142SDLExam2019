import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {


		String fileContent = loadData("students.txt");
		if(args==null || args.length != 1)
		{
			return ;
		}
		else if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String fileContent = bufferedReader.readLine();
				
				String words[] = fileContent.split(",");			
				for(String word : words)
			 	{ 
			 		System.out.println(word); 
			 	}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String fileContent = bufferedReader.readLine();
				
				System.out.println(fileContent);
				String words[] = fileContent.split(",");	
				Random random = new Random();
				int randomIndex = random.nextInt();
				System.out.println(words[randomIndex]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", true));
				String argValue = args[0].substring(1);
	       	 	Date date = new Date();
	       		String data_Format = "dd/mm/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(data_Format);
	        	String formatted_data = dateFormat.format(date);
				bufferedWriter.write(", "+argValue+"\nList last updated on "+formatted_data);
				bufferedWriter.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String fileContent = bufferedReader.readLine();
				
				String words[] = fileContent.split(",");	
				boolean done = false;
				String argValue = args[0].substring(1);
				for(int idx = 0; idx<words.length && !done; idx++) {
					if(words[idx].equals(argValue)) {
						System.out.println("We found it!");
							done=true;
					}
				}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String fileContent = bufferedReader.readLine();
				
				char words[] = fileContent.toCharArray();			
				boolean in_word = false;
				int count=0;
				for(char word:words) {
					if(word ==' ') 
					{
						if (!in_word) {	count++; in_word =true;	}
						else { in_word=false;}			
					}
				}
			System.out.println(count +" word(s) found " + words.length);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
	}

	static String loadData(String fileName)
	{
		try
		{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 

			return bufferedReader.readLine();
		}catch(Exception e)
		{
			System.out.println("File not Found");
			return null;
		}
	}
}