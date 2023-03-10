public class Dog implements OurComparable {
    public String name;
    private int size;
    
    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    @Override
    public int compareTo(Object o) {
        Dog d = (Dog) o;
        return size - d.size;
    }

    public void bark() {
        System.out.println(name + " says: bark");
    }
}
