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

see more in: <a href="#Array Plus">here</a>

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

## set debug config in vsCode

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

click <a href="#Generic List">here</a> to create a generic class constructor that takes any kinds of variable.

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



## Overload

Two methods with the same name is allowed in Java, since they **have different parameters**. We say that two methods with the same name but different signatures are **overloaded**.



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

​	

# Git things

[Git Help Document](https://sp18.datastructur.es/materials/guides/using-git.html)

[Git WTFs](https://sp18.datastructur.es/materials/guides/git-wtfs.html) （git weird technical failure scenarios）

As a side note on development workflow, it is a good idea to commit your code as often as possible. Whenever you make significant (or even minor) changes to your code, make a commit. If you are trying something out that you might not stick with, commit it (perhaps to a different branch, which will be explained below).

## Undoing Changes

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

## Remote

```bash
git push origin main  //push your latest commit to github
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







# Prjct 1

It is suggested that you should use **Sentinel node** in project 1.

style guide: https://sp19.datastructur.es/materials/guides/style-guide.html



guide: https://docs.google.com/presentation/d/1XBJOht0xWz1tEvLuvOL4lOIaY0NSfArXAvqgkrx0zpc/edit#slide=id.g15cbbcb770b_47_40

## Resource

latest code: https://github.com/Berkeley-CS61B/lectureCode-fa22



# Supplementary Knowledge

1. git issue : [LF will be replaced by CRLF in git - What is that and is it important?](https://stackoverflow.com/questions/5834014/lf-will-be-replaced-by-crlf-in-git-what-is-that-and-is-it-important)



