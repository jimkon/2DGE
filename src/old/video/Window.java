package old.video;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

@SuppressWarnings("serial")
public class Window extends Frame implements ComponentListener{
	
	private int width, height;
	
	public Window(){
		super();
		width = 0;
		height = 0;
		setResizable(false);
		addComponentListener(this);
	}
	
	public Window(int width, int height, boolean resizable){
		super();
		this.width = width;
		this.height = height;
		setSize(width, height);
		setResizable(resizable);
		addComponentListener(this);
	}

	public void addDisplay(Display display){
		super.addDisplay(display);
		if(width==0 && height==0){
			System.out.println("asdasd");
			pack();
		}
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		//System.out.println(e);
		width = e.getComponent().getWidth();
		height = e.getComponent().getHeight();
		//System.out.println(width+" "+height);
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
