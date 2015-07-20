package codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class FileFixIt {
	
	static void initializeExisting(String[] existing, HashSet<String> dir)
	{
		for(int i=0; i<existing.length; i++)
		{
			createDir(existing[i], dir);
		}
	}

	static int createDir(String path, HashSet<String> dir)
	{
		if(dir.contains(path)) return 0;
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<path.length(); i++)
		{
			sb.append(path.charAt(i));
			if(i+1 == path.length() || path.charAt(i+1) == '/')
			{
				if(!dir.contains(sb.toString()))
				{
					count++;
					dir.add(sb.toString());
				}
			}
		}
		return count;
	}

	static int func(String[] existing, String[] toCreate)
	{
		int count = 0;
		HashSet <String> dir = new HashSet<String>();

		initializeExisting(existing, dir);

		for(int i=0; i<toCreate.length; i++)
		{
			count += createDir(toCreate[i], dir);
		}

		return count;
	}


	public static void main(String[] args) throws FileNotFoundException {
		Scanner stdin = null;
		File inFile = new File("a.txt");		
		stdin = new Scanner(inFile);

		int caseNum = 1;
		int totalCases = stdin.nextInt();
		//System.out.println(totalCases);
		while (stdin.hasNextLine()) {
			int exist = stdin.nextInt();
			int newPath = stdin.nextInt();
			//System.out.println(exist + " " + newPath);
			
			String[] e = new String[exist];
			String[] t = new String[newPath];
			
			for(int i=0; i<exist; i++)
			{
				e[i] = stdin.next();
				//System.out.println(e[i]);
			}
			
			for(int i=0; i<newPath; i++)
			{
				t[i] = stdin.next();
				//System.out.println(t[i]);
			}
			//System.out.println();
			System.out.println("Case #"+caseNum+":  "+func(e, t)); 
			caseNum++;
		}
		stdin.close();
		
	}

}
