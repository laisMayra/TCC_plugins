package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ROISelectionModel;
import view.ImageProcessingPanel;
import view.ROISelectionPanel;

public class ROISelectionController extends ImageProcessingPanelController{
    protected ROISelectionPanel roiSelectionPanel;
    protected ROISelectionModel roiSelectionModel;
    
    @Override
    public void panelController() {
    	this.roiSelectionModel = new ROISelectionModel();
    	this.roiSelectionPanel = new ROISelectionPanel();
    	this.roiSelectionPanel.getBtnROISelection().addActionListener(new ROISelectionButtonListener(this.roiSelectionModel, this.roiSelectionPanel) );
//    	this.partionatedOtsuPanel.getBtnBinarization().addActionListener(new PartionatedOtsuButtonListener(this.partionatedOtsuPanelModel));
    }
    
    public ImageProcessingPanel getPanelView() {
		return this.roiSelectionPanel;
	}
}

class ROISelectionButtonListener implements ActionListener{
	protected ROISelectionModel roiSelectionPanelModel;
	protected ROISelectionPanel roiSelectionPanel;
	
	public ROISelectionButtonListener(ROISelectionModel roiSelectionPanelModel, ROISelectionPanel roiSelectionPanel) {
		this.roiSelectionPanelModel = roiSelectionPanelModel;
		this.roiSelectionPanel = roiSelectionPanel;
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
  		this.roiSelectionPanelModel.getSelectedROI(this.roiSelectionPanel);
	 }
}