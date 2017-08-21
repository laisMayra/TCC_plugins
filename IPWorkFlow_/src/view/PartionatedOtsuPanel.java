package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.ImageProcessingPanel;

public class PartionatedOtsuPanel extends ImageProcessingPanel {

	protected JButton btnBinarization;
	protected JButton btnROISelection;
	protected JLabel width, heigth;
	protected JTextField widthSelected, heigthSelected;
	
	@Override
	public void setupPanel() {
		super.setupPanel();

		//Width
		this.width = new JLabel("Width");
//		this.width.setHorizontalAlignment(JLabel.LEFT);
//		this.width.setHorizontalTextPosition(JLabel.LEFT);
		this.width.setBounds(32, 321, 117, 25);
		this.add(this.width);
		this.widthSelected = new JTextField("00.00");
		this.widthSelected.setEditable(false);
//		this.widthSelected.setBounds(220, 371, 50, 25);
		this.widthSelected.setBounds(82, 321, 50, 25);
		this.add(this.widthSelected);
		
		//Heigth
		this.heigth = new JLabel("Heigth");
		this.heigth.setBounds(162, 321, 117, 25);
		this.add(this.heigth);
		this.heigthSelected = new JTextField("00.00");
		this.heigthSelected.setEditable(false);
		this.heigthSelected.setBounds(212, 321, 50, 25);
		this.add(this.heigthSelected);
		
		//Selection Button
		this.btnROISelection = new JButton("Select");
		this.btnROISelection.setBounds(312, 321, 117, 25);
		this.add(this.btnROISelection);
		
		//Binarization Button
		this.lblPanelTitle.setText("Binarization");
		this.txtPanelDescription.setText("Use the tool **** to select the area that represents...");
		this.btnBinarization = new JButton("Binarization");
		this.btnBinarization.setBounds(175, 371, 117, 25);
		this.add(this.btnBinarization);
		
	}
	
	public JButton getBtnBinarization() {
		return this.btnBinarization; 
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