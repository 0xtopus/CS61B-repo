public class TestAnimals {
    public static void main(String[] args) {
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);
        Dog d = new Dog("Fido", 4);

        a.greet(); // (A) ______________________
        c.greet(); // (B) ______________________
        d.greet(); // (C) ______________________
        a = c;
        ((Cat) a).greet(); // (D) ______________________
        a.greet(); // (E) ______________________
        a = new Dog("Spot", 10);
        d = (Dog)a;
    }
}