package ru.lessons.lesson;

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
        double resultMul = 1;
        for (double param: params){
            resultMul *= param;
        }
        result = resultMul;
    }

    /**
     * divite numbers
     * @param param1 param for divide
     * @param param2 param for divide
     */
    public void div(double param1, double param2){
        result = param1 / param2;
    }

    /**
     * subtract numbers
     * @param param1 param for subtract
     * @param param2 param for subtract
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
