package ovning2_done;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class ACircle extends JComponent{

	public double side1, side2, side3;

	public ACircle(double side1, double side2, double side3) 
	{
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public void paint(Graphics g2)
	{
		Graphics2D g = (Graphics2D) g2;

		int radCircum = 100 * (int) (Triangle.radiusCircumcircle(side1, side2, side3));

		int radInCircle = 100 * (int) (Triangle.radiusIncircle(side1, side2, side3));

		g.drawOval((this.getHeight() / 2) - (radCircum / 2),
				(this.getWidth() / 2) - (radCircum / 2),
				(radCircum),
				(radCircum));

		g.drawOval((this.getHeight() / 2) - (radInCircle / 2),
				(this.getWidth() / 2) - (radInCircle / 2),
				radInCircle,
				radInCircle);

		// Find a way to draw the triangle ...


		// Find a way to position the triangle ...
	}
}
