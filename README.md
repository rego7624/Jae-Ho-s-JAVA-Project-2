# Jae-Ho-s-Second-Project

2018.07.13

**Second Java Project!**

## Library Managing System

<img alt="도서관 매니저 프로필" src="https://lh3.googleusercontent.com/proxy/JGwWd75u0CBWMSiSlLByDpuqZ0lc4cBYE1_HtQQN3xsVH-pDYq0OfXODWu6AQjOyHFNpoS-XfpafNlecM6S-D5MsS-OA4hJTDLxYKBD5YHZUHygZ65FSQWkjbZkpv9IRy7Oo_IoLwDPrm5myoAAggPpTibVQZq0P" width="400">


## Description


### I made a library managing program as my individual Project!

* I built program to manage books by using Book class and members by using Member class, using two class at Library class to practically manage book lending system at library


**UML**

<img alt="아키텍처1" src="https://ifh.cc/g/RIGwVc.png" width="400">

<img alt="아키텍처1" src="https://ifh.cc/g/gXgoAQ.png" width="400">

<img alt="아키텍처1" src="https://ifh.cc/g/QPioVC.png" width="400">

<img alt="아키텍처1" src="https://ifh.cc/g/7jfPYU.png" width="400">

**Book Class**

* This class is for managing books at the library. Each book class has a variable serialNum which contains the book’s serial number, bookName which contains the book’s name, bookAuthor which contains the book’s author and borrowOrnot which contains information about the book’s status. When borrowOrnot is 0, the book is not borrowed. When borrowOrnot is 1, the book is borrowed. When borrowOrnot is 2, the book is borrowed and reserved. When the borrowOrnot is 3, the book is reserved and returned.

* This class has constructors which doesn’t need any parameter or get serialnum, bookname and bookauthor as parameters to save the book’s information. The variable borrowOrnot is always set as 0 at the beginning.

* This class has function testTry1, testTry2, borrowTry, reserveTry, returnTry, getSerialNum, getBookNum, getBookAuthor, getBorrowOrnot and compareTo whose details are described at our project report.

**Member Class**

* This class is for managing members of the library. Each member has a variable name which contains the member’s name, job which contains the member’s job, age which contains the member’s age, ID which contains the member’s ID, sex which contains the member’s sex, bookNum which contains the number of books he or she borrowed, bannedDay which contains the days he or she cannot borrow books and resBookNum which contains the serial number of the reserved book. The maximum number of bookNum is 3. Each member also has an ArrayList serialNumList which contains the serial numbers of borrowed books and borrowDateList which contains the borrow date of borrowed books.

* This class has constructors which doesn’t need any parameter or get name, job, age and sex as a parameter to save the member’s information. The variable bookNum, bannedDay and resBookNum is always set as 0 at the beginning.

* This class has function testTry1, testTry2, borrowTry, reserveTry, doCurrentDate, doDiffOfDate, returnTry, getName, getJob, getAge, getBookNum, getSerialNum, getBannedDay, getResBookNum and compareTo whose details are described at our project report.

**Library Class**

* This class is for managing overall library system by using Book class and Member class. It has a variable Mem_num which contains the number of the members, Book_num which contains the number of the books and password which contains the password of the library. It also has an ArrayList Books which contains books which are made by Book class and Members which contains members which are made by Member class.

* This class has a constructor which gets a password as a parameter and set the library’s password as a parameter password.

* This class has function add_book, add_member, sorting_books, rev_sorting_books, sorting_members, rev_sorting_members, delete_book, find_book, delete_member, find_member, modify_member1, modify_member2, displaybook, displaymember, one_person_display, borrowTry, reserveTry and retTry whose details are described at our project report.

**Server Class**

* This class is for providing the main interface to user by communication with Client class. Server class imports three classes(library, member, book), which let users to use all the features of the library program. Server class has several String type variables. For example, str_in is a String type variable which holds the string to receive, str_out is a String type variable to hold the string to be sent, str_out_menu1~3 are for providing user an option, and password for administrator’s master key.

* Server class uses several methods such as writeUTF which is used to write at client window, methods from other classes, etc. In server class’s while loop, there are 5 big choices. '1' is for view book lists, '2' is for book borrowing and reserving, '3' is for return books, '4' is for modify member information, and '5' is for administrator and 'stop' for end the program. There are some sub choices and the most important and largest group is ‘5’ administrator. In choice 5, there are 8 sub choices. '1' is for adding book, '2' is for deleting book, '3' is for adding member, '4' is for deleting member, '5' is for display members, '6' is for sorting books in , '7' for sorting members as ascending or descending, and 'kill server' for killing the main server.

* Server class also has variable named port, which is similar to promise(address) between server and client. This variable enables the connection between the server and the client, and prevents unrelated clients from connecting to the server.

**Client Class**

* This class is used for communication with the server. It uses socket class which is already defined. Also it has two String type variables str and str2 to save strings which are for read and write with server. The most important method in client class is run, which is located in Reader class. Reader class extends thread which allows for simultaneous operation through the run function. The run method prevents the time imbalance between server and client.
