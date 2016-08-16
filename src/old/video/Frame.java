package old.video;

import javax.swing.JFrame;

public abstract class Frame extends JFrame{

	public Frame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addDisplay(Display display){
		add(display);
	}
}
