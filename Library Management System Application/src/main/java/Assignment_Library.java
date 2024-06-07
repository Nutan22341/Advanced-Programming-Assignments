import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.*;
import java.time.format.DateTimeFormatter;
class MemberFine {
    public String bookId;
    public String memId;
    public String title;
    public String author;
    public String name;
    public long fine;


    public MemberFine(String bookId, String title, String author, String name,String memId,long fine ) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.name = name;
        this.fine = fine;
        this.memId = memId;
    }

    public String getBookId() {
        return bookId;
    }
    public String getMemId(){
        return memId;
    }
    public long getFine(){
        return fine;
    }
    public String getName(){
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
class BookType {
    public String bookId;
    public String title;
    public String author;
    public String name;

    public BookType(String bookId, String title, String author, String name ) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.name = name;
    }

    public String getBookId() {
        return bookId;
    }
    public String getName(){
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}


class Book {
    private static int nextBookId = 1;
//    public String bookId;
    public String bookId;
    public String title;
    public String author;
    public int totalCopies;
    public int availableCopies;


    public Book(String bookId, String title, String author) {

        this.title = title;
        this.author = author;
        this.availableCopies = totalCopies;
        this.bookId = "B" + nextBookId++;
        print();
    }
    public void print(){
        System.out.println("Added '" + title + "' by " + author + " (ID: " + bookId + ") to the bookstore.");
    }
    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }


    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void decreaseAvailableCopies() {
        availableCopies--;
    }
    public void increaseAvailableCopies() {
        availableCopies++;
    }
}
class Member {
    private static int nextMemId = 1;
    public String phoneNumber;
    public String name;
    public int age;
    public String Memid;
    public List<BookType> bookTypes;

    public Member(String phoneNumber, String name, int age) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.age = age;
        this.Memid = "M" + nextMemId++;
    }
    public String getMemId() {
        return Memid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public List<BookType> getBookTypes() {
        return bookTypes;
    }

    public void addBookType(BookType bookType) {
        bookTypes.add(bookType);
    }
}
class Member1 {
    public String name;
    public String PhNo;
    public ArrayList<Member> members = new ArrayList<>();
    private Member loggedInMember = null;
    public ArrayList<String[]> memberInfoArray = new ArrayList<>(); // ArrayList to store member info

    public void registerMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the member's phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter the member's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the member's age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        Member newMember = new Member(phoneNumber, name, age);
        members.add(newMember);


        String[] memberInfo = new String[3];
        memberInfo[0] = name;
        memberInfo[1] = phoneNumber;
        memberInfo[2] = newMember.getMemId();
        memberInfoArray.add(memberInfo);

        System.out.println("Registered member: " + name + "\nPhone Number: " + phoneNumber + "\nRegistered members Id "+ newMember.getMemId());

    }
//    public void displayMembers() {
//        if (members.isEmpty()) {
//            System.out.println("No registered members.");
//        } else {
//            System.out.println("Registered members:");
//            for (Member member : members) {
//                System.out.println("Name: " + member.getName() + " | Phone Number: " + member.getPhoneNumber() + " | Age: " + member.getAge());
//            }
//
//        }
//    }
    public void removeMember(String phoneNumber) {
        Iterator<Member> iterator = members.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (member.getPhoneNumber().equals(phoneNumber)) {
                iterator.remove();
                System.out.println("Removed member with Phone Number: " + phoneNumber + " from the library.");
                return;
            }
        }
        System.out.println("Member with Phone Number: " + phoneNumber + " not found in the library.");
    }
    public String[] check(){

        System.out.println("Enter the Name of member");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();

        System.out.println("Enter the Mobile Number");
        PhNo = sc.nextLine();// asking for phone Number

        String[] result = new String[3];
        if (members.isEmpty()) {
             result[0] = name;
             result[1] = "0";
             result[2] = "";
             return result;
        }
        else {

            for (int i = 0; i < members.size(); i++) {
                Member mem = members.get(i);
                if(name.equals(mem.getName()) && PhNo.equals(mem.getPhoneNumber())){
                    result[0] = name;
                    result[1] = "1";
                    result[2] = mem.getMemId();
                    return result;
                }
            }
        }
        result[0] = name;
        result[1] = "0";
        result[2] = "";
        return result;
    }
}
class Bookstore extends Member1 {
    private int nextBookId = 1;
    public ArrayList<Book> books = new ArrayList<>();
    public ArrayList<Book> issued_books = new ArrayList<>();
    public ArrayList<BookType> members_book = new ArrayList<>();
    ArrayList<String[]> arrayOfArrays = new ArrayList<>();
    ArrayList<MemberFine> arrayOfFine = new ArrayList<MemberFine>();
    ArrayList<String[]> arrayOfTme = new ArrayList<>();
    Instant currentTimeInSeconds1;
    public int issued_copies = 0;

    public void addBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the title of the book: ");
        String title = sc.nextLine();
        System.out.print("Enter the author of the book: ");
        String author = sc.nextLine();
        System.out.print("Enter the total number of copies: ");
        int totalCopies = sc.nextInt();



        for(int i = 0; i<totalCopies; i++){
            String bookId = "B" + nextBookId++;
            Book newBook = new Book(bookId, title, author);
            books.add(newBook);
        }

    }

    public void removeBook(String bookId) {
        int flag = 0;
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                    System.out.println("Removed 1 copy of book with ID: " + bookId + " from the bookstore.");
                    flag = 1;
                    books.remove(book);
                    break;
            }
        }
        if(flag==0){
            System.out.println("Book with ID: " + bookId + " not found in the bookstore.");
        }
    }

    public void displayBooks_Book() {
        if (books.isEmpty()) {
            System.out.println("No books in the bookstore.");
        } else {
            System.out.println("Books in the bookstore:");
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                System.out.println("Book Title : " + book.getTitle() + "\nAuthor : " + book.getAuthor() + "\nBook ID : " + book.getBookId());
                System.out.println("------------------------------------------------------------------------");
            }
        }
    }

    public void Display_Book_person() {
            System.out.println("Books issued by the You:");
        if (!issued_books.isEmpty()) {
            Book book = issued_books.get(issued_books.size() - 1); // Get the last book in the ArrayList
            System.out.println("Book Title : " + book.getTitle() + "\nAuthor : " + book.getAuthor() + "\nBook ID : " + book.getBookId());
            System.out.println("------------------------------------------------------------------------");
        } else {
            System.out.println("No books in the bookstore.");
        }
    }

    public void Issue_Books(String name_member) {
        displayBooks_Book();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the book ID you want to issue: ");
        String bookId = sc.nextLine();

        int flag = 1;
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (bookId.equals(book.getBookId())) {

                currentTimeInSeconds1 = Instant.now();
                issued_copies++;
                issued_books.add(book);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
                        .withZone(ZoneOffset.UTC);
                String currentTimeString = formatter.format(currentTimeInSeconds1);


                String[] time = {book.bookId,currentTimeString};
                arrayOfTme.add(time);
                flag = 0;
                BookType b = new BookType(book.bookId,book.title,book.author,name_member);
                members_book.add(b);


                // MEMBERS BOOK CONTAIN THE ISSUED BOOK LIST WITH PERSON NAME

                books.remove(i); // Remove the book from the books list
                System.out.println("Book issued successfully.");
                break;
            }
        }
        if (flag == 1) {
            System.out.println("Book not found.");
        }
    }
    public void existing_member() {
        if (members_book.isEmpty()) {
            System.out.println("There is not eny member who have taken book");
        } else {
            for (BookType mb : members_book) {
                if (mb.getName() != null) {
                    System.out.println("Book ID: " + mb.getBookId() + " | Author: " + mb.getAuthor() + " | Name: " + mb.getName() + " | Title: " + mb.getTitle());

                }
            }
        }
    }
    public void Return_Book(String memid) {
        System.out.println("Enter the book Id which you want to return :");
        Scanner sc = new Scanner(System.in);
        String book_id = sc.nextLine();

        boolean bookFound = false;
        int flag = 0;

        Iterator<Book> issuedBooksIterator = issued_books.iterator();
        Iterator<String[]> arrayOfTmeIterator = arrayOfTme.iterator();
        Iterator<BookType> membersBookIterator = members_book.iterator();

        while (issuedBooksIterator.hasNext()) {
            Book book = issuedBooksIterator.next();

            if (book_id.equals(book.getBookId())) {
                while (arrayOfTmeIterator.hasNext()) {
                    String[] time = arrayOfTmeIterator.next();
                    String bookIdInArray = time[0];

                    if (book_id.equals(bookIdInArray)) {
                        Instant currentTimeInSeconds = Instant.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
                        Instant instant = Instant.from(formatter.parse(time[1]));
                        Duration secondsLate = Duration.between(instant, currentTimeInSeconds);
                        long a = 10;
                        Duration adjustedDuration = secondsLate.minusSeconds(a);

                        // Define the fine rate per day
                        if (secondsLate.getSeconds() > 0) {
                            int fineRatePerDay = 3; // Change this rate as needed

                            books.add(book);
                            long getTime = secondsLate.getSeconds();
                            long fineAmount = getTime * fineRatePerDay;

                            fineAmount = fineAmount-10;
                            System.out.println("Fine Amount: " + fineAmount + " rupees");

                            while (membersBookIterator.hasNext()) {
                                BookType mb = membersBookIterator.next();
                                if (mb.getBookId().equals(book_id)) {
                                    MemberFine m = new MemberFine(book.getBookId(), book.getTitle(), book.getAuthor(), mb.getName(),memid, fineAmount);
                                    arrayOfFine.add(m);

                                    flag = 1;
                                    membersBookIterator.remove(); // Remove the member's book entry
                                    break;
                                }
                            }

                            issuedBooksIterator.remove(); // Remove the book from issued_books
                            arrayOfTmeIterator.remove(); // Remove the corresponding time entry
                            break; // No need to continue searching
                        } else {
                            books.add(book);
                            while (membersBookIterator.hasNext()) {
                                BookType mb = membersBookIterator.next();
                                if (mb.getBookId().equals(book_id)) {
    //                                MemberFine m = new MemberFine(book.getBookId(), book.getTitle(), book.getAuthor(), mb.getName(), 0);
                                    flag = 1;
                                    membersBookIterator.remove(); // Remove the member's book entry
                                    break;
                                }
                            }

                            issuedBooksIterator.remove(); // Remove the book from issued_books
                            arrayOfTmeIterator.remove(); // Remove the corresponding time entry
                            System.out.println("Book returned within the time");
                        }
                    }
                }
                bookFound = true;
                break;
            }
        }

        if (!bookFound) {
            System.out.println("Book with ID: " + book_id + " not found in the list of removed books.");
        }
}

    public void Members_with_Fine(){
        if(arrayOfFine.isEmpty()){
            System.out.println("There is not any member in the library list who issued books");
        }
        for (MemberFine mb : arrayOfFine) {
            System.out.println("Book ID: " + mb.getBookId() + " | Author: " + mb.getAuthor() + " | Name: " + mb.getName() + " | Title: " + mb.getTitle()+ "| Fine"+ mb.getFine());
        }
    }
    public void payFine() {
        System.out.println("Enter the Book Id of Book for which you want to pay the fine");
        Scanner sc = new Scanner(System.in);
        String bookid = sc.nextLine();
        Iterator<MemberFine> iterator = arrayOfFine.iterator();

        if (arrayOfFine.isEmpty()) {
            System.out.println("There is not any member in the library list who issued books");
            return;
        }

        while (iterator.hasNext()) {
            MemberFine mb = iterator.next();
            if (mb.getBookId().equals(bookid)) {
                System.out.println("You have a fine of rupees " + mb.getFine());
                System.out.println("Enter the amount of fine you want to pay:");
                long paidAmount = sc.nextLong();

                if (paidAmount >= mb.getFine()) {
                    iterator.remove(); // Remove the fine entry if the paid amount is greater or equal to the fine amount
                    System.out.println("You have paid your fine.");

                    // Add the book back to the books list
                    for (Book book : issued_books) {
                        if (book.getBookId().equals(bookid)) {
                            books.add(book);
                            issued_books.remove(book);
                            break;
                        }
                    }
                    break;
                } else {
                    System.out.println("Paid amount is less than the fine. Fine not cleared.");
                }
            }
            else{
                System.out.println("Enter a valid Book Id or This book id does not exist in the library");
            }
        }
    }
    public void check2(){

    }


}

public class Assignment_Library{
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        Bookstore b = new Bookstore();
        Member1 member1 = new Member1();
        HashSet<String> uniqueValues2 = new HashSet<>();
        while(true) {
            try {
                System.out.println("Enter a number according to the given below");
                System.out.println("1.Enter as a Librarian");
                System.out.println("2.Enter as a Member");
                System.out.println("3.Exit");
                int num = sc.nextInt();
                if (num == 1) {
                    while (true) {
                        try {
                            System.out.println("1.Register a Member");
                            System.out.println("2.Remove a Member");
                            System.out.println("3.Add a Book");
                            System.out.println("4.Remove a Book");
                            System.out.println("5.View all Members along with their Books and Fines paid");
                            System.out.println("6.View all Books");
                            System.out.println("7.Back");
                            int num2 = sc.nextInt();

                            if (num2 == 1) {
                                member1.registerMember();
                            } else if (num2 == 2) {
                                Scanner sc3 = new Scanner(System.in);
                                System.out.print("Enter the member's phone number to remove: ");
                                String phoneNumberToRemove = sc3.nextLine();
                                member1.removeMember(phoneNumberToRemove);
                            } else if (num2 == 3) {
                                b.addBook();
                            } else if (num2 == 4) {
                                Scanner sc1 = new Scanner(System.in);
                                System.out.print("Enter the book ID to remove: ");
                                String bookIdToRemove = sc1.nextLine();
                                b.removeBook(bookIdToRemove);
                            } else if (num2 == 5) {
                                b.Members_with_Fine();
                            } else if (num2 == 6) {
                                b.displayBooks_Book();
                            } else if (num2 == 7) {
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter a valid option.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid option.");
                            sc.nextLine();
                        }
                    }
                } else if (num == 2) {
                    String[] values = member1.check();
                    uniqueValues2.add(values[2]);
                    int k = 0;

                    while (true) {
                        try {
                            // Take username as input to check weather the member exist or not
                            if(values[1].equals("1")) {
                                System.out.println("1.List available Books");
                                System.out.println("2.List my Books");
                                System.out.println("3.Issue Books");
                                System.out.println("4.Return Books");
                                System.out.println("5.Pay Fine");
                                System.out.println("6.Back");
                                System.out.println("---------------------------------------------------------------------------------");
                                Scanner sc2 = new Scanner(System.in);
                                int num3 = sc2.nextInt();
                                if (num3 == 1) {

                                    b.displayBooks_Book();
                                } else if (num3 == 2) {
                                    int l = 0;
                                    for (int j = 0; j < b.members_book.size(); j++) {
                                        BookType book = b.members_book.get(j);
                                        if(values[0].equals(book.getName())){
                                            System.out.println("Book Title : " + book.getTitle() + "\nAuthor : " + book.getAuthor() + "\nBook ID : " + book.getBookId());
                                            System.out.println("---------------------------------------------------------------------------------");
                                            l=1;
                                        }
                                    }
                                    if(l==0){
                                        System.out.println("you have not issued book yet");
                                    }

                                } else if (num3 == 3) {
                                    boolean hasMatch = false;

                                    for (String uniqueValue2 : uniqueValues2) {
                                        for (MemberFine mb : b.arrayOfFine) {
                                            if (uniqueValue2.equals(mb.getMemId())) {
                                                hasMatch = true;
                                                break; // Exit the inner loop as a match was found
                                            }
                                        }


                                    }
                                    int issuedBookCount = 0;
                                    for (BookType book : b.members_book) {
                                        if (values[0].equals(book.getName())) {
                                            issuedBookCount++;
                                        }
                                    }
                                    if (!hasMatch) {
                                        // No match found for this uniqueValue2, so call the Issue_Books function
                                        if (issuedBookCount < 2) { // Allow issuing only if less than 2 books are issued
                                            b.Issue_Books(values[0]);
                                        } else {
                                            System.out.println("You can not issue more than 2 books");
                                        }
                                    } else {
                                        // Reset the flag for the next iteration
                                        System.out.println("You have not paid your fine ");
                                        hasMatch = false;
                                    }

                                } else if (num3 == 4) {
                                    b.Return_Book(values[2]);
                                } else if (num3 == 5) {
                                    b.payFine();
                                } else if (num3 == 6) {
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please enter a valid input.");
                                }
                            }
                            else{
                                System.out.println("Member is not registered");
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid option.");
                            sc.nextLine();
                        }
                    }
                } else if (num == 3) {
                    break;
                } else{
//                    b.existing_member();
                    System.out.println("Invalid input. Please enter a valid option.");
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid option.");
                sc.nextLine();
            }
            i++;
        }
    }
}