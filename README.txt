****************
* Double Linked List
* CS 221 003
* March 31, 2024
* Aris Vetter
**************** 

OVERVIEW:

 This program creates an indexed unsorted double linked list with a ListIterator 
 in which elements can be manipulated (added, removed, set to different values, 
 and more) and various values can be retrieved (elements in particular spots, 
 overall size of the list, if an element is in the list, a string format of the list, etc). 
 This functionality of this test was reviewed with a ListTester class, which was added to 
 in development.


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
you can add to any position, remove any element or position, change the values at any position,
and retrieve information from any position.

This specific program creates an indexed list, meaning that the elements can be accessed
directly by their location (for instance, the 7th element in the list). You can add or delete
elements and the indexes are automatically updated. 

Additionally, this list is an unsorted list, meaning that there is no inherent order. For 
a sorted list, for instance, String elements could be maintained so they were always in 
alphabetical order. However, for an unsorted list, the elements stay in the relative position
that they were placed in (of course, this position will be affected by the placement/deletion
of other elements in the list, not saying that the current 3rd element will necessarily always
be the third element).

A linked list is a specific type of list built from Nodes. I think of Nodes as a container for
the element. In this case (of a DLL), each Node has three pointers: one points to the Node that is after
it, one that points to the Node that comes before it, and one points to the element that it 
represents. There are two additional Nodes that are always kept track of: the first Node and the last Node.
Alternatively, a single linked list would just have two pointers--a pointer to the
Node that comes after it and a pointer to its element. Single linked lists also keep track of the head
and tail nodes. The purpose of having a list be linked, rather than an arrayList, is so that each time
an element is added or removed to/from anywhere besides the end of the list, elements do not need to be 
"shifted" to adjust their position. Instead, only the pointers before and after the modification need to 
point to a different node. 

The purpose of double linking a list is so that methods can improve efficiency by being able to start
at the front or the back of a list and move to the next or previous node. For some methods, like addToRear(),
the single linked list would have to iterate through the entire list just to get the Node before the tail
node. That makes the method an O(n) order, or a linear function. However, in a double linked list, the method
would be able to start at the rear and get the previous Node, getting rid of the need to loop through the entire
list. So, in some cases, the DLL would be able to perform a function at a constant order that a single linked
list wouldn't be able to. 

While avoiding shifting elements gives linked lists the runtime advantage for methods involving adding or removing
from anywhere other than the end of the list, arrayLists can directly retrieve an element at a given index
in constant run time. This means that if you plan on accessing items by index frequently, an arrayList is 
likely a better option. These types of lists also differ in terms of their memory usage. Double linked lists
require keeping track of three pointers per item of the list and single linked lists require two pointers per item.
An arrayList uses memory for the entire list that was created, whether that list is completely empty or full,
so this list type approximately uses 1.5 times the memory spaces as the number of items in the list. So,
which list is preferrable really depends on what type of efficiency you want to prioritize and how which methods
you plan on using most.

The methods of this program are implemented using a ListIterator. A ListIterator inherits the
functionality of the Iterable class. The purpose of iterators in generally so that all collections
can be navigated through (like in a for-each loop) in a standardized way.  The ListIterator can be 
initialized at any valid index within the list. If the starting index is in the second half of the list, 
the iterator actually starts at the tail end and navigates in reverse order to improve the run time for 
large lists. Its methods include ways to navigate the list as well as ways to modify the list (including 
setting, removing, and adding elements). Becuase these functions can perform everything that is required 
in the methods of the IUDoubleLinkedList class, for the purpose of avoiding code duplication, I used the 
ListIterator in almost all of my methods.

The final major part of this project was adding to the ListTester class. This will be described in the
testing section of the README.

In summary, the double linked list class implements the indexed unsorted lists class.
It organizes and structures itself using the Node class to represent the element and its
position in the list. It performs its methods as well as allows for iteration using the
DLLIterator subclass. The ListTester class validates that the DLL works as desired.


TESTING:

To ensure that my program works and meets the requirements, I added to the ListTester 
class. This class tested a variety of scenarios, ranging in size from empty lists to
three element lists, and after different series of method calls. Within each scenario,
every method was tested, and both valid and invalid inputs were given when applicable
(for instance, the remove at a specific index method was tested for indexes that were 
and weren't in the list). While obviously not every possibility was tested, because of
the large variety of scenarios that were tested, and the fact that edge cases were frequently
tested, I feel confident in the functionality of the program.

My testing strategy was trying to hit as many high value scenarios as possible--meaning
unique scenarios or scenarios that depend on many methods working simultaneously... 
essentially that ones that are most likely to reveal issues in the code. Additionally, 
edge cases were prioritized. The kind of tests that were ran were the general list tests, iterator tests, 
list iterator tests, and iterator concurrency tests. Concurrency tests check that if the test is
modified externally since the iterator was created, a ConcurrentModificationException is thrown.

My program can handle bad input in the way that was described in the DLL javadocs.
Different exceptions are required to be thrown in cases of bad input (such as an index
out of bounds exception if the index given was incorrect), and the testing class looks
for the program to successfully output the correct exception. In that sense, the program 
is idiot proof to the level that the indexed unsorted list interface designed it. I know
that because that was the standard that we compared our program's performance to in the
testing process. There are no known bugs in the program, but there is no consideration about 
the handling of duplicate values (which would likely mess up methods that search for an 
element in the list, like remove(element)).

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
 testing class like this one independently, but now that I've seen what
 one looks like, I at least would know how to begin.

 The biggest "Aha!" moment for me was when in class, the idea of using the
 ListIterator to complete all of the other methods in the double linked list
 was suggested. Before, I was still not loving the idea of having to make a 
 List Iterator. I know the reasoning--so that no matter what kind of list, 
 it could be navigated through easily. But, I still wasn't convinced that it was that useful 
 or powerful of a tool (I saw it as almost unecessary code). Seeing the ListIterator's
 ability to take the place of basically every other part of my code was definitely
 a shift in my perspective. I finally understood the excitement around having a 
 ListIterator, and seeing my previously very long methods compact to a couple 
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
though the scenarios themselves would have the correct toString() output.

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
