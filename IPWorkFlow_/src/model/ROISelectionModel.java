package model;

import ij.IJ;
import ij.ImagePlus;
import ij.gui.Roi;
import view.ROISelectionPanel;

public class ROISelectionModel {
	
	public void getSelectedROI(ROISelectionPanel panel){
		ImagePlus imp;
		String x, y, w, h;
//		ROISelectionPanel roiSelectionPanel;
		
		
		try {
			imp = IJ.getImage();
			Roi roi = imp.getRoi();
			x = String.valueOf(roi.getFloatHeight());
			y = String.valueOf(roi.getFloatWidth());
			System.out.println(x);
			System.out.println(y);
			IJ.setTool(0);
//			new WaitForUserDialog("Do something, then click OK.").show();
			
			panel.setWidthSelected(y);
			panel.setHeigthSelected(x);
			
			
		}
		catch (Exception exceptionType) {
			exceptionType.printStackTrace();
        }		
		
		
	}

}
