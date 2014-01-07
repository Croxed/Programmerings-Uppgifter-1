package ovning2_done;

import java.util.Arrays;


public class Triangle 
{
	// Returns the area
	public static double area(double side1, double side2, double side3)
	{
		// Using Heron's formula to calculate area.
		// s = a + b + c / 2
		// AREA = sqrt ( S (S-A) * (S-B) * (S-C) )
		double s = (side1 + side2 + side3) / 2;
		double area = Math.sqrt(s*(s - side1)*(s - side2)*(s - side3));
		return area;
	}

	public static double radiusIncircle(double side1, double side2, double side3)
	{
		// Using Heron's formulas to return radius
		// RADIUS OF INCIRCLE = 2 * AREA / (A + B + C)
		double radius = (2 * area(side1, side2, side3)) / (side1 + side2 + side3);
		return radius;

	}

	public static double radiusCircumcircle(double side1, double side2, double side3)
	{
		// DIAMETER OF CIRCUMCIRCLE = abc / 2 * area
		double radius = ((side1 * side2 * side3 / (2 * area(side1, side2, side3))) / 2);
		return radius;
	}

	// Checks if the triangle is possible
	public static boolean checkTrianglePossible(double side1, double side2, double side3)
	{
		double[] doubleArray = new double[]{side1, side2, side3};
		Arrays.sort(doubleArray);
		if(doubleArray[0] + doubleArray[1] > doubleArray[2]) 
		{
			return true;
		}
		return false;
	}
} // END OF CLASS
