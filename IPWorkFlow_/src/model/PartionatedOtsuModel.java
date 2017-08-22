package model;

import ij.IJ;
import ij.ImagePlus;
import ij.gui.Roi;
import ij.plugin.frame.ThresholdAdjuster;
import view.PartionatedOtsuPanel;

public class PartionatedOtsuModel{
	ImagePlus imp;
	String roiWidth, roiHeigth;
	
	public void getSelectedROI(PartionatedOtsuPanel panel){
		//Width and Height selection
		imp = IJ.getImage();
		Roi roi = imp.getRoi();
		roiHeigth = String.valueOf(roi.getFloatHeight());
		roiWidth = String.valueOf(roi.getFloatWidth());
//		System.out.println(String.valueOf(roi.getFloatHeight()));
//		System.out.println(String.valueOf(roi.getFloatWidth()));
		IJ.setTool(0);
//		new WaitForUserDialog("Do something, then click OK.").show();
		
		panel.setWidthSelected(String.valueOf(roi.getFloatWidth()));
		panel.setHeigthSelected(String.valueOf(roi.getFloatHeight()));
	}
		
	public void applyBinarization() {
		
		ImagePlus imp2, combined_stack;
		int width, height, h, w;
		
		

		ThresholdAdjuster thresholdAdjuster;
		try{
			imp = IJ.getImage();
			Roi roi = imp.getRoi();
			
			float impW;
			impW = Float.valueOf(roiWidth);
			w = Math.round(imp.getWidth()/impW);
			
			float impH;
			impH = Float.valueOf(roiHeigth);
			h = Math.round(imp.getHeight()/impH);
			
			System.out.println(String.valueOf(w));
			System.out.println(String.valueOf(h));
			
			imp.deleteRoi();
			IJ.run(imp, "8-bit", "");
			
			//Binarization			
			imp2 = imp.duplicate();
			imp2.show();
			int id = imp2.getID();
			String title = imp2.getTitle();
			int x, y;
						
			width = imp2.getWidth();
			height = imp2.getHeight();

			for (y = 0; y < h; y++) {
				float offsetY = y * height / h;
			 	for (x = 0; x < w; x++) {
					float offsetX = x * width / w;
					IJ.selectWindow(id);
					String tileTitle = title + " [" + x + "," + y + "]";
					String t = ""+y+""+x;
					IJ.run("Duplicate...", "title=" + t);
					IJ.makeRectangle(offsetX, offsetY, width/w, height/h);
					IJ.run("Crop");
				}
			}
			
			//Otsu
			thresholdAdjuster = new ThresholdAdjuster();
			for (y = 0; y < h; y++) {
				for (x = 0; x < w; x++) {
					String t = ""+y+""+x;
					IJ.selectWindow(t);
					IJ.setAutoThreshold(IJ.getImage(),  "Otsu");
					ThresholdAdjuster.setMode("B&W");
					IJ.run("Convert to Mask");
					
				}
			}
			
			//Join imagens
			//n == number of division per line and number of lines
			//Lines
			for(y=0 ; y<h ; y++){
				String stack_one_name = "stack1=" + y + "0 stack2=" + y + "1";
				IJ.run("Combine...", stack_one_name);
				//Rolls
				for(x=2 ; x<w ; x++){
					String stack_name = "stack1=[Combined Stacks] stack2="+y+""+x;
					IJ.run("Combine...", stack_name);
					
				}
				String line_name = ""+y;
				combined_stack = IJ.getImage();
				combined_stack.setTitle(line_name);
			}
			
			//Combinations
			IJ.run("Combine...", "stack1=0 stack2=1 combine");
			for(y=2 ; y<h ; y++){
				IJ.run("Combine...", "stack1=[Combined Stacks] stack2=" + y + " combine");
			}

		}
		catch (Exception exceptionType) {
			exceptionType.printStackTrace();
        }
	}
}
	