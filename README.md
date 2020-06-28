# Jae-Ho-s-Second-Project

2018.07.13

**Second Java Project!**

## Library Managing System

<img alt="도서관 매니저 프로필" src="https://lh3.googleusercontent.com/proxy/JGwWd75u0CBWMSiSlLByDpuqZ0lc4cBYE1_HtQQN3xsVH-pDYq0OfXODWu6AQjOyHFNpoS-XfpafNlecM6S-D5MsS-OA4hJTDLxYKBD5YHZUHygZ65FSQWkjbZkpv9IRy7Oo_IoLwDPrm5myoAAggPpTibVQZq0P" width="400">


## Description


### I made a library managing program as my individual Project!

* I built program to manage books by using Book class and members by using Member class, using two class at Library class to practically manage book lending system at library


- UML

<img alt="아키텍처1" src="https://ifh.cc/g/RIGwVc.png" width="400">

<img alt="아키텍처1" src="https://ifh.cc/g/gXgoAQ.png" width="400">

<img alt="아키텍처1" src="https://ifh.cc/g/QPioVC.png" width="400">

<img alt="아키텍처1" src="https://ifh.cc/g/7jfPYU.png" width="400">

-Book Class

* This class is for managing books at the library. Each book class has a variable serialNum which contains the book’s serial number, bookName which contains the book’s name, bookAuthor which contains the book’s author and borrowOrnot which contains information about the book’s status. When borrowOrnot is 0, the book is not borrowed. When borrowOrnot is 1, the book is borrowed. When borrowOrnot is 2, the book is borrowed and reserved. When the borrowOrnot is 3, the book is reserved and returned.

* This class has constructors which doesn’t need any parameter or get serialnum, bookname and bookauthor as parameters to save the book’s information. The variable borrowOrnot is always set as 0 at the beginning.

* This class has function testTry1, testTry2, borrowTry, reserveTry, returnTry, getSerialNum, getBookNum, getBookAuthor, getBorrowOrnot and compareTo whose details are described at our project report.
