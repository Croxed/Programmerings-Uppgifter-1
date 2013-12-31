package ovning3_done;

import java.util.Random;

import javax.swing.JFrame;

public class TheShortestPath extends JFrame {

	/**
	 * @author Alexander Lingtorp, TIDAB, 2013
	 */
	public static int[] XtoZoneOne, ZoneThreetoY;
	public static int[][] ZoneTwotoZoneThree;
	public static int stationOneIndex, stationTwoIndex, shortest, m, n;

	public static void main(String[] args) 
	{
		TheShortestPath theShortestPath = new TheShortestPath();
	}

	public TheShortestPath()
	{
		generateRandoms();
		calculate();
		initGUI();
	}

	public void initGUI()
	{
		JFrame jFrame = new JFrame();

		DrawClass drawClass = new DrawClass(jFrame, stationOneIndex, stationTwoIndex, shortest);

		jFrame.setLocationRelativeTo(null);

		jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		jFrame.setSize(400, 650);

		jFrame.setResizable(false);

		jFrame.setTitle("The Shortest Path - From X to Y");

		jFrame.setVisible(true);
	}

	public void calculate()
	{		
		// Adds the distance from X to Zone #2
		// to the distance from Zone #2 -> Zone #3
		for(int i = 0; i < m; i++)
		{
			for(int i2 = 0; i2 < n; i2++)
			{
				ZoneTwotoZoneThree[i][i2] += XtoZoneOne[i];
			}
		}

		// Adds the distance from zone #3 to Y
		// to the distance from Zone #2 to Zone #3
		for(int i = 0; i < m; i++)
		{
			for(int i2 = 0; i2 < n; i2++)
			{
				ZoneTwotoZoneThree[i][i2] += ZoneThreetoY[i2];
			}
		}

		shortest = ZoneTwotoZoneThree[0][0];
		stationOneIndex = 0;
		stationTwoIndex = 0;

		// Checks for the shortest path from Zone 1 to Zone 2
		for(int i = 0; i < m; i++)
		{
			for(int i2 = 0; i2 < n; i2++)
			{
				if(ZoneTwotoZoneThree[i][i2] <= shortest)
				{
					shortest = ZoneTwotoZoneThree[i][i2];
					stationOneIndex = i;
					stationTwoIndex = i2;
				}
			}
		}
		System.out.println("Shortest path is: " + shortest + " through stations " + (stationOneIndex + 1) + " and " + (stationTwoIndex + 1));
	}

	public void generateRandoms()
	{
		// Number of stations Zone #2
		n = new Random().nextInt(10) + 1;
		// Number of stations Zone #3
		m = new Random().nextInt(10) + 1; 

		XtoZoneOne = new int[m];  // Ui (1 < i < m)
		ZoneTwotoZoneThree = new int[m][n]; //Bij 
		ZoneThreetoY = new int[n];

		for(int i = 0; i < m; i++)
		{
			XtoZoneOne[i] = new Random().nextInt(10) + 1;

			// Print length of the paths
			System.out.println("Path: X to Zone #1: " + XtoZoneOne[i]);

			for(int i2 = 0; i2 < n; i2++)
			{
				ZoneTwotoZoneThree[i][i2] = new Random().nextInt(10) + 1;

				// Print length of the paths
				System.out.println("\n Path: Zone #2 to Zone #3: " + ZoneTwotoZoneThree[i][i2]);
			}
		}

		for(int i = 0; i < n; i++)
		{
			ZoneThreetoY[i] = new Random().nextInt(10) + 1;
			System.out.println("\n Path from Zone #3 to Y: " + ZoneThreetoY[i]);

		}
		System.out.println("\n Number of stations: Zone #1: " + m + " Zone #2: " + n);
	}
}