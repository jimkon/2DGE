package video;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class Frame extends JFrame{

	public Frame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setScreen(Screen screen){
		getContentPane().removeAll();
		add(screen);
	}
}
