package cc.phil.pong;

import cc.phil.firstgame.movement.MoveStrategy;
import org.newdawn.slick.geom.Shape;

public abstract class GameObject {
    // Membervariables
    //
    public static final float X_CENTER_OF_SCREEN = 300.0f;
    public static final float Y_CENTER_OF_SCREEN = 400.0f;
    protected float speed;
    protected Shape collisionShape;                   // Collisionshape for paddle and ball
    protected float x, y;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " Collision";
    }
}