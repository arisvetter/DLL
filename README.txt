Design: describe the roles of and relationships between the interface and classes that make up this program. You had choices about how to implement many methods; why did you choose what you chose?
Testing: a detailed description of your testing procedure. You should describe how you tested your class and what bugs you found and fixed by doing so.
Discussion: a discussion of your experience writing this assignment. This could be in the form of a journal.

////IS TESTING FILE CORRECT?
//FIX NODE2
//did i get generics right in the overview?
****************
* Double Linked List
* CS 221 003
* March 31, 2024
* Aris Vetter
**************** 

OVERVIEW:

 This program creates an indexed unsorted double linked list (DLL) in which elements can be
 manipulated (added, removed, set to different values, and more) and various
 values can be retrieved (elements in particular spots, overall size,
 if an element is in the list, a string format of the list, and more). 
 The DLL also allows for a list iterator to be made, which provides standardized
 navigation and manipulation of the list. The DLL was created with generic types,
 meaning that it supports holding any object type.

INCLUDED FILES:

 * IUDoubleLinkedList.java - source file
 * ListTester.java - source file
 * IndexedUnsortedList.java - source file
 * Node.java - source file
 * README.txt - this file


COMPILING AND RUNNING:

 From the directory containing all source files, compile the
 driver class, which is ListTester.java, (and all dependencies) with the command:
 $ javac ListTester.java

 Run the compiled class file with the command:
 $ java ListTester

 Console output will give the results of the tests after the program finishes.


PROGRAM DESIGN AND IMPORTANT CONCEPTS:

This program creates an Indexed Unsorted Double Linked List.

Starting from the basics, a general list is an abstract data type (ADT), or the mental
model of how data is managed. It's important that whatever the ADT is--whether that's a 
stack, queue, or in this case, a list--the operations that can be performed on that data
align with what makes sense in the user's mind for that ADT. 

While stacks and queues have a little more restrictions on what operations can be performed,
lists have considerably more options. common types

This specific program creates an indexed list, meaning that the elements can be accessed
directly by their location (for instance, the 7th element in the list). Personally, I think 
of it like when you start typing a numbered To Do List on Microsoft Word. You can add or delete
To Do List items at any point in your document and the numbers are automatically updated. 

Additionally, this list is an unsorted list, meaning that there is no inherent order. For 
a sorted list, for instance, String elements could be maintained so they were always in 
alphabetical order. However, for an unsorted list, the elements stay in the relative position
that they were placed in (of course, this position will be affected by the placement/deletion
of other elements in the list, not saying that the 3rd element will necessarily always be the 
third element).


In this project, a double linked list was created.
what is a list

--what is a double linked list
    -what is a node
    -generic types
    -order run time
    -situations it would be ideal for
    -what you are looking to optimize
    -other list options available

-List iterators vs iterators
    -why have an iterator
    -potential advantages of previous
    -section where I started from the back if in the back half... 
    -using iterators to perform all other methods

-DLL
-IUList
-node
-DLLIterator

-why use DLLIterator in all of my method implementation? clarity, simplicity, less code duplication MAYBE NOT ALWAYS MORE EFFICIENT
-only a few methods where it was completely unecessary



 This is the sort of information someone who really wants to
 understand your program - possibly to make future enhancements -
 would want to know.

 Explain the main concepts and organization of your program so that
 the reader can understand how your program works. This is not a repeat
 of javadoc comments or an exhaustive listing of all methods, but an
 explanation of the critical algorithms and object interactions that make
 up the program.

 Explain the main responsibilities of the classes and interfaces that make
 up the program. Explain how the classes work together to achieve the program
 goals. If there are critical algorithms that a user should understand, 
 explain them as well.
 
 If you were responsible for designing the program's classes and choosing
 how they work together, why did you design the program this way? What, if 
 anything, could be improved? 

TESTING:

 How did you test your program to be sure it works and meets all of the
 requirements? What was the testing strategy? What kinds of tests were run?
 Can your program handle bad input? Is your program  idiot-proof? How do you 
 know? What are the known issues / bugs remaining in your program?

 -one element lists
 -two element lists and on and on



DISCUSSION:

 Throughout completing this project, as well as the smaller assignments
 building up to the DoubleLinkedList, I feel like I have gained a much
 better understanding of testing suites, the power of a ListIterator, 
 and conceptualizing double linked lists as a whole.

 When we first edited the ListTester class, I was overwhelmed with the 
 size of the class, its organization, and knowing which change scenarios
 should be implemented. Now, I feel very comfortable navigating the 
 ListTester and understanding what each section of it does. I think it
 would be a daunting task to have to create a (relatively) large 
 testing class like this one independantly, but now that I've seen what
 one looks like, I at least would know how to begin.

 The biggest "Aha!" moment for me was when in class, the idea of using the
 ListIterator to complete all of the other methods in the double linked list
 was suggested. Before, I was still not loving the idea of having to make a 
 List Iterator. I know the reasoning--that it provides a standardized way to
 move through lists, so that no matter what kind of list, it could be navigated 
 through easily. But, I still wasn't convinced that it was that useful or 
 powerful of a tool (I saw it as almost unecessary code). Seeing the ListIterator's
 ability to take the place of basically every other part of my code was definitely
 a shift in my perspective. I finally understood the excitement around having a 
 ListIterator, and seeing my previosly very long methods compact to a couple 
 of lines was so satisfying. 

 One of my other biggest takeaways was, unfortunately, that drawing a picture
 of what you are attempting indeed does help you understand what you are doing. 
 Although it was said multiple times in class, I continued to believe I was somehow 
 immune to needing to do this. When I was going back and debugging, drawing the 
 situations out really helped me figure out where my thinking went wrong.

 I didn't have to do research on my own for this project, besides referencing
 the kind of bare Double Linked List API and the informational slides on Canvas.
 (https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)

 Discuss the issues you encountered during programming (development)
 and testing. What problems did you have?  What kinds of errors did you get? How did you 
 fix them?
