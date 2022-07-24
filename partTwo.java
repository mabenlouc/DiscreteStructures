// **************************************************************** 
// partTwo.java 
// 
// A program that will decide whether a function is one to one, onto, bijective. 
// The program asks the user for the file name and program will write the data 
// to a file "output.txt". 
//
// Mohammed Benloucif February 18, 2022          
// **************************************************************** 
import java.io.*;
import java.util.*;

public class partTwo {

    public static void main(String[] args) throws Exception{ 
    	Scanner sc = new Scanner(System.in);
	    System.out.print("Enter file name: ");   //get input filename for sets
        String filename = sc.nextLine();  
        //for taking input and output from file
        File outputFile = new File("output.txt");
        File file = new File(filename);                //open file reader
        Scanner in = new Scanner(file); 
        PrintWriter out = new PrintWriter(outputFile); //open output file for writing
      
        //taking input from file
        int x,y,num;
        x = in.nextInt();

        int domain[] = new int[x];

        for(int i = 0;i<x ;i++)
        {
          domain[i] = in.nextInt();

        }

        y = in.nextInt();

        int codomain[] = new int[y];

        for(int i = 0;i<y ;i++)
        {
          codomain[i] = in.nextInt();

        }
       num = in.nextInt();

        int mapping[][] = new int[num][2];

        for(int i = 0;i<num;i++)
        {
          mapping[i][0] = in.nextInt();
          mapping[i][1] = in.nextInt();

        }

    boolean one_to_one,onto;
    one_to_one = onto = true; 
    //checking for one-one 
    for(int i = 0;i<num;i++)
    {
      for(int j = i+1;j<num ;j++)
      {
         if(mapping[i][1]==mapping[j][1]&&mapping[i][0]!=mapping[j][1])
         {
            one_to_one = false;
         }
      }
    }
    //checking for onto 
    for(int i = 0;i<y;i++)
    {
      boolean found =  false;
      for(int j = 0;j<num ;j++)
      {
         if(mapping[j][1]==codomain[i])
         {
            found = true;
         }
      }
      //if value has no image:
      if(found==false)
         onto = false;
    }


    if(one_to_one==true)    //if it is one to one
    {
      out.println("Function is one to one ");
    }
    else
    {
      out.println("Function is not one to one "); // if not

    }

    if(onto==true) //if it is onto
    {
      out.println("Function is onto ");
    }
    else
    {
      out.println("Function is not onto ");  //if not

    }
    if(one_to_one==true&&onto==true) //if it is bijective
    {
      out.println("Function is bijective ");
    }
    else
    {
      out.println("Function is not bijective ");   //if not

    }
    out.close();
    in.close();
    sc.close();
   }
}