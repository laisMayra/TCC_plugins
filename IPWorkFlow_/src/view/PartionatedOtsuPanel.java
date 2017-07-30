package view;

import javax.swing.JButton;

import view.ImageProcessingPanel;

public class PartionatedOtsuPanel extends ImageProcessingPanel {

	protected JButton btnBinarization;
	
	@Override
	public void setupPanel() {
		super.setupPanel();
		this.lblPanelTitle.setText("Step 4 - Binarization");
		this.txtPanelDescription.setText("");
		this.btnBinarization = new JButton("Binarization");
		this.btnBinarization.setBounds(157, 371, 117, 25);
		this.add(this.btnBinarization);
	}
	
	public JButton getBtnBinarization() {
		return this.btnBinarization; 
	}
}