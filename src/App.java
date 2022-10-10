import sort.Sort;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class App {
    public static void printArray(int[] array){
        for(int a: array){
            System.out.println(a + " ");
        }
        System.out.println();
    }
    public static boolean isSorted(int[] array){
        for(int i = 0; i < array.length-1; i++)
        if(array[i] > array[i+1]){
        return false;
        }
        return true;
    }
    
    public static int[] readFileToArray(String filename) throws Exception {
        try {
            Scanner scanner = new Scanner(new File(filename));
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if (str != "\n") {
                    arrayList.add(Integer.parseInt(str));
                }
            }
            int[] arrayTemp = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i ++) {
                arrayTemp[i] = arrayList.get(i);
            }
            return arrayTemp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeArrayToFile(int[] array, String filename) throws IOException{
        try (FileWriter writer = new FileWriter(filename);) {
            for (int a: array) {
                writer.write(a + "\n");
            }
        }
    } 
    public static void main(String[] args) throws Exception {
       
       
     long startTime = System.currentTimeMillis();
        int array[] = Sort.createRandomArray(arrayLength);
        System.out.print("\nUnsorted Numbers:  \n" + Arrays.toString(array));
        startTime = System.currentTimeMillis();
        int sortedArray[] = Sort.mergeSort(array);
        double mergeTime = Double.valueOf((double)(System.currentTimeMillis() - startTime) / 1000D);
       
        System.out.print("\nMergeSort Numbers: \n" + Arrays.toString(sortedArray));
        System.out.println((new StringBuilder("The sorted array is in correct order: ")).append(isSorted(sortedArray)).toString());
        startTime = System.currentTimeMillis();
        Sort.bubbleSort(array);
        double bubbleTime = Double.valueOf((double)(System.currentTimeMillis() - startTime) / 1000D);
       
        System.out.print("\nBubbleSort Numbers:\n" + Arrays.toString(array));
        System.out.print("\n");

        System.out.println((new StringBuilder("\nIf sorted:  ")).append(isSorted(sortedArray)).toString());
       
        System.out.println((new StringBuilder("Same order: ")).append(Arrays.equals(sortedArray, array)).toString());
       
        System.out.printf("\nThe time of MergeSort  for size %d is %.6fs\n", new Object[] {
            Integer.valueOf(arrayLength), mergeTime});
        System.out.printf("The time of BubbleSort for size %d is %.6fs\n", new Object[] {
            Integer.valueOf(arrayLength), bubbleTime});
        System.out.println((new StringBuilder("\nBubbleSort is ")).append(String.valueOf(bubbleTime/mergeTime)).append(" times faster than MergeSort."));
       
        System.out.println("\nPlease enter the size of input array, or 0(exit):");
       
        arrayLength = sc.nextInt();
       } while(!(arrayLength==0));

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Try my new application called bubblesort, where you can make files: \n");
        System.out.println("Would you like to make new file : Please enter 2(yes) or 1(no)?: \n");
        int answerChoice = scanner.nextInt();
        String filename;
        int[] array;
        
         if (answerChoice == 1) {
             System.out.println("Please enter a filename make sure it ends with .txt for example; name.txt:");
             filename = scanner.next();
             array = readFileToArray(filename);
             bubbleSort(array);
             System.out.println("Do you want to view sorted array in file? (Enter yes or no)");
             String save = scanner.next();
             if (save.equals("yes")) {
                 writeArrayToFile(array, "bubble.txt");
                 System.out.println("The sorted array is saved in file name bubble.txt");
             } else { System.out.println("Thanks for playing!");
                 try{
                     FileInputStream fiStream = new FileInputStream(filename);
                     Scanner fileScan = new Scanner(fiStream);
                     while (fileScan.hasNextLine()){
                         System.out.printf("\t" + fileScan.hasNextLine());
                         
                         fiStream.close();
                         fileScan.close();
                 }
                  } catch (FileNotFoundException e){
                         System.out.printf("system error");
                      
                   } catch (Exception e) {
                  e.printStackTrace();
             }
             scanner.close();
             }
         } else if (answerChoice == 2) {
             System.out.println("Please enter the number of random integers you want to appear in file:");
             int number = scanner.nextInt();
             array = createRandomArray(number);
             System.out.println("Please enter the filename to save:");
             filename = scanner.next();
             if (filename == "") {
                 filename = "integers.txt";
                 try{
                         FileInputStream fiStream = new FileInputStream(filename);
                         Scanner fileScan = new Scanner(fiStream);
                         while (fileScan.hasNextLine()){
                             System.out.printf("\t" + fileScan.hasNextLine());
                             
                             fiStream.close();
                             fileScan.close();
                         }
                          } catch (FileNotFoundException e){
                             System.out.printf("system error");
                          
                         } catch (Exception e) {
                          e.printStackTrace();
                 }
             }
             writeArrayToFile(array, filename);
             bubbleSort(array);
         }
         scanner.close();
     }
 }