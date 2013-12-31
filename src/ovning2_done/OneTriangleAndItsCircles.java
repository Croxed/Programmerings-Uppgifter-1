package ovning2_done;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class OneTriangleAndItsCircles extends JFrame{

	private final double side1, side2, side3;

	public static void main(String[] args)
	{
		new OneTriangleAndItsCircles();
	}

	public OneTriangleAndItsCircles()
	{
		// Skapar en JFrame (fönstret)
		JFrame jFrame = new JFrame();

		//Warning dialog
		JOptionPane.showMessageDialog(jFrame,
				"If your triangle contains a angle >120 degrees, go elsewhere. :)",
				"Warning",
				JOptionPane.WARNING_MESSAGE);

		String side1String = JOptionPane.showInputDialog(null, "Lenght of side #1: ");		

		// Måste göra om strängen till ett heltal
		side1 = Double.parseDouble(side1String);

		String side2String = JOptionPane.showInputDialog(null, "Length of side #2: ");		

		// Måste göra om strängen till ett heltal
		side2 = Double.parseDouble(side2String);

		String side3String = JOptionPane.showInputDialog(null, "Length of side #3: ");		

		// Måste göra om strängen till ett heltal
		side3 = Double.parseDouble(side3String);

		// Sätter titeln på fönstret.
		jFrame.setTitle("A Triangle and its circles");

		// Sätter storleken på fönstret
		jFrame.setSize(400, 400);

		// Sätter fönstrets position på skärmen i mitten (null).
		jFrame.setLocationRelativeTo(null);

		// Sätter hur fönstret ska reagera när användare försöker
		// stänga fönstret.
		jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE); 

		calculate();

		jFrame.setLayout(new BorderLayout());

		jFrame.add(new ACircle(side1, side2, side3));

		// Sätter fönstret till synligt
		jFrame.setVisible(true);
	}

	public void calculate()
	{
		// Checks if triangle is possible
		if(!Triangle.checkTrianglePossible(side1, side2, side3))
		{
			System.out.println("No planar triangle exists with sides " + side1
					+ ", " + side2 + ", " + side3 + ". Sorry. :(");
			System.exit(0);
		}

		System.out.println(Triangle.radiusCircumcircle(side1, side2, side3));
		// Calls & prints functions in class Triangle
		// which returns values
		System.out.print("\n Side 1: " + side1 + "\n Side 2: " + side2 + "\n Side 3: " + side3
				+ "\n\n Area: "
				+ Triangle.area(side1, side2, side3)
				+ "\n Incircle radius: "
				+ Triangle.radiusIncircle(side1, side2, side3)
				+ "\n Circumcircle radius: "
				+ Triangle.radiusCircumcircle(side1, side2, side3));

	}
}