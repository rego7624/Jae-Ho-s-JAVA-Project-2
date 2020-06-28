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

## Interface, Functions and Actions

**Interface**

The interface of the library management program is provided by the server. We have applied the communication beyond the management program, so we implemented all the functions with a part of the server and multiple functions, although the conditions required by the problem are not all implemented in one function. A user of the library management program accesses the server through the client, sends and receives strings from the server, and server provides all functions of the management program to user.

**Functions in Book class**

1.testTry1 in Book class

* This function is in Book class and made for testing a book’s whether the book is borrowed or not when a user is trying to borrow the book. This function will return true when the book is available

2.testTry2 in Book class

* This function is in Book class and made for testing a book’s whether the book is borrowed or not when a user is trying to return the book. This function will return true when the book is borrowed.

3.borrowTry in Book class

* This function is in Book class and made for processing a member’s book borrowing attempt.

* When a variable borrowOrnot is 0, the book is available. An operation of this function means that testTry1 of Book and Member class returned true, so then we can proceed borrowing operation. So it changes borrowOrnot to 1 and prints “Complete!” and return true.

* When the variable borrowOrnot is 1, the book is already borrowed. So it just prints "Already borrowed. Try agian." and return false.

* When the variable borrowOrnot is not 0 or 1, it must be 2 or 3 which means the book is reserved. So the function prints “This book is reserved.” and return false.

4.reserveTry in Book class

* This function is in Book class and made for processing the member’s book reservation attempt.

* When the variable borrowOrnot is 0, the book is not borrowed so the user can try borrowing rather than reserving. So the function prints "Not reserved. Borrow!" and return false.

* When the variable borrowOrnot is 1, the book is already borrowed and not reserved. An operation of this function means that testTry2 of Book and Member class returned true, so then we can proceed reservation operation. So it changes borrowOrnot to 2 and prints “Complete!” and return true.

* When the variable borrowOrnot is not 0 or 1, it must be 2 or 3 which means the book is reserved. So the function prints “This book is already reserved.” and return false.

5.returnTry in Book class

* This function is in Book class and made for processing the member’s book returning attempt.

* When the variable borrowOrnot is 0, the book is not borrowed. Returning a book that is not borrowed cannot happen. So the function prints "Not borrowed. Check a serial number!" and return false.

* When the variable borrowOrnot is 1, the book is borrowed and not reserved. Then, the function can just process returning operation, so it changes borrowOrnot to 0 and prints “Complete!”. It returns true.

* When the variable borrowOrnot is not 0 or 1, it is 2 and it means that the book is reserved. So the function changes borrowOrnot to 3 which means that the reserved book is returned. And it prints "This is reserved book. Please bring it to librarian." to keep the reserved book. It also returns true.

6. compareTo in Book class

* This function is in Book class and made for organizing books by its serial numbers.

* It compares serial numbers of its own serial number and book’s serial number to be sorted. So, if its own serial number is smaller than the book’s serial number it returns -1 and if they are same it returns 0. Otherwise, it returns 1.

7.4 kinds of get_______ in Book class

* These functions are simply used when the program needs to get each variable of the Book class.

**Functions in Member class**

1. testTry1 in Member class

* This function is in Member class and made for testing if a member can borrow a book or not. If a variable bookNum is less than 3 and a variable bannedDay is 0, the member is able to borrow a book so the function returns true. Otherwise, it will return false.

2. testTry2 in Member class

* This function is in Member class and made for testing if a member can reserve a book or not because one member can only reserve one book. If a variable resBookNum is 0 and the variable bannedDay is 0, the member is able to reserve a borrowed book so the function returns true. Otherwise, it will return false.

3. borrowTry in Member class

* This function is in Member class and made for processing a member’s book borrowing attempt. 

* When the variable bookNum is less than 3 and the variable bannedDay is 0, the member can borrow the book. So the function adds the serialNum of the book to ArrayList serialNumList and adds a current date to borrowDateList to calculate a lending period by using doCurrentDate function. It also increase bookNum and prints “Complete!” If the member is borrowing the reserved book, it also changes the variable resBookNum to 0. It finally returns true.

* When the variable bookNum is 3, it means the member already borrowed maximum books that he or she can borrow. So it prints "You already borrowed 3 books." and returns false. 

* When the variable bannedDay is over 0, it means the member cannot borrow books for a while because he or she was overdue. So it prints "You cannot borrow books for"+bannedDay+"day(s)." and returns false. 

4. reserveTry in Member class

* This function is in Member class and made for processing a member’s book reservation attempt. 
When the variable resBookNum and bannedDay is 0, the member is available to reserve the book. So the function changes resBookNum to serialNum and prints “Complete!”. It returns true.

* When the variable resBookNum is over 0, it means the member already reserved the book. So it prints "You already reserved the book!" and return false.

* When the variable bannedDay is over 0, it means the member cannot reserve books for a while because he or she was overdue. So it prints "You cannot reserve books for"+bannedDay+"day(s)." and returns false. 

5.doCurrentDate in Member class

* This function is in Member class and made for saving date data at ArrayList borrowDateList to calculate a lending period.

* It uses java.util.Calendar and gets GregorianCalendar of Korea. By using Calendar.get, it express a current date in a form of “year-month-day” and return it as a String.

6. doDiffofDate in Member class

* This function is in Member class and made for calculating the lending period by using a current date and saved date data at ArrayList borrowDateList. 
The saved date data at ArrayList borrowDateList would be a parameter start and the current date would be a parameter end.

* It uses java.text.SimpleDateFormat, .parse(), .getTime() to calculate the difference between the start date and the end date and returns it.

7. returnTry in Member class

* This function is in Member class and made for processing a member’s book returning attempt. 

* Returning process doesn’t have any restriction at member class, so the function just removes serialNum from the serialNumList and decreases the variable bookNum. 

* But before removing the serialNum, it saves an index of the serialNum to calculate the lending period.
Then, it uses the index to get borrowed date from the borrowDateList and uses doDiffOfDate function and doCurrentDate function and calculates the lending period. 

* It saves it at borrowDays.

* When borrowDays is over 14, the member is overdue, so his or her bannedDay increase and it prints "You are late! You cannot borrow books for "+bannedDay+"days."

* Otherwise, it just prints “Complete!” because there is no other factors to consider.

* This function always return true because the returning operation doesn’t have any restriction so it doesn’t fail.

8. compareTo in Member class

* This function is in Member class and made for organizing members by their name.

* It compares their own name and parameter k’s name.

9. 7 kinds of get_______ in Member class

* These functions are simply used when the program needs to get each variable of the Member class.


**Functions in Library class**

1. add_book in Library class

* This function is in Library class and made for registering a new book to an ArrayList Books. This function gets serial_num, book_name and book_author as parameters and save it to variables of Book class. If there is an exception, it prints "There is an Error! Try again!" and just return. And then it adds new Book to an ArrayList Books.

2. add_member in Library class

* This function is in Library class and made for registering a new member to an ArrayList Members. This function gets new_mem_ID, new_mem_name, new_mem_subject, new_mem_age and new_mem_sex as parameters and save it to variables of Member class. If there is an exception, it prints "There is an Error! Try again!" and just return. And then it adds new Member to an ArrayList Members.

3. sorting_books in Library class

* This function is in Library class and made for sorting books by their serial number. It uses Collection.sort() of java.util.ArrayList.

4. sorting_books in Library class

* This function is in Library class and made for sorting books by their serial number in reverse order. It uses Collection.sort() of java.util.ArrayList.

5. sorting_members in Library class

* This function is in Library class and made for sorting members by their ID. It uses Collection.sort() of java.util.ArrayList.

6.	rev_ sorting_members in Library class

* This function is in Library class and made for sorting members by their ID in reverse order. It uses Collection.sort() of java.util.ArrayList.

7.	delete_book in Library class

* This function is in Library class and made for deleting a book from an ArrayList Books. It finds book by find_book() and deletes it by .remove().

8.	find_book in Library class

* This function is in Library class and made for finding a book from an ArrayList Books. It uses .get(index) of java.util.ArrayList and compare one by one to find the same serial number of the book.

9.	delete_member in Library class

* This function is in Library class and made for deleting a member from an ArrayList Members. It finds member by find_member() and deletes it by .remove().

10.	find_member in Library class

* This function is in Library class and made for finding a member from an ArrayList Members. It uses .get(index) of java.util.ArrayList and compare one by one to find the same ID of the member.

11.	modify_member1 in Library class

* This function is in Library class and made for trying to modify the information of the member. It gets the member’s ID and find him or her. Then ask “Do you really want to modify the member information?” and gets answer at ans to return.

12.	modify_member2 in Library class

* This function is in Library class and made for trying to modify the information of the member. It gets ans form the modify_member1 function and if ans is yes, it returns "You can modify subject and age information. First type the new subject information." to get more information.

13.	displaybook in Library class

* This function is in Library class and made for displaying all the informations about all the books. 

14.	displaymember in Library class

* This function is in Library class and made for displaying all the informations about all the members. 

15.	one_person_display in Library class

* This function is in Library class and made for displaying all the informations about one member.

16.	borrowTry in Library class

* This function is in Library class and made for trying to borrow books. It gets Boolean values from borrowTry function of Book class and Member class. If they are all true, borrowTry succeeds and returns true. Otherwise, it returns false.

17.	reserveTry in Library class

* This function is in Library class and made for trying to reserve books. It gets Boolean values from reserveTry function of Book class and Member class. If they are all true, reserveTry succeeds and returns true. Otherwise, it returns false.

18.	retTry in Library class

* This function is in Library class and made for trying to return books. It gets Boolean values from returnTry function of Book class and Member class. If they are all true, retTry succeeds and returns true. Otherwise, it returns false.

19.	upper_display in Library class

* This function is in Library class and made for printing the members which is upper than the input ID. It gets String ID as the parameter and returns String str which includes the String information of members who has larger ID than the parameter ID.

20.	lower_display in Library class

* This function is in Library class and made for printing the members which is lower than the input ID. It gets String ID as the parameter and returns String str which includes the String information of members who has smaller ID than the parameter ID.

