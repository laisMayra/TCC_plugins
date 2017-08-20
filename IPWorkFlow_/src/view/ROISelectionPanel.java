package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ROISelectionPanel extends ImageProcessingPanel {

//	public String getWidth() {
//		return widthSelected.getText();
//	}

	protected JButton btnROISelection;
	protected JLabel width, heigth;
	protected JTextField widthSelected, heigthSelected;	
	
	@Override
	public void setupPanel() {
		super.setupPanel();
		this.lblPanelTitle.setText("Step 1 - ROI Selection");
		this.txtPanelDescription.setText("Use the tool **** to select the area that represents...");
//		this.btnBinarization = new JButton("Binarization");
//		this.btnBinarization.setBounds(157, 371, 117, 25);
//		this.add(this.btnBinarization);
		
		//Width
		this.width = new JLabel("Width");
//		this.width.setHorizontalAlignment(JLabel.LEFT);
//		this.width.setHorizontalTextPosition(JLabel.LEFT);
		this.width.setBounds(170, 371, 117, 25);
		this.add(this.width);
		this.widthSelected = new JTextField("00.00");
		this.widthSelected.setEditable(false);
		this.widthSelected.setBounds(220, 371, 50, 25);
		this.add(this.widthSelected);
		
		//Heigth
		this.heigth = new JLabel("Heigth");
		this.heigth.setBounds(300, 371, 117, 25);
		this.add(this.heigth);
		this.heigthSelected = new JTextField("00.00");
		this.heigthSelected.setEditable(false);
		this.heigthSelected.setBounds(350, 371, 50, 25);
		this.add(this.heigthSelected);
		
		this.btnROISelection = new JButton("Select");
		this.btnROISelection.setBounds(10, 371, 117, 25);
		this.add(this.btnROISelection);
		
	}
	
	public JButton getBtnROISelection() {
		return this.btnROISelection; 
	}
	
	public void setWidthSelected(String width) {
		this.widthSelected.setText(width); ;
	}

	public void setHeigthSelected(String heigth) {
		this.heigthSelected.setText(heigth);
	}
}
