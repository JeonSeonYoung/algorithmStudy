package algorithm.study.array;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ObjectArray implements Array<Object> {
    Object[] data;
    int idx = 0;
    int maxSize;

    ObjectArray(int size) {
        maxSize = size;
        data = new Object[maxSize];
    }

    @Override
    public Array<Object> add(Object val) {
        if(idx >= maxSize)
            throw new ArrayIndexOutOfBoundsException();

        data[idx++] = val;
        return this;
    }

    @Override
    public Array<Object> add(Object val, int index) {
        if(idx >= maxSize)
            throw new ArrayIndexOutOfBoundsException();

        for (int i = idx; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = val;
        idx++;

        return this;
    }

    @Override
    public Array<Object> remove(int index) {
        for (int i = index; i < idx - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--idx] = null;

        return this;
    }

    @Override
    public void clear() {
        data = new Object[maxSize];
        idx = 0;
    }

    @Override
    public int size() {
        return idx;
    }

    @Override
    public int find(Object object) {
        for (int i = 0; i < idx; i++) {
            if (object.equals(data[i]))
                return i;
        }
        return -1;
    }

    @Override
    public Object get(int index) {
        return data[index];
    }

    @Override
    public void set(Object val, int index) {
        data[index] = val;
    }

    @Override
    public void swap(int index1, int index2) {
        Object temp = data[index2];
        data[index2] = data[index1];
        data[index1] = temp;
    }

    @Override
    public String toString() {
        return "[" +
                IntStream.range(0, idx)
                        .mapToObj(idx -> data[idx])
                        .map(Object::toString)
                        .collect(Collectors.joining(", "))
                + "], size : " + this.size();
    }
}
