package ArraySort;

import java.util.Arrays;
import java.util.Collections;

public class SortIingAlgorithms
{
    public static void main(String[] args) throws InterruptedException {
        System.out.println();
        System.out.println("SORT ALGORITHMS EFFICIENCY COMPARISON(10,000 Elements)");
        int size = 10000;
        Integer[] numbers = new Integer[size];
        for (int i = 0; i <= numbers.length-1; i++) {
            numbers[i] = i;
        }
        Arrays.sort(numbers,Collections.reverseOrder());
        Integer length = numbers.length;



        //BUBBLE SORT
        Thread bubble = new Thread(new Runnable() {
            @Override
            public void run() {
                long bubblestart = System.nanoTime();
                BubbleSort(numbers);
                long bubbleend = System.nanoTime();
                System.out.println("Time taken: "+(double)(bubbleend-bubblestart)/1000000+" Bubble Sort Algorithm");
            }
        });
        bubble.start();


        //SELECTION SORT
        Thread selection = new Thread(new Runnable() {
            @Override
            public void run() {
                long selectionstart = System.nanoTime();
                SelectionSort(numbers);
                long selectionend = System.nanoTime();
                System.out.println("Time taken: "+(double)(selectionend-selectionstart)/1000000+" Selection Sort Algorithm");
            }
        });
        selection.start();

        //INSERTION SORT
        Thread insert = new Thread(new Runnable() {
            @Override
            public void run() {
                long insertionstart = System.nanoTime();
                InsertionSort(numbers);
                long insertionend = System.nanoTime();
                System.out.println("Time taken: "+(double)(insertionend-insertionstart)/1000000+" Insertion Sort Algorithm");
            }
        });
        insert.start();


        //MERGE SORT
        Thread merge = new Thread(new Runnable() {
            @Override
            public void run() {
                long mergestart = System.nanoTime();
                MergeFunction(numbers,length);
                long mergeend = System.nanoTime();
                System.out.println("Time taken: "+(double)(mergeend-mergestart)/1000000+" Merge Sort Algorithm");
            }
        });
        merge.start();


        bubble.join();
        selection.join();
        insert.join();
        merge.join();


    }

    public static Integer[] BubbleSort(Integer[] numbers)
    {
        for (int i = 0; i < numbers.length-1; i++)
        {
            for (int j = i+1 ; j < numbers.length; j++) {
                if (numbers[i] > numbers[j])
                {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        return numbers;
    }

    public static Integer[] SelectionSort(Integer[] numbers)
    {
        for (int i = 0; i < numbers.length-1; i++)
        {
            int minvalue = i;
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[j]<numbers[minvalue])
                    minvalue = j;
                int temp = numbers[minvalue];
                numbers[minvalue] = numbers[i];
                numbers[i] = temp;
            }
        }
        long end = System.nanoTime();
        return numbers;
    }

    public static Integer[] InsertionSort(Integer[] numbers)
    {
        for (int i = 0; i < numbers.length; i++)
        {
            int num = numbers[i];
            int j = i - 1;
            while(j>=0 && numbers[j]>num)
            {
                numbers[j+1] = numbers[j];
                j = j - 1;
            }
            numbers[j + 1] = num;
        }
        return numbers;
    }

    public static void MergeFunction(Integer[] a, Integer n)
    {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Integer[] l = new Integer[mid];
        Integer[] r = new Integer[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        MergeFunction(l, mid);
        MergeFunction(r, (n - mid));
        merge(a, l, r, mid, n - mid);
    }

    public static void merge(Integer[] Original,Integer[] l,Integer[] r,Integer left,Integer right)
    {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right)
        {
            if (l[i] <= r[j])
            {
                Original[k++] = l[i++];
            }
            else
            {
                Original[k++] = r[j++];
            }
        }
        while (i < left)
        {
            Original[k++] = l[i++];
        }
        while (j < right)
        {
            Original[k++] = r[j++];
        }
    }
}
