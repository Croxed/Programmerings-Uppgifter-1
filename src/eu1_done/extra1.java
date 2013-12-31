package eu1_done;

import java.util.Arrays;
import java.util.Random;

/* Hittar det minsta elementet i en mängd med
 * hjälp av utbytessortering.
 * 
 * @author Alexander Lingtorp
 */

public class extra1 
{
	public static int lowest;
	public static int[] inputInts;

	public static void main(String[] args)
	{
		generateRandoms();
		calculate();
	}

	public static void calculate() throws IllegalArgumentException
	{
		if(inputInts.length == 0) 
		{
			throw new IllegalArgumentException("Otillräckligt med argument!");
		}

		// Init lowest value
		lowest = inputInts[0];

		// Walk through the array and find the lowest value
		for(int i2 = 0; i2 < inputInts.length; i2++)
		{
			if(inputInts[i2] < lowest)
			{
				lowest = inputInts[i2];
				System.out.println("Lowest: " + lowest + Arrays.toString(inputInts));

			}
		}
		// Print all data out
		System.out.println(Arrays.toString(inputInts));
		System.out.println(lowest);
	}

	public static void generateRandoms()
	{
		// Generate a array with random values
		inputInts = new int[10];
		for(int i = 0; i < inputInts.length; i++)
		{
			inputInts[i] = new Random().nextInt(100);
		}
	}
}
