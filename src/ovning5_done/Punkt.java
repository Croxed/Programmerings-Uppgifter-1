package ovning5_done;

public class Punkt 
{
	private String name;
	private int x;
	private int y;

	public Punkt(String name, int x, int y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public String getName()
	{
		return name;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public String stringRepresentation()
	{
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(this.name + " ");
		sBuilder.append(this.x + " ");
		sBuilder.append(this.y);
		return sBuilder.toString();
	}
}