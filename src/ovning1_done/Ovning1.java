package ovning1_done;

import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public class Ovning1 extends JFrame
{
	private static final long serialVersionUID = 1L;

	/**This 'program' calculates on some weather data.
	 * @author Alexander Lingtorp, TIDAB1, 2013-11-05
	 */

	public static List<JTextField> fields = new ArrayList<JTextField>();

	// Collects the period sum of temps.
	public static int[] collectListPeriod;

	// Number of weeks
	public static int antalVeckor;

	// 2D Array to store values in
	public static int[][] valueArray;

	// Numberformat for printing values
	public static DecimalFormat numberFormat = new DecimalFormat("#.00");

	public static void main(String[] args) 
	{
		// Fråga hur många veckor som mätningen skett på
		// Förutsätter att vi får ett heltal av användaren
		String antalVeckorString = JOptionPane.showInputDialog(null, "Number of weeks of measurements: ");	

		// Dynamic number of measurement per week
		//String antalVeckorString2 = JOptionPane.showInputDialog(null, "Number of measurements.: ");	

		// Måste göra om strängen till ett heltal
		antalVeckor = Integer.parseInt(antalVeckorString);

		// Init the 2D array
		valueArray = new int[antalVeckor][7];

		collectListPeriod = new int[antalVeckor * 7];

		//  Skapar fönstret & alla widgets
		initGUI(antalVeckor);
	}

	public static void initGUI(int antalVeckor)
	{	
		// Skapar en JFrame (fönstret)
		JFrame jFrame = new JFrame();

		// Sätter layouen för fönstret
		jFrame.setLayout(new GridLayout(0, 1));

		// Gör första raden
		JPanel jPanelForstaRad = new JPanel();

		// Sätter layouten för första raden
		jPanelForstaRad.setLayout(new GridLayout(1, 14));

		// Fyller första raden med widgets
		for(int i = 1; i <= 14; i++)
		{
			// Skapar en ny textbox
			JLabel jLabel = new JLabel();

			// Ger textboxarna var sin text
			// Beroende på vilket index (i)
			switch(i)
			{
			case 2:
				jLabel.setText(" Day 1");
				break;
			case 3:
				jLabel.setText(" Day 2");
				break;
			case 4:
				jLabel.setText(" Day 3");
				break;
			case 5:
				jLabel.setText(" Day 4");
				break;
			case 6:
				jLabel.setText(" Day 5");
				break;
			case 7:
				jLabel.setText(" Day 6");
				break;
			case 8:
				jLabel.setText(" Day 7");
				break;
			default:
				jLabel.setText("");
				break;
			}
			jPanelForstaRad.add(jLabel);
		}
		jFrame.add(jPanelForstaRad);

		// Lägger till antalet veckorader till panelen
		for(int i = 1; i <= antalVeckor; i++)
		{

			// Skapar en panel i fönstret
			JPanel jPanel = new JPanel();
			jPanel.setLayout(new GridLayout(1, 14));

			// Skapar Vecka#X textboxen
			JLabel vecka = new JLabel("   Week # " + i);
			jPanel.add(vecka);

			// Skapar en inputbox för var dag
			JTextField textField1 = new JTextField();
			textField1.getDocument().addDocumentListener(new MyDocumentListener(i, 1));
			jPanel.add(textField1);

			JTextField textField2 = new JTextField();
			textField2.getDocument().addDocumentListener(new MyDocumentListener(i, 2));
			jPanel.add(textField2);

			JTextField textField3 = new JTextField();
			textField3.getDocument().addDocumentListener(new MyDocumentListener(i, 3));
			jPanel.add(textField3);

			JTextField textField4 = new JTextField();
			textField4.getDocument().addDocumentListener(new MyDocumentListener(i, 4));
			jPanel.add(textField4);

			JTextField textField5 = new JTextField();
			textField5.getDocument().addDocumentListener(new MyDocumentListener(i, 5));
			jPanel.add(textField5);

			JTextField textField6 = new JTextField();
			textField6.getDocument().addDocumentListener(new MyDocumentListener(i, 6));
			jPanel.add(textField6);

			JTextField textField7 = new JTextField();
			textField7.getDocument().addDocumentListener(new MyDocumentListener(i, 7));
			jPanel.add(textField7);

			// Skapar en textbox med texten "Medeltemp. : "
			JLabel jLabel1 = new JLabel("Average temp. : ");
			jPanel.add(jLabel1);

			// Skapar en inputbox
			// Ska hålla värde och kan inte ändras av användaren.
			JTextField textField8 = new JTextField();
			textField8.setEditable(false);
			fields.add(textField8);
			jPanel.add(textField8);

			// Skapar en textbox med texten "Högsta temp. : "
			JLabel jLabel2 = new JLabel("Highest temp. : ");
			jPanel.add(jLabel2);

			// Skapar en inputbox
			// Ska hålla värde och inte ändras av användaren
			JTextField textField9 = new JTextField();
			textField9.setEditable(false);
			fields.add(textField9);
			jPanel.add(textField9);

			// Skapar en textbox med texten "Lägsta temp. : "
			JLabel jLabel3 = new JLabel("Lowest temp. : ");
			jPanel.add(jLabel3);

			// Creates an inputbox
			// Shall contain info, not touch by user
			JTextField textField10 = new JTextField();
			textField10.setEditable(false);
			fields.add(textField10);
			jPanel.add(textField10);

			// Adds the panel to the frame/window
			jFrame.add(jPanel);
		}

		// Create a new jpanel
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new GridLayout(1, 6)); 

		//Add the last row to the panel
		JLabel jLabel = new JLabel();
		jLabel.setText("                                  Average temp.: ");
		jPanel2.add(jLabel);

		JTextField textField1 = new JTextField();
		textField1.setEditable(false);
		fields.add(textField1);
		jPanel2.add(textField1);

		JLabel jLabel2 = new JLabel();
		jLabel2.setText("                                 Highest temp.: ");
		jPanel2.add(jLabel2);

		JTextField textField2 = new JTextField();
		textField2.setEditable(false);
		fields.add(textField2);
		jPanel2.add(textField2);

		JLabel jLabel3 = new JLabel();
		jLabel3.setText("                                  Lowest temp.: ");
		jPanel2.add(jLabel3);

		JTextField textField3 = new JTextField();
		textField3.setEditable(false);
		fields.add(textField3);
		jPanel2.add(textField3);

		// Add the panel to the fram/window
		jFrame.add(jPanel2);

		// Sets the title of the window
		jFrame.setTitle("Weather Measurements");

		// Defines the size of the window
		jFrame.setSize(1400, 350);

		// Sets the position of the windows relativ to
		// nothing, a.k.a center
		jFrame.setLocationRelativeTo(null);

		// Sets the exit behaviour of the window
		jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE); 

		// Sets the window to visible
		jFrame.setVisible(true);
	}

	private static class MyDocumentListener implements DocumentListener {
		private final int row;
		private final int id;

		public MyDocumentListener(int row, int id) {
			this.id = id;
			this.row = row;
		}

		@Override
		public void changedUpdate(DocumentEvent arg0) {}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			try {
				int temperature = Integer.parseInt(arg0.getDocument().getText(0, arg0.getDocument().getLength()));
				calculateValues(row, id, temperature);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}

		}
		@Override
		public void removeUpdate(DocumentEvent arg0) {}
	} // END OF INNER CLASS

	public static void calculateValues(int row, int id, int temperature)
	{
		// Set values received in the 2D array
		valueArray[row - 1][id - 1] = temperature;

		// Grab all values & calculate the average temp
		for(int i = 0; i < antalVeckor; i++)
		{
			// Variable to hold this weeks temp. sum
			int collectTemp = 0;

			// Init an array to collect the 
			// values from one row in valueArray
			int[] collectArrayWeek = new int[7];

			for(int i2 = 0; i2 < collectArrayWeek.length; i2++)
			{
				// Collect weeks sum temp. in one variable
				collectTemp += valueArray[i][i2];

				// Copy one row over from valueArray
				collectArrayWeek[i2] += valueArray[i][i2];

				// Collects all week data into a period array
				collectListPeriod[i * 7 + i2] = 0;
				collectListPeriod[i * 7 + i2] += collectArrayWeek[i2];
				System.out.println(collectListPeriod[i * 7 + i2]);
			}

			// Divide the sum of the temps.
			double averageTemp = (double) collectTemp/7;

			// Set the 0, 3, 6th widgets text in the fields list
			// Format the numbers so that we dont get a lot of decimals
			fields.get(i * 3).setText(numberFormat.format(averageTemp) + " C");

			// Sort the collectArray into ascending order
			Arrays.sort(collectArrayWeek);

			// Set the 1, 4, 7th widgets text - week
			fields.get((i * 3) + 2).setText(numberFormat.format(collectArrayWeek[0]) + " C");

			// Set the 2, 5, 8th widgets text - week
			fields.get((i * 3) + 1).setText(numberFormat.format(collectArrayWeek[6]) + " C");	

			// Print things out for debugging, could use Log.X also ...
			System.out.println("\nHighest temp. : " + collectArrayWeek[6]
					+ "\nLowest temp. :" + collectArrayWeek[0]);
			System.out.println(temperature + " C");
			System.out.println("Row: " + row + " Id: " + id);
			System.out.println("Average : " + averageTemp);	
			System.out.println("CollectListPeriod lenght: " + collectListPeriod.length);
		}

		// Sort the period array (denna metod fungerar för Bengt)
		Arrays.sort(collectListPeriod);

		// Hold the sum of temps over the period
		double sumPeriod = 0;

		// Collect sum for the period in sumPeriod
		for(int i6 = 0; i6 < antalVeckor * 7; i6++)
		{
			sumPeriod += collectListPeriod[i6];
		}

		// Divide the period sum by number of days
		double averagePeriod = sumPeriod/(antalVeckor * 7);

		// Set the third last widgets text (average temp)
		fields.get(antalVeckor * 3).setText(numberFormat.format(averagePeriod) + " C");

		// Set the second last widgets text (highest temp)
		fields.get((antalVeckor * 3) + 1).setText(numberFormat.format(collectListPeriod[collectListPeriod.length - 1]) + " C");

		// Set the last widgets text (lowest temp)
		fields.get((antalVeckor * 3) + 2).setText(numberFormat.format(collectListPeriod[0]) + " C");
	}
} // END OF CLASS

/* Uppgift #2 & 3: 
 *  Den 2D vektorn (array:en) där temperaturerna lagras heter valueArray
 *  För att erhålla värden för varje vecka går man igenom en rad och 
 *  tilldelar dessa värden till en temporär array vid namn collectWeekArray
 *  
 *  Sedan utförs en sortering där minsta talet får position 0 och
 *  det största talet i array:en hamnar på sista plats d.v.s 6.
 *  
 *  För medelvärdet summarerar man värdet av alla tal i array:en
 *  varvid man delar denna summa på antalet dagar. Detta funkar för
 *  både hela perioden samt varje vecka.
 *  På denna array utförs sedan beräkningar varvid resultatet sätts till
 *  sina respektive widgets som finns i en lista vid namn fields.
 *  
 *  Samma metod används för att erhålla periodens värden.
 */