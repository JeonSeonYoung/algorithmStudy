package algorithm.study.stack;

public class PostFix {

    private Stack<Character> stack;

    public PostFix(int size) {
        stack = new Stack<>(size);
    }

    public String print(String infix) {
        stack.clear();
        String postfix = "";
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (isNum(c))
                postfix += c;
            else if (isFundamentalOperation(c)) {
                while (!hasPrecedence(c))
                    postfix += stack.pop();
                stack.push(c);
            } else if (c == ')')
                postfix += extractOperandsBetween();
            else if (c == '(')
                stack.push(c);
        }

        while (!stack.isEmpty())
            postfix += stack.pop();

        return postfix;
    }

    private String extractOperandsBetween() {
        String operands = "";
        while (!stack.peek().equals('('))
            operands += stack.pop();
        stack.pop(); // remove (
        return operands;
    }

    private boolean isFundamentalOperation(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private boolean hasPrecedence(char c) {
        if (stack.isEmpty()) return true;
        char operator = stack.peek();
        if (!isFundamentalOperation(operator)) return true;
        return (operator == '+' || operator == '-') && (c == '*' || c == '/');
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    // test client
    public static void main(String[] args) {
        System.out.println(
                new PostFix(1000).print("1*2+3")
        );
        System.out.println(
                new PostFix(1000).print("1*(2+3)")
        );
        System.out.println(
                new PostFix(1000).print("1*(2+3*4)+5")
        );
    }
}
