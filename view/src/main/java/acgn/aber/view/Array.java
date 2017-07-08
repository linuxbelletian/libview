package acgn.aber.view;


/**
 * Created by aber on 01/07/2017.
 * Simple fixed size array implementation
 */

class Array<T> {

    private Object[] mArray;
    private int mCapacity;
    private int mSize;

    Array(int capacity) {
        mCapacity = capacity;
        mArray = new Object[capacity];
    }

    public void add(int index, T item) {
        if (index < 0 || index > mSize || mSize >= mCapacity) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(mArray, index, mArray, index + 1, mSize - index);
        mArray[index] = item;
        ++mSize;
    }

    public void add(T item) {
        if (mSize >= mCapacity) {
            throw new IndexOutOfBoundsException();
        }
        mArray[mSize++] = item;
    }

    public void addAll(Array<T> array) {
        if (mSize + array.size() > mCapacity) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < array.size(); ++i) {
            mArray[mSize++] = array.get(i);
        }
    }

    public void clear() {
        mSize = 0;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= mSize) {
            throw new IndexOutOfBoundsException();
        }
        return (T) mArray[index];
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if(index < 0 || index >= mSize) {
            throw new IndexOutOfBoundsException();
        }
        T item = (T) mArray[index];
        System.arraycopy(mArray, index + 1, mArray, index, mSize - 1 - index);
        --mSize;
        return item;
    }

    public int size() {
        return mSize;
    }


}
