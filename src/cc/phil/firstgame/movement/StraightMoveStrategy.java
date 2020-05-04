package cc.phil.firstgame.movement;

public class StraightMoveStrategy implements MoveStrategy{
    // Membervariables
    //
    private float x;
    private float y;
    protected float moveXPostion = 0;
    private float speed;
    private boolean bounceFromBorder;

    // Constructor
    //
    public StraightMoveStrategy(float x, float y, float speed, boolean bounceFromBorder) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.bounceFromBorder = bounceFromBorder;
    }

    // Methodes
    //
    public void update(int delta) {
        this.x += 0;
    }

    // Getter / Setter
    //
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return speed;
    }

    public boolean isBounceFromBorder() {
        return bounceFromBorder;
    }
}
