import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		Constant constant = new Constant();
		String fileContent = loadData(constant.studentList);
		if(args==null || args.length != 1)
		{
			return ;
		}
		else if(args[0].equals(constant.showAll)) {
			System.out.println("Loading data ...");			
			try {
				String words[] = fileContent.split(constant.Spliter);			
				for(String word : words)
			 	{ 
			 		System.out.println(word); 
			 	}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals(constant.showRandom)) 
		{
			System.out.println("Loading data ...");			
			try {
				System.out.println(fileContent);
				String words[] = fileContent.split(constant.Spliter);	
				Random random = new Random();
				int randomIndex = random.nextInt();
				System.out.println(words[randomIndex]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains(constant.addEntry)){
			System.out.println("Loading data ...");			
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", true));
				String argValue = args[0].substring(1);
	       	 	Date date = new Date();

	        	DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a");
	        	String formatted_data = dateFormat.format(date);
				bufferedWriter.write(", "+argValue+"\nList last updated on "+formatted_data);
				bufferedWriter.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains(constant.findEntry)) 
		{
			System.out.println("Loading data ...");			
			try {
				
				String words[] = fileContent.split(constant.Spliter);	
				//boolean done = false;
				String argValue = args[0].substring(1);
				int index=-1;
				for(int idx = 0; idx<words.length; idx++) {
					if(words[idx].equals(argValue)) {
						
							index=idx;
							break;
					}
				}
				if(index>=0)
				{
					System.out.println("Data Found");
				}
				else
				{
					System.out.println("Data not Found");
				}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains(constant.showCount)) 
		{
			System.out.println("Loading data ...");			
			try {
				
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