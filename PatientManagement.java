import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class PatientManagement {
    private String dateOfBirth;
    private String fullName;

    public PatientManagement(String dateOfBirth, String fullName) {
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }


    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        List<PatientManagement> patientList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add new patient");
            System.out.println("2. List of Patient");
            System.out.println("3. Distribute Cure");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter date of birth (dd/mm/yyyy): ");
                    String dob = scanner.nextLine();

                    System.out.print("Enter full name: ");
                    String name = scanner.nextLine();

                    PatientManagement patient = new PatientManagement(dob, name);
                    patientList.add(patient);
                    break;
                case 2:
                    if (patientList.isEmpty()) {
                        System.out.println("Data not found!");
                    } else {
                        patientList.sort(new Comparator<PatientManagement>() {
                            @Override
                            public int compare(PatientManagement p1, PatientManagement p2) {
                                try {
                                    Date date1 = dateFormat.parse(p1.getDateOfBirth());
                                    Date date2 = dateFormat.parse(p2.getDateOfBirth());
                                    return date1.compareTo(date2);
                                } catch (ParseException e) {
                                    return 0;
                                }
                            }
                        });

                        PatientManagement oldestPatient = patientList.remove(0);
                        System.out.println("Removed oldest patient: " + oldestPatient.getFullName());
                    }
                    break;
                case 3:
                    if (patientList.isEmpty()) {
                        System.out.println("Data not found!");
                    } else {
                        System.out.println("List of patients:");
                        for (PatientManagement p : patientList) {
                            System.out.println(p.getDateOfBirth() + " – " + p.getFullName());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Thank You.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid choice!");
            }
        }
    }
}
