public class celestial_body{ //allows us to get items from arraylist/linkedlist
	String name;
	Double mass;
	Double xc;
	Double yc;
	Double xd;
	Double yd;
	Double size;
	public celestial_body(){
		this.name = "none";
		this.mass = 0.0;
		this.xc = 0.0;
		this.yc = 0.0;
		this.xd = 0.0;
		this.yd = 0.0;
		this.size = 0.0;
	}
	public celestial_body(String name, Double mass, Double xc, Double yc, Double xd, Double yd, Double size){
		this.name = "none";
		this.mass = 0.0;
		this.xc = 0.0;
		this.yc = 0.0;
		this.xd = 0.0;
		this.yd = 0.0;
		this.size = 0.0;
	}
	public void set_name(String name){ 
		this.name = name;
	}
	public String get_name(){
		return this.name;
	}
	public void set_mass(Double mass){
		this.mass = mass; 
	}
	public Double get_mass(){
		return this.mass;
	}
	public void set_xc(Double xc){
		this.xc = xc; 
	}
	public Double get_xc(){
		return this.xc;
	}
	public void set_yc(Double yc){
		this.yc = yc; 
	}
	public Double get_yc(){
		return this.yc;
	}
	public void set_xd(Double xd){
		this.xd = xd; 
	}
	public Double get_xd(){
		return this.xd;
	}
	public void set_yd(Double yd){
		this.yd = yd; 
	}
	public Double get_yd(){
		return this.yd;
	}
	public void set_size(Double size){
		this.size = size;
	}
	public Double get_size(){
		return this.size;
	}
	public String toString(){
		return this.name + " " + this.mass + " " + this.xc + " " + this.yc + " " + this.xd + " " + this.yd + " " + this.size;
	}
}