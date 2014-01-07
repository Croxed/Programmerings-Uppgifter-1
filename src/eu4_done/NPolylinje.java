package eu4_done;

import java.util.Iterator;
import java.util.Random;

import ovning5_done.Punkt;

public class NPolylinje implements Polylinje {

	private LinkedList<Punkt> linkedList = new LinkedList<Punkt>();
	private int antalPunkter = new Random().nextInt(5) + 1;
	private String farg;
	private int bredd = 1;

	public NPolylinje()
	{
		for(int i = 0; i < antalPunkter; i++)
		{
			this.linkedList.add(generateRandomPunkt());
		}
		this.farg = generateRandomFarg();
	}

	public static Punkt generateRandomPunkt()
	{
		// X koordinat för Punkten
		int x = new Random().nextInt(10) + 1;

		// Y koordinat för Punkten
		int y = new Random().nextInt(10) + 1;

		// Antal bokstäver i linjens namn
		int bokstaver = new Random().nextInt(5) + 1;

		StringBuilder sBuilder = new StringBuilder();
		for(int i2 = 0; i2 < bokstaver; i2++)
		{
			sBuilder.append((char) (new Random().nextInt(25) + 65)); 
		}
		return new Punkt(sBuilder.toString(), x, y);
	}

	@Override
	public Punkt[] getHorn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFarg() {
		// TODO Auto-generated method stub
		return this.farg;
	}

	@Override
	public int getBredd() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double langd() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFarg(String farg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBredd(int bredd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void laggTill(Punkt horn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void laggTillFramfor(Punkt horn, String hornNamn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void taBort(String hornNamn) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<Punkt> iterator() {
		// TODO Auto-generated method stub
		return linkedList.iterator();
	}

	@Override
	public String toString()
	{
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("{");
		while(this.linkedList.iterator().hasNext())
		{
			sBuilder.append("(");
			sBuilder.append(this.linkedList.iterator().next().stringRepresentation());
			sBuilder.append(")");
		}
		sBuilder.append(", " + this.farg + ", " + this.bredd);
		sBuilder.append("}");
		return sBuilder.toString();
	}

	public String generateRandomFarg()
	{
		int fargCode = new Random().nextInt(3);
		String farg = null;

		switch(fargCode)
		{
		case 0:
			farg = "röd";
			break;
		case 1:
			farg = "blå";
			break;
		case 2:
			farg = "gul";
			break;
		default:
			farg = null;
			break;
		}
		return farg;
	}
}
