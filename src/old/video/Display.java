package old.video;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

@SuppressWarnings("serial")
public class Display extends Canvas {
	
	private BufferedImage img;
	private int[] pixel;
	private Graphics g;
	private BufferStrategy bs;
	
	public Display(int w, int h){
		Dimension size = new Dimension(w, h);
		setMaximumSize(size);
		setMinimumSize(size);
		setSize(size);
		setIgnoreRepaint(true);
		img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		pixel = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		
	}
	
	public void render(boolean showRenderTime){
		long start = System.nanoTime();
		bs = getBufferStrategy();
		if(bs==null){
			createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
		if(showRenderTime){
			long time = System.nanoTime()-start;
			System.out.println(time + 
					"nanoseconds needed for render ("+ time/1000000+" ms)");
		}
	}
	
	public void drawPixel(int x, int y, Color c){
		if(x>=img.getWidth() || x<0 || y>=img.getHeight() || y<0){
			System.err.println("Wrong coordinates in drawPixel");
			return;
		}
		pixel[x+y*img.getWidth()] = c.getRGB();
	}
	
	public void drawLine(int x0, int y0, int x1, int y1, Color c){
		if(x1>=img.getWidth() || x1<0 || x0>=img.getWidth()|| x0<0 || y1>=img.getHeight() || y1<0 || y0>=img.getHeight() || y0<0){
			System.err.println("Wrong coordinates in drawLine");
			return;
		}
		int dx, dy, err, sx, sy,e2;
		dx = Math.abs(x1-x0);
		dy = Math.abs(y1-y0); 
		if (x0 < x1)
			sx = 1;
		else
			sx = -1;
		   
		if( y0 < y1 )
			sy = 1;
		else
			sy = -1;
		
		err = dx-dy;
		while(true){
		   drawPixel(x0,y0,c);
		   if (x0 == x1 && y0 == y1)
			   break;
		   
		   e2 = 2*err;
		   if (e2 > -dy ){ 
		       err = err - dy;
		       x0 = x0 + sx;
		   }
		   if( x0 == x1 && y0 == y1){
			   drawPixel(x0,y0,c);
			   break;
		   }
		   if (e2 <  dx){ 
		       err = err + dx;
		       y0 = y0 + sy ;
		   }
		}
	}
	
	public void clearScreen(){
		for(int i=0; i<pixel.length; i++){
			pixel[i]=0;
		}
	}
	
	public static void main(String[] args){
		Window w = new Window(600, 400, false);
		Display d = new Display(20, 20);
		w.addDisplay(d);
		w.setTitle("asdas");
		while(true){
			d.clearScreen();
			int x1=0, y1 = 0, x2 = 0, y2 = 0;
			d.drawLine(x1, y1, x2, y2, Color.CYAN);
			d.render(false);
		}
	}
	
	

}
