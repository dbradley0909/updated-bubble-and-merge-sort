package sort;
import java.util.Arrays;
import java.util.Random;

public class Sort {
   
    public static int[] createRandomArray(int arrayLength) {
        Random random = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
        array[i] = random.nextInt(100);
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int a : array) {
            System.out.printf("%d ", a);
        }
        System.out.println();
    }
    
    public static void bubbleSort(int[] array){
        for (int i = array.length -1; i > 0 ; i--){
        for (int j = 0; j < i ; i++){
        if(array[j] >= array[j+1]){
        int temp = array[j];
        array[j] = array[j+1];
        array[j] = temp;
     }
     }
     printArray(array);
     }
    }

// tried to look up a different way to mofify code and not copy someone else code but had trouble finding and comparing for merge sort method
    public static int[] mergeSort(int[] array){
        int alength = array.length;
        if (alength <= 2){
        return array;
        }
        int arrayLength1 = alength/2;
        int [] array1 = Arrays.copyOfRange(array,0, arrayLength1);
        int [] array2 = Arrays.copyOfRange(array,arrayLength1, alength);
    
        array1 = mergeSort(array1); array2 = mergeSort(array2);
        int[] mergedArray = merge(array1, array2);  
        return mergedArray;
        }
        
    
    public static int[] merge(int[] array1, int[] array2) {
        int [] mergedArray = new int[array1.length + array2.length];
         int i = 0, j = 0, k = 0;
         while(j < array1.length && k < array2.length){
            if(array1[j] <= array2[k]){
            mergedArray[k] = array1[j];
            k++;
            }else{
            mergedArray[i] = array2[k];
            j++;
            }
            i++;
         }
         while(j < array1.length){
            mergedArray[i] = array1[j];
            j++;
            i++;
            }
         while(k < array1.length){
            mergedArray[i] = array2[k];
            k++;
            i++;
            }
         return mergedArray;
    }

}
