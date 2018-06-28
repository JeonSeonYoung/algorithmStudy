package hash;

public class App {
    public static void main(String[] args) {

        MyHash myHash = new MyHash(11);

        for(int i = 1; i<11; ++i){
            myHash.put(i *7);
        }
        for(int i = 1; i<11; ++i){
            myHash.put(i *4);
        }

        System.out.println(myHash);
        System.out.println(myHash.contains(14));
        System.out.println(myHash.contains(99));
        System.out.println(myHash.contains(8));
        System.out.println(myHash.contains(36));
        System.out.println(myHash.collisionMaxCount());
        myHash.removeKey(14);
        System.out.println(myHash);
    }
}
