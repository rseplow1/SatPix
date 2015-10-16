
	import java.io.*;
import java.util.Scanner;

	public class SatPix {

		public static void main(String[] args) throws IOException
		{
		boolean[][] booleanArr = fileToBoolArray("satpix.txt");
			int sizeOfLargestPasture=0;
			int currentPasture=0;
			for (int i = 0; i<booleanArr.length; i++)
			{
				for (int j = 0; j<booleanArr[0].length; j++)
				{
					currentPasture = SatPix.recursivelyMeasureAndMarkPasture(booleanArr.length, booleanArr[0].length, booleanArr);
					if (currentPasture > sizeOfLargestPasture)
					{
						sizeOfLargestPasture = currentPasture;
					}
				}
			}
			System.out.println (sizeOfLargestPasture);
			//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("satpix.out")));
		//	out.println(sizeOfLargestPasture);
			//out.close();
			}
		
	private static boolean[][] fileToBoolArray(String fileName) throws FileNotFoundException, IOException
	{
		//This helper method converts the input file into a 2D array of booleans
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (new File(fileName));
		int c = sc.nextInt();
		int r = sc.nextInt();
		boolean [] [] boolArr =  new boolean [c][r];
		for (int i = 0; i<c; i++)
		{
			for (int j = 0; j<r; j++)
			{
				if (sc.next() == "*")
				{
					boolArr [c][r] =  true;
				}
				else if (sc.next() == ".")
				{
					boolArr [c][r] = false;
				}
			}
		}
		return boolArr;
	}

		private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] arr)
		{
			//This recursive method employs the flood-fill algorithm to
			//count the size of a single pasture and "mark" it so it is not double-counted
			if (arr[row][col] != true)
			{
				return 0;
			}
			arr[row][col] = false;
			if (row == arr.length || col == arr[0].length)
			{
				return 1;
			}
			if (arr[row+1][col] == true)
			{
				recursivelyMeasureAndMarkPasture(row+1, col, arr);
			}
			if (arr[row-1][col]== true)
			{
				recursivelyMeasureAndMarkPasture(row-1, col, arr);
			}
			if (arr[row][col+1]==true)
			{
				recursivelyMeasureAndMarkPasture(row, col+1, arr);
			}
			if (arr[row][col-1] == true)
			{
				recursivelyMeasureAndMarkPasture(row, col-1, arr);
			}
			return 1;
		}
		
	}

