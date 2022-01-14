package domain.player;

import java.awt.Point;
import java.awt.*;


public class StraightLine {
    int startX, startY, endX, endY, steps;
    int currentStep;
    double diffX, diffY;
    int speed;
    
    
    //the below will be changed with the noble phantasm, after applying the singelton patterm
    //they will be changed with the original values.
    
    int nobleWidth;
    int nobleHeight;
    int screenWidth;
    int limitHeight; //the height when the enchanted sphere gets lower than this, one chance is gone.
    int playerChance;
    public StraightLine(int startPointX, int startPointY, int endPointX, int endPointY, int numSteps) {
        startX = startPointX;
        startY = startPointY;
        endX = endPointX;
        endY = endPointY;
        steps = numSteps;
        diffX = ((endPointX - startPointX)/ steps  ) * 1.0;
        diffY = ((endPointY - startPointY) / steps ) * 1.0;
    }

    public boolean hasMoreSteps() {
        if (currentStep > steps)
            return false;
        return true;
    }

    public Point nextPosition() {
        currentStep++;
        if (currentStep > steps)
            return new Point(endX, endY);
        return new Point((int)(startX + (diffX * currentStep)),
                (int)(startY + (diffY * currentStep)));
    }
    
    public void draw(Graphics g, int xS , int xE ,int yS,int  yE, int steps) {
    	Point point = new Point();
    	StraightLine path = new StraightLine(xS,xE,0,0,steps);
        if (path != null && path.hasMoreSteps())
            point = path.nextPosition();
    

        }
    
public void moveEnchantedSphere() {
		
	
		
		if(startX < 0) {
			speed = -speed;
		}
		else if(startX + nobleWidth > screenWidth) {
			speed = -speed;
		}
		
		if(startY > limitHeight) {
			playerChance--;
			//put the enchanted Sphere back to the position of noblePhantasm
			
		}
		
    
}
    
}

