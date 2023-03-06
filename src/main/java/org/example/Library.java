package org.example;

import org.example.Entities.Books;
import org.example.Entities.Loans;
import org.example.Entities.Members;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Library {
    private Map<String,Books> books;
    private Map<String,Members> members;
    private List<Loans> loans;
    private Map<String,Members> late_fees;

    public void add_book(Books _book){
        //check first, if the book exists
        if(books.containsKey(_book.getISBN())){
            System.out.println("Book with ISBN " + _book.getISBN() + " already exists.");
        }else {
            books.put(_book.getISBN(),_book);
        }
    }
    public void remove_book(Books _book){
        if(books.containsKey(_book.getISBN())){
            books.remove(_book.getISBN());
        }else{
            System.out.println("Book with ISBN " + _book.getISBN() + " doesn't exists.");
        }
    }
    public void register_member(Members _member){
        if(members.containsKey(_member.getId())){
            System.out.println("Book with ISBN " + _member.getId() + " already exists.");
        }else {
            members.put(_member.getId(),_member);
        }
    }
    public void borrow_book(Members _member,Books _book){
        for(var loan : loans){
            if( ( Objects.equals(loan.getMember().getId(), _member.getId()) )
                    && (Objects.equals(loan.getBook().getISBN(), _book.getISBN())) ) {
                throw new IllegalStateException("The member already has a loan for the same book!");
            }
        }
        Loans new_loan = new Loans(_book,_member, LocalDate.now(),LocalDate.of(2023,3,3),20.3f);
    }
    public void return_book(Members _member,Books _book){
        for(var loan : loans){
            if( ( Objects.equals(loan.getMember().getId(), _member.getId()) )
                    && (Objects.equals(loan.getBook().getISBN(), _book.getISBN())) ) {
                if( loan.getDue_date().equals(LocalDate.now()) ) {
                    late_fees.put(_member.getId(),_member);
                }else {
                    loans.remove(loan);
                }
            }
        }
    }

    public float calculate_late_fees(){
        float total_late_fees = 0;
        for(var loan : loans){
            total_late_fees += loan.getLate_fee();
        }
        return total_late_fees;
    }
}
