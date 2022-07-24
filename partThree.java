// **************************************************************** 
// partThree.java 
// 
// A program that will compute the sum and product of two square matrices. 
// The program asks the user for the file name and the output file name
// and program will write the data to the specified output file. 
//
// Mohammed Benloucif February 18, 2022          
// **************************************************************** 
import java.util.*;
import java.io.*;

public class partThree{
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		//Scanner object to read input from the user
		Scanner sc = new Scanner(System.in);

		// ask input and output file names
		String inputFile;
		System.out.print("Enter file name: ");
		inputFile = sc.next();
		String outputFile;  
		System.out.print("Enter output file name: ");
		outputFile = sc.next();
		// open input and output files
		File inFile = new File(inputFile); //Opening input file for reading 
		Scanner readFile = new Scanner(inFile);
		FileWriter writeFile = new FileWriter(outputFile);//open output file for writing
		 
		//read size of matrix
		int m;
		m = readFile.nextInt();
		//create array of size m by m
		int[][] x = new int[m][m];
		//- read m*m values into x
		for(int i = 0;i<m;i++)
		for(int j = 0;j<m;j++)
		x[i][j] = readFile.nextInt();
		  
		//m = read size of matrix
		m = readFile.nextInt();
		//y = create array of size m by m
		int[][] y = new int[m][m];
		//read m*m values into y
		for(int i = 0;i<m;i++)
		for(int j = 0;j<m;j++)
		y[i][j] = readFile.nextInt();

		//for finding the sum of the matrices
		//u = create array of size m by m
		int[][] u = new int[m][m];
		//for (i = 0 to m-1)
		for(int i = 0;i<m;i++)
		//for (j = 0 to m-1)
		for(int j = 0;j<m;j++)
		//u[i][j] = x[i][j] + y[i][j]
		u[i][j] = x[i][j] + y[i][j]; 
		                                        //print m and u
		writeFile.write(m + "\n");
		
		for(int i = 0;i<m;i++){
		for(int j = 0;j<m;j++)
		writeFile.write(u[i][j] + " ");
		writeFile.write("\n");
		}

		//for finding the product of the matrices
		//create array of size m by m
		int[][] v = new int[m][m];
		//- for (i = 0 to m-1)
		for(int i = 0;i<m;i++)
		//for (j = 0 to m-1)
		for(int j = 0;j<m;j++)
		//{
		{
	    int temp;
		temp = 0;
		//for (k = 0 to m-1)
		for (int k = 0;k<m;k++)
		//temp = temp + x[i][k]*y[k][j]
		temp = temp + x[i][k]*y[k][j];
		//v[i][j] = temp
		v[i][j] = temp;
		//}
		}
		
		writeFile.write(m + "\n");
		
		for(int i = 0;i<m;i++){                  //printing m and v
		for(int j = 0;j<m;j++)
		writeFile.write(v[i][j] + " ");
		writeFile.write("\n");
		}
		
	
		readFile.close();
		writeFile.flush();
		writeFile.close();
        sc.close();
		}
		}
