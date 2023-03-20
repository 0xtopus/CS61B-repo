

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
- All variables must be public static final.
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

    

you can use **61B Style Checker** in IntelliJ CS61B plugin to help you check your style.

## Troubleshooting

-  **错误： 编码 GBK 的不可映射字符**
  - 解决方案：
    1. 使用 `javac -encoding UTF-8 <filename>`编译;
    2. java源程序代码在保存时把java文件转换成ANSI编码格式即可。
-  check *IntelliJ* key board shortcut: `Ctrl` + `Alt` +`S` --> `Keymap`
   - ref: https://www.jetbrains.com/help/idea/configuring-keyboard-and-mouse-shortcuts.html
-  <a href="https://www.cnblogs.com/huangguoming/p/15682942.html">warning: commented out code</a> 建议不要注释代码
-  Permanently Set Up Libraries in IntelliJ:  <a ref="https://sp18.datastructur.es/materials/lab/lab4/lab4">link</a>

- Set debug config in vsCode

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
    
    

- Get rid of all numbers at the beginning of the lines when you copy some codes from exercise pdf files:

  **chatGPT**:

  Here's the updated *regular expression*: `^\d+\s*`.

  This pattern will match a sequence of one or more digits at the beginning of a line, followed by zero or more whitespace characters. The `*` after the `\s` means "zero or more".


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



## Disjoint Sets

Two sets are named *disjoint sets* if they have no elements in common. A Disjoint-Sets (or Union-Find) data structure keeps track of a fixed number of elements partitioned into a number of *disjoint sets*. The data structure has two operations:

1. `connect(x, y)`: connect `x` and `y`. Also known as `union`
2. `isConnected(x, y)`: returns true if `x` and `y` are connected (i.e. part of the same set).



- By applying different means, the results of cost varies:<img src="..\AceMyFile\note_pics\DisjointSet.png" style="zoom:67%;" />




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

B-trees are balanced search trees that maintain perfect balance by setting a limit on the number of elements in a single node and splitting nodes in half when they reach that limit. They are also known as 2-3-4 or 2-3 Trees, which refers to the number of children each node can have. The insertion process involves inserting into a leaf node and popping up the middle left node if necessary until the parent node can accommodate or you reach the root.

**Insertion Process**

Here’s a brief and intuitive summary of the insertion process for B-trees:

1. Traverse down the tree with the node to be inserted, going left and right according to whether or not the node is greater than or smaller than the items in each node.
2. Add the node to a leaf node.
3. If the new node has more than the maximum number of elements allowed (e.g., 4 for a 2-3-4 tree), pop up the middle left node and re-arrange the children accordingly.
4. If this results in a parent node having more than the maximum number of elements allowed, repeat step 3 until you reach a parent that can accommodate or you get to the root.

**B-Tree Invariants**

A B-tree has the following helpful invariants:

- All leaves must be the same distance from the source.
- A non-leaf node with *k* items must have exactly k+1 children.

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

# Project 1

It is suggested that you should use **Sentinel node** in project 1.

style guide: https://sp19.datastructur.es/materials/guides/style-guide.html



guide: https://docs.google.com/presentation/d/1XBJOht0xWz1tEvLuvOL4lOIaY0NSfArXAvqgkrx0zpc/edit#slide=id.g15cbbcb770b_47_40

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

