/** 중위표기법 : (2 + 5) * 3 * (2 + 1) ==> 후위표기법: 25 + 3 * 21 + * */

package javas.Stack;

public class Postfix {

    // 연산자 우선순위
    private static int prec(char ch){
        switch (ch){
            case '(' : case ')' : return 0;
            case '+' : case  '-' : return 1;
            case '*' : case  '/' : return 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        String data = "(2+5)*3*(2+1)";
        char[] charArray = data.toCharArray();

        MyStack stack = new MyStack(20);

        for(int i = 0; i<charArray.length; ++i){

            char lCh = charArray[i];

            switch (lCh) {
                case '(':
                    stack.push(lCh);
                    break;
                case ')':
                    while (!((Character) stack.peek()).equals('(')) {
                        sb.append(stack.pop());
                    }
                    break;
                case '+': case '-': case '/': case '*':
                    if (prec((Character) stack.peek()) >= prec(lCh)) {
                        sb.append(stack.pop());
                        stack.push(lCh);
                        break;
                    }else{
                        stack.push(lCh);
                        break;
                    }
                default:
                    sb.append(lCh);
                    break;
            }
        }

        while (!stack.isEmpty()){
            if(((Character)stack.peek()).equals('(')){
                stack.pop();
            }else{
                sb.append(stack.pop());
            }
        }

        System.out.println(sb.toString());


    }

}
