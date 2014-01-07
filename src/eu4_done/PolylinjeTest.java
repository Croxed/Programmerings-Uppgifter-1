package eu4_done;

import java.util.Random;

import ovning5_done.Punkt;

public class PolylinjeTest {

	public static void main(String args[])
	{
		@SuppressWarnings("unused")
		PolylinjeTest test = new PolylinjeTest();
	}

	public PolylinjeTest()
	{
		// Uppgift #1 & #2 & #3 & #4
		VektorPolylinje(new VPolylinje()); 
		LinkedListPolylinje(new NPolylinje());

		// Uppgift #5 - Genererar nya mängder med Polylinjer för varje metod.
		try
		{
			System.out.println("\n Shortest Yellow of NPolylinjer: " + returnShortestYellow(generateNPolylinjer()).toString());
			System.out.println("\n Shortest Yellow of VPolylinjer: " + returnShortestYellow(generateVPolylinjer()).toString());
			System.out.println("\n Shortest Yellow of NPolylinjer & VPolylinjer: " + returnShortestYellow(generatePolylinjer()).toString());
		}catch(NoYellowPolylinjeException e)
		{
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Skriver ut vPolylinjens alla punkter
	 */
	public void VektorPolylinje(Polylinje vPolylinje)
	{
		System.out.println("Vektor Polylinje: ");

		for(Punkt p : vPolylinje.getHorn())
		{
			System.out.println(p.getName());
		}
	}

	/**
	 * Skriver ut nPolylinjens alla punkter
	 */
	public void LinkedListPolylinje(Polylinje nPolylinje)
	{
		System.out.println("\nLinkedList Polylinje: ");
		for(Punkt p : nPolylinje)
		{
			System.out.println(p.getName());
		}
	}

	/**
	 * Returnerar den kortaste av dem gula Polylinje:rna
	 * @return Polylinje
	 */
	public static Polylinje returnShortestYellow(Polylinje[] polylinje) throws NoYellowPolylinjeException
	{
		// Hitta dem gula.
		int antalGula = 0;
		for(Polylinje p : polylinje)
		{
			if(p.getFarg().equals("gul"))
			{
				antalGula++;
			}
		}

		Polylinje[] gulaPolylinjer = new Polylinje[antalGula];
		System.out.println("\n Antal Gula: " + antalGula);
		if(antalGula == 0)
		{
			throw new NoYellowPolylinjeException("Inga gula polylinjer existerar.");
		}

		int i = 0;
		for(Polylinje p : polylinje)
		{
			if(p.getFarg().equals("gul"))
			{
				gulaPolylinjer[i] = p;
				i++;
			}
		}
		// Hitta den kortaste bland dem gula.
		double langd = gulaPolylinjer[0].langd();
		Polylinje kortaste = gulaPolylinjer[0];

		for(Polylinje p : gulaPolylinjer)
		{
			if(p.langd() < langd)
			{
				langd = p.langd();
				kortaste = p;
			}
		}

		return kortaste;
	}

	/**
	 * Genererar en slumpmässig lista med NPolylinjer 
	 * @return En lista
	 */
	public NPolylinje[] generateNPolylinjer()
	{
		int antal = new Random().nextInt(10) + 1;
		NPolylinje[] vektor = new NPolylinje[antal];

		for(int i = 0; i < antal; i++)
		{
			vektor[i] = new NPolylinje();
		}

		return vektor;
	}

	/**
	 * Genererar en slumpmässig lista med VPolylinjer
	 * @return En lista med VPolylinjer
	 */
	public VPolylinje[] generateVPolylinjer()
	{
		int antal = new Random().nextInt(10) + 1;
		VPolylinje[] vektor = new VPolylinje[antal];

		for(int i = 0; i < antal; i++)
		{
			vektor[i] = new VPolylinje();
		}

		return vektor;
	}

	/**
	 * Genererar en slumpmässig lista med både VPolylinjer & NPolylinjer
	 * @return En lista med både VPolylinjer & NPolylinjer
	 */
	public Polylinje[] generatePolylinjer()
	{
		int antalVPolylinjer = new Random().nextInt(10) + 1;
		int antalNPolylinjer = new Random().nextInt(10) + 1;
		Polylinje[] vektor = new Polylinje[antalVPolylinjer + antalNPolylinjer];

		for(int i = 0; i < antalVPolylinjer; i++)
		{
			vektor[i] = new VPolylinje();
		}

		for(int i = antalVPolylinjer; i < antalVPolylinjer + antalNPolylinjer; i++)
		{
			vektor[i] = new NPolylinje();
		}

		return vektor;
	}
}