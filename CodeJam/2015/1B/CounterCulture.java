package codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CounterCulture {

	private static long reverse(long num)
	{
		long ret = 0;
		while(num>0)
		{
			ret *= 10;
			ret += num%10;
			num /= 10;
		}
		return ret;
	}

	private static int func(long N)
	{
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		map.put(N, 1);


		for(long i=N-1; i>0 ;i--)
		{
			int countPrevious = map.get(i+1) + 1;
			int countReverse = 0;
			long rev = reverse(i);

			if(rev<=N && map.containsKey(rev))
			{
				countReverse = map.get(rev) + 1;
				map.put(i, countPrevious < countReverse? countPrevious:countReverse);
			}
			else
			{
				map.put(i, countPrevious);
			}


		}

		return map.get(1l);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner stdin = null;
		File inFile = new File("a.txt");		
		stdin = new Scanner(inFile);

		int caseNum = 1;
		int totalCases = stdin.nextInt();
		//System.out.println(totalCases);
		while (stdin.hasNextLine()) {
			long N = stdin.nextLong();
			//System.out.println(N);
			//A = (long)Math.ceil(Math.sqrt(A));
			System.out.println("Case #"+caseNum+":  "+func(N)); 
			caseNum++;
		}
		stdin.close();
	}

}
