package codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rotate {

	static boolean H(int i, int j, int K, char[][] input, int size)
	{
		if(i+K > size) return false;
		int count = 1;
		while(count < K)
		{
			if(input[i][j] != input[i+count][j])
				return false;
			count++;
		}
		return true;
	}
	
	static boolean V(int i, int j, int K, char[][] input, int size)
	{
		if(j+K > size) return false;
		int count = 1;
		while(count < K)
		{
			if(input[i][j] != input[i][j+count])
				return false;
			count ++;
		}
		return true;
	}
	
	static boolean D1(int i, int j, int K, char[][] input, int size)
	{
		if(i+K>size || j+K>size) return false;
		int count = 1;
		while(count < K)
		{
			if(input[i][j] != input[i+count][j+count])
				return false;
			count++;
		}
		return true;
	}
	
	static boolean D2(int i, int j, int K, char[][] input, int size)
	{
		if(i+K>size || j-K<-1) return false;
		
		int count = 1;
		while(count < K)
		{
			if(input[i][j] != input[i+count][j-count])
				return false;
			count++;
		}
		return true;
	}

	static String checkWinner(char[][] input, int size, int K)
	{
		boolean redWin = false;
		boolean blueWin = false;

		for(int i=0; i<size; i++)
		{
			if(redWin && blueWin) break;
			for(int j=0; j<size; j++)
			{
				if(input[i][j] != '.') 
				{
					boolean win = H(i, j, K, input, size) || V(i, j, K, input, size) || D1(i, j, K, input, size) || D2(i, j, K, input, size);
					if(win)
					{
						if(input[i][j] == 'R') redWin = true;
						else blueWin = true;
					}
				}
			}
		}
		if(redWin && blueWin) return "Both";
		else if(redWin) return "Red";
		else if(blueWin) return "Blue";
		else return "Neither";
	}



	static void takeGravity(char[][] input, int size)
	{
		for(int col=0; col<size; col++)
		{
			int bottom = size-1;
			int current = size -1;
			while(current >= 0)
			{
				if(input[bottom][col] != '.')
				{
					bottom--; current--;
				}
				else if(input[current][col] == '.')
					current--;
				else
				{
					input[bottom][col] = input[current][col];
					input[current][col] = '.';
					bottom--; current--;
				}
			}
		}

	}

	static char[][] rotate(char[][] input, int size)
	{
		char[][] output = new char[size][size];

		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				output[i][j] = '.';
			}
		}

		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				if(input[i][j] != '.')
				{
					int newRow = j;
					int newCol = size-i-1;
					output[newRow][newCol] = input[i][j];
				}
			}
		}
		return output;
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
			int K = stdin.nextInt();
			//System.out.println(N + " " + K);

			String[] input = new String[N];

			for(int i=0; i<N; i++)
			{
				input[i] = stdin.next();
				//System.out.println(input[i]);
			}

			char[][]  inputChar = new char[N][N];
			for(int i=0; i<N; i++)
			{
				String s = input[i];
				for(int j=0; j<N; j++)
				{
					inputChar[i][j] = s.charAt(j);
				}
			}

			char[][] afterRotate = rotate(inputChar, N);
			takeGravity(afterRotate, N);
			//System.out.println();
			System.out.println("Case #"+caseNum+":  "+checkWinner(afterRotate, N, K)); 
			caseNum++;
		}
		stdin.close();
	}

}
