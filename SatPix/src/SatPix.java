
	import java.io.*;
import java.util.Scanner;

	public class SatPix {

		public static void main(String[] args) throws IOException
		{
			boolean[][] booleanArr = fileToBoolArray("satpix.txt");
			int sizeOfLargestPasture=0;
			int currentPasture=0;
		    for (int i = 0; i<booleanArr.length-1; i++)
			{
				for (int j = 0; j<booleanArr[0].length-1; j++)
				{
					currentPasture = SatPix.recursivelyMeasureAndMarkPasture(i, j, booleanArr);
					if (currentPasture > sizeOfLargestPasture)
					{
						sizeOfLargestPasture = currentPasture;
					}
				}
			}
			System.out.println (sizeOfLargestPasture);
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("satpix.out")));
		out.println(sizeOfLargestPasture);
		out.close();
			
		//	for (int i = 0; i<booleanArr.length; i++)
		//	{
			//	for (int j =0; j<booleanArr[0].length; j++)
		//		{
		//			System.out.print (" " + booleanArr[i][j]);
		//		}
		//		System.out.println (" ");
		//	}
			}
		
	private static boolean[][] fileToBoolArray(String fileName) throws FileNotFoundException, IOException
	{
		//This helper method converts the input file into a 2D array of booleans
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (new File(fileName));
		int c = sc.nextInt();
		int r = sc.nextInt();
		String s = "";
		boolean [] [] boolArr =  new boolean [r][c];
		for (int i = 0; i<r; i++)
		{
			if (sc.hasNext() == true)
			 {
				s = sc.next();
			 }
			for (int j = 0; j<c; j++)
			{
				String sub = s.substring(j, j+1);
				if (sub.equals ( "*"))
				{
					boolArr [i][j] =  true;
				}
				else if (sub.equals ("."))
				{
					boolArr [i][j] = false;
				}
			}
		}
		return boolArr;
		
	}

		private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] arr)
		{
			if (row >= 0
					&& col >= 0
					&& row < arr.length
					&& col < arr[0].length
					&& arr[row][col] == true)
			{
				arr[row][col] = false;
			
				return 1 + recursivelyMeasureAndMarkPasture(row - 1, col, arr)
				+ recursivelyMeasureAndMarkPasture(row + 1, col, arr)
				+ recursivelyMeasureAndMarkPasture(row, col + 1, arr)
				+ recursivelyMeasureAndMarkPasture(row, col - 1, arr);
				
			}
			return 0;
			//This recursive method employs the flood-fill algorithm to
			//count the size of a single pasture and "mark" it so it is not double-counted
		
		}
		
	}

