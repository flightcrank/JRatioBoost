
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JProgressBar;

/**
 *
 * @author karma
 */

public class JCircleProgress extends JProgressBar {
    
    private boolean outline;
    private Color c;
    private FontMetrics fm;
    
    public JCircleProgress() {

        this.setValue(0);
        this.setMaximum(100);
        this.setStringPainted(true);
        this.outline = true;
        this.c = Color.ORANGE;
        this.setFont(new Font("Arial", Font.PLAIN, 18));
	this.fm = getFontMetrics(this.getFont());
    }
   
    public Color getColour() {
        
        return c;
    }

    public void setColour(Color c) {
        
        this.c = c;
    }
    
    public boolean isOutline() {
        
        return outline;
    }

    public void setOutline(boolean outline) {
        
        this.outline = outline;
    }
    
    @Override
    public void paintComponent(Graphics grphcs) {
    
        //super.paintComponent(grphcs);
	
        Graphics2D g2d = (Graphics2D) grphcs.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(c);
        
        int v = this.getValue();
        int max = this.getMaximum();
        
        float f = (float) v / max;
        float r = f * 360;
        
        double mainDiameter;
        
        
        //choose the smallest of the width or height of the JComponent to determine the diameter of the circle
        if (this.getWidth() > this.getHeight()) {
            
            mainDiameter = this.getHeight() - 2;
        
        } else {
            
            mainDiameter = this.getWidth() - 2;
        }
        
	//Define the dimensions and position of the hole
	double innerDiameter = mainDiameter / 2;
        
        //define the upper left corner of where to begin drawing from in the JComponent
	int main_circle_X = (this.getWidth() / 2) - (int)mainDiameter / 2;
	int main_circle_Y = (this.getHeight() / 2) - (int)mainDiameter / 2;

	int inner_circle_X = (this.getWidth() / 2) - (int)innerDiameter / 2;
	int inner_circle_Y = (this.getHeight() / 2) - (int)innerDiameter / 2;
	
        // Define the Round Hole Shape
        Ellipse2D.Double holeShape = new Ellipse2D.Double(inner_circle_X, inner_circle_Y, innerDiameter, innerDiameter);
        
        //Create a Custom Clipping Area
        //Start with the full bounds of the component
        Area customClip = new Area(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
                 
        //Subtract the hole from the clipping area
        customClip.subtract(new Area(holeShape));
        
        //Save and Set the Clip
        Shape oldClip = g2d.getClip(); // Save existing clip to restore later
        g2d.setClip(customClip);       // Apply the custom clip with the hole

	//draw the main progress circle
        g2d.fillArc(main_circle_X, main_circle_Y, (int)mainDiameter, (int)mainDiameter, 90, -(int)r);
        
        //Restore the original clip 
        g2d.setClip(oldClip);

        //Apply the font to the Graphics context
        g2d.setFont(this.getFont());
        
        
        if (outline) {
            
		//outer outline
        	g2d.setColor(new Color(153,153,153));
		g2d.draw(new Ellipse2D.Double(main_circle_X, main_circle_Y, mainDiameter, mainDiameter));
        	
		g2d.setColor(Color.WHITE);
		g2d.draw(new Ellipse2D.Double(main_circle_X + 1, main_circle_Y + 1, mainDiameter - 2, mainDiameter - 2));
        
		//inner outline
		g2d.setColor(new Color(153,153,153));
		g2d.draw(new Ellipse2D.Double(inner_circle_X + 1, inner_circle_Y + 1, innerDiameter - 2, innerDiameter - 2));
        	
		g2d.setColor(Color.WHITE);
		g2d.draw(new Ellipse2D.Double(inner_circle_X, inner_circle_Y, innerDiameter, innerDiameter));
        }

	if (this.paintString) {
        		
        	//int textWidth = this.fm.stringWidth(this.getString() + "%"); // This is the width in pixels
        	int textWidth = this.fm.stringWidth(this.getString()); // This is the width in pixels
        	int n = textWidth / 2;
        	g2d.setColor(Color.BLACK);
		g2d.drawString(this.getString(), (this.getWidth() / 2) - n, (this.getHeight() / 2) + this.fm.getAscent() / 2);
	}
       
    }
    
    public float calculatePercentage () {
        
        return ((float) this.getValue() / this.getMaximum()) * 100;
    }
}
