package Qn5SolutionOne;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest
{
    @Test
    public void counter()
    {
        String x = "xyz(abc)123", y = "x(hello)", z = "(xy)1";
        assertEquals("(abc)",Solution.Counter(x));
        assertEquals("(hello)",Solution.Counter(y));
        assertEquals("(xy)",Solution.Counter(z));
    }
}