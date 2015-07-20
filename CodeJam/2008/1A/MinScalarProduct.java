package codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class MinScalarProduct {

//	input1.add(1l);
//	input1.add(2l);
//	input1.add(3l);
//	input1.add(4l);
//	input1.add(5l);
//
//	input2.add(1l);
//	input2.add(0l);
//	input2.add(1l);
//	input2.add(0l);
//	input2.add(1l);
	private static long func(List<Long> input1, List<Long> input2)
	{
		long result = 0;

		Collections.sort(input1);
		Collections.sort(input2);
		Collections.reverse(input2);

		for(int i=0; i<input1.size(); i++)
		{
			result += input1.get(i) * input2.get(i);
		}

		return result;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner stdin = null;
		File inFile = new File("a.txt");		
		stdin = new Scanner(inFile);

		int caseNum = 1;
		int totalCases = stdin.nextInt();
		//System.out.println(totalCases);
		while (stdin.hasNextLine()) {
			int size = stdin.nextInt();
			//System.out.println(size);
			//stdin.nextLine();
			List<Long> input1 = new ArrayList<Long>();
			List<Long> input2 = new ArrayList<Long>();
			for(int i=0; i<size; i++)
			{
				input1.add(stdin.nextLong());
			//	System.out.print(input1.get(i) + " ");
			}
			//System.out.println();
			for(int i=0; i<size; i++)
			{
				input2.add(stdin.nextLong());
			//	System.out.print(input2.get(i) + " ");
			}
			
			//System.out.println();
//			boolean done = false;
//			int totalOp = 0;
//			String combined = strs.get(0);
//
			System.out.println("Case #"+caseNum+":  "+func(input1, input2)); 
			caseNum++;

		}
	}
}
