package stos;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class stackTest {
    @Test
    public void testPush() {
        Stos stos = new Stos();
        stos.push(1);
        double result = stos.peek();
        assertEquals(1, result, 0.001);
    }

    @Test
    public void testPush2() {
        Stos stos = new Stos();
        stos.push(-1.3);
        double result = stos.peek();
        assertEquals(-1.3, result, 0.001);
    }

    @Test
    public void testPop() {
        Stos stos = new Stos();
        stos.push(1);
        double result = stos.pop();
        assertEquals(1, result, 0.001);
    }

    @Test
    public void testPop2() {
        Stos stos = new Stos();
        stos.push(-3.44);
        double result = stos.pop();
        assertEquals(-3.44, result, 0.001);
    }

    @Test
    public void testPeek() {
        Stos stos = new Stos();
        stos.push(2);
        stos.push(1);
        double result = stos.peek();
        assertEquals(1, result, 0.001);
    }

    @Test
    public void testPeek2() {
        Stos stos = new Stos();
        stos.push(2.67);
        stos.push(1);
        stos.pop();
        double result = stos.peek();
        assertEquals(2.67, result, 0.001);
    }

    @Test
    public void testRNP() {
        RPN onp = new RPN();
        double result = onp.count("2 3 + 5 *");
        assertEquals(25, result, 0.001);
    }

    @Test
    public void testRNP2() {
        RPN onp = new RPN();
        double result = onp.count("2 3.5 + -5.5 *");
        assertEquals(-30.25, result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRNPIllegalOperator() {
        RPN onp = new RPN();
        String pom = "5 10 $";
        onp.count(pom);
    }
}
