import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Distribute {
    public static Patient distributeCure(List<Patient> patientList) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (patientList.isEmpty()) {
            System.out.println("Data not found!");
            return null;
        } else {
            Patient youngestPatient = Collections.min(patientList, new Comparator<Patient>() {
                @Override
                public int compare(Patient p1, Patient p2) {
                    try {
                        Date date1 = dateFormat.parse(p1.getdateBirth());
                        Date date2 = dateFormat.parse(p2.getdateBirth());
                        return date1.compareTo(date2);
                    } catch (ParseException e) {
                        return 0;
                    }
                }
            });

            patientList.remove(youngestPatient);
            System.out.println("Distributed Cure to the Youngest Patients: " + youngestPatient.getFullName());

            return youngestPatient;
        }
    }
}
