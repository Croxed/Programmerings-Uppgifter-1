package ovning5_done;

/* @author AlexanderLingtorp
 * 
 * Ovning5 - beskriver en linje
 * 
 * 
 */

public class PolyLinje 
{
	private Punkt[] horn;
	private String farg = "svart";
	private int bredd = 1;
	private PolylinjeIterator Iterator;

	public PolyLinje(Punkt[] horn, String farg)
	{
		this.horn = horn;
		//Punkt[] punktVektor = new Punkt[horn.length];
		// for för att fylla punktVektor
		//this.horn = punktVektor;
		this.farg = farg;
		this.Iterator = new PolylinjeIterator();
	}

	public void setFarg(String farg)
	{
		this.farg = farg;
	}

	public void setBredd(int bredd)
	{
		this.bredd = bredd;
	}

	public String getFarg()
	{
		return this.farg;
	}

	public int getBredd()
	{
		return this.bredd;
	}

	public Punkt[] getHorn()
	{
		return horn;
	}

	// Räknar ut sträckan emellan alla
	// Punkter & sedan summerar dessa.
	public double stracka()
	{
		double distans = 0;
		for(int i = 0; i < this.horn.length - 1; i++)
		{
			int x = this.horn[i].getX();
			int y = this.horn[i].getY();
			int x2 = this.horn[++i].getX();
			int y2 = this.horn[i].getY();
			int x3 = Math.abs(x - x2);
			int y3 = Math.abs(y - y2);
			distans += Math.sqrt(x3 * x3 + y3 * y3);
			System.out.println("Distans: " + distans
					+ " X: " + x
					+ " Y: " + y
					+ " X2: " + x2
					+ " Y2: " + y2
					+ " Math.abs(y - y2): " + (Math.abs(y - y2))
					+ " Math.abs(x - x2): " + (Math.abs(x - x2)));		
		}
		return distans;
	}

	// Lägger till en Punkt i en ny vektor som är 
	// 1 längre än den gamla.
	public void laggTillHorn(Punkt horn)
	{
		Punkt[] h = new Punkt[this.horn.length + 1];
		int i = 0;
		for(i = 0; i < this.horn.length; i++)
		{
			h[i] = this.horn[i];
		}
		h[i + 1] = horn;
	}

	// Lägger till en Punkt innan en specifik Punkt
	public void laggTillFramfor(Punkt horn, String hornNamn)
	{
		Punkt[] h = new Punkt[this.horn.length + 1];

		for(int i = 0, i2 = 0; i < this.horn.length; i++, i2++)
		{
			if(i == findPunkt(hornNamn))
			{
				h[i] = horn;
				i++;
			}

			h[i] = this.horn[i2];
		}
		this.horn = h;
	}

	// Går igenom mängden och returnar index på hörnet
	public int findPunkt(String hornNamn)
	{
		int i = 0;
		for(i = 0; i < this.horn.length; i++)
		{
			if(this.horn[i].getName() == hornNamn)
			{
				break;
			}
		}
		return i;
	}

	public void taBort(String hornNamn)
	{
		Punkt[] h = new Punkt[this.horn.length - 1];
		int i = 0;
		int i2 = 0;
		for(i = 0; i < this.horn.length; i++)
		{
			if(this.horn[i].getName() == hornNamn)
			{
				continue;
			}else
			{
				h[i2] = this.horn[i];
				i2++;
			}
		}
	}

	public String stringRepresentation()
	{
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("{");
		for(int i = 0; i < this.horn.length; i++)
		{
			sBuilder.append("(");
			sBuilder.append(this.horn[i].stringRepresentation());
			sBuilder.append(")");
		}
		sBuilder.append(", " + this.farg + ", " + this.bredd);
		sBuilder.append("}");
		return sBuilder.toString();
	}

	public boolean finnsHorn()
	{
		return Iterator.finnsHorn();
	}

	public void gaFram()
	{
		Iterator.gaFram();
	}

	public Punkt horn()
	{
		return Iterator.horn();
	}

	public class PolylinjeIterator
	{
		private int aktuell = -1;

		public PolylinjeIterator()
		{
			if(horn.length > 0) 
			{
				aktuell = 0;
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

			return horn[aktuell];
		}

		public void gaFram()
		{
			if(aktuell >= 0 && aktuell < horn.length - 1)
			{
				aktuell++;
			}else
			{
				aktuell = -1;
			}
		}
	}
}