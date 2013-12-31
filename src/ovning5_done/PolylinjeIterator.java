package ovning5_done;

public class PolylinjeIterator
{
	private int aktuell = -1;
	private PolyLinje polyLinje;

	public PolylinjeIterator(PolyLinje polyLinje)
	{
		if(polyLinje.getHorn().length > 0) 
		{
			aktuell = 0;
			this.polyLinje = new PolyLinje(polyLinje.getHorn(), polyLinje.getFarg());
		}
	}

	public boolean finnsHorn()
	{
		return aktuell != -1;
	}

	public Punkt horn() throws java.util.NoSuchElementException
	{
		if(!this.finnsHorn()) {
			throw new java.util.NoSuchElementException("Slut av iterationen.");
		}

		Punkt horn = polyLinje.getHorn()[aktuell];

		return horn;
	}

	public void gaFram()
	{
		if(aktuell >= 0 && aktuell < polyLinje.getHorn().length - 1)
		{
			aktuell++;
		}else
		{
			aktuell = -1;
		}
	}
}
