package model;

/**
 * 自動車のクラス
 */
public class Car {

    private int position;
    private int speed;
    private final int maxSpeed;
    private final double deceleration;

    public Car(int maxSpeed, double deceleration, int position) {
        this.position = position;
        this.deceleration = deceleration;
        this.maxSpeed = maxSpeed;
    }

    public Car(int maxSpeed, double deceleration, int position, int speed) {
        this.position = position;
        this.deceleration = deceleration;
        this.maxSpeed = maxSpeed;
        this.speed = speed;
    }

    public int evalSpeed(int headway) {
        speed = Math.min(maxSpeed, speed + 1);
        speed = Math.min(speed, headway - 1);
        if (Math.random() < deceleration) {
            speed = Math.max(0, speed - 1);
        }
        return speed;
    }

    public int move(int length) {
        position = (position + speed) % length;
        return position;
    }

    public int getPosition() {  return position;  }

    public int getSpeed() {  return speed;  }

}
