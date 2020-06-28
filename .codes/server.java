import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import LibraryDisplay.Book;
import LibraryDisplay.Library;
import LibraryDisplay.Member;

public class LibraryMainServer {
   public static void main (String args[]) {
      int port = 1779;
      try {
         ServerSocket ss = new ServerSocket (port);
         System.out.println("Starting Library Main Server.");
         System.out.println("Waiting for Client access.");
         Socket s = ss.accept();
         System.out.println(s.getRemoteSocketAddress() + " Client is connected.");
         
         DataInputStream data_in = new DataInputStream(s.getInputStream()); //Makes stream to be input from connected client s
         DataOutputStream data_out = new DataOutputStream(s.getOutputStream()); //Generate an output stream to send data to the client
         
         String str_in = ""; //Create a variable str_in to hold the string to receive
         String str_out = ""; //Create a variable str_out to hold the string to be sent
         String str_out_menu1 = "\n\nWrite '1' for view book lists, '2' for book borrowing and reserving, \n'3' for return books, '4' for modify member information, '5' for administrator and 'stop' for end the program.";
         String str_out_menu2 = "Write '1' for borrowing the book and '2' for reserving the book.";
         String str_out_menu3 = "Write '1' for add book, '2' for delete book, '3' for add member, '4' delete member,\n'5' for display members,"
               + " '6' for Sorting Books, '7' for Sorting Members 'kill server' for killing server.";
         String str_out_wrong = "Wrong input! Retruning to main menu...";
         String password = "javateam5";
         
         Book b = new Book();
         Library l = new Library(password);
         Member m = new Member();
         
        
         while(true) {
            data_out.writeUTF(str_out_menu1);
            data_out.flush();
            System.out.println("Receiving message...");
            str_in = data_in.readUTF();
            System.out.println("Received messages from clients : " + str_in);
            if(str_in.equals("1")) {
               str_out = l.displaybook();
               data_out.writeUTF(str_out);
               data_out.flush();
            }
            
            else if(str_in.equals("2")) { //borrow or reserve
               data_out.writeUTF("Type your ID.");
               data_out.flush();
               str_in = data_in.readUTF();
               if(l.find_member(str_in)==-1) {
                   data_out.writeUTF("There is no ID which you typed.");
                   data_out.flush();
                   continue;
               }
               m=l.Members.get(l.find_member(str_in));
               data_out.writeUTF(str_out_menu2);
               data_out.flush();
               System.out.println("Receiving message for borrowing or reserving...");
               str_in = data_in.readUTF();
               if(str_in.equals("1")) {
                  data_out.writeUTF("Type the serial num");
                  data_out.flush();
                  str_in = data_in.readUTF();//예외구문 만들
                  int str_in2=Integer.parseInt(str_in); // 문자열 숫자로 바꾸기
                  b = l.Books.get(l.find_book(str_in2));
                  if(l.borrowTry(b.getSerialNum(), m.ID)) {
                     data_out.writeUTF("Thank you for Borrow.");
                     data_out.flush();
                  }
                  else {
                     data_out.writeUTF("You can't Borrow that Book.");
                     data_out.flush();
                  }
               }
               else if(str_in.equals("2")) {
                  data_out.writeUTF("Type the serial num");
                  data_out.flush();
                  str_in = data_in.readUTF();
                  int str_in2=Integer.parseInt(str_in); // 문자열 숫자로 바꾸기
                  b = l.Books.get(l.find_book(str_in2));
                  if(l.reserveTry(b.getSerialNum(), m.ID)) {
                     data_out.writeUTF("Thank you for Reserve.");
                     data_out.flush();
                  }
                  else if(b.getBorrowOrnot()==0){
                      data_out.writeUTF("There is no one who borrowed the book. How about borrowing it?");
                      data_out.flush();
                  }
                  else {
                     data_out.writeUTF("You can't Reserve that Book.");
                     data_out.flush();
                  }
               }
               else {
                  data_out.writeUTF(str_out_wrong);
                  data_out.flush();
               }
            }
            
            else if(str_in.equals("3")) {
               data_out.writeUTF("Type your ID.");
               data_out.flush();
               str_in = data_in.readUTF();
               m=l.Members.get(l.find_member(str_in));
               data_out.flush();
               System.out.println("Returnning book");
               data_out.writeUTF("Type the serial num");
               data_out.flush();
               str_in = data_in.readUTF();
               int str_in2=Integer.parseInt(str_in); // 문자열 숫자로 바꾸기
               b = l.Books.get(l.find_book(str_in2)); 
               if(!l.retTry(b.getSerialNum(), m.ID)) {
                   data_out.writeUTF("There is an input Error, Try again");
                   data_out.flush();
                   continue;
               }
               data_out.writeUTF("Thank you for Return.");
               data_out.flush();
            }
            else if(str_in.equals("4")) {
               String ID, answer, new_subject, new_age;
               int new_age_int;
               data_out.writeUTF("Type your ID.");
                data_out.flush();
                System.out.println("Receiving message for the member ID...");
                ID = data_in.readUTF();
                data_out.writeUTF(l.modify_member1(ID));
                data_out.flush();
                if(l.modify_member1(ID).equals("Member ID error!")) {
                   continue;
                }
                answer = data_in.readUTF();
                data_out.writeUTF(l.modify_member2(answer));
                data_out.flush();
                if(l.modify_member2(answer).equals("error")) {
                   continue;
                }
                new_subject = data_in.readUTF();
                int index = l.find_member(ID);
                m=l.Members.get(index);
                m.subject=new_subject;
                data_out.writeUTF("Now type the new age information.");
                data_out.flush();
                new_age = data_in.readUTF();
                new_age_int = Integer.parseInt(new_age);
                m.age=new_age_int;
            }
            else if(str_in.equals("5")) {
                data_out.writeUTF("Welcome, administrator. Please write the master password.\nPassword : ");
                data_out.flush();
                System.out.println("Receiving message for the master password...");
                str_in = data_in.readUTF();
                if(str_in.equals(password)) {
                   data_out.writeUTF(str_out_menu3);
                   data_out.flush();
                   System.out.println("Receiving message from adiministrator...");
                   str_in = data_in.readUTF();
                   if(str_in.equals("1")) {
                      String serial_num, book_name, book_author;
                      data_out.writeUTF("Type serialnum(int): ");
                      data_out.flush();
                      System.out.println("Receiving message for the serial number...");
                      serial_num = data_in.readUTF();
                      int serial_num_int = Integer.parseInt(serial_num);
                      if(l.find_book(serial_num_int)!=-1) {
                          data_out.writeUTF("That serial number is already exist! Try again!");
                          data_out.flush();
                          continue;
                      }
                      data_out.writeUTF("Type Bookname(String): ");
                      data_out.flush();
                      System.out.println("Receiving message for the book name...");
                      book_name = data_in.readUTF();
                      data_out.writeUTF("Type Bookauthor(String): ");
                      data_out.flush();
                      System.out.println("Receiving message for the book author...");
                      book_author = data_in.readUTF();
                      l.add_book(serial_num, book_name, book_author);
                   }
                   else if(str_in.equals("2")) {
                      String book_serial_num;
                      int book_serial_num_int;
                      data_out.writeUTF("Type serialnum(int): ");
                      data_out.flush();
                      System.out.println("Receiving message for the serial number...");
                      book_serial_num = data_in.readUTF();
                      book_serial_num_int = Integer.parseInt(book_serial_num);
                      data_out.writeUTF(l.delete_book(book_serial_num_int));
                      data_out.flush();
                   }
                   else if(str_in.equals("3")) {
                      String new_mem_name, new_mem_subject, new_mem_age, new_mem_ID, new_mem_sex;
                      data_out.writeUTF("Type your ID(String): ");
                      data_out.flush();
                      System.out.println("Receiving message for the new member's ID...");
                      new_mem_ID = data_in.readUTF();
                      if(l.find_member(new_mem_ID)!=-1) {
                          data_out.writeUTF("That ID is alrady exist! Try again!");
                          data_out.flush();
                          continue;
                      }
                      data_out.writeUTF("Type your name(String): ");
                      data_out.flush();
                      System.out.println("Receiving message for the new member's name...");
                      new_mem_name = data_in.readUTF();
                      data_out.writeUTF("Type your subject(String): ");
                      data_out.flush();
                      System.out.println("Receiving message for the new member's subject...");
                      new_mem_subject = data_in.readUTF();
                      data_out.writeUTF("Type your age(int): ");
                      data_out.flush();
                      System.out.println("Receiving message for the new member's age...");
                      new_mem_age = data_in.readUTF();
                      data_out.writeUTF("Type your sex(male or female): ");
                      data_out.flush();
                      new_mem_sex = data_in.readUTF();
                      l.add_member(new_mem_ID, new_mem_name, new_mem_subject, new_mem_age, new_mem_sex);
                      data_out.writeUTF("Thank you for Sign-In!");
                      data_out.flush();
                   }
                   else if(str_in.equals("4")) {
                      String del_ID;
                      data_out.writeUTF("Type member ID(String): ");
                      data_out.flush();
                      System.out.println("Receiving message for the serial number...");
                      del_ID = data_in.readUTF();
                      if(l.find_member(del_ID)==-1) {
                          data_out.writeUTF("We can't find that member! Try again. ");
                          data_out.flush();
                          continue;
                      }
                      data_out.writeUTF(l.one_person_display(del_ID));
                      data_out.flush();
                      data_out.writeUTF("Do you want to delete? (yes/no) : ");
                      data_out.flush();
                      String YES = data_in.readUTF();
                      if(YES.equals("yes")) {
                         l.delete_member(del_ID);
                          data_out.writeUTF("Deleting is succesfully done. ");
                      }
                   }
                   else if(str_in.equals("5")) {
                       data_out.writeUTF("Type? (All, ID , <[show upper], >[show lower])");
                       data_out.flush();
                       str_in = data_in.readUTF();
                       if(str_in.equals("All")) {
                           data_out.writeUTF(l.displaymember());
                           data_out.flush();
                       }
                       else if(str_in.equals("ID")) {
                           data_out.writeUTF("Please enter the ID");
                           data_out.flush();
                           String ID = data_in.readUTF();
                           if(l.find_member(ID)==-1) {
                               data_out.writeUTF("Invalid ID! Try again");
                               data_out.flush();
                           }
                           else {
                              data_out.writeUTF(l.one_person_display(ID));
                           }
                       }
                       else if(str_in.contentEquals("<")) {
                           data_out.writeUTF("Please enter the ID");
                           data_out.flush();
                           String ID = data_in.readUTF();
                           if(l.find_member(ID)==-1) {
                               data_out.writeUTF("Invalid ID! Try again");
                               data_out.flush();
                           }
                           else {
                              data_out.writeUTF(l.upper_display(ID));
                              data_out.flush();
                           }
                       }
                       else if(str_in.contentEquals(">")) {
                           data_out.writeUTF("Please enter the ID");
                           data_out.flush();
                           String ID = data_in.readUTF();
                           if(l.find_member(ID)==-1) {
                               data_out.writeUTF("Invalid ID! Try again");
                               data_out.flush();
                           }
                           else {
                              data_out.writeUTF(l.lower_display(ID));
                              data_out.flush();
                           }
                       }
                       else if(str_in.contentEquals(">")) {
                          
                       }
                       else {
                           data_out.writeUTF("Invalid String! Try again");
                           data_out.flush();
                       }
                   }
                   else if(str_in.equals("6")) {
                       data_out.writeUTF("Choose the sorting methods: Asc(ascending) or Desc(descending)");
                       data_out.flush();
                       str_in = data_in.readUTF();
                       if(str_in.equals("Asc")) {
                          l.sorting_books();
                           data_out.writeUTF(l.displaybook());
                           data_out.flush();
                       }
                       else if(str_in.equals("Desc")) {
                              l.rev_sorting_books();
                               data_out.writeUTF(l.displaybook());
                               data_out.flush();
                       }
                       else {
                           data_out.writeUTF("Invalid String! Try again");
                           data_out.flush();
                       }
                   }
                   else if(str_in.equals("7")) {
                       data_out.writeUTF("Choose the sorting methods: Asc(ascending) or Desc(descending)");
                       data_out.flush();
                       str_in = data_in.readUTF();
                       if(str_in.equals("Asc")) {
                          l.sorting_members();
                           data_out.writeUTF(l.displaymember());
                           data_out.flush();
                       }
                       else if(str_in.equals("Desc")) {
                              l.rev_sorting_members();
                               data_out.writeUTF(l.displaymember());
                               data_out.flush();
                       }
                       else {
                           data_out.writeUTF("Invalid String! Try again");
                           data_out.flush();
                       }
                   }
                   else if(str_in.equals("kill server")) {
                      break;
                   }
                   else {
                      data_out.writeUTF(str_out_wrong);
                      data_out.flush();
                   }
                }
            }
           
            
            else if(str_in.equals("stop")) {
               //continue;
            }
            else {
               System.out.println("Wrong input. Please check input.");
            }
         }
         
         
         data_in.close();
         s.close();
         ss.close();
      } catch (Exception e) {
         System.out.println(e);
         
      }
      
   }
}
