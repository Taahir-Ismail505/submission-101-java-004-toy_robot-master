package za.co.wethinkcode.toyrobot;

public class Robot {

    public static final Position CENTRE = new Position(0,0);
    private final Position TOP_LEFT = new Position(-100,100);
    private final Position BOTTOM_RIGHT = new Position(100,-200);
    private Direction currentDirection;

    private Position position;
    private String status;
    private String name;

    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        this.position = CENTRE;
        this.currentDirection = Direction.NORTH;
    }

    public String getStatus() {

        return this.status;
    }

    public Direction getCurrentDirection() {
        return Direction.NORTH;
    }

    public boolean handleCommand(Command command){

        return command.execute(this);
    }

    public boolean updatePosition(int nrSteps){
        int newX = this.position.getX();
        int newY = this.position.getY();

        if (Direction.NORTH.equals(this.currentDirection)) {
            newY = newY + nrSteps;
        }

        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            this.position = newPosition;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + this.position.getX() + "," + this.position.getY() + "] "
                + "{" + this.currentDirection + "} "
                + this.name + "> " + this.status;
    }

    public Position getPosition() {

        return this.position;
    }

    public void setStatus(String s) {

        this.status = s;
    }
}
