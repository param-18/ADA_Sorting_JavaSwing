package pr;

public class QuickSort {

	public static void quickSort(int[] iArray, int l, int u)
    {
		if (l < u)
        {
            int pi = partition(iArray, l, u);
            quickSort(iArray, l, pi-1);
            quickSort(iArray, pi+1, u);
        }
    }

    private static int partition(int[] a , int l , int u)
    {
    	int x = a[l];
        int i = l;
        int j = u + 1;

        while (i <= j)
        {
            i++;
            //scanning left to right
            while ( i < u && a[i] <= x )
                i++;
            j--;
            //scanning right to left
            while (a[j] > x )
                j--;
            //changing intermediate positions
            if (i < j)
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        //final swapping

        a[l] = a[j];
        a[j] = x;

        return j;
    }

}
