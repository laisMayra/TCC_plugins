package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.PartionatedOtsuModel;
import view.ImageProcessingPanel;
import view.PartionatedOtsuPanel;

public class PartionatedOtsuController extends ImageProcessingPanelController{
    protected PartionatedOtsuPanel partionatedOtsuPanel;
    protected PartionatedOtsuModel partionatedOtsuModel;
    
    @Override
    public void panelController() {
    	this.partionatedOtsuPanel = new PartionatedOtsuPanel();
        this.partionatedOtsuModel = new PartionatedOtsuModel();
        this.partionatedOtsuPanel.getBtnBinarization().addActionListener(new PartionatedOtsuButtonBinarizationListener(this.partionatedOtsuModel));
        this.partionatedOtsuPanel.getBtnROISelection().addActionListener(new PartionatedOtsuButtonROISelectionListener(this.partionatedOtsuModel, this.partionatedOtsuPanel));
    }
    
    public ImageProcessingPanel getPanelView() {
		return this.partionatedOtsuPanel;
	}
}

class PartionatedOtsuButtonBinarizationListener implements ActionListener{
	protected PartionatedOtsuModel partionatedOtsuModel;
	
	public PartionatedOtsuButtonBinarizationListener(PartionatedOtsuModel partionatedOtsuModel){
		this.partionatedOtsuModel = partionatedOtsuModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.partionatedOtsuModel.applyBinarization();
	}
}

class PartionatedOtsuButtonROISelectionListener implements ActionListener{
	protected PartionatedOtsuModel partionatedOtsuModel;
	protected PartionatedOtsuPanel partionatedOtsuPanel;
	
	public PartionatedOtsuButtonROISelectionListener(PartionatedOtsuModel partionatedOtsuModel, PartionatedOtsuPanel partionatedOtsuPanel){
		this.partionatedOtsuModel = partionatedOtsuModel;
		this.partionatedOtsuPanel = partionatedOtsuPanel;
	}
	
	 @Override
	 public void actionPerformed(ActionEvent e) {
  		this.partionatedOtsuModel.getSelectedROI(partionatedOtsuPanel);
	 } 
}