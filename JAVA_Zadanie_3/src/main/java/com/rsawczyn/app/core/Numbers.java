package com.rsawczyn.app.core;

import java.util.Scanner;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

public class Numbers {
	
	private ArrayList <BigDecimal> numbers = new ArrayList<BigDecimal>(); 

    public Numbers(String filename) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(filename));
		this.numbers = new ArrayList<BigDecimal>();
		
		while(reader.hasNext())
		{
			BigDecimal bg = new BigDecimal(reader.next());
			this.numbers.add(bg.setScale(3,BigDecimal.ROUND_HALF_UP));
		}	
		reader.close();
    }

    public void addNumber(BigDecimal content) {
		this.numbers.add(content.setScale(3,BigDecimal.ROUND_HALF_UP));
    }
	
    public ArrayList <BigDecimal> getList() {
        return this.numbers;
    }
	
	public ArrayList <BigDecimal> doSort()
	{
		ArrayList <BigDecimal> nb = new ArrayList<BigDecimal>(this.numbers);
		Collections.sort(nb);
		return nb;
	}
	
	public BigDecimal sum()
    {
    	BigDecimal sum = new BigDecimal("0");
		sum.setScale(3,BigDecimal.ROUND_HALF_UP);
    	for(BigDecimal nb: this.numbers)
    	{
  			sum =  sum.add(nb);
  	    }
    	return sum;
    }
	
	public BigDecimal average()
    {
		BigDecimal size = new BigDecimal(this.numbers.size());
		if (size.setScale(3, BigDecimal.ROUND_HALF_UP).signum() != 0)
			return sum().divide(size,BigDecimal.ROUND_HALF_UP);
		else
			return size;
    }
}