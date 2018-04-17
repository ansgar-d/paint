package groupd.paint;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class SavePaint extends JFrame{

	File fileToSave ;
	SwingWorker<Void, Void> worker;
	JPanel panel;
	JFrame mainFrame;
	boolean isAutoSave = false;
	
	
	public SavePaint(JPanel panel, JFrame mainFrame)
	{
		this.panel=panel;
		this.mainFrame=mainFrame;	  
	}

	public void save() {
		if (fileToSave == null)
		{
			saveAs();
		}
		else {
			saveIntoFile();
		}
	}


	public void saveIntoFile()
	{
		BufferedImage bufImage = takeSnapShot();
		try{
			fileToSave.createNewFile();
			ImageIO.write(bufImage, "jpeg", fileToSave);
		}catch(Exception ex){

		}
	}

	public void saveAs() {

		JFileChooser fileChooser = new JFileChooser();
		int rVal = fileChooser.showSaveDialog(mainFrame);
		if (rVal == JFileChooser.APPROVE_OPTION) {

			if (fileToSave==null) fileToSave = fileChooser.getSelectedFile();

			saveIntoFile();
		}    
	}
	
	

	private BufferedImage takeSnapShot(){
		BufferedImage bufImage = new BufferedImage(panel.getSize().width, panel.getSize().height,BufferedImage.TYPE_INT_RGB);
		panel.paint(bufImage.createGraphics());
		return bufImage;
	}

	public void autoSave() {
		isAutoSave = !isAutoSave;
		if (isAutoSave)
		{
			//for autosave
			 worker = new SwingWorker<Void, Void>() {
				   @Override
				   protected Void doInBackground() throws Exception {
				    
					   while (isAutoSave) {
						   Thread.sleep(1000);
						   save();
					   }
					   return null;
				   }
				  };
				  worker.execute();
		}
		else {
			worker.cancel(true);
			worker = null;
		}
	}

}
