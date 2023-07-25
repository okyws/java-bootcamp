package childs;

import parents.Member;

public class LoanBookOrder {
  private String loanID;
  private Member member;
  private BookForLoan books;
  private int loanPeriod;

  public LoanBookOrder() {
    super();
  }

  public LoanBookOrder(String loanID, Member member, BookForLoan books, int loanPeriod) {
    super();
    this.loanID = loanID;
    this.member = member;
    this.books = books;
    this.loanPeriod = loanPeriod;
  }

  public String getLoanID() {
    return loanID;
  }

  public void setLoanID(String loanID) {
    this.loanID = loanID;
  }

  public Member getMember() {
    return member;
  }

  public Member setMember(Member member) {
    return this.member = member;
  }

  public BookForLoan getBook() {
    return books;
  }

  public BookForLoan setBook(BookForLoan books) {
    return this.books = books;
  }

  public int getLoanPeriod() {
    return loanPeriod;
  }

  public int setLoanPeriod(int loanPeriod) {
    return this.loanPeriod = loanPeriod;
  }

  @Override
  public String toString() {
    return "LoanBookOrder [loanID=" + loanID + ", member=" + member + ", book=" + books + ", loanPeriod=" + loanPeriod
        + "]";
  }
}
