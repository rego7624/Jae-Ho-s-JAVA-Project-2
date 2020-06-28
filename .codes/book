package LibraryDisplay;

public class Book implements Comparable<Book> {
	int serialNum;
	String bookName;
	String bookAuthor;
	
	int borrowOrnot; // borrowed=1, not borrowed=0, booked=2
	int borrowPeriod;

	public Book() {
		this.borrowOrnot=0;
		this.borrowPeriod=14;
	}
	
	public Book(int serialnum, String bookname, String bookauthor) {
		this.serialNum=serialnum;
		this.bookName=bookname;
		this.bookAuthor=bookauthor;
		this.borrowOrnot=0;
		this.borrowPeriod=14;
	}
	
	public boolean testTry1() {
		if(borrowOrnot==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean testTry2() {
		if(borrowOrnot==1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean borrowTry() {
		if(borrowOrnot==0) {
			borrowOrnot=1;
		//	System.out.println("Complete!");
			return true;
		}
		else if(borrowOrnot==1) {
			System.out.println("Already borrowed. Try agian.");
			return false;
		}
		else {
			System.out.println("This book is reserved.");
			return false;
		}
	}
	
	public boolean reserveTry() {
		if(borrowOrnot==0) {
			System.out.println("Not reserved. Borrow!");
			return false;
		}
		else if(borrowOrnot==1) {
		//	borrowOrnot=2;
		//	System.out.println("Complete!");
			return true;
		}
		else {
			System.out.println("This book is already reserved.");
			return false;
		}
	}
	
	public boolean returnTry() {
		if(borrowOrnot==0) {
			System.out.println("Not borrowed. Check a serial number!");
			return false;
		}
		else if(borrowOrnot==1) {
			borrowOrnot=0;
			System.out.println("Complete!");
			return true;
		}
		else if(borrowOrnot==2){
			borrowOrnot=3;
			System.out.println("This is reserved book. Please bring it to librarian.");
			return false;
		}
		return false;
	}
	
	public int getSerialNum() {
		return serialNum;
	}
	public String getBookName() {
		return bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public int getBorrowOrnot() {
		return borrowOrnot;
	}
	
	//시리얼 넘버에 따라 정렬
	public int compareTo(Book book) {
		if(this.serialNum < book.getSerialNum())
			return -1;
		else if (this.serialNum > book.getSerialNum())
			return 1;
		return 0;
	}
	
}
