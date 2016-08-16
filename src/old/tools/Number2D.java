package old.tools;

public class Number2D {

	public static Number2D ZERO = new Number2D(0, 0);
	
	public double x, y;
	
	public Number2D(){
		x=0;
		y=0;
	}
	public Number2D(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public void set(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public void add(double x, double y){
		this.x +=x;
		this.y +=y;
	}
	
	public void add(Number2D n){
		this.x += n.x;
		this.y += n.y;
	}
	
	public void sub(Number2D n){
		this.x -= n.x;
		this.y -= n.y;
	}
	
	public void multi(double n){
		x *=n;
		y *=n;
	}
	
	public double distanceFrom(Number2D n){
		return Math.sqrt((double)Math.pow(y-n.y, 2) + Math.pow(x-n.x, 2) );
	}
	
	public double distanceFrom(int x, int y){
		return Math.sqrt((double)Math.pow(this.y-y, 2) + Math.pow(this.x-x, 2) );
	}
	
	public Number2D yAxisReflection(){
		return new Number2D(-x, y);
	}
	
	public Number2D xAxisReflection(){
		return new Number2D(x, -y);
	}
	
	public Number2D zeroReflection(){
		return new Number2D(-x, -y);
	}
	
	public void reset(){
		x = 0;
		y = 0;
	}
	
	public String toString(){
		return " ( "+x+", "+y+") ";
	}

}
