
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class JArrow extends JComponent {
	
	public final static int LEFT = 0;
	public final static int RIGHT = 1;
	public final static int UP = 2;
	public final static int DOWN = 3;
	private int direction = UP;

	public JArrow() {
		
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(30, 30));
	}
	
	public void setDirection(int num) {
		
		this.direction = num;
	}

	public static BufferedImage createArrow(int width, int height, int direction) { 
		
		BufferedImage arrowImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = arrowImg.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(150, 150, 150));
		
		Polygon p = new Polygon();
		int centerX = width / 2;
		int centerY = height / 2; 
		int base = width / 3; 
		
		p.addPoint(centerX,0);
		p.addPoint(width, centerY);
		p.addPoint(width - base, centerY);
		p.addPoint(width - base, height);
		p.addPoint(base , height);
		p.addPoint(base, centerY);
		p.addPoint(0, centerY);

		switch (direction) {

			case RIGHT:
				
				g2d.rotate(Math.PI / 2, centerX, centerY);
				g2d.fillPolygon(p);
			break;
			case LEFT:
				
				g2d.rotate((Math.PI / 2) * 3, centerX, centerY);
				g2d.fillPolygon(p);
			break;
			case DOWN:
				
				g2d.rotate(Math.PI, centerX, centerY);
				g2d.fillPolygon(p);
			break;
			default:
				g2d.fillPolygon(p);
		}

		return arrowImg;
	}

	public void drawArrowImg(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		BufferedImage img = createArrow(50, 50, direction);
		
		int centerX = this.getWidth() / 2;
		int centerY = this.getHeight() / 2; 

		g2d.translate(centerX - 25, centerY - 25);
		g2d.drawImage(img, null, 0, 0);
	}

	public void drawArrow(Graphics g) {
	
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setPaint(new Color(150, 150, 150));

		Polygon p = new Polygon();
		int centerX = this.getWidth() / 2;
		int centerY = this.getHeight() / 2; 
		int base = this.getWidth() / 3; 
		
		p.addPoint(centerX,0);
		p.addPoint(this.getWidth(), centerY);
		p.addPoint(this.getWidth() - base, centerY);
		p.addPoint(this.getWidth() - base, this.getHeight());
		p.addPoint(base , this.getHeight());
		p.addPoint(base, centerY);
		p.addPoint(0, centerY);
	
		switch (direction) {

			case RIGHT:
				
				g2d.rotate(Math.PI / 2, centerX, centerY);
				g2d.fillPolygon(p);
			break;
			case LEFT:
				
				g2d.rotate((Math.PI / 2) * 3, centerX, centerY);
				g2d.fillPolygon(p);
			break;
			case DOWN:
				
				g2d.rotate(Math.PI, centerX, centerY);
				g2d.fillPolygon(p);
			break;
			default:
				g2d.fillPolygon(p);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Toolkit.getDefaultToolkit().sync(); //smoother animation in linux
		drawArrow(g);
	}
}

