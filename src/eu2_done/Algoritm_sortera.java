package eu2_done;

import java.util.Arrays;
import java.util.Random;

public class Algoritm_sortera 
{
	/*
	 * 1. Åskådliggör algoritmen.
	 * 2. Bestäm algoritmens tidskomplexitet när det gäller antalet jämförelser.
	 * 3. Jämför tidskomplexiteten mellan urvalssorteringen och utbytessorteringen. Både antalet jämförelser och antalet tilldelningar ska betraktas.
	 * 4. Bevisa algoritmen.
	 */

	public static void main(String[] args) 
	{
		sort(generateRandoms());
	}

	public static int[] generateRandoms()
	{
		// Generate a random set of values
		int[] randomSet = new int[new Random().nextInt(10) + 5];

		// Fill the set with values
		for(int i = 0; i < randomSet.length; i++)
		{
			randomSet[i] = new Random().nextInt(10);
		}

		System.out.println("Innan sortering: " + Arrays.toString(randomSet));

		return randomSet;
	}

	public static void sort(int[] randomSet)
	{
		int i = 0;
		int m = 0;
		while(i < randomSet.length)
		{
			int j = i + 1;
			m = randomSet[i];

			while(j < randomSet.length)
			{
				if(randomSet[j] < randomSet[i])
				{
					m = randomSet[i];
					randomSet[i] = randomSet[j];
					randomSet[j] = m;
				}
				j++;
			}
			System.out.println("Efter " + (i + 1) + " iterationer " + Arrays.toString(randomSet));
			i++;
		}
		System.out.println("Efter sortering: " + Arrays.toString(randomSet));
	}
}