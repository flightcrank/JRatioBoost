import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class JSpinLoader extends JComponent {
	
	int numSteps = 8;
	int size = 5;
	double rot = 0;
	double speed = .05;
	boolean clockwise = true;
	ImageIcon spinnerIcon = null;
	Timer timer;
	ActionListener taskPerformer;
	
	public JSpinLoader() {
		
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(30, 30));

		taskPerformer = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evt) {
				
				animate();
				repaint();
			}
		};

		timer = new Timer(33, taskPerformer);
	}
	
	public JSpinLoader(int width, int height, JButton jb) {
		
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(30, 30));

		taskPerformer = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {

				animate();
				jb.setIcon(new ImageIcon(createSpinnerImage(width, height, rot)));
			}
		};
		
		timer = new Timer(33, taskPerformer);
	}
	
	public void start() {
		
		if (!timer.isRunning()) {
			
			timer.start();
		}
	}
	
	public void stop() {
		
		if (timer.isRunning()) {
			
			timer.stop();
		}
	}
	
	public void setSize(int num) {
		
		this.size = num;
	}

	public void setSteps(int num) { 

		this.numSteps = num;
	}

	public void setDirection(boolean direction) {
		            
		clockwise = direction;
	} 
	
	public void setSpeed(double num) {
		
		this.speed = num;
	}
	
	private void animate() {
		
		if (clockwise == true) {

			rot += speed;

		} else {
		
			rot -= speed;
		}

		if (rot >= 2 * Math.PI || rot <= -2 * Math.PI) {
			
			rot = 0;
		}
	}
	
	public  BufferedImage createSpinnerImage(int width, int height, double direction) { 
		
		BufferedImage spinnerImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = spinnerImage.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(150, 150, 150));
		
		int centerX = width / 2;
		int centerY = height / 2;
		double angleAmount = (2 * Math.PI) / numSteps;
		int radius = centerY - (int) (size / 2);
		
		g2d.translate(centerX, centerY);
		g2d.rotate(direction);

		for (int i = 0; i < numSteps; i++) {
			
			double x = Math.sin(angleAmount * i) * radius;
			double y = Math.cos(angleAmount * i) * radius;
			g2d.fillOval((int) x - (size / 2) ,(int) y - (size / 2) , size, size);
		}
		
		return spinnerImage;
	}
	
	public void draw(Graphics g) {
	
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setPaint(new Color(150, 150, 150));
		//g2d.drawString("Java 2D", 50, 50);
		int centerX = this.getWidth() / 2;
		int centerY = this.getHeight() / 2;
		double angleAmount = (2 * Math.PI) / numSteps;
		int radius = centerY - (int) (size / 2);
		
		g2d.translate(centerX, centerY);
		g2d.rotate(rot);

		for (int i = 0; i < numSteps; i++) {
			
			double x = Math.sin(angleAmount * i) * radius;
			double y = Math.cos(angleAmount * i) * radius;
			g2d.fillOval((int) x - (size / 2) ,(int) y - (size / 2) , size, size);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Toolkit.getDefaultToolkit().sync(); //smoother animation in linux
		draw(g);
	}
}
