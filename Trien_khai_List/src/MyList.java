import java.util.Arrays;

public class MyList <E>{
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object [] elements;

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity(){
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements,newSize);
    }

    public void add(E e){
        if (size == elements.length){
            ensureCapacity();
        }elements[size++] = e;
    }

    public E get(int index){
        if (index >= size || index<0){
            System.out.println("There's not index " + index + " in the array");;
        }return (E) elements[index];
    }


}
