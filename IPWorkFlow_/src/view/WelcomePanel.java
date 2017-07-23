package view;


import javax.swing.JLabel;


import view.ImageProcessingPanel;

public class WelcomePanel extends ImageProcessingPanel {

	@Override
	public void setupPanel() {
		super.setupPanel();
		this.lblPanelTitle.setText("Partitioned Otsu");
		this.txtPanelDescription.setText("Welcome to the jungle..");
	}
}