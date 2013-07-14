package com.interview.algorithms.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Verify whether an arithmatic expression is valid, suppose the expression only contains "+", "-", "*", "/", "(", ")"
 * and numbers are positive integers.
 * Created with IntelliJ IDEA.
 * User: zouzhile
 * Date: 7/14/13
 * Time: 4:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class C1_24_ExpressionValidation {

    static class Stack {

        List<Character> data = new ArrayList<Character>();

        public void push(char ch) {
            data.add(ch);
        }

        public char pop() {
            if(data.isEmpty())
                return Character.CONTROL;
            else
                return data.remove(data.size() - 1);
        }

        public boolean isEmpty() {
            return data.isEmpty();
        }

        public String toString(){
            String result = "";
            Iterator<Character> itr = this.data.iterator();
            while(itr.hasNext())
                result = itr.next() + result;
            return result;
        }
    }

    /**
     * The idea: Push the content of the expression to a stack. When see a ')', pop out stack chars until see a '(',
     * this will derives a basic expression inside a pair of parentheses. If all basic expressions are valid, then the
     * entire expression is valid.
     * @param expression
     * @return
     */
    public boolean validate(String expression) {
        expression = expression.trim().replace("\\s+", "");
        if("".equals(expression.trim())) // empty string are valid expressions
            return true;
        Stack stack = new Stack();
        for(int i = 0; i < expression.length(); i ++) {
            char current = expression.charAt(i);
            if(current == ')') {
                String subExpr = "";
                char poppedChar = stack.pop();
                while(poppedChar != Character.CONTROL && poppedChar != '(') {
                    subExpr += poppedChar;
                    poppedChar = stack.pop();
                }
                if(! this.validateBasicExpression(subExpr))
                    return false;
                else
                    stack.push('9'); // replace the original expression with a number
            } else
                stack.push(current);
        }

        return this.validateBasicExpression(stack.toString());
    }

    /*
       Basic expressions are those don't contain parentheses. There are two invalid cases:
       1) start or end with an operator
       2) continuous operator chars within the expression.
       3) unmatched '(' or ')' in the expression
     */
    private boolean validateBasicExpression(String basicExpression){
        if("".equals(basicExpression.trim()))
            return true;
        char begin = basicExpression.charAt(0);
        char end = basicExpression.charAt(basicExpression.length() - 1);
        if (this.isOperator(begin) || this.isOperator(end))
            return false;

        // check on continuous operator chars
        char previous = Character.CONTROL;
        for(int i = 0; i < basicExpression.length(); i ++) {
            char current = basicExpression.charAt(i);
            if(this.isOperator(previous) && this.isOperator(current) || this.isParentheses(current))
                return false;
            previous = current;
        }
        return true;
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private boolean isParentheses(char ch) {
        return ch == '(' || ch == ')';
    }

    public static void main(String[] args) {
        C1_24_ExpressionValidation validator = new C1_24_ExpressionValidation();
        String expression = "2+5*(2+4)";
        System.out.println(expression + ": " + validator.validate(expression));

        expression = "2+)5*(2+4)";
        System.out.println(expression + ": " + validator.validate(expression));

        expression = "2+(5*(2+4)";
        System.out.println(expression + ": " + validator.validate(expression));

        expression = "5*2";
        System.out.println(expression + ": " + validator.validate(expression));
    }
}
