package algorithm.study.array;

public class ArrayTest {
    public static void main(String[] args) {
        Array<Object> array = new ObjectArray(6);

        array.add(1).add(2).add(3);

        System.out.println(array);

        array.add(5, 1).add(6, 0);
        System.out.println(array);

        try {
            array.add(8).add(5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(array);

        array.remove(0).remove(1);

        System.out.println(array);

        array.add(1).clear();

        System.out.println(array);

        array.add(4).add(5).add(6);

        System.out.println(array);
        System.out.println(array.find(5));
        System.out.println(array.find(50));

        System.out.println(array.get(2));

        array.set(10, 1);
        System.out.println(array);

        array.swap(0, 2);
        System.out.println(array);


    }
}
