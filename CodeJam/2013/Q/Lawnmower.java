package codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lawnmower {
	static boolean isOkay(int[][] input, int i, int j)
	{
		int key = input[i][j];
		boolean verticalOkay = true;
		for(int x = 0; x<input.length; x++)
		{
			if(input[x][j] > key)
			{
				verticalOkay = false;
				break;
			}
		}
		
		if(verticalOkay) return true;
		
		for(int x=0; x<input[0].length; x++)
		{
			if(input[i][x] > key)
				return false;
		}
		
		return true;
	}
	
	static String func(int[][] input)
	{
		for(int i=0; i<input.length; i++)
		{
			for(int j=0; j<input[0].length; j++)
			{
				if(!isOkay(input, i, j))
				{
					return "No";
				}
			}
		}
		return "Yes";
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner stdin = null;
		File inFile = new File("a.txt");		
		stdin = new Scanner(inFile);

		int caseNum = 1;
		int totalCases = stdin.nextInt();
		//System.out.println(totalCases);
		while (stdin.hasNextLine()) {
			int N = stdin.nextInt();
			int M = stdin.nextInt();
			//System.out.println(N + " " + M);
			
			int[][] input = new int[N][M];
			
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<M; j++)
				{
					input[i][j] = stdin.nextInt();
					//System.out.print(input[i][j] + " ");
				}
				//System.out.println();
			}

			System.out.println("Case #"+caseNum+":  "+func(input)); 
			caseNum++;
		}
		stdin.close();
	}

}
