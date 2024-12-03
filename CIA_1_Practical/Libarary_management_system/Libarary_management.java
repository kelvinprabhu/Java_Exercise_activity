package CIA_1_Practical.Libarary_management_system;

import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;
    Boolean isIssued;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getIsIssued() {
        return isIssued;
    }

    public void setIsIssued(Boolean isIssued) {
        this.isIssued = isIssued;
    }

}

class ReferenceBook extends Book {
    int edition;

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String DisplayInfo() {
        return "Reference Book" + "\nBook ID: " + bookId + "\nTitle: " + title + "\nAuthor: " + author + "\nEdition"
                + edition;
    }

    public void setIsIssued(Boolean isIssued) {
        this.isIssued = isIssued;
    }
}

class FictionBook extends Book {
    String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String DisplayInfo() {
        return "Fiction Book" + "\nBook ID: " + bookId + "\nTitle: " + title + "\nAuthor: " + author + "\nGenre: "
                + genre;
    }

    public void setIsIssued(Boolean isIssued) {
        this.isIssued = isIssued;
    }

}

class Periodical extends ReferenceBook {
    String issueFrequency;

    public String getIssueFrequency() {
        return issueFrequency;
    }

    public void setIssueFrequency(String issueFrequency) {
        boolean isValid = Valdation(issueFrequency);
        if (isValid) {
            this.issueFrequency = issueFrequency;
        } else {
            System.out.println("Invalid Issue Frequency");
        }

    }

    public Boolean Valdation(String issueFrequency) {
        if (issueFrequency == "Weekly" || issueFrequency == "Monthly" || issueFrequency == "Yearly") {
            return true;
        } else {
            return false;
        }
    }

    public String DisplayInfo() {
        // if (super.isIssued == false) {
        return "Periodical" + "\nBook ID: " + bookId + "\nTitle: " + title + "\nAuthor: " + author + "\nEdition"
                + edition + "\nIssue Frequency: " + issueFrequency;
        // }

    }

    public void setIsIssued(Boolean isIssued) {
        super.isIssued = isIssued;
    }
}

public class Libarary_management {
    public static void main(String[] args) {
        ReferenceBook refBook = new ReferenceBook();
        refBook.setBookId(101);
        refBook.setTitle("Java Programming");
        refBook.setAuthor("James Gosling");
        refBook.setEdition(5);
        // System.out.println(refBook.DisplayInfo());

        FictionBook ficBook = new FictionBook();
        ficBook.setBookId(102);
        ficBook.setTitle("Harry Potter");
        ficBook.setAuthor("J.K. Rowling");
        ficBook.setGenre("Fantasy");
        // System.out.println(ficBook.DisplayInfo());

        Periodical perBook = new Periodical();
        perBook.setBookId(103);
        perBook.setTitle("Times of India");
        perBook.setAuthor("Times of India");
        perBook.setEdition(1);
        perBook.setIssueFrequency("Weekly");
        IssueBook(102);
        displayBooks(refBook, ficBook, perBook);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book id to issue the book");
        int IssuebookId = scanner.nextInt();
        scanner.nextLine();

        IssueBook(IssuebookId);

    }

    private static void displayBooks(ReferenceBook refBook, FictionBook ficBook, Periodical perBook) {
        System.out.println("Displaying Available books in the library :");
        System.out.println(refBook.DisplayInfo());
        System.out.println(ficBook.DisplayInfo());
        System.out.println(perBook.DisplayInfo());
    }

    private static void IssueBook(int bookId) {
        // logic to issue book
        Book book = new Book();
        if (bookId == 101) {
            book = new ReferenceBook();
            book.setIsIssued(true);
            System.out.println("Book Issued");
        } else if (bookId == 102) {
            book = new FictionBook();
            book.setIsIssued(true);
            System.out.println("Book Issued");

        } else if (bookId == 103) {
            book = new Periodical();
            book.setIsIssued(true);
            System.out.println("Book Issued");

        } else {
            System.out.println("Book not found");
        }

        System.out.println("Book Issued Successfully");

    }
}
