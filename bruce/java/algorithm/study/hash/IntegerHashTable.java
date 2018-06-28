package algorithm.study.hash;

import algorithm.study.linkedlist.DoublyLinkedList;
import algorithm.study.linkedlist.LinkedList;
import algorithm.study.linkedlist.SinglyLinkedList;

import java.util.Arrays;
import java.util.stream.IntStream;

import static algorithm.study.util.LapUtil.check;

public class IntegerHashTable implements HashTable<Integer> {

    private int bucketSize = 11;
    private LinkedList<Integer>[] hashes;

    public IntegerHashTable() {
        hashes = new LinkedList[bucketSize];
        for (int i = 0; i < bucketSize; i++)
            hashes[i] = new DoublyLinkedList<>();
    }

    @Override
    public boolean contains(Integer key) {
        return hashes[hashValue(key)].contains(key);
    }

    @Override
    public void removeKey(Integer key) {
        //hashes[hashValue(key)].clear();
        hashes[hashValue(key)].remove(
                hashes[hashValue(key)].indexOf(key)
        );
    }

    @Override
    public int collisionMaxCount() {
        return Arrays.stream(hashes)
                .map(LinkedList::size)
                .max(Integer::compareTo)
                .orElse(0);
    }

    @Override
    public void put(Integer key) {
        hashes[hashValue(key)].addLast(key);
    }

    @Override
    public void clear() {
        for (int i = 0; i < bucketSize; i++)
            hashes[i].clear();
    }

    private int hashValue(Integer key) {
        return key % bucketSize;
    }

    public static void main(String[] args) {
        HashTable<Integer> hashTable = new IntegerHashTable();

        hashTable.put(1);
        hashTable.put(3);
        hashTable.put(7);

        System.out.println(hashTable.collisionMaxCount()); // 1

        hashTable.put(12);

        System.out.println(hashTable.collisionMaxCount()); // 2

        hashTable.removeKey(12);

        System.out.println(hashTable.collisionMaxCount()); // 1

        System.out.println(hashTable.contains(3)); // T
        System.out.println(hashTable.contains(12)); // F
        System.out.println(hashTable.contains(18)); // F

        hashTable.clear();
        System.out.println(hashTable.collisionMaxCount()); // 0


        final int length = 3_000_000;
        final int popped = 1_000_000;
        check(
                () -> IntStream.range(0, length).forEach(hashTable::put)
        );
        System.out.println(hashTable.collisionMaxCount());
        check(
                () -> IntStream.range(0, popped).forEach(hashTable::removeKey)
        );
        System.out.println(hashTable.collisionMaxCount());
    }
}
