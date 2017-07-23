package model;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.frame.ThresholdAdjuster;
import ij.process.ImageProcessor;

public class BinarizationModel{
		
	public void applyBinarization() {
		
		ImagePlus imp, imp2, combined_stack;
		int width, height, n=5;

		ThresholdAdjuster thresholdAdjuster;
		try{
			
			
			imp = IJ.getImage();
			IJ.run(imp, "8-bit", "");
			
			imp2 = imp.duplicate();
			imp2.show();
			int id = imp2.getID();
			String title = imp2.getTitle();
			int x, y;
						
			width = imp2.getWidth();
			height = imp2.getHeight();

			for (y = 0; y < n; y++) {
				float offsetY = y * height / n;
			 	for (x = 0; x < n; x++) {
					float offsetX = x * width / n;
					IJ.selectWindow(id);
					String tileTitle = title + " [" + x + "," + y + "]";
					String t = ""+y+""+x;
					IJ.run("Duplicate...", "title=" + t);
					IJ.makeRectangle(offsetX, offsetY, width/2, height/2);
					IJ.run("Crop");
				}
			}
			
			//Otsu
			thresholdAdjuster = new ThresholdAdjuster();
			for (y = 0; y < n; y++) {
				for (x = 0; x < n; x++) {
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
			for(y=0 ; y<n ; y++){
				String stack_one_name = "stack1=" + y + "0 stack2=" + y + "1";
				IJ.run("Combine...", stack_one_name);
				//Rolls
				for(x=2 ; x<n ; x++){
					String stack_name = "stack1=[Combined Stacks] stack2="+y+""+x;
					IJ.run("Combine...", stack_name);
					
				}
				String line_name = ""+y;
				combined_stack = IJ.getImage();
				combined_stack.setTitle(line_name);
			}
			
			//Combinations
			IJ.run("Combine...", "stack1=0 stack2=1 combine");
			for(y=2 ; y<n ; y++){
				IJ.run("Combine...", "stack1=[Combined Stacks] stack2=" + y + " combine");
			}
			
//			IJ.selectWindow(id);
//			close();

			
			
			
			
			
			
			
			
//			ip.setRoi(0, 0, 100, 100);
//		   	imp.setProcessor(null, ip.resize(100));
//			t.setProcessor(null, ip.duplicate());
//			t.show();
		   	
//			thresholdAdjuster = new ThresholdAdjuster();
//			ThresholdAdjuster.setMode("Red");
//			IJ.setAutoThreshold(imp, "Default");
//			IJ.run(imp, "Threshold...", "");
//			ThresholdAdjuster.setMode("B&W");
//			IJ.setAutoThreshold(t, "Otsu");
//			//IJ.run(imp, "Convert to Mask", "");
			
			
		}
		catch (Exception exceptionType) {
			exceptionType.printStackTrace();
        }
	}
}
	