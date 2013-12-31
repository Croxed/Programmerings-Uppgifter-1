package tester;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class SimpleExample extends JFrame {
	
    public SimpleExample() {
        
       setTitle("Simple example");
       setSize(300, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE); 
       
       String s = (String)JOptionPane.showInputDialog(
               this,
               "Ge mig ett binärt tal, tack! MAX 4 STYCKEN!",
               JOptionPane.PLAIN_MESSAGE
               );
       
       List<Integer> varden = new ArrayList<Integer>();

       
       for(int i = 0; i < 4; i++)
       {
    	  int binar = (int) s.charAt(i);
    	  System.out.println(s.charAt(i));
    	  switch(binar)
    	  {
    	  case 1:
    		  int tal = 2^i; 
    		  
    		  if(i == 1)
    			  tal = 1;
    		  
    		  varden.set(i, tal);
    	  }
    	  System.out.println(varden);
       }
    }    

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleExample ex = new SimpleExample();
                ex.setVisible(true);
                
            }
        });
    }
}