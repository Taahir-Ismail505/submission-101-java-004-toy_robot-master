package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PositionTest {
    @Test
    public void shouldKnowXandY() {
        Position p = new Position(10, 20);
        assertEquals(10, p.getX());
        assertEquals(20, p.getY());

    }

    @Test
    void initialPosition() {
        Robot robot = new Robot("CrashTestDummy");
        assertEquals(Robot.CENTRE, robot.getPosition());
        assertEquals(Direction.NORTH, robot.getCurrentDirection());
    }

    @Test
    public void insideRectangularRegion() {
        Position topLeft = new Position(-20, 20);
        Position bottomRight = new Position(20,-20);
        assertTrue((new Position(10,10)).isIn(topLeft, bottomRight), "should be inside");
        assertFalse((new Position(10,30)).isIn(topLeft, bottomRight), "should be beyond top boundary");
        assertFalse((new Position(10,-30)).isIn(topLeft, bottomRight), "should be beyond bottom boundary");
        assertFalse((new Position(30,10)).isIn(topLeft, bottomRight), "should be beyond right boundary");
        assertFalse((new Position(-30,10)).isIn(topLeft, bottomRight), "should be beyond left boundary");
    }
}
