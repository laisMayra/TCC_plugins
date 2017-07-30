package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.PartionatedOtsuModel;
import view.ImageProcessingPanel;
import view.PartionatedOtsuPanel;

public class PartionatedOtsuController extends ImageProcessingPanelController{
    protected PartionatedOtsuPanel partionatedOtsuPanel;
    protected PartionatedOtsuModel partionatedOtsuPanelModel;
    
    @Override
    public void panelController() {
    	this.partionatedOtsuPanel = new PartionatedOtsuPanel();
        this.partionatedOtsuPanelModel = new PartionatedOtsuModel();
        this.partionatedOtsuPanel.getBtnBinarization().addActionListener(new PartionatedOtsuButtonListener(this.partionatedOtsuPanelModel));
    }
    
    public ImageProcessingPanel getPanelView() {
		return this.partionatedOtsuPanel;
	}
}

class PartionatedOtsuButtonListener implements ActionListener{
	protected PartionatedOtsuModel partionatedOtsuPanelModel;	
	
	public PartionatedOtsuButtonListener(PartionatedOtsuModel partionatedOtsuPanelModel) {
		this.partionatedOtsuPanelModel = partionatedOtsuPanelModel;
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
  		this.partionatedOtsuPanelModel.applyBinarization();
	 }
}