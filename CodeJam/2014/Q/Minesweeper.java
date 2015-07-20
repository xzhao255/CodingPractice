package codejam;

public class Minesweeper {

	static void print(char[][] input)
	{
		for(int i=0; i<input.length; i++)
		{
			for(int j=0; j<input[0].length; j++)
				System.out.print(input[i][j]);
			System.out.println();
		}
		System.out.println();
	}
	
	static void generate(char[][] input, int row, int col, int mines, int size)
	{
		if(mines == 0)
		{
			print(input);
			return;
		}
		for(int i=row; i<size; i++)
		{
			for(int j=col; j<size; j++)
			{
				input[i][j] = '*';
				if(j+1 == size) generate(input, i+1, col, mines-1, size);
				else generate(input, row, j+1, mines-1, size);
				input[i][j] = '.';
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int size = 2;
		char[][] input = new char[size][size];
		
		for(int i=0; i<size; i++)
			for(int j=0; j<size; j++)
				input[i][j] = '.';
		
		generate(input, 0, 0, 3, size);
	}

}
