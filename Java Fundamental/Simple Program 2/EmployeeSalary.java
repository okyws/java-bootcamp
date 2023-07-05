
import java.util.Scanner;

public class EmployeeSalary {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String branchOffice = input.nextLine();
    String position = input.nextLine();
    int durationOfWork = input.nextInt();
    boolean isMarried = input.nextBoolean();

    input.close();
    int umk = getUMK(branchOffice);
    int employeeSalary = calculateBasicSalary(position, durationOfWork, umk);
    int familyAllowance = calculateFamilyAllowance(employeeSalary, isMarried);
    int occupationalAllowance = calculateOccupationalAllowance(position, durationOfWork, employeeSalary);
    int employeeBenefits = calculateEmployeeBenefits(position);
    int employeeGrossSalary = calculateGrossSalary(employeeSalary, familyAllowance, occupationalAllowance,
        employeeBenefits);
    int retirementDeductions = calculateRetirementDeductions(employeeGrossSalary);
    int deductionBPJS = calculateBpjsDeductions(employeeGrossSalary);
    int deductionPPH = calculatePphDeduction(employeeGrossSalary);
    int employeeNetSalary = calculateNetSalary(employeeGrossSalary, retirementDeductions, deductionBPJS, deductionPPH);

    System.out.println(employeeSalary);
    System.out.println(familyAllowance);
    System.out.println(occupationalAllowance);
    System.out.println(employeeBenefits);
    System.out.println(employeeGrossSalary);
    System.out.println(retirementDeductions);
    System.out.println(deductionBPJS);
    System.out.println(deductionPPH);
    System.out.println(employeeNetSalary);
  }

  public static int getUMK(String branchOffice) {
    int umk = 0;
    switch (branchOffice) {
      case "Garut":
      case "garut":
      case "GARUT":
        umk = 1961085;
        break;
      case "Bandung":
      case "bandung":
      case "BANDUNG":
        umk = 3742276;
        break;
      case "jakarta":
      case "Jakarta":
      case "JAKARTA":
        umk = 4453935;
        break;
      case "Bekasi":
      case "bekasi":
      case "BEKASI":
        umk = 4782935;
        break;
      case "Bogor":
      case "bogor":
      case "BOGOR":
        umk = 4330249;
        break;
      case "Palembang":
      case "palembang":
      case "PALEMBANG":
        umk = 3289409;
        break;
      default:
        System.out.println("Branch " + branchOffice + " Not Found");
        break;
    }
    return umk;
  }

  public static int calculateBasicSalary(String position, int durationOfWork, int umk) {
    int employeeSalary = 0;
    switch (position) {
      case "Admin":
      case "ADMIN":
      case "admin":
        if (durationOfWork < 2) {
          employeeSalary = umk;
        } else {
          employeeSalary = (int) (umk * 1.2);
        }
        break;
      case "Coordinator":
      case "COORDINATOR":
      case "coordinator":
        if (durationOfWork < 3) {
          employeeSalary = (int) (umk * 1.1);
        } else {
          employeeSalary = (int) (umk * 1.3);
        }
        break;
      case "SPV":
      case "spv":
      case "Spv":
        if (durationOfWork < 2) {
          employeeSalary = (int) (umk * 1.25);
        } else if (durationOfWork >= 2 && durationOfWork <= 4) {
          employeeSalary = (int) (umk * 1.4);
        } else {
          employeeSalary = (int) (umk * 1.5);
        }
        break;
      case "Sprinter":
      case "sprinter":
      case "SPRINTER":
        employeeSalary = (int) (umk * 0.9);
        break;
      case "Officer":
      case "officer":
      case "OFFICER":
        employeeSalary = umk;
        break;
      case "Manager":
      case "manager":
      case "MANAGER":
        if (durationOfWork < 3) {
          employeeSalary = (int) (umk * 1.5);
        } else {
          employeeSalary = (int) (umk * 2);
        }
        break;
      default:
        System.out.println("position " + position + " invalid.");
        break;
    }
    return employeeSalary;
  }

  public static int calculateFamilyAllowance(int employeeSalary, boolean isMarried) {
    int familyAllowance = 0;
    if (isMarried) {
      familyAllowance = (int) (employeeSalary * 0.1);
    }
    return familyAllowance;
  }

  public static int calculateOccupationalAllowance(String position, int durationOfWork, int employeeSalary) {
    int occupationalAllowance = 0;
    if (durationOfWork > 4) {
      switch (position) {
        case "Admin":
        case "ADMIN":
        case "admin":
          occupationalAllowance = (int) (employeeSalary * 0.05);
          break;
        case "Coordinator":
        case "COORDINATOR":
        case "coordinator":
          occupationalAllowance = (int) (employeeSalary * 0.05);
          break;
        case "SPV":
        case "spv":
        case "Spv":
          occupationalAllowance = (int) (employeeSalary * 0.05);
          break;
        case "Sprinter":
        case "sprinter":
        case "SPRINTER":
          occupationalAllowance = 0;
          break;
        case "Officer":
        case "officer":
        case "OFFICER":
          occupationalAllowance = 0;
          break;
        case "Manager":
        case "manager":
        case "MANAGER":
          occupationalAllowance = (int) (employeeSalary * 0.05);
          break;
        default:
          System.out.println("position " + position + " invalid.");
          break;
      }
    }
    return occupationalAllowance;
  }

  public static int calculateEmployeeBenefits(String position) {
    int employeeBenefits = 0;
    switch (position) {
      case "Admin":
      case "ADMIN":
      case "admin":
        employeeBenefits = 200000;
        break;
      case "Coordinator":
      case "COORDINATOR":
      case "coordinator":
        employeeBenefits = 500000;
        break;
      case "SPV":
      case "spv":
      case "Spv":
        employeeBenefits = 700000;
        break;
      case "Sprinter":
      case "sprinter":
      case "SPRINTER":
        employeeBenefits = 200000;
        break;
      case "Officer":
      case "officer":
      case "OFFICER":
        employeeBenefits = 200000;
        break;
      case "Manager":
      case "manager":
      case "MANAGER":
        employeeBenefits = 1000000;
        break;
      default:
        System.out.println("position " + position + " invalid.");
        break;
    }
    return employeeBenefits;
  }

  public static int calculateGrossSalary(int employeeSalary, int familyAllowance, int occupationalAllowance,
      int employeeBenefits) {
    return employeeSalary + familyAllowance + occupationalAllowance + employeeBenefits;
  }

  public static int calculateRetirementDeductions(int employeeGrossSalary) {
    return (int) (employeeGrossSalary * 0.02);
  }

  public static int calculateBpjsDeductions(int employeeGrossSalary) {
    return (int) (employeeGrossSalary * 0.02);
  }

  public static int calculatePphDeduction(int employeeGrossSalary) {
    return (int) (employeeGrossSalary * 0.05);
  }

  public static int calculateNetSalary(int employeeGrossSalary, int retirementDeductions, int deductionBPJS,
      int deductionPPH) {
    return employeeGrossSalary - retirementDeductions - deductionBPJS - deductionPPH;
  }
}
