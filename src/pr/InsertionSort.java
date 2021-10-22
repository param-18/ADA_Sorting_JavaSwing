package pr;

public class InsertionSort {	
	public static void insertionSort(int[] array , int n)
	  {
	      int key = 0;
	      for(int i = 1 ; i < n ; i++)
	      {
	          key = array[i];
	          int j = i - 1;
	          while ( j >= 0 && array[j] > key)
	          {
	              array[j + 1] = array[j];
	              j--;
	          }
	          array[j + 1] = key;
	      }
	  }

}

