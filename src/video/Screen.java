package video;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Screen extends Canvas implements Runnable{
	
	public static void main(String[] args) {
		Screen d = new Screen(150, 150);
		Window w = new Window(600, 400);
		w.setScreen(d);
		d.start();
//		JFrame frame = new JFrame("test");
//		frame.setSize(new Dimension(600, 400));
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Display d = new Display(100, 100);
//		frame.add(d);
////		frame.pack();
//		frame.setVisible(true);
//		frame.setLocationRelativeTo(null);
//		d.start();
	}
	
	private BufferedImage img;
	private int[] pixel;
	private Graphics g;
	private BufferStrategy bs;
	private State state;
	private Thread thread;
	private volatile boolean isRunning;
	private int fps = 0;
	
	public Screen(int w, int h){
		Dimension size = new Dimension(w, h);
		setMaximumSize(size);
		setMinimumSize(size);
		setSize(size);
		setIgnoreRepaint(true);
		img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		pixel = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		state = new State(pixel, w, h);
		thread = new Thread(this);
	}
	
	public void render(){
		bs = getBufferStrategy();
		if(bs==null){
			createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		state.render();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
	}
	
	public void start(){
		isRunning = true;
		thread.start();
	}

	@Override
	public void run() {
		System.out.println("screen started");
		long last = System.currentTimeMillis();
		while(isRunning){
			fps++;
//			if(this.getPeer()==null){
//				System.out.println("null");
//				continue;
//			}
			render();
			if(System.currentTimeMillis()-last>1000){
				System.out.println(fps);
				fps=0;
				last = System.currentTimeMillis();
			}
		}
	}
}
