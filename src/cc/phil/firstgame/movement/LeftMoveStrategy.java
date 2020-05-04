package cc.phil.firstgame.movement;

public class LeftMoveStrategy extends StraightMoveStrategy {
    // Constructor
    //
    public LeftMoveStrategy(float x, float y, float speed, boolean bounceFromBorder) {
        super(x, y, speed, bounceFromBorder);
    }

    // Methodes
    //
    @Override
    public void update(int delta) {
        this.moveXPostion -= (float) delta / getSpeed();
        setX(moveXPostion);

        if (getX() < 0) {
            bounceOrWrapObject(true, delta);
        }
    }

    private void bounceOrWrapObject(boolean bounceFromBorder, int delta) {
        if (bounceFromBorder) {
            this.moveXPostion += (float) delta / getSpeed();
        } else {
            setX(800);
        }
    }
}
