package groupd.paint;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SavePaint extends JFrame{

	File fileToSave ;

	public void save(JPanel panel, JFrame mainFrame) {
		if (fileToSave == null)
		{
			saveAs(panel, mainFrame);
		}
		else {
			saveIntoFile(panel);
		}
	}


	public void saveIntoFile(JPanel panel)
	{
		BufferedImage bufImage = takeSnapShot(panel);
		try{
			fileToSave.createNewFile();
			ImageIO.write(bufImage, "jpeg", fileToSave);
		}catch(Exception ex){

		}
	}

	public void saveAs(JPanel panel, JFrame mainFrame) {

		JFileChooser fileChooser = new JFileChooser();
		int rVal = fileChooser.showSaveDialog(mainFrame);
		if (rVal == JFileChooser.APPROVE_OPTION) {

			if (fileToSave==null) fileToSave = fileChooser.getSelectedFile();

			saveIntoFile(panel);
		}    
	}

	private BufferedImage takeSnapShot(JPanel panel){
		BufferedImage bufImage = new BufferedImage(panel.getSize().width, panel.getSize().height,BufferedImage.TYPE_INT_RGB);
		panel.paint(bufImage.createGraphics());
		return bufImage;
	}
}
