package ru.lessons.lesson;

/**
 * Created by VitAl on 13.03.2018.
 */
public class Calculator {

    private double result = 0;

    /**
         * add numbers
         * @param params - arguments for add
     */
    public void add(double... params){
        for (double param: params){
            result += param;
        }
    }

    /**
     * multiply numbers
     * @param params - arguments for multiply
     */
    public void mul(double... params){
        for (double param: params){
            result *= param;
        }
    }

    /**
     * divite numbers
     * @param param1
     * @param param2
     */
    public void div(double param1, double param2){
        result = param1 / param2;
    }

    /**
     * subtract numbers
     * @param param1
     * @param param2
     */
    public void sub(double param1, double param2){
        result = param1 - param2;
    }

    /**
     * clean result of calculation
     */
    public void cleanResult(){
        result = 0;
    }

    /**
     * get result
     * @return result of calculation
     */
    public double getResult() {
        return result;
    }
}
