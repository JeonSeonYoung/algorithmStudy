package algorithm.study.stack;

import java.util.ArrayList;
import java.util.List;

public class PostFix {

    private Stack<String> operators;
    private List<String> postfixElements;

    public PostFix(int size) {
        operators = new Stack<>(size);
        postfixElements = new ArrayList<>();
    }

    public PostFix process(String infix) {
        operators.clear();
        postfixElements.clear();

        for (int i = 0; i < infix.length(); ) {
            int nextIdx = nextIdx(infix, i);
            String c = infix.substring(i, nextIdx);
            i = nextIdx;

            if (isNum(c))
                postfixElements.add(c);
            else if (isFundamentalOperation(c)) {
                while (!hasPrecedence(c))
                    postfixElements.add(operators.pop());
                operators.push(c);
            } else if (c.equals(")"))
                postfixElements.addAll(extractOperandsBetween());
            else if (c.equals("("))
                operators.push(c);
        }

        while (!operators.isEmpty())
            postfixElements.add(operators.pop());

        return this;
    }

    private int nextIdx(String infix, int i) {
        String c = infix.substring(i, i + 1);
        if (!isNum(c))
            return Math.min(i + 1, infix.length());
        while (isNum(c)) {
            i++;
            if (i >= infix.length() - 1) break;
            c = infix.substring(i, i + 1);
        }
        return Math.min(i, infix.length());
    }

    public PostFix print() {
        System.out.println(postfixElements);
        return this;
    }

    public int compute() {
        int result = 0;
//        Stack<Character> operandCache = new Stack<>(size);
//        char element = postfixElements.pop();
//        if (isNum(element))
//            operandCache.push(element);
//        else { // operator
//            if (element == '+') result += operandCache.pop() + operandCache.pop();
//            if (element == '-') result += operandCache.pop() - operandCache.pop();
//            if (element == '*') result += operandCache.pop() * operandCache.pop();
//            if (element == '/') result += operandCache.pop() / operandCache.pop();
//        }
        return result;
    }


    private List<String> extractOperandsBetween() {
        List<String> operands = new ArrayList<>();
        while (!operators.peek().equals("("))
            operands.add(operators.pop());
        operators.pop(); // remove (
        return operands;
    }

    private boolean isFundamentalOperation(String c) {
        return c.equals("+") ||
                c.equals("-") ||
                c.equals("*") ||
                c.equals("/");
    }

    private boolean hasPrecedence(String c) {
        if (operators.isEmpty()) return true;
        String operator = operators.peek();
        if (!isFundamentalOperation(operator)) return true;
        return (operator.equals("+") || operator.equals("-"))
                && (c.equals("*") || c.equals("/"));
    }

    private boolean isNum(String c) {
        try {
            int i = Integer.parseInt(c);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // test client
    public static void main(String[] args) {
        System.out.println(
                new PostFix(1000).process("11*222+3").print().compute()
        );
        System.out.println(
                new PostFix(1000).process("1*(2+3)").print().compute()
        );
        System.out.println(
                new PostFix(1000).process("1*(22+3*4)+5").print().compute()
        );
        System.out.println(
                new PostFix(1000).process("(2+51)*3*(2+1)").print().compute()
        );


    }
}
