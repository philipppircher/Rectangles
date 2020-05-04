package cc.phil.firstgame.movement;

public class RightMoveStrategy extends StraightMoveStrategy {
    // Constructor
    //
    public RightMoveStrategy(float x, float y, float speed, boolean bounceFromBorder) {
        super(x, y, speed, bounceFromBorder);
    }

    // Methodes
    //
    public void update(int delta) {
        this.moveXPostion += (float) delta / getSpeed();
        setX(moveXPostion);

        if (getX() < 0) {
            bounceOrWrapObject(true, delta);
        }
    }
    // TODO check and continue here..
    private void bounceOrWrapObject(boolean bounceFromBorder, int delta) {
        if (bounceFromBorder) {
            this.moveXPostion += (float) delta / getSpeed();
        } else {
            setX(800);
        }
    }
}
