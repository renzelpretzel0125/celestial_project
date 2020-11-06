import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.nio.file.Files;
import java.io.BufferedReader;
import java.nio.file.Path;
import java.io.IOException;

import java.util.Arrays;

public class celestial extends JPanel implements ActionListener{

	double scale;
	static List<celestial_body> ds;

	public void readInput(String filename){
		List<celestial_body> dataStructure = null;
		try(BufferedReader br=Files.newBufferedReader(Path.of(filename));){
			String line = br.readLine();
			//if line is arraylist make data structure equals new arraylist else linklist
			if(line.toLowerCase() == "arraylist"){
				dataStructure = new ArrayList<celestial_body>();
			}else{
				dataStructure = new LinkedList<celestial_body>();
			}
			this.scale = Double.valueOf(br.readLine());
			while((line = br.readLine())!= null){ //reads lines and sets
				String[]split = line.split(",");
				System.out.println(Arrays.toString(line.split(",")));
				celestial_body c = new celestial_body();
				c.set_name(split[0]);
				c.set_mass(Double.valueOf(split[1]));
				c.set_xc(Double.valueOf(split[2]));
				c.set_yc(Double.valueOf(split[3]));
				c.set_xd(Double.valueOf(split[4]));
				c.set_yd(Double.valueOf(split[5]));
				c.set_size(Double.valueOf(split[6]));
				dataStructure.add(c);

			}
			this.ds = dataStructure;
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	// animation
	
	Timer tm = new Timer(0,this);
	//int x = 0/*position horizontallay of the frame*/, velX = 2;//velX = velocity X
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i = 0; i<ds.size();i++){
			double xc = ds.get(i).get_xc();
			double yc = ds.get(i).get_yc();
			double s = ds.get(i).get_size();
			g.setColor(Color.BLUE);
			g.fillOval((int)xc/*position x*/,(int)yc/*position y*/,(int)s/*width*/,(int)s/*height*/);
		}
		tm.start();//start timer for action listener

	}
	public void actionPerformed(ActionEvent e){//to use action listener
		
		double g = 6.674*Math.pow(10,-11);//gravity
		double m1;//first mass
		double m2;//second mass
		double d;//distance
		double f;//force
		
		for(int i = 0; i<ds.size();i++){
			m1 = ds.get(i).get_mass();
			double xc = ds.get(i).get_xc();//coordinate
			double yc = ds.get(i).get_yc();
			double xd = ds.get(i).get_xd();//velocity
			double yd = ds.get(i).get_yd();
			double s = ds.get(i).get_size();//size of planets
			for(int j = 0; j<ds.size();j++){
				if(i!=j){
					double d1;
					double d2;
					
					d1 = Math.pow(ds.get(i).get_xc()-ds.get(j).get_xc(),2);
					d2 = Math.pow(ds.get(i).get_yc()-ds.get(j).get_yc(),2);
					d = Math.sqrt(d1+d2);
					m2 = ds.get(j).get_mass();
					

					double xc2 = ds.get(j).get_xc();//coordinate
					double yc2 = ds.get(j).get_yc();
					double xd2 = ds.get(j).get_xd();//velocity
					double yd2 = ds.get(j).get_yd();
					
					f = g *(m1 * m2 / Math.pow(d,2)); //force between two celestial bodies
					
					if(xc>xc2){ //if celestial i is greater than celestial j, force/mass adds to the velocity of celestial
						ds.get(i).set_xd(xd+(f/m1));
					}else if(xc<xc2){//if lesser then velocity is subtracted due to being further and not effecting each others gravity
						ds.get(i).set_xd(xd-(f/m1));
					}else{
						ds.get(i).set_xd(xd);
					}

					if(yc>yc2){//same as line 101 but with the y coordinates
						ds.get(i).set_yd(yd+(f/m1));
					}else if(yc<yc2){
						ds.get(i).set_yd(yd-(f/m1));
					}else{
						ds.get(i).set_yd(yd);
					}

					ds.get(j).set_xc(xc2+xd2);//coordinate is updated incrementing it with velocity
					ds.get(j).set_yc(yc2+yd2);//same with line 117 but with y coordinates

					if(xc<0 || xc>(768-s)){//if xc reaches borders, it goes back into the 768x768 frame
						if(yc<0 || yc>(768-s)){
							ds.get(i).set_xc(xc2-xd2);
							ds.get(i).set_yc(yc2-yd2);
						}
					}

					repaint();

				}
				
				ds.get(i).set_xc(xc+xd);//follows the same rules as the previous lines but for the other celestial
				ds.get(i).set_yc(yc+yd);

				if(xc<0 || xc>(768-s)){//same as line 122
					if(yc<0 || yc>(768-s)){
						ds.get(i).set_xc(xc-xd);
						ds.get(i).set_yc(yc-yd);
					}
				}
				repaint();

			}
			
		}

		repaint();
	}


	public static void main(String[]args){

		celestial t  = new celestial();
		JFrame jf = new JFrame();

		t.readInput("nbody_input.txt");
		
		jf.setTitle("Celestial");	
		jf.setSize(768,768);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
		
	}


}