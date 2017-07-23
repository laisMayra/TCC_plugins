package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ImageProcessingPanel;
import view.BinarizationPanel;
import model.BinarizationModel;
import controller.ImageProcessingPanelController;

public class BinarizationController extends ImageProcessingPanelController{
    protected BinarizationPanel binarizationPanel;
    protected BinarizationModel binarizationPanelModel;
    
    @Override
    public void panelController() {
    	this.binarizationPanel = new BinarizationPanel();
        this.binarizationPanelModel = new BinarizationModel();
        this.binarizationPanel.getBtnBinarization().addActionListener(new BinarizationButtonListener(this.binarizationPanelModel));
    }
    
    public ImageProcessingPanel getPanelView() {
		return this.binarizationPanel;
	}
}

class BinarizationButtonListener implements ActionListener{
	protected BinarizationModel binarizationPanelModel;	
	
	public BinarizationButtonListener(BinarizationModel binarizationPanelModel) {
		this.binarizationPanelModel = binarizationPanelModel;
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
  		this.binarizationPanelModel.applyBinarization();
	 }
}