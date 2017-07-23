package view;

import javax.swing.JButton;

import view.ImageProcessingPanel;

public class BinarizationPanel extends ImageProcessingPanel {

	protected JButton btnBinarization;
	
	@Override
	public void setupPanel() {
		super.setupPanel();
		this.lblPanelTitle.setText("Step 4 - Binarization");
		this.txtPanelDescription.setText("Now is necessary to apply a binarization process on the image.  This process transforms the image on a black and white mode.\n" + 
				"\n" +
				"The black color will be the region of the interest and the white will be the background. The process used here is called threshold.\n" + 
				"\n" +
				"After click on \"Binarization\" button a \"Threshold\" dialog will be show.\n" + 
				"\n" +
				"A default threshold is processed automaticaly. To use this default threshold simply click apply. Otherwise, use de slide bars to configure the threshold by your way.\n" + 
				"\n" +
				"Important: if the region of the interest stay white click on \"Dark background\" checkbox to invert the color.\n" +
				"\n" +
				"Finally click on \"Apply\" button to set the binarization and close the \"Threshold\" dialog.");
		this.btnBinarization = new JButton("Binarization");
		this.btnBinarization.setBounds(157, 371, 117, 25);
		this.add(this.btnBinarization);
	}
	
	public JButton getBtnBinarization() {
		return this.btnBinarization; 
	}
}