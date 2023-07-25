package childs;

import java.util.concurrent.atomic.AtomicInteger;

public class LoanDetail implements interfaces.InterfaceLoanFee {
  private String loanId;
  private String memberName;
  private String bookId;
  private String title;
  private double loanBookPrice;
  private int loanDuration;
  private double loanFee;
  private static AtomicInteger nextLoanId = new AtomicInteger(1);

  public LoanDetail() {
    super();
  }

  public LoanDetail(String memberName, String bookId, String title, double loanBookPrice,
      int loanDuration) {
    super();
    this.loanId = generateNextLoanId();
    this.memberName = memberName;
    this.bookId = bookId;
    this.title = title;
    this.loanBookPrice = loanBookPrice;
    this.loanDuration = loanDuration;
    this.loanFee = calculateLoanFee();
  }

  public String getLoanId() {
    return loanId;
  }

  public String getMemberName() {
    return memberName;
  }

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public String getBookId() {
    return bookId;
  }

  public void setBookId(String bookId) {
    this.bookId = bookId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getLoanBookPrice() {
    return loanBookPrice;
  }

  public void setLoanBookPrice(double loanBookPrice) {
    this.loanBookPrice = loanBookPrice;
  }

  public int getLoanDuration() {
    return loanDuration;
  }

  public void setLoanDuration(int loanDuration) {
    this.loanDuration = loanDuration;
  }

  public double getLoanFee() {
    return loanFee;
  }

  @Override
  public double calculateLoanFee() {
    return this.getLoanBookPrice() * this.loanDuration;
  }

  // untuk keperluan debug
  @Override
  public String toString() {
    return "LoanDetail [loanId=" + loanId + ", memberName=" + memberName + ", bookId=" + bookId + ", title=" + title
        + ", loanBookPrice=" + loanBookPrice + ", loanDuration=" + loanDuration + ",  loanFee=" + loanFee + "]";
  }

  private String generateNextLoanId() {
    return "Ord-" + String.format("%03d", nextLoanId.getAndIncrement());
  }
}
