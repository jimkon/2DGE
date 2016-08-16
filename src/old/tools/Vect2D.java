package old.tools;

public class Vect2D extends Number2D{

	public static void main(String[] args) {
		Vect2D v = new Vect2D(1.5 ,0);
		Vect2D v1 = new Vect2D(0,1.5);
		System.out.println(v.distanceFrom(v1));
		System.out.println(v.angleDegrees(v1));
		System.out.println(v1.distanceFrom(v1));
		System.out.println(v1.angleDegrees(v1));
	}
	
	public Vect2D(){
		super();
	}
	
	public Vect2D(double x, double y) {
		super(x, y);
	}
	
	public double norm2(){
		return distanceFrom(ZERO);
	}
	
	public double angleRads(){
		return Math.atan((double)y/x);
	}
	
	public double angleRads(Vect2D v){
		return Math.acos(dotProduct(v)/(v.norm2()*norm2()));
	}
	
	public double angleDegrees(){
		if(y==0){
			if(x==0){return 0;}
			return (x>0)? 0 : 180; 
		}
		return (180*angleRads())/(Math.PI);
	}
	
	public double angleDegrees(Vect2D n){
		return (360*angleRads(n))/(2*Math.PI);
	}
	
	public double dotProduct(Vect2D v){
		return x*v.x+y*v.y;
	}

}
