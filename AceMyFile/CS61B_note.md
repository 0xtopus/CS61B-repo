

# Java

## Intro

*J*ava is an object oriented language.

rules: 

1. Every Java file must contain a class declaration *.

2. All code lives inside a class*, even helper functions, global constants, etc.

3. To run a Java program, you typically define a main method using 

   ```java
   public static void main(String[] args)
   ```

4. Functions must be declared as a part of a class in Java. A function that is part of a class is called "method" .

5. To define a function, we use `public static`. There are alternate ways to do that.

6. All parameters of a function must have a declared type. Functions in Java return only one value!



## Conditional

三目运算符：

```java
return size==0 ? true : false;
```





## Array

to create an array:

```java
int[] numbers = new int[3];
numbers[0] = 4;
numbers[1] = 7;
numbers[2] = 10;
System.out.println(numbers[1]);
```

and here's another way:

```java
int[] numbers = new int[]{4, 7, 10};
System.out.println(numbers[1]);
```



## Array Plus

3 ways of creating an array in *Java*：

```java
int[] x;
int[] y;

x = new int[3];			//all elements are with the default value 0
y = new int[]{1,2,3,4};
int[] z = {1,2,3,4};
```



- each element of an array should have the same type.



**arraycopy()**

- there is one way you can copy an array fast and easy:

```java
x = new int[]{2,3,4,5};
int[] y = {6,7,8,9,10};
System.arraycopy(x,0,y,3,2); // the result: copy x[0],x[1] to y[3],y[4]
/* so y[5] = {6,7,8,2,3} */
```

- this demonstrates one way to copy information from one array to another. `System.arraycopy` takes five parameters:

  - The array to use as a source

- Where to start in the source array

  - The array to use as a destination

- Where to start in the destination array

  - How many items to copy

- **Shallow copy**: However, `arraycopy()`only creates a ==shallow copy== of an array, i.e. it only makes a **primative data type 1D array** <a href="#Immutable Data Type">immutable</a>. If you want to make a deep copies of **2D arrays** or **reference type 1D arrays**, please <a href="#array-deep-copy">check here</a>.

  

- **Array resizing**: 

  When the array gets too full, we can resize the array. However, we have learned that **array size cannot change**. The solution is, instead, to create a new array of a larger size, then copy our old array values to the new array. Now, we have all of our old values, but we have more space to add items.

  - **Resizing Speed** In the lecture video, we started off resizing the array by one more each time we hit our array size limit. This turns out to be extremely slow, because copying the array over to the new array means we have to perform the copy operation for each item. The worst part is, since we only resized by one extra box, if we choose to add another item, we have to do this again each time we add to the array.

    **Improving Resize Performance** Instead of adding by an extra box, we can instead ==create a new array with `size * FACTOR` items==, where `FACTOR` could be any number, like 2 for example. We will discuss why this is fast later in the course.

    **Downsizing Array Size** What happens if we have a 1 million length array, but we remove 990,000 elements of the array? Well, similarly, we can downsize our array by creating an array of half the size, if we reach 250,000 elements, for example. Again, we will discuss this more rigorously later in the course.

  



- you can specify the index of array at runtime while you can't do such thing with class.

  ```java
  int indexOfInterest = askUserForInteger();
  int[] x = {100, 101, 102, 103};
  int k = x[indexOfInterest];
  System.out.println(k);
  ```




- 2D array:

  ```java
  int[][] x = new int[][]{{1,2}, {3,4}, {5,6}};
  int[][] z = new int[3][3];
  int[][] matrix;
  matrix = new int[4][];
  matrix = new int[4][4];
  ```

  kind like C:  `int x[3][2]`

  - the default value of 2D array

  ```java
  int[][] x = new int[4][];	// x[n] = null
  int[] y = x[0];	// y = null
  x[0] = {1,2,3};
  ```

  - now x[0] stores an address points to a box stores the address of this array  `{1,2,3}`, meanwhile y still has the value "`null`" because "`null`" **points to no address**, so y's pointer won't change with x
  - <img src=".\note_pics\2DArray.png" style="zoom:75%;" />

  

- Generic Array:

  ```java
  public class AList<Glorp> {
      ...
      private Glorp[] arr = (Glorp[]) new Object[8]; 
      ...
  }
  ```

  create a generic array is a little bit special... Take care about syntax !!!

  <img src=".\note_pics\genericArray.png" alt="Generic Array" style="zoom:75%;" />

​		

**also to remember that once you want to delete the last item of your generic object array, ==set the last box to "null"== !!!**



## The Enhanced For Loop

```java
public static void main(String[] args) {
	String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};

	for (String s : a) {
        System.out.println(s);
    }
}
```

用字符变量 `s` 把字符数组`a`的每个元素再循环中遍历。

这种方法不能改变原数组内的值，具体事例见 [An awesome exercise][https://sp18.datastructur.es/materials/discussion/examprep02sol.pdf] 的第四题。

## An awesome exercise on Java basics

https://sp18.datastructur.es/materials/discussion/examprep02sol.pdf

探究了*Static变量，Scope*，以及*作用域* 等重要概念，非常棒的练习！！



## Compilation

The standard tools for executing Java programs use a two step process:

<img src=".\note_pics\javaCompilation.png" style="zoom:80%;" />

- Why make a .class file at all?
  - .class file has been type checked. Distributed code is safer.
  - .class files are simpler for computers to execute. Distributed code is faster.
  - And it can also protect your intellectual property for no need to give out source.
  
  

## Defining and Using Classes

https://joshhug.gitbooks.io/hug61b/content/chap1/chap12.html

https://sp18.datastructur.es/materials/lectures/lec2/lec2.html

<img src=".\note_pics\javaClassTerminology.png" style="zoom:80%;" />

<img src=".\note_pics\defAClass.png" style="zoom:80%;" />

Create a generic class: <a href="#Generic List">here</a>

## A Generic Variable Constructor

click <a href="#Generic List">here</a> to see how to create a generic class constructor that takes any kinds of variable.

- If you need to instantiate a generic over a primitive type, use `Integer`, `Double`, `Character`, `Boolean`, `Long`, `Short`, `Byte`, or `Float` instead of their primitive equivalents.



## static vs non-static

- you'd better access **static things** by class name and access **non-static things** by specific instance.

- nested class case
  - If the nested class has no need to use any of the instance methods or variables of `SLList`, you may declare the nested class `static`, as follows. Declaring a nested class as `static` means that methods inside the static class can ==not access any of the members of the enclosing class.== In this case, it means that no method in `IntNode` would be able to access `first`, `addFirst`, or `getFirst`.

```java
public class SLList {
       public static class IntNode {
            public int item;
            public IntNode next;
            public IntNode(int i, IntNode n) {
                item = i;
                next = n;
            }
       }

       private IntNode first;
...
```



## Java的数据类型

8种基本类型(primitive)：byte、short、int、long、float、double、boolean、char

plus one **reference type**: Objects，arrays.... ect.

to both types, the *Golden Rules of Equation* is effective. However, the latter stores either **null** or **an arrow** points to where the data is.



- convert one type to another:

  - simply google like this: "java convert string to double", and you will get: 

  > "We can *parse String to double* using parseDouble() method. *String* can start with “-” to denote negative number or “+” to denote positive number."



## Private keyword

Private variables and methods can only be accessed by code inside the same `.java` file, e.g. in this case `SLList.java`



## Immutable Data Type

An immutable data type is one for which an instance cannot change in any observable way after instantiation.

Examples:

- Mutable: ArrayDeque, Percolation.
- Immutable: Integer, String, Date.

The `final` keyword will help the compiler ensure immutability.

- `final` variable means you may assign a value once (either in the constructor of the class or in the initializer), but after it can never change.
- `final` is neither sufficient nor necessary for a class to be immutable.

**Advantage:** Less to think about; avoids bugs and makes debugging easier.

- Analogy: Immutable classes have some buttons you can press / windows you can look inside. Results are ALWAYS the same, no matter what.

**Disadvantage:** Must create a new object anytime anything changes.

- Example: String concatenation is slow!

## Writing Tests

```java
import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {
    
    @Test
    public void testSomething() {
        ...
        // use asserts to help you judge whether you get right  
        assertEquals(expected, actual);
        ...
    }
}
```



- why using test?

<img src=".\note_pics\usingTest.png" style="zoom:75%;" />



**Test-Driven Development (TDD)\**

TDD is a development process in which we write tests for code before writing the code itself. The steps are as follows:

1. Identify a new feature.
2. Write a unit test for that feature.
3. Run the test. It should fail.
4. Write code that passes the test. Yay!
5. Optional: refactor code to make it faster, cleaner, etc. Except now we have a reference to tests that should pass.

Test-Driven Development is not required in this class and may not be your style but unit testing in general is most definitely a good idea.



## Overloading

Two methods with the same name is allowed in Java, since they **have different parameters**. We say that two methods with the same name but different signatures are **overloaded**.



## Interface -- Making code general

Sometimes we might need to, say, if we want to execute a method (like `largestNumber()`) that applies to both two different classes, such as `AList` and `SLList`, then we can use **a new reference type** to make `AList` and `SLList` become *hyponyms* of the new reference type.

In order to do so, we can use the key word `interface` to define our new reference type:

```java
public interface List<Item> { 
	/* put signitures of what all subclasses of List can do inside! */
    ...
        
    /* And you can put some default methods inside too! */
    default public void method() { ... }
    
}
```

**Interface Inheritance**: Formally, we say that subclasses inherit from the superclass. Interfaces contain all the method signatures, and each subclass must implement every single signature.



And we should declare who are its subclasses using key word `implement` like this:

```java
public AList<Item> implements List<Item> { ... }
```



**these are the qualities of interfaces**:

- All methods must be public.
- All variables must be public static final.(<a href="#Immutable Data Type">immutable data type</a>)
- Cannot be instantiated
- All methods are by default abstract unless specified to be `default`
- Can implement more than one interface per class



**abstract classes**:

also, there are  **abstract classes** who are something in between of class and interface. Basically, abstract classes can do everything interfaces can do and more.

**When in doubt, try to use interfaces** in order to reduce complexity.

 <a her="https://joshhug.gitbooks.io/hug61b/content/chap4/chap44.html">You can check here to see more details. </a>



## Overriding

若父类中有方法重写了或实现了父类或接口里的抽象方法，就加上 @override

```java
@Override
public Item get(int i) { ... }
```

The subclasses do not have to re-implement the default method anywhere; they can simply call it for free. However, we can still override default methods, and re-define the method in our subclass.



## Static vs. Dynamic Type

Every variable in Java has a static type. This is the type specified when the variable is declared, and is checked at compile time. Every variable also has a dynamic type; this type is specified when the variable is instantiated, and is checked at runtime. 

**Dynamic Method Selection -- Overriding only!** The rule is, if we have a static type `X`, and a dynamic type `Y`, then if `Y` overrides the method from `X`, then on runtime, we use the method in `Y` instead. 

**Overloading and Dynamic Method Selection** Dynamic method selection plays no role when it comes to overloaded methods.



## Extends

define a hierarchical relationship between classes:

```java
public class RotatingSLList<Item> extends SLList<Item>
```

- extends allow the class `RotatingSLList` to inherit:
  - instance and static variables
  - all methods
  - all nested classes (This changes a little bit with the introduction of private variables but don’t worry about that right now. **The one item that is not inherited is a class’s constructor.**)
- Similarly it shares an "is-a" relationship with the `SLList` class.

**The Special Case of the Constructor?** Even though constructor’s are not inherited, we still use them. We can call the constructor explicitly by using the keyword `super()`. *At the start of every constructor, there is already an implicit call to its super class's constructor*.

```java
public VengefulSLList() {
  deletedItems = new SLList<Item>();
}
```

is equivalent to:

```java
public VengefulSLList() {
  super();
  deletedItems = new SLList<Item>();
}
```

However, if you omit `super()`, the auto constructor call only invokes **the constructor with empty argument**. (i.e you have to use `super(args)` if you want to use the constructor who takes parameters)

### Extends vs implements

Just remember, in the context of inheritance, the `extends` keyword is active in giving the subclass the abilities of the superclass. You can think of it as a fairy Godmother: she sees your needs and helps you out with some of her fairy magic. On the other hand, in the context of generics, `extends` simply states a fact: You must be a subclass of whatever you're extending. **When used with generics (like in generic method headers), `extends` imposes a constraint rather than grants new abilities.** It's akin to a fortune teller, who just tells you something without doing much about it.



## Casting

Casting allows us to force the static type of a variable, basically tricking the compiler into letting us force the static type of am expression.

```java
Poodle largerPoodle = (Poodle) maxDog(frank, frankJr);
```



## Understanding Static vs Dynamic Types

The static type of an object is its declared type, which determines the set of methods and fields that can be accessed at **compile-time**. The dynamic type of an object is its actual type at runtime, which may be a subtype of the static type, and determines the specific implementation of overridden methods. When a variable of a supertype is used to hold a subtype object, ==the static type limits the access to subtype-specific features, and may require explicit casting to access them.== This can lead to compile-time errors or runtime errors if the wrong type is assumed.

you can cast the superclass to subclass to overcome it.

## Inheritance Cheatsheet

`VengefulSLList extends SLList` means VengefulSLList "is-an" SLList, and inherits all of SLList's members:

- Variables, methods nested classes(**A subclass does inherit the private members of its parent class but can't access them.**)
- Not constructors Subclass constructors must invoke superclass constructor first. The `super` keyword can be used to invoke overridden superclass methods and constructors.

Invocation of overridden methods follows two simple rules:

- Compiler plays it safe and only allows us to do things according to the **static type**.
- For overridden methods (*not overloaded methods*), the actual method invoked is based on the dynamic type of the invoking expression
- Can use casting to overrule compiler type checking.

**Typing Rules**

- Compiler allows the memory box to hold any subtype.
- Compiler allows calls based on static type.
- Overriden non-static methods are selected at runtime based on dynamic type.
- For overloaded methods, the method is selected at compile time.



**And ChatGPT said:**

> In Java, there are two types of inheritance: **interface inheritance** and **implementation inheritance.**
>
> Interface inheritance occurs when an interface extends another interface. This means that the sub-interface inherits all of the methods and constants of the parent interface. However, it does not inherit the implementation of those methods.
>
> Implementation inheritance occurs when a class extends another class. This means that the subclass inherits both the methods and the implementation of those methods from the parent class. In other words, the subclass can use the parent class's methods without having to redefine them.
>
> It is important to note that a class can only extend one class (single inheritance) but can implement multiple interfaces (multiple inheritance). This means that a class can inherit the implementation of methods from one parent class but can implement the methods of multiple interfaces.



## Compile Error vs. Runtime Error

Made a lot of mistakes on <a href="https://www.youtube.com/watch?v=jZvAA4B3Ebk&list=PLnp31xXvnfRqAfvA4R9Oh09PstFymwCif&index=5&ab_channel=UCBerkeleyCS61B">this one</a>, so do a summary again.

1. 一般来说，编译器在编译的时候会检查静态类型，并根据静态类型决定使用的方法。
2. 发生Overriden的时候：non-static methods are selected at runtime based on dynamic type.
3. Override只发生在父类型和子类型有**同名方法**且同名方法的**参数类型相同**的时候。
3. Casting发生时，编译器会检查：“这个类型可不可以是xx类型呢？（既然是编译器检查那肯定看的是静态类型啦）”，一般来说，子类型**可以是**父类型；父类型也**可以是**子类型。
   - 如果子类型被cast到父类型，那么选择运行时的方法就会考虑父类型里的方法；
   - 如果父类型被cast到子类型，那么即使子类型里有某个方法，但如果父类型中没有相应的方法，在运行时就会产生runtime error。

## Delegation vs. Extension

我的理解：

- delegation 就是使用辅助ADT来实现你想要的目标ADT的功能。

```java
public class DelegationStack<Item> {
    private LinkedList<Item> L = new LinkedList<Item>();
    public void push(Item x) {
        L.add(x);
    }
}
```



- extension 就是在已有的ADT实现的基础上，再添加进新的方法实现新的功能。(is-a)

```java
public class ExtensionStack<Item> extends LinkedList<Item> {
    public void push(Item x) {
        add(x);
    }
}
```



- view 就是新建一个指向原对象的实例变量，通过对这个变量进行特定的操作来修改原对象的某些属性。 

```java
public class StackAdapter<Item> {
    private List L;
    public StackAdapter(List<Item> worker) {
        L = worker;
    }

    public void push(Item x) {
        L.add(x);
    }
}
```



delegation is accomplished by passing in a class while extension is defined as inheriting

see <a href="https://joshhug.gitbooks.io/hug61b/content/chap8/chap81.html">8.1</a>

**Delegation vs Extension:** Right now it may seem that Delegation and Extension are pretty much interchangeable; however, there are some important differences that must be remembered when using them.

Extension tends to be used when you know what is going on in the parent class. In other words, you know how the methods are implemented. Additionally, with extension, you are basically saying that the class you are extending from acts similarly to the one that is doing the extending. 

On the other hand, Delegation is when you do not want to consider your current class to be a version of the class that you are pulling the method from.

Views: Views are an alternative representation of an existed object. Views essentially limit the access that the user has to the underlying object. However, changes done through the views will affect the actual object.

**Talks with new Bing**

Me:

> extract the core ideas about delegation, view and extension from the page i previously given, compare the difference between them with simple examples to specify when to use each of them, then write a conclusion of it.

new Bing:

> Here is a summary of the core ideas about delegation, view and extension from the page you provided:
>
> - Delegation is a way of implementing an ADT by using another existing data structure as a helper. For example, to implement a stack ADT, we can use an array or a list as a helper and delegate the operations to them. Delegation allows us to reuse existing code and avoid duplication.
> - View is a way of creating a new ADT by changing how an existing one is accessed or displayed. For example, to create a circular list ADT, we can use a regular list as a helper and change how we access its elements by wrapping around the end. View allows us to create different perspectives on existing data without modifying it.
> - Extension is a way of creating a new ADT by adding more functionality to an existing one. For example, to create a priority queue ADT, we can extend the queue ADT by adding a priority field to each element and sorting them accordingly. Extension allows us to customize and enhance existing code and create new abstractions.
>
> The difference between them can be illustrated with some simple examples:
>
> - Suppose we want to implement an animal shelter ADT that stores animals in order of arrival and allows adopting either the oldest animal or the oldest animal of a given species. We can use delegation by using two queues as helpers: one for storing all animals and one for storing each species separately. We can delegate the enqueue and dequeue operations to these queues accordingly.
> - Suppose we want to implement an image filter ADT that applies different effects on images such as grayscale, sepia or blur. We can use view by using an image object as a helper and changing how we access its pixels according to the filter type. We can view the same image object with different filters without modifying it.
> - Suppose we want to implement an email client ADT that sends and receives emails with attachments, encryption and spam filtering features. We can use extension by extending an email message ADT that only handles plain text messages. We can add new fields and methods for handling attachments, encryption and spam filtering.
>
> The conclusion is that delegation, view and extension are three different ways of creating new ADTs from existing ones based on their functionality, accessibility or customization needs. They help achieve efficient programming by reducing complexity, increasing modularity and hiding implementation details.



## Higher Order Function

 A higher order function is a function that treats other functions as data. 

In old school Java (Java 7 and earlier), memory boxes (variables) could not contain pointers to functions. What that means is that we could not write a function that has a "Function" type, as there was simply no type for functions.

To get around this we can take advantage of interface inheritance. Let's write an interface that defines any function that takes in an integer and returns an integer - an `IntUnaryFunction`.

```java
public interface IntUnaryFunction {
    int apply(int x);
}
```

Now we can write a class which `implements IntUnaryFunction` to represent a concrete function. Let's make a function that takes in an integer and returns 10 times that integer.

```java
public class TenX implements IntUnaryFunction {
    /* Returns ten times the argument. */
    public int apply(int x) {
        return 10 * x;
    }
}
```

At this point, we've written in Java the  `tenX` function. Let's write `do_twice` now.

```java
public static int do_twice(IntUnaryFunction f, int x) {
    return f.apply(f.apply(x));
}
```

A call to `print(do_twice(tenX, 2))` in Java would look like this:

```java
System.out.println(do_twice(new TenX(), 2));
// do_twice(new TenX(), 2);
```



## Package

Sometimes there are just too many classes having the same name. To avoid conflict, we can use **Package name**. In industry, this differentiation happens by appending the class to a website address (backwards) like below:

```java
ug.joshh.animal.Dog d = new ug.joshh.animal.Dog()
```

And if you don't want to write such a long name every time you use it, you can do some `import` things to make your life easier:

```java
import ug.joshh.animal.animal
```

Now we can use dogs as we please.

### Quick import

> In IntelliJ, when you cursor is on the class name your wrote without package name, e.g. `Dog`, you can use the shortcut "Alt + Enter" to automatically add `import ...` at the top of your file.

### Creating a Package

Creating a package takes the following two steps:

1.) Put the package name at the top of every file in this package

```java
package ug.joshh.animal;

public class Dog {
    private String name;
    private String breed;
    …
}
```

2.) Store the file in a folder that has the appropriate folder name. The folder should have a name that matches your package:

i.e. `ug.joshh.animal` package is in ug/joshh/animal folder

**Creating a Package, in IntelliJ**

1.) File → New Package

1.) Choose package name (i.e. “ug.joshh.animal”)

**Adding (new) Java Files to a Package, in IntelliJ**

1.) Right-click package directory name

2.) Select New → Java Class

3.) Name your class, and IntelliJ will automatically put it in the correct folder + add the “package ug.joshh.animal” declaration for you.

**Adding (old) Java Files to a Package, in IntelliJ**

1.) Add “package [packagename]” to the top of the file.

2.) Move the .java file into the corresponding folder.

### Default packages

- **Your Java files should generally start with an explicit package declaration!!!**

Any Java class without an explicit package name at the top of the file is automatically considered to be part of the “default” package. However, when writing real programs, you should avoid leaving your files in the default package (unless it’s a very small example program). This is because code from the default package cannot be imported, and it is possible to accidentally create classes with the same name under the default package.

### JAR File

Oftentimes, programs will contain multiple .class files. If you wanted to share this program, rather than sharing all the .class files in special directories, you can “zip” all the files together by creating a JAR file. This single .jar file will contain all your .class files, along with some other additional information.

see <a href="https://joshhug.gitbooks.io/hug61b/content/chap7/chap71.html">more about it</a>.



## Access Control

- private
- protected
- ​                  (*Package Private*)
- public

<img src=".\note_pics\accessControl.png" style="zoom:80%;" />



> It is important to note that for **interfaces**, the default access for its methods is actually **public** (i.e. when there is no modifier), and not package-private. 



A class without modifier is a *package-private* class, so it cannot be seen outside the package.



## Throw Errors

- When you know at some point your program should crash, then use `throw` to let it crash. 

Example:

```java
public static void main(String[] args) {
    System.out.println("ayyy lmao");
    throw new RuntimeException("For no reason.");
}
```

And then when you run it, you'll get:

```bash
$ java Alien
ayyy lmao
Exception in thread "main" java.lang.RuntimeException: For no reason.
at Alien.main(Alien.java:4)
```

However, you can use `try...catch` to continue your flow when Exception is thrown:

```java
Dog d = new Dog("Lucy", "Retriever", 80);
d.becomeAngry();

// try something might trigger an exception
try {
    d.receivePat(); // this method will throw a Exception e
} catch (Exception e) {
    // catch exception and handle it in "catch"
    System.out.println("Tried to pat: " + e); 
}
System.out.println(d);
```

Running it will be like:

```bash
$ java ExceptionDemo
Tried to pat: java.lang.RuntimeException: grrr... snarl snarl
Lucy is a displeased Retriever weighing 80.0 standard lb units.
```

- A good thing to use `try..catch` is that you can avoid many embedded `if..else`, think of a real life code example of reading a file below:

```pseudocode
func readFile: {
    try {
        open the file;
        determine its size;
        allocate that much memory;
        read the file into memory;
        close the file;
    } catch (fileOpenFailed) {
        doSomething;
    } catch (sizeDeterminationFailed) {
        doSomething;
    } catch (memoryAllocationFailed) {
        doSomething;
    } catch (readFailed) {
        doSomething;    
    } catch (fileCloseFailed) {
        doSomething;
    }
}
```

By using `try...catch...`, you separate the normal flow and exceptions, and it allows you to make up each exception solely.

- <a href="https://joshhug.gitbooks.io/hug61b/content/chap6/chap66.html">Checked vs Unchecked Exceptions</a>



## Iteration

To implement <a href="#The Enhanced For Loop">the enhanced loop</a> for your own class, check <a href="https://joshhug.gitbooks.io/hug61b/content/chap6/chap63.html">6.3</a> to see how to do it.

<a href="https://joshhug.gitbooks.io/hug61b/content/chap6/chap67.html">build a class support iteration</a>

类似这样的*Enhanced Loop*:

```java
Set<String> s = new HashSet<>();
...
for (String city : s) {
    ...
}
```

原理其实是这样的：

```java
Set<String> s = new HashSet<>();
...
Iterator<String> seer = s.iterator();
while (seer.hasNext()) {
    String city = seer.next();
    ...
}
```

让我们来看看如何使我们自己的类也支持*Enhanced Loop*：

- 首先，要有一个`iterator()`方法，让它 return 一个 `iterator` 对象.

```java
public Iterator<E> iterator();
```

- 然后，我们就可以使用自己的iterator来进行类似`for-each`的循环了

例：假设我在自己的`List<>`类里定义了`iterator()`，那么我就可以进行下列操作：

```java
List<Integer> friends = new ArrayList<Integer>();
...
// 声明一个变量"seer"为iterator    
Iterator<Integer> seer = friends.iterator();

// 当"seer.hasNext()"返回值不为"false"时：
while (seer.hasNext()) {
    // "seer.next()"做两件事：1.返回下一个元素的数值; 2.迭代到下一个元素;
	System.out.println(seer.next());
}
```

那么，如何搭建一个支持`iterator`的类呢？

根据上述示例中的代码，我们可以发现，只有满足下列条件时，代码才能被正确编译：

1. 我们使用了`iterator()`来给变量`seer`赋值，因此，我们的类里必须要有`iterator()`方法；
2. `seer`里必须有`hasNext()` 和`next()`方法，所以在Iterator的interface里必须有这两个方法。

所以，当我们要在自己的类里支持`iterator时`，要先extends `Iterable interface`

```java
// Iterable Interface
public interface Iterable<T> {
    Iterator<T> iterator();
}
```

```java
// extend Iterable Interface
public interface List<T> extends Iterable<T>{
    ...
}
```

> ==注意区分`Iterator`和`Iterable`！==
>
> **The List interface extends the Iterable interface, inheriting the abstract iterator() method.** (Actually, List extends Collection which extends Iterable, but it's easier to codethink of this way to start.)

在`Iterator Interface`里，定义了`hasNext()` 和 `next()`方法：

```java
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
```



于是，我们要做的就是在我们的类里嵌套一个新的子类来implements` Iterator Interface`，在这个子类中，你要实现`public boolean hasNext()`和`public T next()`里的代码；

然后，再新建一个iterator()，这样就可以使用"Enhanced Loop"了

例：

```java
import java.util.Iterator;

// 你自己的类，extends Iterable<T>
// 或者应该在这个类的interface里extends Iterable<T>
public class ArraySet<T> extends Iterable<T> {	

    ...
        
    // 嵌套一个新子类来implements Iterator
    private class ArraySetIterator implements Iterator<T> {
    	private int wizPos;

    	public ArraySetIterator() {
        	wizPos = 0;
    	}

    	public boolean hasNext() {
        	return wizPos < size;
    	}

    	public T next() {
        	T returnItem = items[wizPos];
        	wizPos += 1;
        	return returnItem;
    	}
    }
    
    // 再新建一个iterator()返回刚刚创建的新类ArraySetIterator()，
    // 这样就可以使用"Enhanced Loop"了
    public Iterator<T> iterator() {
    	return new ArraySetIterator();
	}
}


```

好了，现在我们就可以愉快地使用`Enhanced Loop`了：

```java
ArraySet<Integer> aset = new ArraySet<>();
...
for (int i : aset) {
    System.out.println(i);
}
```



无关紧要的补充：`HashSet`自带`Enhanced Loop`:

```java
Set<String> s = new HashSet<>();
s.add("Tokyo");
s.add("Lagos");
for (String city : s) {
    System.out.println(city);
}
```





## Object methods

All classes inherit from the overarching Object class. The methods that are inherited are as follows:

- `String toString()`
- `boolean equals(Object obj)`
- `Class <?> getClass()`
- `int hashCode()`
- `protected Objectclone()`
- `protected void finalize()`
- `void notify()`
- `void notifyAll()`
- `void wait()`
- `void wait(long timeout)`
- `void wait(long timeout, int nanos)`

## compareTo() method

- more details: https://joshhug.gitbooks.io/hug61b/content/chap5/chap53.html



The compareTo() method is a method that compares two objects of the same type and returns an integer value that indicates their relative order. The compareTo() method is defined by the Comparable interface, which is implemented by many classes in Java, such as String, Integer, Date, etc.

The compareTo() method follows some general rules:

- It returns 0 if the two objects are equal
- It returns a positive value if the current object is greater than the parameter object
- It returns a negative value if the current object is less than the parameter object

The meaning of “greater than” or “less than” depends on how the objects are compared. [For example, for strings, the comparison is based on the lexicographical order of their characters](https://www.w3schools.com/java/ref_string_compareto.asp)[1](https://www.w3schools.com/java/ref_string_compareto.asp)[2](https://www.javatpoint.com/java-string-compareto). For numbers, it is based on their numerical value.

The compareTo() method can be used to sort objects in collections or arrays that use natural ordering. [It can also be used to define custom comparators for other types of ordering](https://www.baeldung.com/java-compareto)[3](https://www.baeldung.com/java-compareto). For example:

```java
// Sorting an array of strings using natural ordering
String[] names = {"Alice", "Bob", "Charlie"};
Arrays.sort(names); // names = {"Alice", "Bob", "Charlie"}

// Defining a custom comparator for reverse alphabetical order
Comparator<String> reverseOrder = new Comparator<String>() {
  @Override
  public int compare(String s1, String s2) {
    return -s1.compareTo(s2); // negate the result of compareTo()
  }
};

// Sorting an array of strings using reverse alphabetical order
Arrays.sort(names, reverseOrder); // names = {"Charlie", "Bob", "Alice"}
```

## Style Guide

here is the <a href="https://sp19.datastructur.es/materials/guides/style-guide.html">style guide</a> for CS 61B.

- mistakes I encountered:

  - Line is longer than 100 characters.

  - File does not end with a newline.

  - ' , ' is not followed by whitespace.

  - '{' is not preceded with whitespace.

    - you can use regex to fix this by replacing  `\)\{` with `) {` 

  - 'while' is not followed by whitespace.

  - 'if' is not followed by whitespace.

    

### 61B Style Checker

you can use **61B Style Checker** in IntelliJ CS61B plugin to help you check your style.

you should have installed the CS 61B plugin, which allows you to locally check style in IntelliJ. If you have this plugin installed, you can check the style of your code files by right clicking on a file in IntelliJ and clicking the "Check Style" option.



## Troubleshooting

-  **错误： 编码 GBK 的不可映射字符**
  
  - 解决方案：
    1. 使用 `javac -encoding UTF-8 <filename>`编译;
    2. java源程序代码在保存时把java文件转换成ANSI编码格式即可。
  
-  check *IntelliJ* key board shortcut: `Ctrl` + `Alt` +`S` --> `Keymap`
   - ref: https://www.jetbrains.com/help/idea/configuring-keyboard-and-mouse-shortcuts.html
   
- <a href="https://www.cnblogs.com/huangguoming/p/15682942.html">warning: commented out code</a> 建议不要注释代码

-  Permanently Set Up Libraries in IntelliJ:  <a ref="https://sp18.datastructur.es/materials/lab/lab4/lab4">link</a>

- Set debug config in VSCode

  - if you want to pass command line args in command when using vscode debug tool, go to debug section, open `lauch.json` and add `"args":["<arg1>", "<arg2>", ...]` within the same bracket where the `name` of  file you desired to run nested, like this  in which I add `"157788000.0"`, `25000.0"`,` "data/awesome.txt"` these three args for the file `NBody.java`.

    ```json
    {
       "type": "java",
       "name": "Launch NBody",
       "args": [
                  "157788000.0",
                  "25000.0",
                  "data/awesome.txt"
                ],
       "request": "launch",
       "mainClass": "NBody",
       "projectName": "proj0_33252093"
    }
    ```

    you can also refer to this link :https://stackoverflow.com/questions/59638889/passing-java-an-argument-while-debugging-in-vs-code
    
  - if you are currently using IntelliJ, in HW4 they will tell you to <a ref="https://www.google.com/search?q=command+line+arguments+intelliJ&oq=command+line+arguments+intelliJ&aqs=chrome..69i57.2608j0j1&sourceid=chrome&ie=UTF-8">Google this</a>.

- Get rid of all numbers at the beginning of the lines when you copy some codes from exercise pdf files:

  **chatGPT**:

  Here's the updated *regular expression*: `^\d+\s*`.

  This pattern will match a sequence of one or more digits at the beginning of a line, followed by zero or more whitespace characters. The `*` after the `\s` means "zero or more".



- **<span id="array-deep-copy">Array Deep Copy</span>**

  summarized by new Bing and slightly modified by me:

  **Problem:** In <a href="https://sp18.datastructur.es/materials/hw/hw4/hw4#faq">HW4</a>, I have a Java class `Board` that contains a 2D array `tiles` of primitive type  `int` and I want to make the elements of the `tiles` array immutable. However, the code I wrote using `System.arraycopy(tiles, 0, this.tiles, 0, size)` in the constructor doesn’t achieve this.

  **Reason:** Using `System.arraycopy` in this way only performs a shallow copy of the source array to the destination array. Since `tiles` is a 2D array (an array of arrays), this means that it only copies the references to the inner arrays from the input `tiles` array to the `this.tiles` array. As a result, any changes made to the inner arrays of the input `tiles` array after creating a `Board` object will be reflected in the `this.tiles` array as well.

  **Solution:** To make the elements of the `tiles` array immutable, you need to perform a deep copy of the input `tiles` array to the `this.tiles` array. This can be achieved by copying each inner array individually using a loop and `System.arraycopy` because **the inner 1D arrays are all primitive type**. (Additionally, instead of returning the `tiles` array directly in any getter methods, you can return a copy of the `tiles` array.)

  **Conclusion:** To make a 2D array immutable in Java, you need to perform a deep copy of the input array (and return a copy of the array in any getter methods). This can be achieved by copying each inner array individually using a loop and `System.arraycopy`. 

  ```java
  // if the inner arrays of your 2D array are all primitive type
  public Board(int[][] tiles) {
      size = tiles.length;
      this.tiles = new int[size][size];
      for (int i = 0; i < size; i++) {
          System.arraycopy(tiles[i], 0, this.tiles[i], 0, size);
      }
  }
  ```

  For 1D arrays of primitive data types or immutable objects, you can use `System.arraycopy` to make a deep copy. However, for 1D arrays of mutable objects, you need to create a new array and copy each element individually(**And the same to the inner arrays of your 2D array if its elements are mutable objects**) .

  ```java
  // create a deep copy of a 1D array of mutable objects
  MyObject[] originalArray = {new MyObject(1), new MyObject(2), new MyObject(3)};
  MyObject[] copyArray = new MyObject[originalArray.length];
  for (int i = 0; i < originalArray.length; i++) {
      copyArray[i] = new MyObject(originalArray[i]);
  }
  ```

  


# Data Structure

## Linked List

[linked list](https://www.javatpoint.com/singly-linked-list): an ordered set of data elements, each containing a link to its successor (and sometimes its predecessor).

### a way to build list in Java

```java
public class IntList {
    public int first;
    public IntList rest;        

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }
    
    public static void main(String[] args){
        IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);
    }
}
```



### single linked list

<img src=".\note_pics\SLList.png" style="zoom:75%;" />

- size variable
- sentinel node

### double linked list

1. Two-Sentinel DLList

<img src=".\note_pics\2SentinelsDLList.png" style="zoom:75%;" />



2. Circular DLList

<img src=".\note_pics\CircularDLList.png" style="zoom:75%;" />

### Generic List

- create a **generic DLList**: any type is welcome!

```java
public class DLList<T> { ... }
```

- using generic DLList:

  - `T` is a placeholder object type.

  - If we now want to create a `DLList` holding `String` objects, then we must say:

    ```
    DLList<String> list = new DLList<>("bone");
    ```

    On list creation, the compiler replaces all instances of `T` with `String`! We will cover generic typing in more detail in later lectures.
  
- Since generics only work with reference types, we **cannot put primitives** like `int` or `double` inside of angle brackets, e.g. `<int>`. Instead, we use the reference version of the primitive type, which in the case of `int` case is `Integer`, e.g.

  ```java
  DLList<Integer> d1 = new DLList<>(5);
  d1.insertFront(10);
  ```

## Invariant

**Invariants** An invariant is a fact about a data structure that is guaranteed to be true (assuming there are no bugs in your code). This gives us a convenient checklist every time we add a feature to our data structure. Users are also guaranteed certain properties that they trust will be maintained. For example, an `SLList` with a sentinel node has at least the following invariants:

- The sentinel reference always points to a sentinel node.
- The front item (if it exists), is always at sentinel.next.item.
- The size variable is always the total number of items that have been added.



## Abstract Data Type

Abbreviation： ADT

Abstract Data Types are defined to be some sort of Object that is defined by some set of operations rather than the implementation of these operations.

There are some built-in Abstract data types in Java. The three most important ADTs come in the java.util library:

- List

  : an ordered collection of items

  - A popular implementation is the [ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)

- Set

  : an unordered collection of strictly unique items (no repeats)

  - A popular implementation is the [HashSet](https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html)

- Map

  : a collection of key/value pairs. You access the value via the key.

  - A popular implementation is the [HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
  
- Stacks 

  - Stacks and queues are two similar types of linear collections with special behavior. A stack is a last-in, first-out ADT: elements are always added or removed from one end of the data structure. A queue is a first-in, first-out ADT.

- priority queue

- Priority queue is like a regular queue except each element has a priority associated with it which determines in what order elements are removed from the queue. In Java, PriorityQueue is a class, a heap data structure implementing the priority queue ADT. The priority is determined by either natural order (E implements Comparable) or a supplied Comparator.

**Some of the methods in their interfaces are introduced in <a href="https://sp18.datastructur.es/materials/discussion/disc05.pdf">disc05</a>**



You can use them like this:

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Example {
  public static void main(String[] args) {
    // create a new ArrayList
    List<Integer> numbers = new ArrayList<>();

    // add some elements to the list
    numbers.add(1);
    numbers.add(2);

    // get the size of the list
    int size = numbers.size();
    System.out.println("The size of the list is: " + size);
  }
}
```

Below we show the relationships between the interfaces and classes. Interfaces are in white, classes are in blue.

<img src=".\note_pics\ADTs.png" style="zoom:65%;" />

## Asymptotics

**Overview** In this part, the method to calculate the complexity of algorithm is introduced.

**How to analysis**

- Choose our cost model (representative operation we want to count).
- Figure out the order of growth for the count of our representative operation by either:
  - Making an exact count, and discarding unnecessary pieces
  - Or, using intuition/inspection to determine orders of growth (comes with practice!)

**Mathematic rigorous**

- Given a piece of code, we can express its runtime as a function R(N)
  - N is some **property** of the input of the function
  - i.e. oftentimes, N represents the **size** of the input
- Rather than finding R(N) exactly, we instead usually only care about the **order of growth** of R(N).
- One approach (not universal): Big-theta
- Another way to express this is to use Big O

**Important sums you should remember**

- 1 + 2 + 3 + ... + N = (N+1)*N/2
- 1 + 2 + 4 + 8 + ... + N = 2*N - 1   (Note that N **is not** the number of the items)

Note that: 

- *N*^2^ vs. N log N is an enormous difference.
- Going from N log N to N is nice, but not a radical change.

**terminology**

- **Order of Growth**

- The terms *“constant”*,* “linear”*, and *“quadratic”* are often used for algorithms with order of growth 1, N, and N^2^

### Tree Recursion

- θ(2^N^)

### Binary Search

- θ(log N)

### Selection Sort

- θ(N^2^)

### Merge Sort

- θ(N log N)



## Data Structure Visulization

- This <a href="https://www.cs.usfca.edu/~galles/visualization/Algorithms.html">website</a> can be of great help in studying following data structures!!!



## Disjoint Sets

Two sets are named *disjoint sets* if they have no elements in common. A Disjoint-Sets (or Union-Find) data structure keeps track of a fixed number of elements partitioned into a number of *disjoint sets*. The data structure has two operations:

1. `connect(x, y)`: connect `x` and `y`. Also known as `union`
2. `isConnected(x, y)`: returns true if `x` and `y` are connected (i.e. part of the same set).

Note that we represent the sets using **only an array**. We visualize it ourselves as trees.



### Quick Find

Let's consider an approach using a *single array of integers*.

- The **indices of the array** represent the elements of our set.
- The **value at an index** is the set number it belongs to.

For example, we represent `{0, 1, 2, 4}, {3, 5}, {6}` as:

<img src="\note_pics\quickFindDisjointSet.png" style="zoom:100%;" />

### Quick Union

An alternate approach is to change the meaning of our `id` array. In this strategy, `id[i]` is the parent object of object `i`. An object can be its own parent. The `find()` method climbs the ladder of parents until it reaches the root (an object whose parent is itself). To connect `p` and `q`, we set the root of `p` to point to the root of `q`.

### Weighted quick union

 Rather than `connect(p, q)` making the root of `p` point to the root of `q`, we instead make the root of the smaller tree point to the root of the larger one. The tree’s *size* is the *number* of nodes, not the height of the tree. Results in tree heights of *lg ⁡N*.

- `connect`: Requires only one change to `id`, but also requires root finding (worst case *lg ⁡N* time).
- `isConnected` (and `find`): Requires root finding (worst case *lg N* time).

Warning: if the two trees have the same size, the book code has the opposite convention as quick union and sets the root of the second tree to point to the root of the first tree. This isn’t terribly important (you won’t be tested on trivial details like these).

<img src="note_pics\WQU.png" style="zoom:80%;" />

### WQU with path compression.

When `find` is called, every node along the way is made to point at the root. Results in nearly flat trees. 

### Runtime

- By applying different means, the results of cost varies:<img src="..\AceMyFile\note_pics\DisjointSet.png" style="zoom:67%;" />

### Example Implementations

You are not responsible for knowing the details of these implementations for exams, but these may help in your understanding of the concepts.

[QuickFind](http://algs4.cs.princeton.edu/15uf/QuickFindUF.java.html)

[QuickUnion](http://algs4.cs.princeton.edu/15uf/QuickUnionUF.java.html)

[WeightedQuickUnion](http://algs4.cs.princeton.edu/15uf/WeightedQuickUnionUF.java.html)

[Weighted Quick Union with Path Compression](http://algs4.cs.princeton.edu/15uf/QuickUnionPathCompressionUF.java.html)


## Binary Tree

- **Tree**: Trees are composed of:

  - nodes

  - edges that connect those nodes.
    - **Constraint**: there is only one path between any two nodes.

​	In some trees, we select a **root** node which is a node that has no parents.

​	A tree also has **leaves**, which are nodes with no children.

- **Binary Trees**: in addition to the above requirements, also hold the binary property constraint. That is, each node has either 0, 1, or 2 children.
- **Binary Search Trees**: in addition to all of the above requirements, also hold the property that For every node X in the tree:
  - Every key in the left subtree is less than X’s key.
  - Every key in the right subtree is greater than X’s key. 



### BST

**Recursive is super useful in realizing these mothods!**

- Find

- Insert

  - avoid temptation of bad recursive, trust your base condition!

- Delete

  - Let's break this problem down into three categories:

    - the node we are trying to delete has no children
    - has 1 child
    - has 2 children

    **No children**

    If the node has no children, it is a leaf, and we can just delete its parent pointer and the node will eventually be swept away by the [garbage collector](https://stackoverflow.com/questions/3798424/what-is-the-garbage-collector-in-java).

    **One child**

    If the node only has one child, we know that the child maintains the BST property with the parent of the node because the property is recursive to the right and left subtrees. Therefore, we can just reassign the parent's child pointer to the node's child and the node will eventually be garbage collected.

    **Two children**

    If the node has two children, we can't just assign one of the children to be the new root. This might break the BST property.

    Instead, we choose a new node to replace the deleted one.

    We know that the new node must be the either one of below:

    - **Predecessor**: be > than everything in left subtree.
    - **Successor**: be < than everything right subtree.

### Summary

Abstract data types (ADTs) are defined in terms of operations, not implementation.

Several useful ADTs:

- Disjoint Sets, Map, Set, List.
- Java provides Map, Set, List interfaces, along with several implementations.

We’ve seen two ways to implement a Set (or Map):

- ArraySet: Θ(*N*) operations in the worst case.
- BST: Θ(log*N*) operations if tree is balanced.

BST Implementations:

- Search and insert are straightforward (but insert is a little tricky).
- Deletion is more challenging. Typical approach is “Hibbard deletion”.



### Binary Tree Height

- **depth**: the number of links between a node and the root.
- **height**: the lowest depth of a tree.
- **average depth**: average of the total depths in the tree. 

The **height** of the tree determines the worst-case runtime, because in the worst case the node we are looking for is at the bottom of the tree.

The **average depth** determines the average-case runtime.



The order you insert nodes into a BST determines its height.

You don't have to know the proof of this, but when we insert randomly into a BST the **average depth** and **height** are expected to be Θ(*log N*).

However, we won't always be able to insert into a BST in random order.



### Rotating Trees

The formal definition of rotation is:

```
rotateLeft(G): Let x be the right child of G. Make G the new left child of x.
rotateRight(G): Let x be the left child of G. Make G the new right child of x.
```

## B-Trees

> B-trees balance by bounding branch breadth and bisecting bulky branches. -- new Bing

**B-Trees are hard to implement!**

B-trees are balanced search trees that maintain perfect balance by setting a limit on the number of elements in a single node and splitting nodes in half when they reach that limit. They are also known as 2-3-4 or 2-3 Trees, which refers to the number of children each node can have. The insertion process involves **inserting into a leaf node** and **popping up the middle left node if necessary** until the parent node can accommodate or you reach the root.

**Insertion Process**

Here’s a brief and intuitive summary of the insertion process for B-trees:

1. Traverse down the tree with the node to be inserted, going left and right according to whether or not the node is greater than or smaller than the items in each node.
2. Add the node to a leaf node.
3. If the new node has more than the maximum number of elements allowed (e.g., 4 for a 2-3-4 tree), pop up the middle left node and re-arrange the children accordingly.
4. If this results in a parent node having more than the maximum number of elements allowed, repeat step 3 until you reach a parent that can accommodate or you get to the root.

**B-Tree Invariants**

A B-tree has the following helpful invariants:

- All leaves must be the same distance from the source.
- A non-leaf node with *k* items must have exactly k+1 children.(Bug: in <a href="https://sp18.datastructur.es/materials/discussion/disc09sol.pdf">dicu09</a>/3 *Trees and LLRB's*, you can find there has two nodes violating this rule)

In tandem, these invariants cause the tree to always be bushy.

**Runtime of B-trees**

The worst-case runtime situation for search in a B-tree would be if each node had the maximum number of elements in it and we had to traverse all the way to the bottom. We will use *L* to denote the number of elements in each node. This means would would need to explore log*N* nodes (since the max height is log*N* due to the bushiness invariant) and at each node we would need to explore *L* elements. In total, we would need to run *L* log *N* operations. However, we know *L* is a constant, so our total runtime is *O*(log*N*).



**Summary**

BSTs have best case height Θ(log*N*), and worst case height Θ(*N*).

- Big O is not the same thing as worst case!

B-Trees are a modification of the binary search tree that avoids Θ(*N*) worst case.

- Nodes may contain between 1 and *L* items.
- contains works almost exactly like a normal BST.
- add works by adding items to existing leaf nodes.
  - If nodes are too full, they split.
- Resulting tree has perfect balance. Runtime for operations is*O*(log*N*).
- Have not discussed deletion. See extra slides if you’re curious.
- Have not discussed how splitting works if *L* > 3 (see some other class).
- B-trees are more complex, but they can efficiently handle ANY insertion order.



## Red-Black Trees

Red-Black Trees are binary search trees that are structurally identical to 2-3 trees and thus stay balanced. 😊

### LLRB

Left-Leaning Red-Black trees have a 1-1 correspondence with 2-3 trees. Every 2-3 tree has a unique LLRB red-black tree associated with it. As for 2-3-4 trees, they maintain correspondence with standard Red-Black trees.

### Properties of LLRB's

Here are the properties of LLRB's:

- 1-1 correspondence with 2-3 trees.
- No node has 2 red links.
- There are no red right-links.
- Every path from root to leaf has same number of black links (because 2-3 trees have same number of links to every leaf).
- Height is no more than 2x height of corresponding 2-3 tree.

**Insertion**

Here is a summary of all the operations:

- When inserting: Use a red link.
- If there is aright leaning “3-node”, we have a Left Leaning Violation
  - Rotate left the appropriate node to fix.
- If there are two consecutive left links, we have an incorrect 4 Node Violation!
  - Rotate right the appropriate node to fix.
- If there are any nodes with two red children, we have a temporary 4 Node.
  - Color flip the node to emulate the split operation.

**Runtime**

Because a left-leaning red-black tree has a 1-1 correspondence with a 2-3 tree and will always remain within 2x the height of its 2-3 tree, the runtimes of the operations will take log*N* time.



## Summary on Trees

- Binary search trees are simple, but they are subject to imbalance which leads to crappy runtime.
- 2-3 Trees (B Trees) are balanced, but painful to implement and relatively slow.
- LLRBs insertion is simple to implement (but deletion is hard).
  - Works by maintaining mathematical bijection with a 2-3 trees.
- Java’s [TreeMap](https://github.com/AdoptOpenJDK/openjdk-jdk11/blob/999dbd4192d0f819cb5224f26e9e7fa75ca6f289/src/java.base/share/classes/java/util/TreeMap.java) is a red-black tree (but not left leaning).
- LLRBs maintain correspondence with 2-3 tree, Standard Red-Black trees maintain correspondence with 2-3-4 trees.
- Allows glue links on either side (see [Red-Black Tree](http://en.wikipedia.org/wiki/Red–black_tree)).
- More complex implementation, but significantly faster.

## Tree ~~Iteration~~ Traversal

<img src=".\note_pics\treeTraversal.png" style="zoom:50%;" />

### Pre-order Traversal

Here's the idea behind pre-order traversal. Start at the root. **Visit the root** (aka, do the **action** you want to do.) The action here is "print".

it is useful to present hierarchic structure of directories. 

(clockwise and print when passing node left)

```java
preOrder(BSTNode x) {
    if (x == null) return;
    print(x.key)
    preOrder(x.left)
    preOrder(x.right)
}
```

### In-order Traversal

Slightly different, but same big-picture idea. Here, instead of **visiting** (aka **printing**) first, we'll first visit the left branch. Then we'll print. Then we'll visit the right branch.

(clockwise and when passing the node bottom)

```java
inOrder(BSTNode x) {
    if (x == null) return;    
    inOrder(x.left)
    print(x.key)
    inOrder(x.right)
}
```

### Post-order Traversal

Again, same big-picture idea, but now we'll print left branch, then right branch, then ourselves.

it is useful to calculate directory sizes.

(clockwise and when passing the node right)

```java
postOrder(BSTNode x) {
    if (x == null) return;    
    postOrder(x.left)
    postOrder(x.right)
    print(x.key)   
}
```

## Quad Trees

When it comes to multi-dimensional problems, we can use **quad trees** or **k-d trees** to solve them.

Imagine a plot with many dots on it, and each dot has a coordinate (x, y). Now let's consider the following two questions:

- How can we determine which dots are within a given range?
- Given a random position, what is the nearest dot to that position?

**quad trees**

<img src="\note_pics\QuadTree.png" style="zoom:40%;" />

For a 2D plot, we can partition the space into four parts (NW, NE, SW, and SE as shown above) around a dot. When adding the next dot, we connect it to the corresponding sub-node in the tree based on its location. The more nodes we add, the more segments we get.

Note that just like in a BST, the order in which we insert nodes determines the topology of the QuadTree. Also note that QuadTrees are a form of spatial partitioning in disguise. Similar to how uniform partitioning created a perfect grid before, QuadTrees hierarchically partition by having each node "own" 4 subspaces.

Effectively, spaces where there are many points are broken down into more finely divided regions, and in many cases this gives better performances.

**Quad Tree Search**

If we are looking for points inside a green rectangle as shown below, from any node we can decide whether the green rectangle lies within one or more quadrants, and only explore the branches/subtrees corresponding to those quadrants. All other quadrants can be safely ignored and pruned away. Below, we see that the green rectangle lies only in the northeast quadrant, and so the NW, SE, and SW quadrants can all be pruned away and left unexplored. We can proceed recursively and end up with a final node (i.e. D) of candidates, among which only B meets our requirements.

<img src="\note_pics\QuadTreeSearch.png" style="zoom:67%;" />

**Higher dimensions**

For example, if we want to represent a 3D space and dots inside the space, we have to use eight sub-nodes to represent the parts of space in corresponding directions(see the diagram below) around a dot and the tree we use is called Oct-tree.

![](\note_pics\OctTrees.png)

Or... we can use **K-D Trees** instead.

**K-D tree**

"K-D" simply means "k dimensions" if you are curious.

<img src="\note_pics\KDTree.png" style="zoom:40%;" />

Here is a demo of 2D K-D tree implementation.

For a demo on K-D tree insertion, you can also check out these [slides](https://docs.google.com/presentation/d/1WW56RnFa3g6UJEquuIBymMcu9k2nqLrOE1ZlnTYFebg/edit#slide=id.g54b6045b73_0_38)

**Nearest neighbor**

To find the point that is the nearest neighbor to a query point, we follow this procedure in our K-D Tree:

- Start at the root and store that point as the "best so far". Compute its distance to the query point, and save that as the "score to beat". In the image above, we start at A whose distance to the flagged point is 4.5.
- This node partitions the space around it into two subspaces. For each subspace, ask: "Can a better point be possibly found inside of this space?" This question can be answered by computing the shortest distance between the query point and the edge of our subspace.

- Continue recursively for each subspace identified as containing a possibly better point.
- In the end, our "best so far" is the best point; the point closest to the query point.

<img src="\note_pics\KDTreeNearestDemo.png" style="zoom:45%;" />

And pseudocode of finding nearest neighbor is like:

```pseudocode
nearest(Node n, Point goal, Node best):
	if n is null:
		return best
	if n.distance(goal) < best.distance(goal):
		best = n
	if goal < n (according to n's comparator):
		goodSide = n."left"Child
		badSide = n."right"Child
	else:
		badSide = n."left"Child
		goodSide = n."right"Child
	best = nearest(goodSide, goal, best)
	if badSide could still have something useful:
		best = nearest(badSide, goal, best)	// Don't forget do this!
	return best
```

For a step by step walkthrough, see these [slides](https://docs.google.com/presentation/d/1DNunK22t-4OU_9c-OBgKkMAdly9aZQkWuv_tBkDg1G4/edit)

**Summary**

Multidimensional data has interesting operations:

- **Ranging Finding**: What are all the objects inside the subspace?
- **Nearest**: What is the closest object to a specific point? (can be generized to k-nearest)

The most common approach is **spatial partitioning**:

- Uniform Partitioning: Analogous to hashing.
- Quadtree
- K-D Tree

Spatial partitioning allows for pruning of the search space.

## Hashing

hashing is a powerful technique for turning a more complex object like a `String` into a numerically representable value like an `int`. 

- **Hash Table**

The *hash table* is a data structure that combines the *hash function* with the fact that arrays can be indexed in constant time. Using the hash table and the map abstract data type, we can build a `HashMap` which allows for amortized constant time access to any key-value pair so long as we know which bucket the key falls into.

<img src=".\note_pics\hashTable.png" style="zoom:67%;" />

We face the problem that not every object in Java can easily be converted to a number. However, the key idea behind hashing is the transformation of any object into a numeric representation. The key is to have a hashing function transform our keys into different values, and convert that number into an index to then access the array. 

We achieve this through our own implementation of a `hashCode()` function, with a return value of an `int` type. This `int` type is our *hash value*. 

All Objects have `hashCode()` method;

The built-in String class in Java, for example, might have the following code block:

```java
public class String {
    public int hashCode() {
        //implementation here
    }
}

```

Based on this example, we can call `key.hashCode()` to generate an integer hash code for a `String` instance called `key`. 

<img src=".\note_pics\hashCodesMethod.png" style="zoom:67%;" />

### Valid Hashcodes!

You may see this term in discussions and potentially on exams. What exactly makes a hash code "valid"? There are two properties:

1. **Deterministic:** The `hashCode()` function of two objects A and B who are equal to each other (`A.equals(B) == true`) have the same hashcode. *This also means the hash function cannot rely on attributes of the object that are not reflected in the* `.equals()` *method.*
2. **Consistent:** The `hashCode()` function returns the same integer every time it is called on the same instance of an object. This means the `hashCode()` function must be independent of time/stopwatches, random number generators, or any methods that would not give us a consistent `hashCode()` across multiple `hashCode()` function calls on the same object instance.

Note that there are no requirements that state that unequal objects should have different hash function values.



### `equals()` and `hashCode()`

==Bottom line: If your class override equals, you should also override hashCode in a consistent manner.==

- If two objects are equal, they must always have the same hash code.

If you don’t, everything breaks:

- `Contains` can’t find objects (unless it gets lucky).
- `Add` results in duplicates.

### Good Hashcodes!

You'll probably see this term a lot as well. But what makes a hashcode "good"? There are a few properties that can make a good `hashCode()`:

1. The `hashCode()` function must be valid.
2. The `hashCode()` function values should be spread as uniformly as possible over the set of all integers.
3. The `hashCode()` function should be relatively quick to compute [ideally O(1) constant time mathematical operations].

### Avoiding Collision

There are two common methods to deal with collisions in hash tables:

1. **Linear Probing:** Store the colliding keys elsewhere in the array, potentially in the next open array space. This method can be seen with distributed hash tables, which you will see in later computer science courses that you may take.(AKA: Open Addressing)
2. **External Chaining:** A simpler solution is to store all the keys with the same hash value together in a collection of their own, such as a `LinkedList`. This collection of entries sharing a single index is called a **bucket**.

### Resizing

No matter how good our `hashCode()` method is, if the underlying array of our hash table is small and we add a lot of keys to it, then we will start getting more and more collisions. Because of this, a hash table should expand its underlying array once it starts to fill up (much like how an `ArrayList` expands once it fills up).

For our hash table, we will define the maximum load factor that we will allow. **If adding another key-value pair would cause the load factor to exceed the specified maximum load factor, then the hash table should resize.** This is usually done by doubling the underlying array length. Java’s default maximum load factor is 0.75 which provides a good balance between a reasonably-sized array and reducing collisions.

As an example, let’s consider what happens if our hash table has an array length of 10 and currently contains 7 elements. Each of these 7 elements are hashed modulo 10 because we want to get an index within the range of 0 through 9. The current load factor is 7/10, or 0.7, just under the threshold.

If we try to insert one more element, we would have a total of 8 elements in our hash table and a load factor of 0.8. Because this would cause the load factor to exceed the maximum load factor, we must resize the underlying array to length 20 before we insert the element. Remember that since our procedure for locating an entry in the hash table is to take the `hashCode() % array.length` and our array’s length has changed from 10 to 20, all the elements in the hash table need to be relocated. Once all the elements have been relocated and our new element has been added, we will have a load factor of 8/20, or 0.4, which is below the maximum load factor.

### Runtime

* Comparing Data Structure Run Times!

| Text                                          | contains(x) | add(x)   |
| --------------------------------------------- | ----------- | -------- |
| Bushy BSTs                                    | Θ(log N)    | Θ(log N) |
| Seperate Chaining Hash Table with NO resizing | Θ(N)        | Θ(N)     |
| Seperate Chaining Hash Table with resizing    | Θ(1)        | Θ(1)     |

### Mutable HashSet Keys

In principle, we can create a `HashSet<List>`.

Weird stuff happens if:

- We insert a List into a HashSet.
- We later mutate that List.

All because a `List` is a <a href="#Immutable Data Type">mutable data type</a>, so when it gets changed, its Hash Code (i.e. key) changes but the contents remains in the original bucket. And then when you try to execute something like `contain()`, it will go to the new bucket to find the target and find nothing, whereas the target is still in the old bucket.

**Key Point**: Never mutate (modify) an object being used as a key. Incorrect results arise, and the item gets lost. [The slides for the Hashing II Lecture ](https://docs.google.com/presentation/d/1U_-RQCJB3j9B-k-kY8I4nS-FuxIvO8EgVIrOthx2InU/edit#slide=id.g2165b69ef3f_0_291)provide a very thorough visual example of this point.

<img src=".\note_pics\neverHashMutable.png" style="zoom:67%;" />

### Hash Bounus

Give a simple procedure that can be carried out by hand that takes a Java string X and finds another Java string Y with the same hashCode().

- Why do this?

  There are several reasons why someone might want to find another string with the same `hashCode()` as a given string:

  1. **Testing**: When testing hash-based data structures such as `HashSet` or `HashMap`, it can be useful to have multiple strings with the same hash code to test how the data structure handles collisions.
  2. **Security**: In some cases, an attacker might try to find multiple strings with the same hash code to exploit weaknesses in a hash-based data structure and cause a denial-of-service attack. By finding another string with the same hash code, one can better understand and prevent such attacks.
  3. **Curiosity**: Finding another string with the same hash code can be an interesting exercise in understanding how the `hashCode()` method works and how it distributes objects across buckets in a hash-based data structure.

- Here is a simple procedure that can be carried out by hand to find another Java string `Y` with the same `hashCode()` as a given Java string `X`:

  1. Let `X` be the given Java string and `n` be its length.
  2. Compute the `hashCode()` of `X` using the formula: `hash = s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]`, where `s[i]` is the ASCII value of the character at index `i` in string `X`.
  3. To find another string `Y` with the same hash code, we can simply swap two characters in string `X`. For example, if we swap the first and last characters of string `X`, we get a new string `Y`.
  4. Verify that strings `X` and `Y` have the same hash code by computing their hash codes using the formula above.

**Suggestion from hw3**

<a href="https://sp18.datastructur.es/materials/hw/hw3/hw3">source</a>

If you’d like to make your hashCodes work well for any number of buckets, you should ensure that it is not always a multiple of any number.

## Heaps and Priority Queue

**Priority Queue.** A Max Priority Queue (or PQ for short) is an ADT that supports at least the insert and delete-max operations. A MinPQ supposert insert and delete-min.

**Heaps.** A max (min) heap is an array representation of a binary tree such that every node is larger (smaller) than all of its children. This definition naturally applies recursively, i.e. a heap of height 5 is composed of two heaps of height 4 plus a parent.

We will define our binary min-heap as being **complete** and obeying **min-heap** property:

- Min-heap: Every node is less than or equal to both of its children
- Complete: Missing items only at the bottom level (if any), all nodes are as far left as possible.

**Implementation**

We can use an array to represent a min-Heap. By setting a descending order of items, we can yield an array as our desirable heap:

<img src=".\note_pics\heapApproach.png" style="zoom:67%;" />

- **Swim**

Given this implementation, we define the following code for the "swim" described in the Heap Operations section.

```java
public void swim(int k) {
    if (keys[parent(k)] ≻ keys[k]) {
		swap(k, parent(k));
		swim(parent(k));              
    }
}
```

This "swim" maintains the order of the array. And finding its parent is only a simple math thing:

```java
private int parent(int k) {
    int index = getIndex(k);
    return (index - 1) / 2;
}
```

And if you want a even simpler return equation, try this:

<img src=".\note_pics\heapApproach2.png" style="zoom:67%;" />

and you will find:

- `leftChild(k) `= *k∗ 2*

- `rightChild(k)` = *k ∗ 2 + 1*

- `parent(k) ` = *k / 2*

### Comparing to alternative implementations

| Methods          | Ordered Array | Bushy BST | Hash Table | Heap    |
| ---------------- | ------------- | --------- | ---------- | ------- |
| `add`            | Θ(N)          | Θ(logN)   | Θ(1)       | Θ(logN) |
| `getSmallest`    | Θ(1)          | Θ(logN)   | Θ(N)       | Θ(1)    |
| `removeSmallest` | Θ(N)          | Θ(logN)   | Θ(N)       | Θ(logN) |

- Heap operations are **amortized** analysis, since the array will have to resize (not a big deal)
- BST's can have constant time `getSmallest` if pointer is stored to smallest element
- Array-based heaps take around 1/3rd the memory it takes to represent a heap using approach 1A (direct pointers to children)

## Graph

A graph consists of:

- A set of nodes (or vertices)
- A set of zero of more edges, each of which connects two nodes.

**all trees are also graphs, but not all graphs are trees.**



### Simple Graphs only

> Graphs can be divided into two categories: *simple* graphs and *multigraphs* (or complicated graphs, a term I invented, because that's how I like to think of them.) Fortunately, in this course (and almost all applications and research) focuses only on simple graphs. So when we say "graph" in this course, you should always think of a "simple graph" (unless we say otherwise.)



### Category

<img src=".\note_pics\graphTypes.png" style="zoom:50%;" />

### terminology

**vertices**: i.e. nodes.

**edges**: same to tree edges.

### graph problems

**s-t Path**: Is there a path between vertices s and t?

**Connectivity**: Is the graph connected, i.e. is there a path between all vertices?

**Biconnectivity**: Is there a vertex whose removal disconnects the graph?

**Shortest s-t Path**: What is the shortest path between vertices s and t?

**Cycle Detection**: Does the graph contain any cycles?

**Euler Tour**: Is there a cycle that uses every edge exactly once?

**Hamilton Tour**: Is there a cycle that uses every vertex exactly once?

**Planarity**: Can you draw the graph on paper with no crossing edges?

**Isomorphism**: Are two graphs isomorphic (the same graph in disguise)?



### Traversal

#### **Depth-First Traversal(DFT)**:

<img src="\note_pics\depthFirstTraversal.png" style="zoom:67%;" />

- DFS: Find a path by using DFT(depth-first Traversal):

<img src="\note_pics\depthFirstTraversalDemo.png" style="zoom:67%;" />

##### DFS Preorder:

012345678(Order of dfs calls)

##### DFS Postorder:

347685210(dfs returns)



#### **Level Order Traversal(LOT)**

- **Breadth-First Search(BFS)** using LOT

  - ```pseudocode
    Initialize the fringe, an empty queue  /* a queue is a first-in-first-out DS */
        add the starting vertex to the fringe
        mark the starting vertex
        while fringe is not empty:
            remove vertex v from the fringe
            for each neighbor n of vertex v:
                if n is not marked:
                    add n to fringe
                    mark n
                    set edgeTo[n] = v
                    set distTo[n] = distTo[v] + 1
    ```

  <img src="\note_pics\BFPDemo.png" style="zoom:67%;" />

  BFS Order: Act in order of distance from source.

  - 0 1 24 53 68 7

<img src="\note_pics\DFSvsBFS.png" style="zoom:67%;" />

#### Summary

BFS finds you the **shortest** paths whereas DFS does not.

Is one more efficient than the other, **runtime-wise**?  - No. 

Is one more efficient than the other, **space-wise**?

- DFS is worse for spindly graphs. Imagine a graph with 10000 nodes all spindly. We'll end up making 10000 recursive calls, which is bad for space.
- BFS is worse for "bushy" graphs, because our queue gets used a lot.

### Graph API

To implement our graph algorithms like BFP and DFP, we need:

- An API
- An underlying data structure to represent our graph

Our choice can have profound implications on:

- Runtime
- Memory usage
- Difficulty of implementing various graph algorithms

We can then define our API to look something like this perhaps:

```java
public class Graph {
  public Graph(int V):               // Create empty graph with v vertices
  public void addEdge(int v, int w): // add an edge v-w
  Iterable<Integer> adj(int v):      // vertices adjacent to v
  int V():                           // number of vertices
  int E():                           // number of edges
...
}
```



Clients (people who wish to use our Graph data structure), can then use any of the functions we provide to implement their own algorithms. The methods we provide can have a significant impact on how easy/difficult it may be for our clients to implement particular algorithms.

we can now consider how a graph should be represented inside of a computer. We want to be able to get quick answers for the following questions about a graph:

- Are given vertices `u` and `v` adjacent?
- Is vertex `v` incident to a particular edge `e`?
- What vertices are adjacent to `v`?
- What edges are incident to `v`?

### Data structures implementing a graph

1. The Adjacency List

In an adjacency list, an array is created that has the same size as the number of vertices in the graph. Each position in the array represents one of the vertices in the graph. Each of these positions point to a list. These lists are called adjacency lists, as each element in the list represents a neighbor of the vertex.

<img src="\note_pics\adjecencyList.png" style="zoom:80%;" />

2. The Adjacency Matrix

In this data structure, we have a two dimensional array of size N×N (where N is the number of vertices) which contains boolean values. The (*i*, *j*)th entry of this matrix is true when there is an edge from *i* to *j* and false when no edge exists. Thus, each vertex has a row and a column in the matrix, and the value in that table says true or false whether or not that edge exists.

<img src="\note_pics\adjacencyMatrix.png" style="zoom:80%;" />

### Efficiency

Your choice of underlying data structure can impact the runtime and memory usage of your graph. This table from the [slides](https://docs.google.com/presentation/d/11iacyiFt3QUrzo1yAU_xoXAjGTH4UzV7o6CR04HYRrI/edit#slide=id.g54593997ea_0_422) summarizes the efficiencies of each representation for various operations. It is strongly not recommended to directly just copy this on to your cheatsheet for the exams without taking the time to first understand where and how these bounds fundamentally came to be. The lecture contains walkthroughs explaining the rationale in detail behind several of these cells.

Further, DFS/BFS on a graph backed by adjacency lists runs in O(V+E), while on a graph backed by an adjacency matrix runs in O(V^2). See the [slides](https://docs.google.com/presentation/d/11iacyiFt3QUrzo1yAU_xoXAjGTH4UzV7o6CR04HYRrI/) for help in understanding why.

<img src="\note_pics\graphRuntimes.png" style="zoom:67%;" />

### Summary

<img src="\note_pics\graphSummary.png" style="zoom:67%;" />



## Shortest Paths

- BFS and DFS are not good enough at finding shortest paths, especially when edges have **weights**.  
- Big notions:
  - What we care to minimize is the sum of the weights of the edges on the selected path.
  - the "Shortest Path Tree" will **always be a tree**.
  - the shortest paths tree from a source `s` can be created in the following way:
    - For every vertex `v` (which is not `s`) in the graph, find the shortest path from `s` to `v`.
    - "Combine"/"Union" all the edges that you found above.

### Visualization

<a ref="https://qiao.github.io/PathFinding.js/visual/">this website</a> allows you to visualize the implementations of Dijkstra's algorithm and A* algorithm. 



### Dijkstra's Algorithm

Dijkstra's algorithm takes in an input vertex *s*, and outputs the shortest path tree from *s*. How does it work?

1. Create a **priority queue**.
2. Add `s` to the priority queue with priority 0. Add all other vertices to the priority queue with priority ∞.
3. While the priority queue is not empty: pop a vertex out of the priority queue, and **relax** all of the edges going out from the vertex.

#### Relaxation

Suppose the vertex we just popped from the priority queue was `v`. We'll look at all of `v`'s edges. Say, we're looking at edge (`v`,`w`) (the edge that goes from `v` to `w`). We're going to try and relax this edge.

What that means is: Look at your current best distance to `w` from the source, call it `curBestDistToW`. Now, look at your `curBestDistToV + weight(v,w)` (let's call it `potentialDistToWUsing`).

Is `potentialDistToWUsing` better, i.e., smaller than `curBestDistToW`? In that case, set `curBestDistToW = potentialDistToWUsingV`, and update the `edgeTo[w]` to be `v`.

**Important note**: we **never relax edges that point to already visited vertices** and **no edge weight is smaller than 0. **

This whole process of calculating the potential distance, checking if it's better, and potentially updating is called relaxing.

#### Pseudocode

```pseudocode
def dijkstras(source):
    PQ.add(source, 0)
    For all other vertices, v, PQ.add(v, infinity)
    while PQ is not empty:
        p = PQ.removeSmallest()
        relax(all edges from p)
```

```pseudocode
def relax(edge p,q):
   if q is visited (i.e., q is not in PQ):
       return

   if distTo[p] + weight(edge) < distTo[q]:
       distTo[q] = distTo[p] + w
       edgeTo[q] = p
       PQ.changePriority(q, distTo[q])
```

<img src="\note_pics\DijkstrasAlgorithm.png" style="zoom:67%;" />



#### Runtime

Because it is based on **Priority Queue**, so we can take it as:

<img src="\note_pics\DijkstrasRuntime.png" style="zoom:67%;" />

### A* Algorithm

If you run Dijkstra's in<a ref="https://qiao.github.io/PathFinding.js/visual/"> the visualizer</a>, you will notice that the outcome is not ideal: the Dijkstra's just search every vertices in all directions.  Instead, we can find our destination more effective by using the A* Algorithm. You can check it in the visualizer.



<img src="\note_pics\AStar.png" style="zoom:50%;" />

**the better your original estimate from the node to the target, the better your estimate from the source to the target, the better your A* algorithm runs.**

The takeaway here is that heuristics need to be good. There are two definitions required for goodness.

1. Admissibility. heuristic(v, target) ≤ trueDistance(v, target). (Think about the problem above. The true distance from the neighbor of C to C wasn't infinity, it was much, much smaller. But our heuristic said it was ∞, so we broke this rule.)
2. Consistency. For each neighbor v of w:
   - heuristic(v, target) ≤ dist(v, w) + heuristic(w, target)
   - where dist(v, w) is the weight of the edge from v to w.

### Summary

https://cs61b-2.gitbook.io/cs61b-textbook/24.-shortest-paths/24.4-summary

<img src="\note_pics\ShortestPathsSummary.png" style="zoom:67%;" />

- <a ref="https://cs61b-2.gitbook.io/cs61b-textbook/24.-shortest-paths/24.5-exercises">This exercise</a> helps you understand better.

## Minimum Spanning Trees

A minimum spanning tree (MST) is the lightest set of edges in a graph possible such that all the vertices are connected. Because it is a tree, it must be connected and acyclic. And it is called "spanning" since all vertices are included.

### Cut property 

We can define a **cut** as an assignment of a graph’s nodes to two non-empty sets (i.e. we assign every node to either set number one or set number two).

We can define a **crossing edge** as an edge which connects a node from one set to a node from the other set.

With these two definitions, we can understand the **Cut Property**; 

**given any cut, the minimum weight crossing edge is in the MST.**

###  Prim's Algorithm

One way to find the MST of a graph is the Prim's Algorithm.

Prim's Algorithm is one way to find a MST from a graph. It is as follows:

1. Start from some arbitrary node.
2. Repeatedly add the shortest edge that has **one node inside the MST in construction.**
3. Repeat until there are V - 1 edges.

- **Why does it work?**

Prim's algorithm works because at all stages of the algorithm, we can reason as follows: 

- Consider dividing all the nodes in the graph into two sets:
  - Set 1: nodes that are part of the existing MST that's under construction
  - Set 2: all other nodes
- According to the algorithm, we always add the **lightest, or minimally weighted, edge** that crosses this cut.
- By **the Cut Property**, the added edge is necessarily part of the final MST.



- **Implementation**

Essentially, this algorithm ==runs via the same mechanism as [Dijkstra's algorithm]().==

==The only difference is that while Dijkstra's considers candidate nodes by their distance from the source node, Prim's looks at each candidate node's **distance from the MST under construction.**==

**Runtime**: 

- Because this algorithm runs through the same mechanism as Dijkstra's algorithm, its runtime is also identical to Dijkstra's:  O(*(V + E) \* log V*)

  - Remember, this is because we need to add to a priority queue fringe once for every edge we have, and we need to dequeue from it once for every vertex we have.

  

### Kruskal's Algorithm

The algorithm is as follows:

1. Sort all the edges from lightest to heaviest.
2. Taking one edge at a time (in sorted order), add it to the MST under construction if doing so **does not introduce a cycle.**
3. Repeat until there are V - 1 edges.

**Why does it work?**

Kruskal's algorithm works because of the following reasons:

- Recall the two "sets" introduced in last section. Any edge we add to the MST will be connecting one node from "set one" (nodes that are in the MST under construction), and another node from "set two" (all other nodes).
- The added edge is not part of cycle because we are only adding an edge if it does not introduce a cycle.
- By looking at edge candidates in order from lightest to heaviest, the added edge must be the lightest edge across this cut. (if there was a lighter edge that would be across this cut, it would have been added before this, and adding this one would cause a cycle to appear). 

**Comparing two algorithms**

It's important to note that the MST returned by Kruskal's might not be the same one returned by Prim's, but both algorithms will always return a MST.  

Since both are minimal (optimal), they will both give valid optimal answers (they are tied as equally minimal / same total weight, and this is as low as it can be).

**Runtime with Unsorted Edges**

Since the underlying data structures of implementing Kruskal's Algorithm are a Priority Queue (to sort the edges), and a Disjoined Set (to connect the edges), the runtime of Kruskal's Algorithm is in tandem with the runtime analysis of [Heaps]() and [WQU](). 

Specifically, we are using  [Weighted Quick Union with Path Compression]() to check whether or not an added edge will introduce a cycle. 

The operations that this algorithm utilizes and their corresponding runtime are:

- Insert: O(∣E∣log∣E∣)
- Delete minimum: O(∣E∣log∣E∣)
- Union: O(∣V∣log∗∣V∣)
- isConnected: O(∣E∣log∗∣V∣)

The bottleneck of the algorithm is sorting all of the edges to start (insert and delete minimum. Hence, the runtime of Kruskal's Algorithm is: O(*E log E*), And if **all edges are sorted** in advance by provided API, then the runtime is: O(*E log \* E*), Where *log∗* is the Ackermann function.

### Summary

In this chapter, we learned about Minimum Spanning Trees and the Cut Property:

- **MST:**  the lightest set of edges in a graph possible such that all the vertices are connected and acyclic. 
- **The Cut Property**: given any cut, the minimum weight crossing edge is in the MST.
  - *Cut*:  an assignment of a graph’s nodes to two non-empty sets 
  - *Crossing Edge:* an edge which connects a node from one set to a node from the other set.

We also learned about how to find MSTs of a graph with two algorithms: 

- **Prim's Algorithm**: Construct MST through a mechanism similar to Dijkstra's Algorithm, with the only difference of inserting vertices into the fringe not based on distance to goal vertex but distance to the MST under construction. 

- **Kruskal's Algorithm**: Construct MST by first sorting edges from lightest to heaviest, then add edges sequentially if no cycles are formed until there are V - 1 edges.

  

**And all algorithm are just fine to use since their runtimes are all at log level.**

<img src="\note_pics\MSTruntimes.png" style="zoom:50%;" />

<a href="https://cs61b-2.gitbook.io/cs61b-textbook/25.-minimum-spanning-trees/25.5-mst-exercises">Exercises here</a>.

intriguing problem: 

Design an algorithm to find the min-product spanning tree; i.e. the spanning tree with the minimum product of its edges. You may assume all edge weights are > 1.

hint: consider log a + log b = log ab.

## Recap all Data Structures

| Name           | Storage Operations               | Primary Retrieval Operation | Retrieve By                     |
| -------------- | -------------------------------- | --------------------------- | ------------------------------- |
| List           | `add(key)`, `insert(key, index)` | `get(index)`                | index                           |
| Map            | `put(key, value)`                | `get(key)`                  | key identity                    |
| Set            | `add(key)`                       | `containsKey(key)`          | key identity                    |
| Priority Queue | `add(key)`                       | `getSmallest()`             | key order (smallest to largest) |
| Disjoint Sets  | `connect(int_a, int_b`           | `isConnected(int_a, int_b)` | two integer values              |

One important thing to note is that these are **abstract** data types (ADTs), which means that we define the behavior of the data structure, not the implementation. There are multiple possible implementations for each of the data structures, and we can even use one data structure in the implementation of another! We often use these ADTs to create even more complex data structures. 

<img src="\note_pics\allDataStructures.png" style="zoom:50%;" />

<img src="\note_pics\allDatastructures2.png" style="zoom:50%;" />

<img src="\note_pics\moreDataStructures.png" style="zoom:50%;" />

**Data Structure**:  A particular way of organizing data.

- We've covered many of the most fundamental abstract data types, their common implementations, and their tradeoffs thereof.
- We'll do one more:
  - The quadtree

## Tries

Knowing the types of data that you are storing can give you great power in creating efficient data structures. Specifically for implementing Maps and Sets, if we know that all keys will be Strings, we can use a Trie:

- Tries theoretically have better performances for searching and insertion than hash tables or balanced search trees

<img src="\note_pics\trie.png" style="zoom:50%;" />

- There are more implementations for how to store the children of every node of the trie, specifically three. These three are all fine, but hash table is the most natural
  - *DataIndexedCharMap* (Con: excessive use of space, Pro: speed efficient)
  - *Bushy BST* (Con: slower child search, Pro: space efficient)
  - *Hash Table* (Con: higher cost per link, Pro: space efficient)
- Tries may not actually be faster in practice, but they support special string operations that other implementations don't
  - `longestPrefixOf` and `keysWithPrefix` are easily implemented since the trie is stored character by character
  - `keysWithPrefix` allows for algorithms like autocomplete to exist, which can be optimized through use of a priority queue.

| Name                  | key type   | get(x)  | Text    |
| --------------------- | ---------- | ------- | ------- |
| Balanced BST          | comparable | Θ(logN) | Θ(logN) |
| RSC Hash Table        | hashable   | Θ(1)†   | Θ(1)∗†  |
| Data Indexed Array    | chars      | Θ(1)    | Θ(1)    |
| Tries (BST, HT, DICM) | strings    | Θ(1)    | Θ(1)    |

*: on average, †\dag†: items are evenly spread

**Advantages of Tries.** Tries have very fast lookup times, as we only ever look at as many characters as they are in the data we’re trying to retrieve. However, their chief advantage is the ability to efficiently support various operations not supported by other map/set implementations including:

- longestPrefixOf
- prefixMatches
- spell checking

**<a href="https://cs61b-2.gitbook.io/cs61b-textbook/26.-prefix-operations-and-tries/26.5-exercises">Trie Exercises</a>**

## Basic Sorts

### Selection Sort

Selection sort uses the following algorithm:

1. Find the smallest item.
2. Swap that item to the front.
3. Repeat until all items are fixed (there are no inversions).

You can see a demo of the sorting algorithm [here](https://docs.google.com/presentation/u/1/d/1p6g3r9BpwTARjUylA0V0yspP2temzHNJEJjCG41I4r0/edit?usp=sharing).

Selection sort runs in Θ(N^2^) time using an array or similar data structure.  It is inefficient!

### Heapsort

#### Naive Heapsort Analysis

The overall runtime of this algorithm is Θ(Nlog⁡N). There are three main components to this runtime:

- Inserting N items into the heap: O(Nlog⁡N)
- Selecting the largest item: Θ(1)
- Removing the largest item: O(log⁡N)

In terms of memory usage, the output array takes an extra Θ(N) space. This is worse than selection sort, which uses no extra space, but the improvement in runtime far outweighs this downside.

Even more, we can use a trick with heapsort to get rid of the extra output array.

#### In-place Heapsort

As an alternate approach, we can use the input array itself to form the heap and output array.

In this approach, we can use a process known as *bottom-up heapification* to convert the input array into a heap. Bottom-up heapification involves moving in reverse level order up the heap, sinking nodes to their appropriate location as you move up.

By using this approach, we avoid the need for an extra copy of the data. Once heapified, we use the naive heapsort approach of popping off the maximum and placing it at the end of our array. In doing so, we maintain an "unsorted" front portion of the array (representing the heap) and a "sorted" back portion of the the array (representing the sorted items so far).

<img src="\note_pics\inPlaceHeapSorting.png" style="zoom:67%;" />

You can see a demo of this algorithm [here](https://docs.google.com/presentation/d/1SzcQC48OB9agStD0dFRgccU-tyjD6m3esrSC-GLxmNc/edit?usp=sharing).

This process overall is still O(N log ⁡N), since bottom-up heapification requires at most N sink-down operations that take at most log⁡ N time each. Using in-place heapsort, we reduce the memory usage of heapsort to Θ(1).

### Mergesort

1. Split the items into half.
2. Mergesort each half.
3. Merge the two sorted halves to form the final result.

You can see a demo of the algorithm [here](https://docs.google.com/presentation/d/1h-gS13kKWSKd_5gt2FPXLYigFY4jf5rBkNFl3qZzRRw/edit#slide=id.g463de7561_042). 

Mergesort has a runtime of Θ(N log ⁡N). 

The auxiliary array used during the merge step requires Θ(N)\Theta(N)Θ(N) extra space. Note that in-place mergesort is possible; however it is very complex and the runtime suffers by a significant constant factor, so we will not cover it here.

<a href="https://cs61b-2.gitbook.io/cs61b-textbook/15.-asymptotics-ii/15.4-mergesort">reference</a>

### Insertion Sort

#### Naive Insertion Sort

In insertion sort, we start with an empty output sequence. Then, we select an item from the input, inserting into the output array at the correct location.

Naively, we can do this by creating a completely seperate output array and simply putting items from the input there. You can see a demo of this algorithm [here](http://goo.gl/bVyVCS).

For the naive approach, if the output sequence contains k items so far, then an insertion takes O(k) time (shifting every item over in the output array).

#### In-place Insertion Sort

We can improve the time and space complexity of insertion sort by using in-place swaps instead of building a seperate output array. 

You can see a demo of this algorithm [here](https://docs.google.com/presentation/d/10b9aRqpGJu8pUk8OpfqUIEEm8ou-zmmC7b_BE5wgNg0/edit#slide=id.g463de7561_042).

Essentially, we move from left to right in the array, selecting an item to be swapped each time. Then, we swap that item as far to the front as it can go. The front of our array gradually becomes sorted until the entire array is sorted.

The best-case runtime of insertion sort is Θ(N)--when there are no swaps, we simply do a linear scan through the array. The worst-case runtime of insertion sort is Θ(N^2^)--in a reverse-sorted array, we have to swap every item all the way to the front.

on arrays with a small number of inversions, insertion sort is probably the fastest sorting algorithm. The runtime is Θ(N+K), where K is the number of inversions in the array. If we define an almost-sorted array as one where the number of inversions K < cN for some constant c, then insertion sort runs in linear time.

A less obvious empirical fact is that insertion sort is extremely fast on small arrays, usually of size 15 or less. The analysis of this is beyond the scope of the course, but the general idea is that divide-and-conquer algorithms (like heapsort and mergesort) spend too much time on the "dividing" phase, whereas insertion sort starts sorting immediately. In fact, the Java [implementation](http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/util/Arrays.java#Arrays.mergeSort(java.lang.Object[]%2Cjava.lang.Object[]%2Cint%2Cint%2Cint)) of mergesort uses insertion sort when the split becomes less than 15 items. 

### Insertion Sort vs Selection Sort

Asymptotically, both selection and insertion sort run in Θ(N^2^) on a reverse-sorted array. However, note that selection sort only does N total swaps (finding the maximum, then swapping to the front), while insertion sort does on the order of N^2^ swaps (swapping each item to the front), so insertion sort will actually be slower by a constant factor.

### Runtime

 <img src="\note_pics\sortRuntime.png" style="zoom:50%;" />

## Quick Sort

The core idea behind Quicksort involves **partitioning.** 

**pivot**: Partitioning on that pivot element (x) involves rearrange a[] such that: 

1. x moves to some position j (can be the original position of i)
2. All array elements to the left of x are less than or equal to x (<= x) 
3. All array elements to the right of x are greater than or equal to x (>= x)

### Tony Hoare’s Quicksort algorithm

**Quick Sort Algorithm**: 

1. Partition on the leftmost item as the pivot. 
2. Recursively quicksort the left half. 
3. Recursively quicksort the right half. 

<img src="\note_pics\quickSort.png" style="zoom:50%;" />

<a href="https://docs.google.com/presentation/d/1QjAs-zx1i0_XWlLqsKtexb-iueao9jNLkN-gW9QxAD0/edit">Quicksort Demo</a>

<a href="https://cs61b-2.gitbook.io/cs61b-textbook/30.-quicksort/30.2-quicksort-algorithm">reference</a>

### Hoare Partitioning

<img src="\note_pics\HoarePartitioning.png" style="zoom:50%;" />

The implementation is based on:

<img src="\note_pics\TonyHoare.png" style="zoom:67%;" />



### Performance Caveats

#### Best Case

For instance, the best case runtime is when the pivot chosen always lands in the middle (in other words, the partition always picks the median element of the array). 

<img src="\note_pics\quickSortBestCase.png" style="zoom:50%;" />

In the best case, the total work done at each level is approximately O(N). To see this, the first partition pivots on one element and requires checking all N elements to determine whether they go on the right or the left of the pivot element. The second layer repeats this, but for N/2 elements on two separate pivots (since we are recursively partitioning on the two halves). Thus, each level is O(N) work. 

The overall runtime becomes Θ(NH)\Theta(NH)Θ(NH), where H = # of layers = Θ(logN). Thus, the total runtime for Quicksort in the best case is Θ(N log N).

#### Worst Case

The worst case for runtime occurs when the pivot chosen at each partition lands at the beginning of the array. In this scenario, each layer still has to do O(N) work, but now there are H = # of layers = N layers, since every single element has to be pivoted on. Thus, the worst case runtime is Θ(N^2^).

<img src="\note_pics\quickSortWorstCase.png" style="zoom:50%;" />

#### Quicksort vs Mergesort

![](\note_pics\quicksortvsMergeSort.png)

In comparison, Mergesort seems to be a lot better, since Quicksort suffers from a theoretical worst case runtime of Θ(N^2^). So how can Quicksort be the fastest sort empirically? Quicksort's advantage empirically comes from the fact that on average, Quicksort is Θ(N log N).

<img src="\note_pics\quicksortvsMergesort2.png" style="zoom:63%;" />



#### Avoiding the Worst Case of Quicksort

As you can see from above, the performance of Quicksort (both in terms of order of growth and in constant factors) depends critically upon **how you select the pivot, how you partition around the pivot, and other optimizations that you can add to speed things up.** 

Given certain conditions, Quicksort can result in Θ(N^2^), which is much worse than Θ(N log N). Some of these conditions include **bad ordering,** where the array is already in sorted order (or almost sorted order), and **bad elements,** where the array has all duplicates. 

There are four ways to avoid worst case in Quicksort:

1. Randomness: pick a random pivot shuffle before sorting.
2. Smart pivot selection: Calculate or approximate the median.
3. Introspect: Switch to another sort if recursion goes deep.
4. Preprocess the array: but knowing an array before sorting it is hard.

### Quick selection

Computing the exact median would be great for picking an item to partition around. Gives us a "safe quick sort".

But it turns out that exact median computation is slow.

However, it turns out that partitioning can be useful to find the exact median, and the result algorithm is the best known median identification algorithm.

### Sorting Stability

 A sort is stable if the order of equal items is preserved. This is desirable, for example, if we want to sort on two different properties of our objects. Know how to show the stability or instability of an algorithm. 

<img src="\note_pics\sortStability.png" style="zoom:67%;" />

### Summary

In summary, Quicksort utilizes partitioning on pivot elements to recursively sort an array. 

In the best case, Quicksort achieves Θ(N log N) time, which is the same as the best case of Mergesort.

Empirically, Quicksort is the fastest sort in the average case, with Θ(N log N) expected runtime for a randomly chosen array case.

However, Quicksort has a bad worst case runtime of Θ(N^2^), which occurs in specific cases where the pivot is consistently chosen near the edge of the array. In comparison, Mergesort has a worst case runtime of Θ(N log N).

<img src="\note_pics\sortingSummary.png" style="zoom:50%;" />

**Quicksort is the fastest**, but the prerequisites are:

-  optimal pivot selection
- optimal partition algorithm
- optimal avoiding worst cases

## Sort Summary

<img src="\note_pics\SortSummary.png" style="zoom:50%;" />

**Optimizing Sorts.** We can play a few tricks to speed up a sort.

- One is to switch to insertion sort for small problems (< 15 items). Another is to exploit existing order in the array. 

- A sort that exploits existing order is sometimes called “adaptive”. Python and Java utilize a sort called *Timsort* that has a number of improvements, resulting in, for example Θ(N) performance on almost sorted arrays. 

- A third trick, for worst case N^2^ sorts only, is to make them switch to a worst case N log ⁡N sort if they detect that they have exceeded a reasonable number of operations.
- Exploiting restrictions on set of keys, if numberof keys are constant, e.g. [3,4,1,2,3,4 ..., 2,2,2,1,3,4,2,3]

**In Java**, Array.sort(someArray) uses:

- Mergesort(specifically the TimSort variant) if someArray consists of Objects.
- Quicksort if someArray consists of primitives.

### Sorting Bounds

#### Math!

**Math Problem Out of Nowhere 1.** We showed that N!∈Ω((N/2)).

**Math Problem Out of Nowhere.** We showed that log(N!)∈Ω(N log N), and that N log N∈Ω(log(N!)). Therefore log(N!)∈Θ(N log N).

#### Puppy, Cat, Dog Problem

if we have puppy, cat and dog each inside one of three boxes, and only try to identify who is in which box by using a scale to weigh the box(Assuming the weight of puppy < cat < dog). By reducing this problem to a sorting problem,  since there are 3! = 6 permutations, we need at least ceil(lg(6)) = 3 questions to resolve the answer. And for N boxes with N animals inside,  there are N! permutations, meaning we need lg(N!) questions to win the game of puppy-cat-dog, and by extension, we need at least lg(N!) to sort N items with yes/no questions. 

Since **log(N!)∈Θ(N log N)**, we can say that the hypothetical best sorting algorithm that uses yes/no questions requires Ω(N log N) yes/no questions. **Thus, there is no comparison based algorithm that has a worst case that is a better order of growth than Θ(N log N) compares. **

#### Conclusion

No comparison based sort's comparisons times will be less than order N log N! 

<img src="\note_pics\sortBound.png" style="zoom:85%;" />



## Radix Sort

You can do a quick review of Counting Sort and Radix Sort by visiting <a href="https://sp18.datastructur.es/materials/lab/lab13/lab13">this Lab</a>.

**Terminology.**

- Radix - just another word for ‘base’ as in the base of a number system. For example, the radix for words written in lowercase English letters is 26. For number written in Arabic numerals it is 10.
- Radix sort - a sort that works with one character at a time (by grouping objects that have the same digit in the same position).

**Counting Sort.** Allows you to sort N keys that are integers between 0 and R-1 in θ(N + R) time. Beats linearithmic lower bound by avoiding any binary compares. This is a completely different philosophy for how things should be sorted. This is the most important concept for this lecture.

<img src="\note_pics\countingSort.png" style="zoom:45%;" />

Counter sort is not based on  "puppy, cat and Dog" , so it can break runtime restrain. 

It is also a hard to use this when the keys aren't numerical or consecutive or have a lots of keys are the same.

<img src="\note_pics\countSortDemo.png" style="zoom:50%;" />

**LSD.** In the LSD algorithm, we sort by each digit, working from right to left. Requires examination of θ(WN) digits, where W is the length of the longest key. Runtime is θ(WN + WR), though we usually think of R as a constant and just say θ(WN). The θ(WR) part of the runtime is due to the creation fo length R arrows for counting sort. We usually do LSD sort using counting sort as a subroutine, but it’s worth thinking about whether other sorts might work as well.

<img src="\note_pics\LSDRadixSort.png" style="zoom:40%;" />

**LSD vs Comparison Sorting.** Our comparison sorts, despite requiring θ(N log N) time, can still be faster than LSD sort, which is linear in the length of our input θ(WN). For extremely large N, LSD sort will naturally win, but log N is typically pretty small. Know which algorithm is best in the two extreme cases of very long dissimilar strings and very long, nearly equal strings.

**MSD.** In MSD sorting, we work from left to right, and solve each resulting subproblem independently. Thus, for each problem, we may have as many as R subproblem. Worst case runtime is exactly the same as LSD sort, θ(WN + WR), though can be much better. In the very best case, where we only have to look at the top character (only possible for R > N), we have a runtime of θ(N + R).

Sorting runtime of sorts

<img src="\note_pics\sortingRuntine.png" style="zoom:50%;" />



## Compression

**Compression Model #1: Algorithms Operating on Bits.** Given a sequence of bits B, we put them through a compression algorithm C to form a new bitstream C(B). We can run C(B) through a corresponding decompression algorithm to recover B. Ideally, C(B) is less than B.

**Variable Length Codewords.** Basic idea: Use variable length codewords to represent symbols, with shorter keywords going with more common symbols. For example, instead of representing every English character by a 8 bit ASCII value, we can represent more common values with shorter sequences. 

**Prefix Free Codes.** If some codewords are prefixes of others, then we have ambiguity, as seen in Morse Code. A prefix free code is a code where no codeword is a prefix of any other. Prefix free codes can be uniquely decoded.

### **Shannon-Fano Coding.** 

Shannon-Fano coding is an intuitive procedure for generating a prefix free code. First, one counts the occurrence of all symbols. Then you recursively split characters into halves over and over based on frequencies, with each half either having a 1 or a 0 appended to the end of the codeword.

<img src="\note_pics\Shanno-FanoCoding.png" style="zoom:50%;" />

But Shannon-Fano Coding is **NOT** optimal.

### **Huffman Coding.** 

Huffman coding generates a provably optimal prefix free code, unlike Shannon-Fano, which can be suboptimal. 

1. First, one counts the occurrence of all symbols, and create a “node” for each symbol. 
2. We then merge the two lowest occurrence nodes into a tree with a new supernode as root, with each half either having a 1 or a 0 appended to the beginning of the codeword.
3.  Repeat this until all symbols are part of the tree. Resulting code is optimal.

<img src="\note_pics\HuffmanCoding.png" style="zoom:50%;" />



**Two ways of Huffman implementation**

<img src="\note_pics\2HuffmanUsage.png" style="zoom:40%;" />

Approach 2 is applied in the real world.

-  If we have an image file of something like the hugplant.bmp from lecture, we can break it into 8 bit chunks and then Huffman encode it. If we give this file to someone else, they probably won’t know how to decompress it, since **Huffman coding is not a standard compression algorithm supported by major operating systems.** Thus, we also need to provide the Huffman decoding algorithm. 

### **Data Structures**

To implement Huffman Coding:

- Compression: Count frequencies, build an **encoding array** and a **decoding trie**, write the trie to the output, and then look up each symbol in the encoding array and write out the appropriate bit sequence to the output. 

<img src="\note_pics\Compression.png" style="zoom:40%;" />

- Decompression: Read in the trie, then repeatedly use longest prefix matching to recover the original symbol(take advantage of prefix-free code!).

<img src="\note_pics\Decompression.png" style="zoom:45%;" />



**Huffman Demos**

Compression Demo:

<img src="\note_pics\HuffmanCompressionDemo.png" style="zoom:40%;" />



Decompression Demo:

<img src="\note_pics\HuffmanDecompressionDemo.png" style="zoom:40%;" />



**Huffman Coding Summary**

Given a file X.txt that we'd like to compress into X.huf:

- Consider each b-bit symbol (e.g. 8-bit chunks, Unicode characters, etc.) of X.txt, counting occurrences of each of the 2^b^ possibilities, where b is the size of each symbol in bits.
- Use Huffman code construction algorithm to create a decoding tire and encoding map. Store this tire at the beginning of X.huf.
- Use encoding map to write codeword for each symbol of input into X.huf.

To decompress X.huf:

- Read in the decoding queue trie.
- Repeatedly use the decoding tire's longestPrefixOf operation until all bits in X.huf  have been converted back to their uncompressed form.

### General Principle Behind Compression

**General Principles Behind Compression.** More generally, the goal is to exploit redundancy and existing order in the input.

**Universal Compression is Impossible.** It is impossible to create an algorithm that can compress any bitstream by 50%. Otherwise, you could just compress repeatedly until you ended up with just 1 bit, which is clearly absurd. A second argument is that for an input bitstream of say, size 1000, only 1 in 2^499 is capable of being compressed by 50%, due to the pigeonhole principle.



**Compression Model #2: Self Extracting Bits.** It seems to make more sense to include not just the compressed bits when considering the size of our output, but also **the algorithm** used to do the decompression.

 

# Project 1

It is suggested that you should use **Sentinel node** in project 1.

style guide: https://sp19.datastructur.es/materials/guides/style-guide.html



guide: https://docs.google.com/presentation/d/1XBJOht0xWz1tEvLuvOL4lOIaY0NSfArXAvqgkrx0zpc/edit#slide=id.g15cbbcb770b_47_40



# Project 3

- if you find the data you need for this project in your `library-sp18` folder is missing,  you can update it by running `git pull origin master` inside the `library-sp18` directory, and if everything works as it should, you should see a collection of thousands of png files appear in the `library-sp18/data` folder.

- The latest version of intellij has removed `Import Project window` and thus you can't find `Import Maven projects automatically` . You can solve this problem by referring to: <a href="https://stackoverflow.com/questions/60759611/import-maven-projects-automatically-checkbox-dissapear-in-intellij-eap">this post</a>:

> By following ways you can Import `Maven` projects automatically:
>
> For `InteliJ IDEA 14` upwards:
>
> ```rust
> Click Settings -> Build, Execution, Deployment -> Build Tools -> Maven -> Importing -> TICK "Import Maven projects automatically".
> ```
>
> For `InteliJ IDEA 2020` upwards:
>
> ```rust
> Click Settings -> Build, Execution, Deployment -> Build Tools -> TICK "Reload projects after changes in the build scripts" and "Any changes"
> ```



## Resource

latest code: https://github.com/Berkeley-CS61B/lectureCode-fa22



# Supplementary Knowledge

## Git things

[Git Help Document](https://sp18.datastructur.es/materials/guides/using-git.html)

[Git WTFs](https://sp18.datastructur.es/materials/guides/git-wtfs.html) （git weird technical failure scenarios）

As a side note on development workflow, it is a good idea to commit your code as often as possible. Whenever you make significant (or even minor) changes to your code, make a commit. If you are trying something out that you might not stick with, commit it (perhaps to a different branch, which will be explained below).

### Undoing Changes

The Git reference has a great section on [undoing things](http://git-scm.com/book/en/Git-Basics-Undoing-Things). Please note that while Git revolves around the concept of history, it is possible to lose your work if you revert with some of these undo commands. Thus, be careful and read about the effects of your changes before undoing your work.

- Unstage a file that you haven’t yet committed:

  ```
    $ git reset HEAD [file]
  ```

  This will take the file’s status back to modified, leaving changes intact. Don’t worry about this command undoing any work. This command is the equivalent of deleting one of the temporary images that you’re going to combine into a panorama.

  Why might we need to use this command? Let’s say you accidentally started tracking a file that you didn’t want to track. (an embarrassing video of yourself, for instance.) Or you were made some changes to a file that you thought you would commit but no longer want to commit quite yet.

- Amend latest commit (changing commit message or add forgotten files):

  ```
    $ git add [forgotten-file]
    $ git commit --amend
  ```

  Please note that this new amended commit will replace the previous commit.

- Revert a file to its state at the time of the most recent commit:

  ```
    $ git checkout -- [file]
  ```

  This next command is useful if you would like to actually undo your work. Let’s say that you have modified a certain `file` since committing previously, but you would like your file back to how it was before your modifications.

  **Note**: This command is potentially quite dangerous because any changes you made to the file since your last commit will be removed. Use this with caution!

### Remote

```bash
git push origin main  //push your latest commit to github
```



- git issue : [LF will be replaced by CRLF in git - What is that and is it important?](https://stackoverflow.com/questions/5834014/lf-will-be-replaced-by-crlf-in-git-what-is-that-and-is-it-important)

