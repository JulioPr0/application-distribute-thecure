import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        List<Patient> patientList = new ArrayList<>();

        while (true) {
            System.out.println("----------------------------Mental Health----------------------------");
            System.out.println("1. Add New Patient");
            System.out.println("2. List of Patients");
            System.out.println("3. Distribute Cure");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Tanggal Lahir (dd/mm/yyyy): ");
                    String dob = scanner.nextLine();

                    System.out.print("Nama Lengkap: ");
                    String name = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Tipe Konseling (face to face or online): ");
                    String counselling = scanner.nextLine();

                    Patient patient = new Patient(dob, name, email, counselling);
                    patientList.add(patient);
                    break;
                case 2:
                    if (patientList.isEmpty()) {
                        System.out.println("Data not found!");
                    } else {
                        System.out.println("List of Patients:");
                        for (Patient p : patientList) {
                            System.out.println(
                                    p.getdateBirth() + " - " + p.getFullName() + " - " + p.getEmail() + " - " + p.getCounselling()
                            );
                        }
                    }
                    break;
                case 3:
                    Distribute.distributeCure(patientList);
                    break;
                case 4:
                    System.out.println("Thank You.");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice. Please Enter a Valid Choice!");
            }
        }
    }
}
