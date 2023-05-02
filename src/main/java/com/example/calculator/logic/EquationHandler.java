/*
Arouchian, Daryl
9/30/2018
*/
package com.example.calculator.logic;

public class EquationHandler {

    private Answer answer;
    private Operand currentOperand = Operand.NONE;
    public static final double pi = Math.PI;


    public Double performPreviousOperand(Double num) {
        switch(currentOperand) {
            case ADD:
                return add(num);
            case DIVIDE:
                try {
                    return divide(num);
                } catch (DivideByZeroException e) {
                    return null;
                }
            case MULTIPLY:
                return multiply(num);
            case SUBTRACT:
                return subtract(num);
            case EQUALS:
                if(returnAnswer() == num) {
                    return returnAnswer();
                } else {
                    answer = new SimpleAnswer(num);
                    return returnAnswer();
                }
            case NONE:
                answer = new SimpleAnswer(num);
                return returnAnswer();
            default:
                return null;
        }
    }

    public void setOperand(Operand operand) {
        currentOperand = operand;
    }

    private double returnAnswer() {
        if(answer == null) {
            return 0.0;
        }

        return answer.getAnswer();
    }

    public double add(double num) {
        if(answer == null) {
            answer = new SimpleAnswer(num);
        } else {
            answer = new SimpleAnswer(answer.getAnswer() + num);
        }

        return answer.getAnswer();
    }

    public double subtract(double num) {
        if(answer == null) {
            answer = new SimpleAnswer(num);
        } else {
            answer = new SimpleAnswer(answer.getAnswer() - num);
        }

        return answer.getAnswer();
    }

    public double multiply(double num) {
        if(answer == null) {
            answer = new SimpleAnswer(num);
        } else {
            answer = new SimpleAnswer(answer.getAnswer() * num);
        }

        return answer.getAnswer();
    }

    public double divide(double num) throws DivideByZeroException {
        if(answer == null) {
            answer = new SimpleAnswer(num);
        } else {
            if(num == 0.0) {
                throw new DivideByZeroException();
            } else {
                answer = new SimpleAnswer(answer.getAnswer() / num);
            }
        }

        return answer.getAnswer();
    }

//    public double factorial(double n) {
//        answer = new SimpleAnswer(factorialInternal(n));
//        return answer.getAnswer();
//    }
//
//    private double factorialInternal(double n) {
//        if(n == 1 || n < 0) {
//            return n;
//        }
//
//        return n * factorialInternal(n-1);
//    }

    public void clear() {
        answer = null;
        currentOperand = Operand.NONE;
    }

    public double getAnswer() {
        return returnAnswer();
    }
}
