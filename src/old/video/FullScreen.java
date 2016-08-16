package old.video;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

@SuppressWarnings("serial")
public class FullScreen extends Frame{

	private GraphicsDevice gd; 
	
	public FullScreen() throws FullScreenNotAllowedException{
		super();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getScreenDevices()[0];
		if(!gd.isFullScreenSupported()){
			throw new FullScreenNotAllowedException();
		}
		else{
			this.setUndecorated(true);
		}
	}
	
	public void addDisplay(Display display){
		super.addDisplay(display);
		gd.setFullScreenWindow(this);
		
	}
}
