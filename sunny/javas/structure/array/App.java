package javas.Array;

public class App {

    public static void main(String[] args) {
        MyArray arr = new MyArray(5);

        for(int i = 0; i<5; ++i){
            arr.add("데이터_"+i);
        }

        System.out.println("배열 전체 데이터 : "+arr);
        System.out.println("--------------------------------------");

        arr.remove(1);
        System.out.println("인덱스 1 삭제 : " + arr);
        System.out.println("--------------------------------------");

        arr.add(1, "새로운 데이터");
        System.out.println("새로운 데이터 추가 : " + arr);
        System.out.println("--------------------------------------");

        // 꽉 찼는데 넣어지는 지 테스트
//        arr.add(2, "새로운 데이터2");
//        System.out.println("새로운 데이터 추가 : " + arr);
//        System.out.println("--------------------------------------");

        arr.swap(2,3);
        System.out.println("값 바꾸기 : " + arr);
        System.out.println("--------------------------------------");

        arr.replace(4, "바껴진 데이터");
        System.out.println("해당 값 변경 : " + arr);
        System.out.println("--------------------------------------");

        System.out.println("값 가져오기 : " + arr.get(0));
        //System.out.println("없는 값 가져오기 : " + arr.get(6));
        System.out.println("--------------------------------------");

        System.out.println("값 찾기 : " + arr.find("데이터_3"));
        System.out.println("없는 값 찾기 : " + arr.find("데이터_7"));
        System.out.println("--------------------------------------");

        arr.clear();
        System.out.println("클리어 : "+arr);
        System.out.println("--------------------------------------");

        arr.add("데이터_0");
        System.out.println("일단 첫번째 다시 등록 : "+arr);
        System.out.println("--------------------------------------");
        arr.add(2,"데이터_2");
        System.out.println("일단 첫번째 다시 등록 : "+arr);
        System.out.println("--------------------------------------");

    }

}
