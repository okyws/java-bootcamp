package parents;

public class Member {
  // Attribute / Field / Properties
  private String memberID;
  private String name;
  private String address;

  // Constructor Default
  public Member() {
    super();
  }

  // Constructor Dengan Parameter
  public Member(String memberID, String name, String address) {
    super();
    this.memberID = memberID;
    this.name = name;
    this.address = address;
  }

  // Getter & Setter
  public String getMemberID() {
    return memberID;
  }

  public void setMemberID(String memberID) {
    this.memberID = memberID;
  }

  public String getName() {
    return name;
  }

  public String setName(String name) {
    return this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public String setAddress(String address) {
    return this.address = address;
  }

  // Method / Function
  @Override
  public String toString() {
    return "Member [memberID=" + memberID + ", name=" + name + ", address=" + address + "]";
  }
}
