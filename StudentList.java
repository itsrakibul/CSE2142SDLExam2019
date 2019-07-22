import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
//		Check arguments
		if(args==null || args.length != 1)
		{
			return ;
		}
		else if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String r = s.readLine();
				String i[] = r.split(",");			
				for(String j : i)
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String fileContent = bufferedReader.readLine();
				String words[] = fileContent.split(",");			
				for(String word : words)
			 	{ 
			 		System.out.println(j); 
			 		System.out.println(word); 
			 	}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String r = s.readLine();
				System.out.println(r);
				String i[] = r.split(",");	
				Random x = new Random();
				int y = x.nextInt();
				System.out.println(i[y]);
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
				BufferedWriter s = new BufferedWriter(new FileWriter("students.txt", true));
				String t = args[0].substring(1);
	       	 	Date d = new Date();
	       		String df = "dd/mm/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(df);
	        	String fd= dateFormat.format(d);
				s.write(", "+t+"\nList last updated on "+fd);
				s.close();
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
				BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String r = s.readLine();
				String i[] = r.split(",");	
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String fileContent = bufferedReader.readLine();
				String words[] = fileContent.split(",");	
				boolean done = false;
				String t = args[0].substring(1);
				for(int idx = 0; idx<i.length && !done; idx++) {
					if(i[idx].equals(t)) {
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
				BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String D = s.readLine();
				char a[] = D.toCharArray();			
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String fileContent = bufferedReader.readLine();
				char words[] = fileContent.toCharArray();			
				boolean in_word = false;
				int count=0;
				for(char c:a) {
					if(c ==' ') 
				for(char word:words) {
					if(word ==' ') 
					{
						if (!in_word) {	count++; in_word =true;	}
						else { in_word=false;}			
					}
				}
			System.out.println(count +" word(s) found " + a.length);
			System.out.println(count +" word(s) found " + words.length);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
	}
}