#  Laboratory work 0 - SOLID principles

### Author: Nelli Garbuz

----
## Task:

1.Implement two SOLID letters in a simple project

## Theory

SOLID is an acronym for the first five object-oriented design (OOD).

SOLID stands for:

* **S - Single-responsibility Principle** - a class should have one and only one reason to change, meaning that a class should have only one job.

* **O - Open-closed Principle** - objects or entities should be open for extension but closed for modification.

* **L - Liskov Substitution Principle** -let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T. This means that every subclass or derived class should be substitutable for their base or parent class.

* **I - Interface Segregation Principle** - a client should never be forced to implement an interface that it doesn’t use, or clients shouldn’t be forced to depend on methods they do not use.

* **D - Dependency Inversion Principle** - entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions. [1]


## Implementation description

In my project I implemented the SRP and LSP from SOLID.

**SRP - Single-Responsibility Principle**

To make a library system management, I need to have a class for books and also users that can register to borrow/return books.

So, for the part of storing books, I created 3 classes, each with its own repsonisbility:

* Book only manages book-related details like title, author, ISBN.
  
* BookFactory is responsible for creating specific book objects (like EBook or PrintedBook), depending on the user's input.
  
* BookInputHandler is responsible for getting the inputs from the user, such as title, author, ISBN of the book.
  
* BookController responsible for all the operations regarding the books (such as adding a new book, showing all the books, checking in our checking out a book)

Because each class has its own different function, I split all of them in different packages (inpundhandlers, models, services,controllers)

```Book.java class``` 

```
public Book(String title, String author, String ISBN, int bookQuantity) {
   this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.bookQuantity = bookQuantity;
        this.bookQuantityCopy = bookQuantity;
}
```
```BookFactory class```

```public class BookFactory {
    public static Book createBook(int bookType, String title, String author, String ISBN, int quantity, String extraDetail) {
        if (bookType == 1) {
            return new EBook(title, author, ISBN, quantity, extraDetail); // File Size for E-Book
        } else {
            return new PrintedBook(title, author, ISBN, quantity, extraDetail); // Version Type for Printed Book
        }
    }
}
```

```BookInputHandler.class```

This is the class responsible for getting the user's input, but most importnat it handles different types of books.

```
System.out.println("Is this an E-Book or Printed Book? (1.E-Book, 2.Printed Book): ");
        int bookType = input.nextInt();
        input.nextLine();

        String extraDetail;
        if (bookType == 1) {
            System.out.println("Enter the file size of the E-Book: ");
            extraDetail = input.nextLine();
        } else {
            System.out.println("Enter the version type of the Printed Book: ");
            extraDetail = input.nextLine();
        }
```

```BookController``` has the following methods:

* compareBookObjects(): to handle that a book with the same title or ISBN code is added only once.
* addBook (): adds a new book in the "library"
* searchByISBN(): allows the user to get information about a book based on the ISBN code
* searchByAuthor(): allows the user to get information about a book based on the author's name
* showAllBooks(): will output all of the books in the library
* upgradeBookQuantity(): make sit possible to add the same book in more copies
* isAvailable(): checks if the book with a specific ISBN is in the library or not
* checkoutBook(): retrieves a ook from the library
* checkInBook(): adds the borrowed book back in the library

For the user part, I did the same thing:

* UserInputHandler is responsible for getting the inputs from the user, such as name and ID for a library user.

* UserController responsible for handling user-related logic like registering, borrowing, and returning books, based on the ISBN of the book.

* UserRepository manages user storage and retrieval (has methods such as adding a new user, verifying an user and showing all the users)

The same logic was applied here, and each class is split in different packages (inputhadlers, controllers, services)

```UserInputHandler.java```
```
    public UserInputHandler(){
        System.out.println("Enter User's name: ");
        this.userName= input.nextLine();

        System.out.println("Enter User's ID number: ");
        this.userId = input.nextLine();
    }
```
```UserRepository``` includes:

* addUser(): adds a new user with a unique name and ID
  
* showAllUsers(): display all registered users at the library

* isUser(): checks if a user with a specific ID is registeres already or not

```UserController``` has the following main methods:

* borrowBook(): implements the logic of "borrowing" a book based on its ISBN code and it becomes attached to the user's profile
  
* returnBook(): represents the return process of a book 

**LSP - Liskov Substitution Principle**

To implement this principle, I decided to extend the class ```Book```, and created two other subclasses ```E-book``` and ```PrintedBook```. ```PrintedBook``` and ```Ebook``` extends ```Book``` and overrides the getType() method.

For The Ebook part, the usee will input the same details as for a simple book, but it will also specify the file size of the electronic book.
```
public EBook(String title, String author, String ISBN, int bookQuantity, String fileSize) {
        super(title, author, ISBN, bookQuantity);
        this.fileSize = fileSize;
    }
```

The same goes for the printed version of the book, and in this case, the user can specify which type it is (Hardcover, Paperback etc.)

```
public PrintedBook(String title, String author, String ISBN, int bookQuantity, String versionType) {
        super(title, author, ISBN, bookQuantity);
        this.versionType = versionType;
    }
```

In addition to this, I made a menu, based on the user's choice and manages the flow of the application.
## Conclusions 
In this laboratory work, I made an implementation of a Library Management System using two letters of SOLID principles (Single Responsibility Principle (SRP) and the Liskov Substitution Principle (LSP)).

Refactoring key classes to comply with SRP ensured that each class had a single, well-defined responsibility, making the system easier to extend and debug. This helped to create classes that are easier to understand and I could create a more organized code.
By implementing the LSP, I ensured that subclasses such as PrintedBook and EBook could be used interchangeably with their superclass Book, without compromising the integrity of the system.

In conclusion, adhering to some of the SOLID principles helped with adding enhancements, making it easier for creating a libary system with a book catalog and user interactions.

![8a562201b31c42400ad6f51255932bb3 1](https://github.com/user-attachments/assets/9a0a580b-f174-437e-b6ea-1927d6729e9f)


## Bibliography
[1] https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design
