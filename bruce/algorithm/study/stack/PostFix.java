package algorithm.study.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostFix {

    private String infixExpression;
    private Stack<String> operators;
    private List<String> postfixElements;

    private int size;

    public PostFix(int size) {
        this.size = size;
        operators = new Stack<>(size);
        postfixElements = new ArrayList<>();
    }

    public PostFix process(String infix) {
        operators.clear();
        postfixElements.clear();
        infixExpression = infix;

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
                postfixElements.addAll(extractOperatorsBetween());
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
        System.out.println("infix :\t\t" + infixExpression);
        System.out.println(
                "postfix :\t" +  postfixElements.stream().collect(Collectors.joining(" "))
        );
        return this;
    }

    public String compute() {
        Stack<String> operandCache = new Stack<>(size);
        for (String element : postfixElements) {
            if (isNum(element))
                operandCache.push(element);
            else { // operator
                double rhs = Double.parseDouble(operandCache.pop());
                double lhs = Double.parseDouble(operandCache.pop());
                Double tempResult = null;
                if (element.equals("+")) tempResult = lhs + rhs;
                if (element.equals("-")) tempResult = lhs - rhs;
                if (element.equals("*")) tempResult = lhs * rhs;
                if (element.equals("/")) tempResult = lhs / rhs;
                operandCache.push(tempResult.toString());
            }
        }
        return operandCache.pop();
    }


    private List<String> extractOperatorsBetween() {
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
        System.out.println(
                new PostFix(1000).process("(2-51)/3-(2+1*12)").print().compute()
        );
    }
}
