package repository;

import parents.Member;

import java.util.ArrayList;
import java.util.List;

public class RepositoryMember {
  // Attribute / Field / Properties
  public List<Member> members;

  // Constructor Default
  public RepositoryMember() {
    super();
  }

  // Constructor Dengan Parameter
  public RepositoryMember(List<Member> members) {
    super();
    this.members = new ArrayList<>();
    this.members.add(new Member("M-001", "Risman", "Bandung"));
    this.members.add(new Member("M-002", "Budi", "Bandung"));
    this.members.add(new Member("M-003", "Resti", "Kab.Bandung"));
  }

  public List<Member> getAllMember() {
    StringBuilder sb = new StringBuilder();
    sb.append("==================================================================================\n");
    sb.append("|| No ||\tMember Id\t||\tMember Name\t||\tAddress\t\t||\n");
    sb.append("==================================================================================\n");
    int i = 1;
    for (Member member : members) {
      sb.append(String.format("|| %2d ", i++));
      sb.append("||\t");
      sb.append(String.format("%-16s", member.getMemberID()));
      sb.append("||\t");
      sb.append(String.format("%-16s", member.getName()));
      sb.append("||\t");
      sb.append(String.format("%-16s", member.getAddress()));
      sb.append("||\n");
    }
    sb.append("==================================================================================\n");
    System.out.print(sb.toString());
    return members;
  }

  public void setMembers(List<Member> members) {
    this.members = members;
  }

  // public void addMember(Member members) {
  // this.members.add(members);
  // }

  // public void removeMember(Member members) {
  // this.members.remove(members);
  // }

  // public void updateMember(Member members) {
  // int index = -1;
  // for (int i = 0; i < getMemberSize(); i++) {
  // if (this.members.get(i).getMemberID().equals(members.getMemberID())) {
  // index = i;
  // break;
  // }
  // }

  // if (index != -1) {
  // this.members.set(index, members);
  // }
  // }

  // public Member getMemberById(String memberID) {
  // for (Member member : members) {
  // if (member.getMemberID().equals(memberID)) {
  // return member;
  // }
  // }
  // return null;
  // }

  // public Member getMemberByName(String name) {
  // for (Member member : members) {
  // if (member.getName().equals(name)) {
  // return member;
  // }
  // }
  // return null;
  // }

  // public Member getMemberByAddress(String address) {
  // for (Member member : members) {
  // if (member.getAddress().equals(address)) {
  // return member;
  // }
  // }
  // return null;
  // }

  public Member getMemberByIndex(int index) {
    return members.get(index - 1);
  }

  // public int getMemberIndexById(String memberID) {
  // for (Member member : members) {
  // if (member.getMemberID().equals(memberID)) {
  // return members.indexOf(member);
  // }
  // }
  // return -1;
  // }

  // public int getMemberIndexByName(String name) {
  // for (Member member : members) {
  // if (member.getName().equals(name)) {
  // return members.indexOf(member);
  // }
  // }
  // return -1;
  // }

  // public int getMemberIndexByAddress(String address) {
  // for (Member member : members) {
  // if (member.getAddress().equals(address)) {
  // return members.indexOf(member);
  // }
  // }
  // return -1;
  // }

  // public int getMemberSize() {
  // return members.size();
  // }

  // public void printAllMember() {
  // StringBuilder sb = new StringBuilder();
  // sb.append("==================================================================================\n");
  // sb.append("|| No ||\tMember Id\t||\tMember Name\t||\tAddress\t\t||\n");
  // sb.append("==================================================================================\n");
  // int i = 1;
  // for (Member member : members) {
  // sb.append("|| ");
  // sb.append(i++);
  // sb.append(" ||");
  // sb.append("\t\t");
  // sb.append(member.getMemberID());
  // sb.append("\t\t||\t");
  // sb.append(member.getName());
  // sb.append("\t\t||\t");
  // sb.append(member.getAddress());
  // sb.append("\t\t||");
  // sb.append("\n");
  // }
  // sb.append("==================================================================================\n");
  // System.out.print(sb.toString());
  // }
}
