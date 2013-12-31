package eu1_done;

import java.util.Arrays;

public class losning 
{
	public static void main(String[] args)
	{
		int[] intA;
		System.out.println(min(intA = new int[]{9, 4, 3, 5, 6, 7, 10, 1, 30, 8, 2}));
	}


	public static int min (int[] element)
			throws IllegalArgumentException
			{
		if (element.length == 0) {
			throw new IllegalArgumentException ("tom samling");
		}

		int[] sekvens = element;
		int antaletPar = sekvens.length / 2;
		int antaletOparadeElement = sekvens.length % 2; 
		int antaletTankbaraElement = antaletPar + antaletOparadeElement;

		int[] delsekvens = new int[antaletTankbaraElement];
		int i= 0;
		int j = 0;

		while(sekvens.length > 1)
		{
			// skilj ur en delsekvens med de tänkbara elementen i = 0;
			i = 0;
			j = 0;

			// Skriver ut sekvensen
			System.out.println(Arrays.toString(sekvens));

			// Jämför de två talen parvis och behåller det minsta för en ny sekvens
			while (j < antaletPar)
			{
				delsekvens[j++] = (sekvens[i] < sekvens[i + 1]) ? sekvens[i] : sekvens[i + 1];
				i += 2;
			}

			// Går igenom det oparade elementet, om det finns.
			if(antaletOparadeElement == 1)
			{
				delsekvens[j] = sekvens[sekvens.length - 1];
			}

			sekvens = delsekvens;
			antaletPar = sekvens.length / 2;
			antaletOparadeElement = sekvens.length % 2;
			antaletTankbaraElement = antaletPar + antaletOparadeElement;

			// Måste fixa en ny delsekvens/mängd annars jobbar den med samma mängd
			delsekvens = new int[antaletTankbaraElement];
		}

		return sekvens[0];
			}
}
