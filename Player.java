
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Player {

    private int centerX = 375;
    private int centerY = 215;
    public static  int speedX = 0;
    public static  int speedY = 0;
    final int MOVESPEED = 5;
    private static int maxhealth = 10;
    public static int health = maxhealth;
    private boolean movingLeft = false;
    private boolean movingRight = false;
    private boolean movingUp = false;
    private boolean movingDown = false;
    private boolean readyToFire = true;

    public static Rectangle Top = new Rectangle(0, 0, 0, 0);
    public static Rectangle Bottom = new Rectangle(0, 0, 0, 0);
    public static Rectangle Left = new Rectangle(0, 0, 0, 0);
    public static Rectangle Right = new Rectangle(0, 0, 0, 0);
    public static Rectangle CollisionZone = new Rectangle(0, 0, 0, 0);

    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    
        public Camera camera = StartingClass.getcamera();

    public void update() {

        centerX -= speedX;
        centerY -= speedY;    

        Top.setRect(centerX - 25 , centerY - 30, 50, 10);
        Bottom.setRect(centerX - 25, centerY + 20, 50, 10);
        Left.setRect(centerX - 30, centerY - 25, 10, 50);
        Right.setRect(centerX + 20 , centerY -25, 10, 50);
        CollisionZone.setRect(centerX - 180, centerY - 180, 360, 360);
    }

    public void shoot() {
        if (readyToFire) {
            Projectile p = new Projectile( centerX, centerY);
            projectiles.add(p);
        }
    }

    public ArrayList getProjectiles() {
        return projectiles;
    }

    public boolean isReadyToFire() {
        return readyToFire;
    }

    public void setReadyToFire(boolean readyToFire) {
        this.readyToFire = readyToFire;
    }

    public void moveRight() {
        speedX = -MOVESPEED;
    }

    public void moveLeft() {
        speedX = MOVESPEED;
    }

    public void moveUp() {
        speedY = MOVESPEED;
    }

    public void moveDown() {
        speedY = -MOVESPEED;
    }

    public void stopRight() {
        setMovingRight(false);
        stop();
    }

    public void stopLeft() {
        setMovingLeft(false);
        stop();
    }

    public void stopUp() {
        setMovingUp(false);
        stop();
    }

    public void stopDown() {
        setMovingDown(false);
        stop();
    }

    private void stop() {
        if (isMovingRight() == false && isMovingLeft() == false) {
            speedX = 0;
        }

        if (isMovingRight() == false && isMovingLeft() == true) {
            moveLeft();
        }

        if (isMovingRight() == true && isMovingLeft() == false) {
            moveRight();
        }

        if (isMovingUp() == false && isMovingDown() == false) {
            speedY = 0;
        }

        if (isMovingUp() == false && isMovingDown() == true) {
            moveDown();
        }

        if (isMovingUp() == true && isMovingDown() == false) {
            moveUp();
        }
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

    public int getHealth() {
        return health;
    }
}
