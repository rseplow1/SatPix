
	import java.io.*;
import java.util.Scanner;

	public class SatPix {

		public static void main(String[] args) throws IOException
		{
//			boolean[][] booleanArr = fileToBoolArray("satpix.in");
			int sizeOfLargestPasture;
			
			/* YOUR CODE GOES HERE */
			
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("satpix.out")));
			out.println(sizeOfLargestPasture);
			out.close();
			}
		
	private static boolean[][] fileToBoolArray(String fileName) throws FileNotFoundException, IOException
	{
		//This helper method converts the input file into a 2D array of booleans
		Scanner sc = new Scanner (System.in);
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
			return 0;
		}
		
	}

