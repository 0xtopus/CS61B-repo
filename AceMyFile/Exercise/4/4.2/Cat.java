/* 
Given the Animal class, fill in the definition of 
the Cat class so that when greet() is called, 
the label “Cat” (instead of “Animal”) is printed to
the screen. Assume that a Cat will make a “Meow!” noise
if the cat is 5 years or older and “MEOW!”
if the cat is less than 5 years old.
 */
public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
        this.noise = "meow";
    }

    @Override
    public void greet() {
        System.out.println("Cat " + name + " says: " + makeNoise());
    }
    
    public static void main(String[] args) {
        Cat Fishball = new Cat("Fishball", 3);
        Fishball.greet();

        Cat Meatball = new Cat("Meatball", 13);
        Meatball.greet();

        
    }
}