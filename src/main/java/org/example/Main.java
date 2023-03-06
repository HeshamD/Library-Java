package org.example;

import org.example.Entities.Books;
import org.example.Entities.Loans;
import org.example.Entities.Members;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        // Create a library object
        Library library = new Library();

        // Create some book objects
        Books book1 = new Books("Java Programming", "John Doe","1234567890",5);
        Books book2 = new Books( "Python Programming", "Jane Smith","2345678901",10);
        Books book3 = new Books("C# Programming", "Bob Johnson","3456789012", 4);

        // Add the books to the library
        library.add_book(book1);
        library.add_book(book2);
        library.add_book(book3);

        // Create some member objects
        Members member1 = new Members("M001", "John", "Doe", "123 Main St", "johndoe@example.com");
        Members member2 = new Members("M002", "Jane", "Smith", "456 Oak Ave", "janesmith@example.com");

        // Add the members to the library
        library.register_member(member1);
        library.register_member(member2);

        // Create some loan objects
        Loans loan1 = new Loans(book1, member1, LocalDate.now().minusDays(7),LocalDate.of(2025,11,2),10.2f);
        Loans loan2 = new Loans(book2, member1, LocalDate.now().minusDays(20),LocalDate.of(2025,12,2),10.2f);
        Loans loan3 = new Loans(book3, member2, LocalDate.now().minusDays(11),LocalDate.of(2025,10,2),10.2f);

        // Add the loans to the library
        library.borrow_book(member1,book1);
        library.borrow_book(member2,book2);
        library.borrow_book(member2,book3);

        // Test the charge_late_fees() method
        var result = library.calculate_late_fees(); // 10% late fee rate

        // Test the remove_book() method
        library.remove_book(book3); // remove book1 from the library

    }
}