import javax.swing.SwingUtilities;

import controller.MainController;
import ij.*;
import ij.plugin.*;
import view.MainGui;
 
//public class IPWorkFlow_ implements PlugIn {
//	public void run(String arg) {
//		IJ.showMessage("Olá Mundo!");
//	}
//}

public class IPWorkFlow_ implements PlugIn {
	public void createAndShowGui() {		
		MainGui mainGui = new MainGui();
		new MainController(mainGui);
		mainGui.setVisible(true);
	}
	
	public void run(String arg) {		
		 SwingUtilities.invokeLater(new Runnable(){ 
	          public void run(){
	              createAndShowGui();
	          }
	      });
	}
}