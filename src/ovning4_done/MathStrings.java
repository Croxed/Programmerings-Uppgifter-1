package ovning4_done;

import java.util.Scanner;


public class MathStrings
{
	public static void main(String[] args) 
	{
		MathStrings mathStrings = new MathStrings();
	}

	public MathStrings()
	{
		initGUI();
	}

	public void initGUI()
	{
		// Låt användare välja operation
		// Ta in två heltal 
		System.out.println(" - Choose operation -"
				+ "\n 1. Addition"
				+ "\n 2. Subtraction"
				+ "\n");
		Scanner scanner = new Scanner(System.in);
		String i2 = scanner.nextLine();

		int i = Integer.valueOf(i2);

		System.out.println("First number: ");
		String tal1 = scanner.nextLine();

		System.out.println("\n Second number: ");
		String tal2 = scanner.nextLine();

		switch(i)
		{
		case 1:
			System.out.println(" " + tal1 
					+ "\n + " + tal2
					+ "\n Result: " + performAddition(tal1, tal2));
			break;
		case 2:
			System.out.println(performSubtraction(tal1, tal2));
			break;
		default:
			break;
		}
	}

	public String performAddition(String tal1, String tal2)
	{
		StringBuilder sBuilder = new StringBuilder();
		int lenght = tal1.length();
		tal2 = matchLenght(lenght, tal2);
		int carry = 0;
		int i = 0;

		if(tal2.length() > lenght) 
		{
			lenght = tal2.length();
			tal1 = matchLenght(lenght, tal1);
		}

		// Reverse 
		tal1 = new StringBuilder(tal1).reverse().toString(); 
		tal2 = new StringBuilder(tal2).reverse().toString();

		while(i < lenght || carry == 1)
		{
			int temp;
			if(i < lenght)
			{
				temp = (tal1.charAt(i) - 48)
						+ (tal2.charAt(i) - 48)
						+ carry;
			}else
			{
				temp = carry;
			}

			System.out.println(temp);

			carry = 0;

			if(temp > 9)
			{
				carry = 1;
				sBuilder.append(temp % 10);
			}else
			{
				sBuilder.append(temp);
			}
			i++;
		}
		return new StringBuilder(sBuilder.toString()).reverse().toString();
	}

	public String matchLenght( int length, String tal)
	{
		StringBuilder sBuilder = new StringBuilder();
		while(sBuilder.length() < (length - tal.length()))
		{
			sBuilder.append(0);
		}
		sBuilder.append(tal);
		return sBuilder.toString();
	}

	public String performSubtraction(String tal1, String tal2)
	{
		StringBuilder sBuilder = new StringBuilder();
		int lenght = tal1.length();
		tal2 = matchLenght(lenght, tal2);
		int carry = 0;
		int i = 0;

		if(tal2.length() > lenght) 
		{
			lenght = tal2.length();
			tal1 = matchLenght(lenght, tal1);
		}

		// Reverse for the indexing.
		tal1 = new StringBuilder(tal1).reverse().toString(); 
		tal2 = new StringBuilder(tal2).reverse().toString();

		while(i < lenght || carry == 1)
		{
			int temp;
			if(i < lenght)
			{
				temp = (tal1.charAt(i) - 48)
						- (tal2.charAt(i) - 48)
						- carry;
			}else
			{
				temp = carry;
			}

			//System.out.println(temp);

			carry = 0;

			if(temp < 0)
			{
				carry = 1;
				sBuilder.append(10 + temp);
			}else
			{
				sBuilder.append(temp);
			}
			i++;
		}

		if(sBuilder.charAt(sBuilder.length() - 1) == 48)
		{
			sBuilder.deleteCharAt(sBuilder.length() - 1);
		}
		return new StringBuilder(sBuilder.toString()).reverse().toString();
	}
} // END OF CLASS