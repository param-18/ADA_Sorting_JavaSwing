package pr;

public class CountingSort {
    public static void countingSort(int[] iArray,int[] oArray , int maxNum)
    {
        int[] tempArray = new int[maxNum + 1];
        //initializing with zero
        for( int i = 0 ; i <= maxNum ; i++)
        {
            tempArray[i] = 0;
        }
        //increase value of count
        for(int i = 0; i < iArray.length; i++)
        {
            ++tempArray[iArray[i]];
        }
        //cumulative sum
        for(int i = 1; i <= maxNum; i++)
        {
            tempArray[i] += tempArray[i - 1];
        }

        //sorting according to tempArray Positions

        for(int i = iArray.length -1 ; i >= 0; i--)
        {
            oArray[--tempArray[iArray[i]]] = iArray[i];
        }
    }

}
