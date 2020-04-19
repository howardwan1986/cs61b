public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int head;


    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        head = 0;

    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void printDeque(){
        int i = head;
        for(int j = 0; j < size; j++){
            System.out.println(items[i] + " ");
            i = (i + 1) % (items.length);
        }
    }

    @Override
    public T get(int index){
        if(index >= size){
            return null;
        }
        return items[ (head + index) % (items.length) ];
    }

    private void resize(int capacity){
        T[] new_items = (T[]) new Object[capacity];

        for(int i = 0; i < size; i++){
            new_items[i] = items[head];
            head = (head + 1) % items.length;
        }
        items = new_items;
        head = 0;
    }

    @Override
    public void addFirst(T item){
        if(size == items.length){
            resize(2 * size);
        }

        head = (head - 1 + items.length) % items.length;
        items[head] = item;
        size += 1;
    }

    @Override
    public T removeFirst(){
        if(items.length >= 16 && size < (items.length) / 4){
            resize(items.length / 2);
        }

        T toRemove = items[head];
        items[head] = null;
        head = (head + 1) % items.length;
        if (!isEmpty()){
            size -= 1;
        }
        return toRemove;
    }

    @Override
    public void addLast(T item){
        if(size == items.length){
            resize(2 * size);
        }

        items[(head + size) % items.length] = item;
        size += 1;
    }

    @Override
    public T removeLast(){
        if(items.length >= 16 && size < (items.length) / 4){
            resize(items.length / 2);
        }

        T toRemove = items[(head + size - 1 + items.length) % items.length];
        items[(head + size - 1 + items.length) % items.length ] = null;

        if (!isEmpty()){
            size -= 1;
        }
        return toRemove;
    }
}
