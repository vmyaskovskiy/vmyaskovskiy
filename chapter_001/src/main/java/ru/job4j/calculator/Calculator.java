
package ru.job4j.calculator;

 /**
 * Class Calculator решение задачи части 001 - урок Элементарный калькулятор 3.1.
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */ 

public class Calculator {
    private double result;

    /**
    * Method add.
    * @param  first,  second.
    */
	
    public void add(double first, double second)
    {
        this.result = first + second;
    }
	
	/**
    * Method subtract.
    * @param first,  second.
    */

    public void subtract(double first, double second) {
        this.result = first - second;
    }
    
	/**
    * Method div.
    * @param first,  second.
    */
	
    public void div(double first, double second) {
        this.result = first / second;
    }
	
	
	/**
    * Method multiple.
    * @param first,  second.
    */

    public void multiple(double first, double second) {
        this.result = first * second;
    }
	
	/**
    * Method getResult.
    * @return this.result.
    */

    public double getResult() {
        return this.result;
    }

}
