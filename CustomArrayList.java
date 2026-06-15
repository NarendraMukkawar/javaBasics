public class CustomArrayList {

    private int[] arr;
    private int size;

    // Default capacity and size
    public CustomArrayList() {
        arr = new int[10];
        size = 0;
    }

    // Add element
    public void add(int element) {

        // Resize=ing if array fill
        if (size == arr.length) {
            resize();
        }

        arr[size] = element;
        size++;
    }

    // Resizing the array to 2x not memory efficient
    private void resize() {

        int[] newArr = new int[arr.length * 2];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    // Get element
    public int get(int index) {

        checkIndex(index);

        return arr[index];
    }

    // Remove element by index
    public void remove(int index) {

        checkIndex(index);

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        size--;
    }

    // Current size
    public int size() {
        return size;
    }

    // Display elements
    public void display() {

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    // throwing exception for index if it is not proper
    private void checkIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
    }

    public static void main(String[] args) {

        CustomArrayList list = new CustomArrayList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        list.display();

        System.out.println("Element at index 2 :- " + list.get(2));

        list.remove(1);

        list.display();

        System.out.println("Size :- " + list.size());
    }
}