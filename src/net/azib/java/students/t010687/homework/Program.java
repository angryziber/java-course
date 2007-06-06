package net.azib.java.students.t010687.homework;
import javax.swing.*;

//http://www.roseindia.net/java/example/java/swing/
//http://java.sun.com/docs/books/tutorial/uiswing/components/dialog.html

/**
 * Program
 *
 * @author Matu
 */
public class Program {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new PreDialogForDecathlonDataFrm(new JFrame());
            }
        });
	}
}
