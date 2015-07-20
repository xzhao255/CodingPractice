package codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FairAndSquare {
	static boolean isPalindrome(long x) {
		if (x < 0)
			return false;
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}
		while (x != 0) {
			long l = x / div;
			long r = x % 10;
			if (l != r)
				return false;
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}

	
	static long func(long A, long B)
	{
		long count = 0;
		while(A*A<=B)
		{
			if(isPalindrome(A) && isPalindrome(A*A)) count++;
			A++;
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
			long A = stdin.nextLong();
			long B = stdin.nextLong();
			//System.out.println(A + " " + B);
			A = (long)Math.ceil(Math.sqrt(A));
			System.out.println("Case #"+caseNum+":  "+func(A, B)); 
			caseNum++;
		}
		stdin.close();
	}
}
