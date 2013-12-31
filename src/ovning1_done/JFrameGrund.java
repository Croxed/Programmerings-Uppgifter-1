package ovning1_done;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JFrameGrund extends JFrame
{
	
	public static void main(String[] args) 
	{
		//  Skapar fönstret
		initGUI();
		
	}
	
	public static void initGUI()
	{
		// Skapar en JFrame (fönstret)
		JFrame jFrame = new JFrame();
		// Sätter titeln på fönstret.
		jFrame.setTitle("Vädermätningar");
		// Sätter storleken på fönstret
	    jFrame.setSize(300, 200);
	    // Sätter fönstrets position på skärmen i mitten (null).
		jFrame.setLocationRelativeTo(null);
		// Sätter hur fönstret ska reagera när användare försöker
		// stänga fönstret.
		jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		// Sätter fönstret till synligt
		jFrame.setVisible(true);
	}
}
