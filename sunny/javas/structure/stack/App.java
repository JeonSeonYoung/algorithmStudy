package javas.Stack;

public class App {

    public static void main(String[] args) {

        MyStack stack = new MyStack(5);

        stack.push("data_0");
        System.out.println("데이터 등록::::::" +  stack);
        System.out.println("----------------------------------------------");
        System.out.println("데이터 peek::::::" +  stack.peek());
        System.out.println("전체 데이터::::::" +  stack);
        System.out.println("----------------------------------------------");
        System.out.println("데이터 pop::::::" +  stack.pop());
        System.out.println("전체 데이터::::::" +  stack);
        System.out.println("스택이 비었니?::::::" +  stack.isEmpty());
        System.out.println("스택이 다 찼니?::::::" +  stack.isFull());
        System.out.println("----------------------------------------------");
        stack.push("data_0");
        stack.push("data_1");
        stack.push("data_2");
        stack.push("data_3");
        stack.push("data_4");
        System.out.println("데이터 한꺼번 등록::::::" +  stack);
        System.out.println("스택이 다 찼니?::::::" +  stack.isFull());
        stack.push("data_5");
        System.out.println("데이터 등록::::::" +  stack);
        System.out.println("----------------------------------------------");
        System.out.println("데이터 peek::::::" +  stack.peek());
        System.out.println("데이터 peek::::::" +  stack.peek());
        System.out.println("----------------------------------------------");
        System.out.println("데이터 pop::::::" +  stack.pop());
        System.out.println("데이터 pop::::::" +  stack.pop());
        System.out.println("데이터 pop::::::" +  stack.pop());
        System.out.println("전체 데이터::::::" +  stack);
        System.out.println("데이터 사이즈::::::" +  stack.size());

    }
}
