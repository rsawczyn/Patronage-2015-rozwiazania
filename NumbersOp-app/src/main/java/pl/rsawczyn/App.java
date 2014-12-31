package pl.rsawczyn;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
Dany jest plik o nazwie dane.txt, zawieraj¹cy listê liczb (np. jakaœ waluta) z przedzia³u: (-99999999,999, 99999999,999) 
rozdzielonych znakiem koñca linii np. dane.txt (wszystkie s¹ poprawne):
0.123
-0.55
0.1
1
-1.123
10.234
-999.999

Utwórz projekt mavenowy, zawieraj¹cy aplikacjê konsolow¹, wyœwietlaj¹c¹ na stdout:

   - Posortowan¹ rosn¹co listê liczb z pliku dane.txt
   - Sumê
   - Œredni¹ arytmetyczn¹
   
 */
public class App 
{
	
	private ArrayList <Double> numbers; 
	
	public App (String filename) throws FileNotFoundException
	{
		Scanner reader = new Scanner(new File(filename));
		this.numbers = new ArrayList<Double>();
		
		while(reader.hasNext())
		{
			this.numbers.add(Double.parseDouble(reader.next()));
		}	
		reader.close();
	}
	
	
    public static void main( String[] args )
    { 
    	try 
    	{
    		App numbersSetOperator = new App("dane.txt");
    		
    		ArrayList<Double> arrListNum = numbersSetOperator.getArrayList();
    		System.out.println("Po odczytaniu z pliku:");
    		for(double nb: arrListNum)
        	{
    			System.out.println(nb);
      	    }
    		
    		numbersSetOperator.sort();
    		
    		arrListNum = numbersSetOperator.getArrayList();
    		System.out.println("\nPo sortowaniu (rosn¹co):");
    		for(double nb: arrListNum)
        	{
    			System.out.println(nb);
      	    }
    		
    		System.out.println("\nLiczba elementów: " + numbersSetOperator.getSize()); 		
    		System.out.println("Suma: " + numbersSetOperator.sum());		
    		System.out.println("Œrednia arytmetyczna: " + numbersSetOperator.average());
    		
    		
    	}
    	catch(FileNotFoundException  e)
    	{
    		System.out.println("File Not Found");
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}    
    	
    }
    
    public void sort()
    {
    	Collections.sort(this.numbers);
    }
    
    public double sum()
    {
    	double sum = 0;
    	for(double nb: this.numbers)
    	{
  			sum += nb;
  	    }
    	return sum;
    }
    
    public double average()
    {
    	return sum()/getSize();
    }
	public int getSize()
	{
		return this.numbers.size();
	}
	
    public ArrayList <Double> getArrayList()
    {
    	return this.numbers;
    }

}
