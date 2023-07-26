// package repository;

// import parents.Member;

// import java.util.ArrayList;
// import java.util.List;

// public class RepositoryMember {
// // Attribute / Field / Properties
// public List<Member> members;

// // Constructor Default
// public RepositoryMember() {
// super();
// }

// // Constructor Dengan Parameter
// public RepositoryMember(List<Member> members) {
// super();
// this.members = members;
// }

// public List<Member> getAllMember() {
// this.members = new ArrayList<>();
// this.members.add(new Member("M-001", "Risman", "Bandung"));
// this.members.add(new Member("M-002", "Budi", "Bandung"));
// this.members.add(new Member("M-003", "Resti", "Kab.Bandung"));

// StringBuilder sb = new StringBuilder();
// sb.append("==================================================================================\n");
// sb.append("|| No ||\tMember Id\t||\tMember Name\t||\tAddress\t\t||\n");
// sb.append("==================================================================================\n");
// int i = 1;
// for (Member member : members) {
// sb.append(String.format("|| %2d ", i++));
// sb.append("||\t");
// sb.append(String.format("%-16s", member.getMemberID()));
// sb.append("||\t");
// sb.append(String.format("%-16s", member.getName()));
// sb.append("||\t");
// sb.append(String.format("%-16s", member.getAddress()));
// sb.append("||\n");
// }
// sb.append("==================================================================================\n");
// System.out.print(sb.toString());
// return members;
// }

// public void setMembers(List<Member> members) {
// this.members = members;
// }

// public Member getMemberById(String memberID) {
// for (Member member : members) {
// if (member.getMemberID().equals(memberID)) {
// return member;
// }
// }
// return null;
// }
// }
