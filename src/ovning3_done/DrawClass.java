package ovning3_done;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawClass extends JPanel
{
	public int stationOneIndex, stationTwoIndex, shortest;

	public DrawClass(JFrame jFrame, int stationOneIndex, int stationTwoIndex, int shortest)
	{
		this.repaint();
		this.stationOneIndex = stationOneIndex + 1;
		this.stationTwoIndex = stationTwoIndex + 1;
		this.shortest = shortest;
		jFrame.add(this);
	}

	@Override
	public void paint(Graphics g2) {
		super.paint(g2);

		Graphics2D g = (Graphics2D) g2;

		// Draws info sheet
		g.drawString("Distance X to Zone #2: ai (1 ≤ i ≤ m).",
				20, 
				500);

		g.drawString("Distance Zone #2 to Zone #3: bij (1 ≤ i ≤ m, 1 ≤ j ≤ n)",
				20, 
				520);

		g.drawString("Distance Zone #3 to Y: cj (1 ≤ j ≤ n) ",
				20, 
				540);

		g.drawString("Where j and i is the index of the station &",
				20, 
				570);

		g.drawString(" n, m is the number of stations in zone #2 & #3.",
				18, 
				590);

		// Draw X
		g.drawOval(20, 150, 30, 30);
		g.drawString("X", 32, 170);
		g.drawString("Start", 22, 120);

		// Draw Y
		g.drawOval(350, 150, 30, 30);
		g.drawString("Y", 362, 170);
		g.drawString("Dest.", 350, 120);

		// Draw Zone #2 (175px is the middle, 45px offset)
		g.drawString("Zone #2", 120, 25);
		for(int i = 1; i <= TheShortestPath.m; i++)
		{
			g.drawOval(120, 44 * i, 30, 30);
			g.drawString(String.valueOf(i), 132, 44 * i + 20);
		}

		// Draw Zone #3 (175px is the middle, 45px offset)
		g.drawString("Zone #3", 225, 25);
		for(int i = 1; i <= TheShortestPath.n; i++)
		{
			g.drawOval(225, 44 * i, 30, 30);
			g.drawString(String.valueOf(i), 237, 44 * i + 20);
		}

		// Draw lines from X to Zone #2
		for(int i = 1; i <= TheShortestPath.m; i++)
		{
			g.draw(new Line2D.Double(50, 165, 120, 44 * i + 10));
		}

		// Draw lines from Zone #2 to Zone #3
		for(int i = 0; i < TheShortestPath.m; i++)
		{
			for(int i2 = 1; i2 <= TheShortestPath.n; i2++)
			{
				g.draw(new Line2D.Double(150, 60 + 44 * i, 225, 44 * i2 + 10));
			}
		}

		// Draw lines from Zone #3 to Y
		for(int i = 1; i <= TheShortestPath.n; i++)
		{
			g.draw(new Line2D.Double(255, 44 * i + 10, 350, 165));
		}

		// Draws the shortest way 
		g.setColor(Color.GREEN);

		// From X to Zone #1
		g.draw(new Line2D.Double(50, 165, 120, 44 * stationOneIndex + 10));	

		// From Zone #1 to #2
		g.draw(new Line2D.Double(150, 44 * stationOneIndex + 10, 225, 44 * stationTwoIndex + 10));

		// From Zone #3 to Y
		g.draw(new Line2D.Double(255, 44 * stationTwoIndex + 10, 350, 165));

		// Set the font
		g.setFont(new Font("Verdana", Font.BOLD, 12));

		// Draw some information
		g.drawString("Shortest path is: " + shortest + " units through stations #" + stationOneIndex + " and #" + stationTwoIndex,
				18, 
				610);
	}
}