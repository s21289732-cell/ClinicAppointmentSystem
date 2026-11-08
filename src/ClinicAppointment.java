import java.util.ArrayList;
import java.util.Scanner;

public class ClinicAppointment {
    static class Appointment {
        String patientName;
        String doctorName;
        String date;
        String time;

        Appointment(String patientName, String doctorName, String date, String time) {
            this.patientName = patientName;
            this.doctorName = doctorName;
            this.date = date;
            this.time = time;
        }

        void display() {
            System.out.println("Patient: " + patientName + " | Doctor: " + doctorName + " | Date: " + date + " | Time: " + time);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Appointment> list = new ArrayList<>();
        int choice;

        System.out.println("=== WELCOME TO CLINIC APPOINTMENT SYSTEM ===");

        do {
            System.out.println("\n1. Book Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Patient Name: ");
                String patient = sc.nextLine();
                System.out.print("Enter Doctor Name: ");
                String doctor = sc.nextLine();
                System.out.print("Enter Date (DD-MM-YYYY): ");
                String date = sc.nextLine();
                System.out.print("Enter Time: ");
                String time = sc.nextLine();
                list.add(new Appointment(patient, doctor, date, time));
                System.out.println("Appointment Booked Successfully!");
            } else if (choice == 2) {
                if (list.isEmpty()) {
                    System.out.println("No Appointments Found!");
                } else {
                    System.out.println("\n--- All Appointments ---");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        list.get(i).display();
                    }
                }
            } else if (choice == 3) {
                if (list.isEmpty()) {
                    System.out.println("No Appointments to Cancel!");
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        list.get(i).display();
                    }
                    System.out.print("Enter Appointment Number to Cancel: ");
                    int num = sc.nextInt();
                    if (num >= 1 && num <= list.size()) {
                        list.remove(num - 1);
                        System.out.println("Appointment Cancelled Successfully!");
                    } else {
                        System.out.println("Invalid Number!");
                    }
                }
            } else if (choice == 4) {
                System.out.println("Thank you! Visit Again!");
            } else {
                System.out.println("Invalid Choice! Try Again.");
            }
        } while (choice != 4);
        sc.close();
    }
}
