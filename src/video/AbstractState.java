package video;

import java.util.ArrayList;

public abstract class  AbstractState {

	private int width, height;
	private int[] pixel;
	private ArrayList<AbstractState> abstractStates = new ArrayList<AbstractState>();
	
	public AbstractState(int[] p, int w, int h) {
		pixel = p;
		width = w;
		height = h;
	}
	
	public void render(){
		paint();
		for(AbstractState s:abstractStates){
			s.render();
		}
	}
	
	public abstract void paint();
	
	public void setPixel(int x, int y, int v){//fix checks
		pixel[x+y*width] = v;
	}

}
