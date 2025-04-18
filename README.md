📚 MyList Project – Custom Data Structures in Java
🧩 Description
This project implements custom physical data structures (MyArrayList, MyLinkedList) and logical data structures (MyStack, MyQueue, MyMinHeap) in Java without using java.util.*, except for Iterator. All core functionality mirrors that of standard Java collections, built entirely from scratch.

📦 Project Structure
✅ Interface
MyList<T>
Custom interface defining common list operations, used by both MyArrayList and MyLinkedList.

🔧 Physical Data Structures
📂 MyArrayList<T>
Uses an internal Object[] array for storage.

Automatically resizes when full.

Efficient O(1) access by index.

Implements:

add, add(index), remove, set, get

addFirst, addLast, getFirst, getLast

sort, toArray, indexOf, lastIndexOf, clear, exists, size

📂 MyLinkedList<T>
Doubly linked list.

Inner class MyNode holds element and references to next and prev.

Keeps head, tail, and size.

Efficient O(1) insertion/removal at head/tail.

Implements all methods of MyList.

🧠 Logical Data Structures
🗂️ MyStack<T>
Implemented using MyLinkedList<T>.

LIFO structure (last-in, first-out).

Core methods: push, pop, peek, isEmpty.

🗂️ MyQueue<T>
Implemented using MyLinkedList<T>.

FIFO structure (first-in, first-out).

Core methods: enqueue, dequeue, peek, isEmpty.

🗂️ MyMinHeap<T extends Comparable<T>>
Implemented using MyArrayList<T>.

Maintains the min-heap property using a binary heap.

Core methods: insert, extractMin, peek, heapifyUp, heapifyDown.

🧪 Testing
Every class is tested in Main.java.

Manual testing is done through a series of System.out.println checks.

Edge cases (empty list, invalid indices, boundary conditions) are tested.

Optional: JUnit test files can be added separately.

📘 How to Run
bash
Копировать
Редактировать
javac Main.java
java Main
Main includes demos for:

Creating and populating MyArrayList, MyLinkedList

Using MyStack and MyQueue

Inserting into and extracting from MyMinHeap

🛠 GitHub & Commits
✅ Minimum 5 commits made throughout development.

✅ Commits are meaningful and track feature progress.

✅ Final code is clean, modular, and well-commented.

💬 Code Documentation
Each class is commented using JavaDoc-style comments.

Complex methods include inline comments explaining logic.

README.md included for project overview and instructions.

📌 Example Code Usage
java
Копировать
Редактировать
MyStack<Integer> stack = new MyStack<>();
stack.push(10);
stack.push(20);
System.out.println(stack.pop()); // 20

MyQueue<String> queue = new MyQueue<>();
queue.enqueue("Alice");
System.out.println(queue.dequeue()); // Alice

MyMinHeap<Integer> heap = new MyMinHeap<>();
heap.insert(3);
heap.insert(1);
System.out.println(heap.extractMin()); // 1
🔐 Constraints
No use of java.util.*, except Iterator

Generic types use <T extends Comparable<T>> for comparison