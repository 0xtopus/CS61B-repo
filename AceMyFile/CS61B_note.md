# Intro

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

# Compilation

The standard tools for executing Java programs use a two step process:

<img src=".\note_pics\javaCompilation.png" style="zoom:80%;" />

- Why make a .class file at all?
  - .class file has been type checked. Distributed code is safer.
  - .class files are simpler for computers to execute. Distributed code is faster.
  - And it can also protect your intellectual property for no need to give out source.

# Defining and Using Classes

https://joshhug.gitbooks.io/hug61b/content/chap1/chap12.html

https://sp18.datastructur.es/materials/lectures/lec2/lec2.html

<img src=".\note_pics\javaClassTerminology.png" style="zoom:80%;" />

<img src=".\note_pics\defAClass.png" style="zoom:80%;" />



## static vs non-static

you'd better access **static things** by class name and access **non-static things** by specific instance.



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



# Java的数据类型

8种基本类型(primitive)：byte、short、int、long、float、double、boolean、char

plus one **reference type**: Objects，arrays.... ect.

to both types, the *Golden Rules of Equation* is effective. However, the latter stores either **null** or **an arrow** points to where the data is.

# Linked List

[linked list](https://www.javatpoint.com/singly-linked-list): an ordered set of data elements, each containing a link to its successor (and sometimes its predecessor).

## a way to build list in Java

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





# Supplementary Knowledge

1. git issue : [LF will be replaced by CRLF in git - What is that and is it important?](https://stackoverflow.com/questions/5834014/lf-will-be-replaced-by-crlf-in-git-what-is-that-and-is-it-important)

