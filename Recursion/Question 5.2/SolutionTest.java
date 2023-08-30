package Qn5SolutionTwo;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void solve()
    {
        assertEquals("(abc)",Solution.Solve("xyz(abc)123"));
        assertEquals("(hello)",Solution.Solve("x(hello)"));
        assertEquals("(xy)",Solution.Solve("(xy)1"));
    }
}