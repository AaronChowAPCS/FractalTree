import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class FractalTree extends PApplet {

private double fractionLength = .8f; 
private int smallestBranch = 10; 
private double branchAngle = .2f;  
private double branchLength = 50;
private int x = 380;
private int y = 380;
public void setup() 
{   
	size(760,760); 
	stroke((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));   
} 
public void draw() 
{   
	background(0);   
	//stroke(0,0,150); 
	strokeWeight(3);
	branchAngle += 0.008f;
	drawBranches(x,y,branchLength,Math.PI/4);
	drawBranches(x,y,branchLength,5*Math.PI/4);
	//drawBranches(x,y,branchLength,Math.PI/2);
	//drawBranches(x,y,branchLength,2*Math.PI/2);
} 
public void drawBranches(int myX,int myY, double myBranchLength, double angle) 
{   
	//your code here
	stroke((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));  
	double angle1 = angle + branchAngle;
	double angle2 = angle - branchAngle;
	myBranchLength *= fractionLength;
	int endX1 = (int)(branchLength*Math.cos(angle1) + myX);
	int endX2 = (int)(branchLength*Math.cos(angle2) + myX);
	int endY1 = (int)(branchLength*Math.sin(angle1) + myY);
	int endY2 = (int)(branchLength*Math.sin(angle2) + myY);

	if(myBranchLength >= smallestBranch)
	{

		drawBranches(endX1, endY1, myBranchLength, angle1);
		drawBranches(endX2, endY2, myBranchLength, angle2);
		line(myX,myY,endX1,endY1);
		line(myX,myY,endX2,endY2);
		ellipse(endX1,endY1, 5,5);
		ellipse(endX2,endY2, 5,5);
	}
} 
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FractalTree" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
