import java.io.*;
import java.util.Scanner; 
import java.util.*; 
import java.lang.*;

public class QuickSort{
	public void sort(int[] a){
		qs(a, 0, a.length-1);
	}

	void qs(int[] a, int start, int end){
		if(start<end){
			int p = partition(a,start,end);
			qs(a, start, p-1);
			qs(a, p+1, end);
		}
	}

	public int partition(int[]a, int start, int end){
		int pivot = a[end];
		int small = start-1;
		int temp = 0;
		for(int i = start; i<end; i++){
			if(a[i]<pivot){
				small++;

				temp = a[small];
				a[small] = a[i];
				a[i] = temp;
			}
		}
		//swap
		int Temp = a[small+1];
		a[small+1] = a[end];
		a[end] = Temp;
		return small+1;
	}

	public static void main(String[] args) throws FileNotFoundException 
    {
        int [] arr = new int[1000000];

        File file = new File("1m-ints.txt");
        Scanner scan = new Scanner(file);

        int k = 0;
        // Reading file
        while(scan.hasNextLine())
        {
            String num = scan.nextLine();
            int sorted = Integer.parseInt(num);
            arr[k++] = sorted;

        }
        QuickSort qs = new QuickSort();
        qs.sort(arr);
        for(int n = 0; n < arr.length; n++)
        {
            System.out.println(arr[n]);
        }
        System.out.print("QuickSort runs in nanoseconds = ");
        System.out.println(System.nanoTime());
    } 
	
}