
import java.awt.Rectangle;

public class Projectile {

	private int x, y, speedX;
	private boolean visible;
	   
        public Camera camera = StartingClass.getcamera();
	private Rectangle r;
	
	public Projectile(int startX, int startY){
		x = startX;
		y = startY;
		speedX = 7;
		visible = true;
		
		r = new Rectangle(0, 0, 0, 0);
	}
	
	public void update(){
		x += speedX;
		r.setBounds(x, y, 10, 5);
		if (x > 800 + camera.getCenterX()){
			visible = false;
			r = null;
		}
		if (x < 800 - camera.getCenterX()){
			checkCollision();
		}
	}

	private void checkCollision() {
		
	}


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
}
