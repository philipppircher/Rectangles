package cc.phil.pong;

import cc.phil.firstgame.movement.MoveStrategy;
import org.newdawn.slick.geom.Shape;

public abstract class GameObject {
    // Membervariables
    //
    public static final float X_CENTER_OF_SCREEN = 300.0f;
    protected float speed;
    protected Shape collisionShape;                   // Collisionshape for paddle and ball
    protected float x, y;

    public GameObject(MoveStrategy moveStrategy) {
        this.x = X_CENTER_OF_SCREEN;
    }

    public GameObject() {

    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " Collision";
    }
}
