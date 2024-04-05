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
  The DLL was created with generic types,
 meaning that it supports holding any object type.

 -say u defined list iterator in dll
 -added to test class in development

 -make shorter look at project description

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

Starting from the basics, a general list is a specific abstract data type (ADT), or a mental
model of how data is managed. It's important that whatever the ADT is--whether that's a 
stack, queue, or in this case, a list--the operations that can be performed on that data
align with what makes sense in the user's mind for that ADT. 

While stacks and queues have a little more restrictions on what operations can be performed,
lists have considerably more options. Just like you could with typing up a list in a document,
you can add to any 

This specific program creates an indexed list, meaning that the elements can be accessed
directly by their location (for instance, the 7th element in the list). Personally, I think 
of it like when you start typing a numbered To Do List on Microsoft Word. You can add or delete
To Do List items at any point in your document and the numbers are automatically updated. 

Additionally, this list is an unsorted list, meaning that there is no inherent order. For 
a sorted list, for instance, String elements could be maintained so they were always in 
alphabetical order. However, for an unsorted list, the elements stay in the relative position
that they were placed in (of course, this position will be affected by the placement/deletion
of other elements in the list, not saying that the current 3rd element will necessarily always
be the third element).

A linked list is a specific type of list built from Nodes. I think of Nodes as a container for
the element. In this case (of a DLL), each Node has three pointers: one points to the Node that is after
it, one that points to the Node that comes before it, and one points to the element that it 
represents. There are two additional Nodes that are alawys kept track of: the first Node and the last Node.
Alternatively, a single linked list would just have two pointers--a pointer to the
Node that comes after it and a pointer to its element. Single linked lists also keep track of the head
and tail nodes. 

The purpose of double linking a list is so that methods can improve efficiency by being able to start
at the front or the back of a list and move to the next or previous node. For some methods, like addToRear(),
the single linked list would have to iterate through the entire list just to get the Node before the tail
node. That makes the method an O(n) order, or a linear function. However, in a double linked list, the method
would be able to start at the rear and get the previous Node, getting rid of the need to loop through the entire
list. So, in some cases, the DLL would be able to perform a function at a constant order that a single linked
list wouldn't be able to. 

An ArrayList, which is an indexed list, is advantagous when elements will often need to be referenced directly
by index. However, when adding or removing from anywhere but the end of the list, the elements will need
to be shifted so that there is no empty index with no element (which is an O(n) order process). 

When it comes down to the difference between a single linked list, an arrayList, and a double
linked list, it all comes down to the situatiion of how you'll be using the lists. 

This program is made using generic types, meaning that the list can have parameters of any data type (whether 
that is ints, Strings, or a type the user defines like "MagicSquares" or "Posts").

In this project, a double linked list was created.
what is a list

--what is a double linked list
    -what is a node
    -generic types
    -order run time
    -situations it would be ideal for
    -what you are looking to optimize
    -other list options available

-List iterators vs iterators USED METHODS WENT 
    -differences
    -why have an iterator
    -potential advantages of previous
    -section where I started from the back if in the back half... 
    -using iterators to perform all other methods

-DLL
-IUList
-node
-DLLIterator (subclass/helper class)

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


 POSSIBLE improvements
 -duplicates


TESTING:

 How did you test your program to be sure it works and meets all of the
 requirements? 
 -different size lists
 -testing all the methods
 -testing methods in different orders
 
 What was the testing strategy? What kinds of tests were run?
 -try hit as manuy high value scenarios as possible
 -prioritized edge cases (zero and last index)

 -series of blackbox tests

 Can your program handle bad input? 
 -illegal  states and by definition of dll-use javadocs to make sure correct
 -duplicates
 -handling bad input with testing class
 
 Is your program  idiot-proof? 
 -yes, cant do anything tht isnt allowed for a list
 
 How do you 
 know? 
 -tested so many scenarios
 
 
 What are the known issues / bugs remaining in your program?
-two paragraphs
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

I started off this assignment by just trying to flesh out every method. Once that
was all complete, I was failing around 300 tests out of a little over 4000. I had
a lot of trouble finding any issues at all. The tests I was failing seemed to be 
kind of random. Some methods would work in some scenarios but not in others, even
thought the scenarios themselves would have the correct toString() output.

For that reason, I struggled to find exactly which parts of my code were likely to
contain the bugs. Debugging with this testing class was harder than I anticipated,
so I didn't find anything important using the Debugger. I instead opted to really 
nitpick every little line of code in my entire IUDoubleLinkedList class. However,
after spending countless hours with that approach to no avail, I decided I needed 
a change. I opted to create an extremely simple driver class, in which I called the
IUDoubleLinkedList constructor and used all of the methods in different ways. At each
step, I printed the toString() of the DLL to the console and compared it to what I 
expected. This allowed me to immediately pinpoint which methods were causing errors, 
where I could then call the Debugger. For me, the simplicity of the basic driver class
made the debugging process so much easier to do, and I quickly found the source of my
problems: the attempted optimization of the ListIterator constructor by starting 
from the head or the tail side depending on the starting index.

The code I had originally written for that section was causing serious problems
because I was starting the iterator at tail when my nextIndex was starting at the 
maximum acceptable index value (which was the size of the list). Thus, my nextIndex 
was always after the nextNode rather than before. To solve that issue, I made a special
case for when the starting index was equal to size, and subtracted one from the
nextIndex value. 

Other than that, the rest of my issues left were because of mistakes I had made in
the testing class. One of my testing scenarios, B_listIterRemoveA_B, was wrong...  I 
accidently had two "it.next();" in the scenario instead of just one. One of my scenarios
I had labeled was AB_ListIterator2PreviousRemove_B. However, walking through that scenario,
the ListIterator starts at the very end and is removing the last Node. I had written it 
expecting it to remove the first Node, so I had to adjust that. Finally, in scenario 
ABC_ListIter2PreviousRemove_AC, I set the ListIter to start at index 1 when index 2 was
what I was supposed to do. Identifying these problems, after the rest of my code was functioning
properly, was easy and simple.
