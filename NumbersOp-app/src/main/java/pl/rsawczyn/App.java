package pl.rsawczyn;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
Dany jest plik o nazwie dane.txt, zawieraj�cy list� liczb (np. jaka� waluta) z przedzia�u: (-99999999,999, 99999999,999) 
rozdzielonych znakiem ko�ca linii np. dane.txt (wszystkie s� poprawne):
0.123
-0.55
0.1
1
-1.123
10.234
-999.999

Utw�rz projekt mavenowy, zawieraj�cy aplikacj� konsolow�, wy�wietlaj�c� na stdout:

   - Posortowan� rosn�co list� liczb z pliku dane.txt
   - Sum�
   - �redni� arytmetyczn�
   
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
    		System.out.println("\nPo sortowaniu (rosn�co):");
    		for(double nb: arrListNum)
        	{
    			System.out.println(nb);
      	    }
    		
    		System.out.println("\nLiczba element�w: " + numbersSetOperator.getSize()); 		
    		System.out.println("Suma: " + numbersSetOperator.sum());		
    		System.out.println("�rednia arytmetyczna: " + numbersSetOperator.average());
    		
    		
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
