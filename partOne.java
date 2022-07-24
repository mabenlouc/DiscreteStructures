// **************************************************************** 
// partOne.java 
// 
// A program that will compute the union and the intersection of two sets. 
// The program asks the user for the file name and program will write the data 
// to a file "output.txt". 
//
// Mohammed Benloucif February 18, 2022          
// **************************************************************** 
import java.util.*;
import java.io.*;

public class partOne {
	
   static Set<Integer> set1;          
   static Set<Integer> set2;
   public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       System.out.print("Enter file name: ");   //get input filename for sets
       String filename = sc.nextLine();
       readData(filename);

       Set<Integer> union = (new HashSet<Integer> (set1));
       union.addAll(set2);                                //union

       Set<Integer> intersection = (new HashSet<Integer> (set1));
       intersection.retainAll(set2);                      //intersection

       writeData(intersection, union, "output.txt" );       //write output to file
       sc.close();
   }

   public static void readData(String filename) throws Exception{
      set1 =    new HashSet<Integer> ();        //creating the first set
      set2 =    new HashSet<Integer> ();        //creating second set
 
          File file = new File(filename);                //open file reader
          Scanner sc = new Scanner(file);                //text file scanner object
          int n = sc.nextInt();                           //read size of the set
          int element;
          for (int i = 0; i<n; i++) {                    //read all elements up to size of the set 
              element = sc.nextInt();           //integer in the set is made an element
              set1.add(element);                //add the elements to the previously created set1
          }                       
          n = sc.nextInt();                              //read the size of set2
          for (int i = 0; i<n; i++) {                    //read all elements up to size of the set
              element = sc.nextInt();                    //integer in the set is made an element
              set2.add(element);                     //add the elements to the previously created set2
          }

          sc.close();                   //close the scanner
   }
   public static void writeData(Set<Integer> intersection, Set<Integer> union, String filename) throws Exception {

           FileWriter file = new FileWriter(filename); //open output file for writing

           file.write(union.size() + "\n");               //write union to file
           for (int value: union)
               file.write(value + " ");
          
           file.write("\n" + intersection.size() + "\n");   //write intersection to file
           for (int value: intersection)
               file.write(value + " ");

           file.close();   
   }
}
