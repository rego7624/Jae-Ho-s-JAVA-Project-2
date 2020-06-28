package LibraryDisplay;

import java.util.ArrayList;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Member implements Comparable<Member> {
	String name;
	public String subject;
	public int age;
	public String ID;
	String sex;
	
	int bookNum; //max=3
	ArrayList<Object> serialNumList = new ArrayList<Object>();
	ArrayList<Object> borrowDateList = new ArrayList<Object>();
	int bannedDay; //책 수 * 연체 일수
	
	int resBookNum;
	int resDay; // max=3
	
	public Member() {
		this.bookNum=0;
		this.bannedDay=0;
		this.resBookNum=0;//reservation
		this.resDay=0;
	}
	
	public Member(String name, String subject, int age, int serialnum) {
		this.name=name;
		this.subject=subject;
		this.age=age;
		
		this.bookNum=0;
		this.bannedDay=0;
		this.resBookNum=0;//reservation
	}
	
	public boolean testTry1() {
		if(bookNum<3&&bannedDay==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean testTry2() {
		if(resBookNum==0 && bannedDay==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean borrowTry(int serialNum) {
		if(bookNum<3&&bannedDay==0) {
			serialNumList.add(serialNum);
			borrowDateList.add(doCurrentDate());
			bookNum++;
			System.out.println("Complete!");
			
			if(serialNum==resBookNum) {
				resBookNum=0;
			}
			
			return true;
		}
		else if(bookNum==3) {
			System.out.println("You already borrowed 3 books.");
			return false;
		}
		else {
			System.out.println("You cannot borrow books for"+bannedDay+"day(s).");
			return false;
		}
	}
	
	public boolean reserveTry(int serialNum) {
		if(resBookNum==0 && bannedDay==0) {
			resBookNum=serialNum;
			System.out.println("Complete!");
			return true;
		}
		else if(resBookNum>0) {
			System.out.println("You already reserved the book!");
			return false;
		}
		else {
			System.out.println("You cannot reserve books for"+bannedDay+"day(s).");
			return false;
		}
			
	}
	
	public String doCurrentDate(){
	    int nYear;
	    int nMonth;
	    int nDay;
	     
	    Calendar calendar = new GregorianCalendar(Locale.KOREA);
	    nYear = calendar.get(Calendar.YEAR);
	    nMonth = calendar.get(Calendar.MONTH) + 1;
	    nDay = calendar.get(Calendar.DAY_OF_MONTH);
	    
	    return nYear+"-"+nMonth+"-"+nDay;
	}

	
	public long doDiffOfDate(String start, String end){
	  //  String start = "2015-04-01";
	  //  String end = "2015-05-05";
	     
	    try {
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        Date beginDate = formatter.parse(start);
	        Date endDate = formatter.parse(end);
	         
	        long diff = endDate.getTime() - beginDate.getTime();
	        long diffDays = diff / (24 * 60 * 60 * 1000);
	 
	        return diffDays;
	         
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return 0;
	    }
	}


	
	
	public boolean returnTry(int serialNum) {
		int borrowDays;
		int i=serialNumList.indexOf(serialNum);
		System.out.println("i"+i);
		serialNumList.remove(i);
		bookNum--;
		
		Object borrowDate = borrowDateList.get(i);
		borrowDays=(int) doDiffOfDate((String) borrowDate,doCurrentDate());

		if(borrowDays>14) {
			bannedDay=borrowDays-14;
			System.out.println("You are late! You cannot borrow books for "+bannedDay+"days.");
		}
		return true;
	}
	
	public String getName() {
		return name;
	}
	public String getsubject() {
		return subject;
	}
	public int getAge() {
		return age;
	}
	public int getBookNum() {
		return bookNum;
	}
	public int getSerialNum(int bookNum) {
		return (int) serialNumList.get(bookNum);
	}
	public int getBannedDay() {
		return bannedDay;
	}
	public int getResBookNum() {
		return resBookNum;
	}

	@Override
	public int compareTo(Member k) {
	      return this.ID.compareTo(k.ID);
/*		int this_ID=Integer.parseInt(this.ID);
		int k_ID=Integer.parseInt(k.ID);
	if(this_ID < k_ID)
		return -1;
	else if (this_ID > k_ID)
		return 1;
	return 0;*/
	}
}
