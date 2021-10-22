package pr;

public class MergeSort {
    private static void merge(int[] a, int l, int m, int r)
    {
        int[] b = new int[r + 1];
        int i, j, k;
        i = k = l;
        j = m + 1;

        while (i <= m && j <= r)
        {
            if (a[i] <= a[j])
                b[k++] = a[i++];
            else
                b[k++] = a[j++];
        }
        while (i <= m)
            b[k++] = a[i++];
        while (j <= r)
            b[k++] = a[j++];

        for (i = l; i <= r; i++)
            a[i] = b[i];
    }
    public static void mergesort(int[] a, int l, int r)
    {
        if (l < r)
        {
            int m = (l + r) / 2;
            mergesort(a, l, m);
            mergesort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

}


