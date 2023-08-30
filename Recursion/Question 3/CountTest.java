package Qn3;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountTest
{
    @Test
    public void counter()
    {
        assertEquals(4, Count.Counter("xxhixx"));
        assertEquals(3, Count.Counter("xhixhix"));
        assertEquals(0, Count.Counter("hi"));
    }

}