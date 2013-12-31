package ovning5_done;

public class PolylinjerTest 
{
	public static void main(String[] args)
	{
		Punkt[] punktVektor = {new Punkt("A", 1, 1), new Punkt("C", 3, 3)};
		PolyLinje polyLinje = new PolyLinje(punktVektor, "svart");
		System.out.println(polyLinje.stracka());
		polyLinje.laggTillFramfor(new Punkt("B", 2, 2), "C");
		System.out.println(polyLinje.stringRepresentation());

		// Uppgift D - gå igenom en Polylinje
		// Gå fram med PolylinjeIterator
		while(polyLinje.finnsHorn())
		{
			System.out.println(polyLinje.horn().stringRepresentation());
			polyLinje.gaFram();
		}
	}
}