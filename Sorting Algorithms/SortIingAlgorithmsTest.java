package ArraySort;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortIingAlgorithmsTest {

    @Test
    public void bubbleSort()
    {
        Integer[] actual   = new Integer[] {9,8,7,6,5,4,3,2,1,0};
        Integer[] expected = new Integer[] {0,1,2,3,4,5,6,7,8,9};
        assertArrayEquals(expected,SortIingAlgorithms.BubbleSort(actual));
    }

    @Test
    public void selectionSort()
    {
        Integer[] actual   = new Integer[] {9,8,7,6,5,4,3,2,1,0};
        Integer[] expected = new Integer[] {0,1,2,3,4,5,6,7,8,9};
        assertArrayEquals(expected,SortIingAlgorithms.SelectionSort(actual));
    }

    @Test
    public void insertionSort()
    {
        Integer[] actual   = new Integer[] {9,8,7,6,5,4,3,2,1,0};
        Integer[] expected = new Integer[] {0,1,2,3,4,5,6,7,8,9};
        assertArrayEquals(expected,SortIingAlgorithms.InsertionSort(actual));
    }
}