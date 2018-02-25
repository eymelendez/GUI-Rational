package edu.pupr.myrationalgui;

import java.util.*;
import java.util.Scanner;


public class Rational 
{
	// Scanner used for user input.
	
	static Scanner userInput = new Scanner(System.in);

	private int numerator; // Denominator the Rational Number
	private int denominator; // Numerator of Rational
   
    
    // Default Constructor
    public Rational() 
    {
		this(0,1);
    	
    }
    
    // Parameter Constructor
    public Rational(int a, int b) 
    {
    	setNumerator(a);
    	setDenominator(b);
    }
	
    /** Here starts the setter for the rational class
     * 
     * @param passes the value of numerator to a.
     */
    
    public void setNumerator(int a) throws ArithmeticException
    {
    	
    	numerator = a;
    	
    	// This is a verification for the denominator which can't be a zero.
    	if (numerator == 0) 
    	{
    		denominator = 1;
    	}
    }
    
    
    /**
     * 
     * @param b : Passed the denominator to the variable b and if the denominator is equal to 0, 
     * 			  it will execute an Arithmetic Exception.
     */
    
    public void setDenominator(int b) 
    {
    	/*if(denominator == 0) 
    	{
    		throw new ArithmeticException("A ZERO denominator can't be entered.");
    	}*/
    	
    	denominator = b;
    }
    
    /**
     * 
     * @return The numerator is returned.
     */
    
    public int getNumerator() 
    {
    	return numerator;
    }
    
    /**
     * 
     * @return The denominator is returned.
     */
    public int getDenominator()
    {
    	return denominator;
    }
    
 // The GDC (Greatest Common Divider) is used in combination with the Simplify Method to determine the number used to make 
 // the fraction smaller but remaining the same value.
    

    public void GCD(Rational g1) 
    {
    	int temp = 1, a = g1.getNumerator(), b = g1.getDenominator();
    	
    	if (a < 0)
    	{
    		a *= 1;
    	}
    	
    	else if (b < 0) 
    	{
    		b *= -1;
    	}

    	while (b > 0)
    	{
    		temp = b;
    		b = a % temp;
    		a = temp;
    	}
    	
    	/* Prints a message specifying the GDC used to simplify the fraction. The number that appears here is being 
    	 * used to reduce the fraction to a smaller number. */
    	
    	System.out.print("The Fraction (");
    	System.out.print(g1.getNumerator()); 
    	System.out.print(" / ");
    	System.out.print(g1.getDenominator());
    	System.out.print(") can be simplified to (");
    	System.out.print(g1.getNumerator() / temp);
    	System.out.print(" / ");
    	System.out.print(g1.getDenominator() / temp);
    	System.out.print(") using the GDC ");
    	System.out.print(temp);
    	System.out.print(".\n\n");
    	
    }

    // Simplify is being used with the GCD method in order to simplify the fraction.
    
    public int Simplify(int a, int b) 
    {

    	// Rational sim;

    	int temp = 1, x, y, r;

    	if (a > b) 
    	{
    		x = a;
    		y = b;
    	}
    	
    	else
    	{
    		x = b;
    		y = a;

    	}
    	
    	while (y != 0) 
    	{
    		r = x % y;
    		x = y;
    		y = r;
    	}

    	return x;
    }
    
    /**
     * 
     * @param Add Method - Does the add method with 2 rational numbers. Uses three variables, 
     * 		  Num1, Num2, and cd are variables that are used to do the add method by the correct way as if you were using a calculator.
     * 		  That is why the "denominator must be equal in order to be summed or subtracted" does NOT apply in this case.
     * 
     *  cd means common divider.
     */
    
    public Rational Add(Rational a1)
    {
    	
    	/**
    	 * @param
    	 */
    	
    	int cd = getDenominator() * a1.getDenominator();
    	int Num1 = getNumerator() * a1.getDenominator();
    	int Num2 = a1.getNumerator() * getDenominator();
    	
    	
    	/*System.out.print("SUM: (");
    	System.out.print(getNumerator());
    	System.out.print(" / ");
    	System.out.print(getDenominator());
    	System.out.print(") + (");
    	System.out.print(a1.getNumerator());
    	System.out.print(" / ");
    	System.out.print(a1.getDenominator());
    	System.out.print(") = (");
    	System.out.print(Num1 + Num2 / Simplify(Math.abs(Num1 + Num2), Math.abs(cd)));
    	System.out.print(" / ");
    	System.out.print(cd / Simplify(Math.abs(Num1 + Num2), Math.abs(cd)));
    	System.out.print(")");
    	System.out.print("\n\n");*/
   

    	return new Rational(Num1 + Num2, cd);
    }
    
    /**
     * 
     * @param Subtract Method - Does the subtract method with 2 rational numbers. Uses three variables, 
     * 		  Num3, Num4, and cds are variables that are used to do the subtracted method by the correct way as if you were using a calculator.
     * 		  That is why the "denominator must be equal in order to be summed or subtracted" rule of math does NOT apply in this case.
     * 
     *  cds means common divider for the subtract method.
     */
    
    public Rational Subtract(Rational s1) 
    {
    	int cds = getDenominator() * s1.getDenominator();
    	int Num3 = getNumerator() * s1.getDenominator();
    	int Num4 = s1.getNumerator() * getDenominator();
    	
    	
    	/*System.out.print("SUBTRACTION: (");
    	System.out.print(getNumerator());
    	System.out.print(" / ");
    	System.out.print(getDenominator());
    	System.out.print(") - (");
    	System.out.print(s1.getNumerator());
    	System.out.print(" / ");
    	System.out.print(s1.getDenominator());
    	System.out.print(") = (");
    	System.out.print(Num3 - Num4 / Simplify(Math.abs(Num3 - Num4), Math.abs(cds)));
    	System.out.print(" / ");
    	System.out.print(cds / Simplify(Math.abs(Num3 - Num4), Math.abs(cds)));
    	System.out.print(")");
    	System.out.print("\n\n");*/
    	
    	return new Rational(Num3 - Num4, cds);
    }
    
    /**
     * 
     * @param Multiply Method - Does the Multiply method with 2 rational numbers. Uses two variables, 
     * 		  Num5, and cdm are variables that are used to do the multiply method by the correct way as if you were using a calculator.
     * 		 
     * 
     *  cdm means common divider for the multiply method.
     */
    
    public Rational Multiply(Rational m1) 
    {
    	int cdm = getDenominator() * m1.getDenominator();
    	int Num5 = getNumerator() * m1.getNumerator();
    	
    	System.out.print("MULTIPLY: (");
    	System.out.print(getNumerator());
    	System.out.print(" / ");
    	System.out.print(getDenominator());
    	System.out.print(") * (");
    	System.out.print(m1.getNumerator());
    	System.out.print(" / ");
    	System.out.print(m1.getDenominator());
    	System.out.print(") = (");
    	System.out.print(Num5 / Simplify(Math.abs(Num5), Math.abs(cdm)));
    	System.out.print(" / ");
    	System.out.print(cdm / Simplify(Math.abs(Num5), Math.abs(cdm)));
    	System.out.print(")");
    	System.out.print("\n\n");
    	
    	return new Rational(Num5, cdm);
    }
    
    /**
     * 
     * @param Divide Method - Does the divide method with 2 rational numbers. Uses two variables, 
     * 		  Num5, and cdm are variables that are used to do the Divide method by the correct way as if you were using a calculator.
     * 		 
     * 
     *  cdd means common divider for the divide method.
     */
    
    public Rational Divide(Rational d1) 
    {
    	int cdd = getDenominator() * d1.getNumerator();
    	int Num6 = getNumerator() * d1.getDenominator();
    	
    	System.out.print("DIVISION: (");
    	System.out.print(getNumerator());
    	System.out.print(" / ");
    	System.out.print(getDenominator());
    	System.out.print(") / (");
    	System.out.print(d1.getNumerator());
    	System.out.print(" / ");
    	System.out.print(d1.getDenominator());
    	System.out.print(") = (");
    	System.out.print(Num6 / Simplify(Math.abs(Num6), Math.abs(cdd)));
    	System.out.print(" / ");
    	System.out.print(cdd / Simplify(Math.abs(Num6), Math.abs(cdd)));
    	System.out.print(")");
    	System.out.print("\n\n");
    	
    	return new Rational(Num6, cdd);
    }
    
    /**
     * 
     * @param DisplayFract method - Displays the fraction as normal.
     */
    
    public final void DisplayFract(Rational f1) 
    {
    	
    	System.out.print("DISPLAY FRACTION: ");
    	System.out.print(f1.getNumerator());
    	System.out.print(" / ");
    	System.out.print(f1.getDenominator());
    	System.out.print("\n\n");
    }
    
    
    /**
     * 
     * @param DisplayFloat Method - Displays the fraction that appears in the DisplayFract as a whole number with decimal points.
     */
    
    public final void DisplayFloat(Rational f2) 
    {
    	double q1 = (double)f2.getNumerator();
    	double q2 = (double)f2.getDenominator();
    	
    	System.out.print("DISPLAY DECIMAL OF FRACTION: ");
    	System.out.print(f2.getNumerator());
    	System.out.print(" / ");
      	System.out.print(f2.getDenominator());  	
      	System.out.print(" = ");
      	System.out.print(q1 / q2);
      	System.out.print("\n");
    }
    
    /**
     *  askUser - It asks the user for the required information, in this cases the numbers used for the fraction methods.
     */
    
    public void askUser() 
    {
    	
    	int a = 0, b = 1;
    	
    	Rational F1 = new Rational();
    	Rational F2 = new Rational();
    	
    	System.out.println("Welcome to the Rational Java Program! \n");
    	
    	System.out.println("IMPORTANT! All values will be display in simplified form. If you want the original values,");
    	System.out.println("you need to multiply by the number specified in the GDC.\n\n");
    	
    	
    	System.out.println("Enter the numerator of the first fraction: ");
    	a = userInput.nextInt();
    	
    	F1.setNumerator(a);
    	
    	System.out.println("Enter the denominator of the first fraction: ");
    	b = userInput.nextInt();
    
    	F1.setDenominator(b);
    	
    	System.out.println("Enter the numerator of the second fraction: ");
    	a = userInput.nextInt();
    	
    	F2.setNumerator(a);
    	
    	System.out.println("Enter the denominator of the second fraction: ");
    	b = userInput.nextInt();
    	
    	F2.setDenominator(b);
    	
    	System.out.println("\n");
    	
    	// Math Methods
    	
    	F1.Add(F2);
    	F1.Subtract(F2);
    	F1.Multiply(F2);
    	F1.Divide(F2);
    	F1.GCD(F2);
    	
    	// Display
    	F1.DisplayFract(F1);
    	F1.DisplayFloat(F1);
    }
    
    /**
     * 
     * @return 0 - Is being used as a "shut down program" if the user enter's a character instead of a number.
     */
    
    public static int checkValidNumber() 
    {
    	try 
    	{
    		return userInput.nextInt();
    	}
    	
    	catch(InputMismatchException e) 
    	{
    		userInput.next();
    		System.out.println("That isn't a whole number");
    		return 0;
    	}
    }
    

    @Override 
    public String toString() 
    {
    	float numeratorFloat = getNumerator();
    	float denominatorFloat = getDenominator();
    	
    	float result = numeratorFloat / denominatorFloat;
    	
    	return String.format("%d / %d = %.2f", numerator, denominator, result);
    	
    }

}