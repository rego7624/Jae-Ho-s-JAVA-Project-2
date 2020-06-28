
package LibraryDisplay;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Library {
	int Mem_num = 0;
	int Book_num = 0;
	String password;

	public ArrayList<Book> Books = new ArrayList<>();
	public ArrayList<Member> Members = new ArrayList<>();

	public Library(String password) {
		this.password = password;
	}

	public void add_book(String serial_num, String book_name, String book_author) {
		Book new_Book = new Book();
		try {
			new_Book.serialNum = Integer.parseInt(serial_num);
			new_Book.bookName = book_name;
			new_Book.bookAuthor = book_author;
		} catch (Exception e) {
			System.out.println("There is an Error! Try again!");
			new_Book = null;
			return;
		}
		Books.add(new_Book);
	}

	public void add_member(String new_mem_ID, String new_mem_name, String new_mem_subject, String new_mem_age,
			String new_mem_sex) {
		Member new_mem = new Member();
		try {
			new_mem.ID = new_mem_ID;
			new_mem.name = new_mem_name;
			new_mem.subject = new_mem_subject;
			new_mem.age = Integer.parseInt(new_mem_age);
			new_mem.sex = new_mem_sex;
		} catch (Exception e) {
			System.out.println("There is an Error! Try again!");
			new_mem = null;
			return;
		}
		Members.add(new_mem);
	}

	public void sorting_books() {
		Collections.sort(Books);
	}

	public void rev_sorting_books() {
		Collections.sort(Books);
		Collections.reverse(Books);
	}

	public void sorting_members() {
		Collections.sort(Members);
	}

	public void rev_sorting_members() {
		Collections.sort(Members);
		Collections.reverse(Members);
	}

	public String delete_book(int serialNum) {
		int index = find_book(serialNum);
		if (index != -1) {
			Books.remove(index);
			return "";
		} else {
			return "We can't find that book, try again!";
		}
	}

	public int find_book(int serialNum) {
		for (int i = 0; i < Books.size(); i++) {
			if (Books.get(i).serialNum == serialNum)
				return i;
		}
		return -1;
	}

	public String delete_member(String ID) {
		int index = find_member(ID);
		if (index != -1) {
			Members.remove(index);
			return "";
		} else {
			return "We can find that member, try again!";
		}
	}

	public int find_member(String ID) {
		for (int i = 0; i < Members.size(); i++) {
			if (Members.get(i).ID.equals(ID))
				return i;
		}
		return -1;
	}

	public String modify_member1(String ID) {
		int index = Library.this.find_member(ID);
		String ans = "";
		if (index == -1) {
			return "Member ID error!";
		} else {
			ans += Library.this.one_person_display(ID);
			ans += "\nDo you really want to modify the member information?";
			return ans;
		}
	}

	public String modify_member2(String answer) {
		if (answer.equals("yes")) {
			return "You can modify subject and age information. First type the new subject information.";
		} else {
			return "error";
		}
	}

	public String displaybook() {
		String str = "";
		for (int i = 0; i < Books.size(); i++) {
			Book temp = new Book();
			temp = Books.get(i);
			str += "\n[Serial number]: " + temp.getSerialNum() + " [Book name]: " + temp.getBookName()
					+ " [Book author]: " + temp.getBookAuthor() + " [Borrowed?]: ";
			if (temp.getBorrowOrnot() == 1)
				str += "Borrowed";
			else if (temp.getBorrowOrnot() == 0)
				str += "not Borrowed";
			else
				str += "Booked";
		}
		return str;
	}

	public String displaymember() {
		String str = "";
		for (int i = 0; i < Members.size(); i++) {
			Member temp = new Member();
			temp = Members.get(i);
			str += "\n[ID]: " + temp.ID + " [name]: " + temp.getName() + " [subject]: " + temp.getsubject() + " [age]: "
					+ temp.getAge() + " [The number of books which you borrowed]: " + temp.getBookNum()
					+ " [banned day] : " + temp.getBannedDay() + " [sex]: " + temp.sex;
		}
		return str;
	}

	public String one_person_display(String ID) {
		Member mem = new Member();
		mem = Members.get(find_member(ID));
		String str = "\n[ID]: " + mem.ID + " [name]: " + mem.getName() + " [sex]: " + mem.sex + " [subject]: "
				+ mem.getsubject() + " [age]: " + mem.getAge();
		return str;
	}

	public String upper_display(String ID) {
		this.sorting_members();
		String str = "";
		int idx = find_member(ID);
		for (int i = idx+1; i < Members.size(); i++) {
			str += "\n[ID]: " + Members.get(i).ID + " [name]: " + Members.get(i).getName() + " [sex]: "
					+ Members.get(i).sex + " [subject]: " + Members.get(i).getsubject() + " [age]: "
					+ Members.get(i).getAge();
		}
		return str;
	}

	public String lower_display(String ID) {
		this.sorting_members();
		String str = "";
		int idx = find_member(ID);
		for (int i = 0; i < idx; i++) {
			str += "\n[ID]: " + Members.get(i).ID + " [name]: " + Members.get(i).getName() + " [sex]: "
					+ Members.get(i).sex + " [subject]: " + Members.get(i).getsubject() + " [age]: "
					+ Members.get(i).getAge();
		}
		return str;
	}

	public Boolean borrowTry(int serialNum, String ID) {
		int idx_book = find_book(serialNum);
		int idx_mem = find_member(ID);
		if (Members.get(idx_mem).testTry1() && Books.get(idx_book).testTry1()) {
			if (Books.get(idx_book).borrowTry() && Members.get(idx_mem).borrowTry(serialNum))
				return true;
			else
				return false;
		}
		return false;
	}

	public Boolean reserveTry(int serialNum, String ID) {
		int idx_book = find_book(serialNum);
		int idx_mem = find_member(ID);
		if (Members.get(idx_mem).testTry2() && Books.get(idx_book).testTry2()) {
			if (Books.get(idx_book).reserveTry() && Members.get(idx_mem).reserveTry(serialNum)) {
				Books.get(idx_book).borrowOrnot = 2;
				System.out.println("Complete!");
				return true;
			} else
				return false;
		} else
			return false;
	}

	public boolean retTry(int serialNum, String ID) {
		int idx_book = find_book(serialNum);
		int idx_mem = find_member(ID);
		Member temp = Members.get(idx_mem);
		if (Books.get(idx_book).returnTry() && temp.returnTry(serialNum)) {
			return true;
		}
		return false;
	}

}
