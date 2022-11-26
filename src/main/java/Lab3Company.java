import lab3.Worker;
import lab3.Client;
import lab3.OfficeBuilding;

import java.util.Arrays;
import java.util.Calendar;

public class Lab3Company {
    public static void main(String[] args)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999, Calendar.DECEMBER, 11);

        Client client1 = new Client.Builder().setName("Patient1Name").setSurname("Patient1Surname")
                .setBirthday(calendar).setId(211).setPhoneNumber("+1111111111")
                .setOrderID(24).createClient();
        Client client2 = new Client.Builder().setName("Patient2Name").setSurname("Patient2Surname")
                .setBirthday(calendar).setId(221).setPhoneNumber("+1111111111")
                .setOrderID(22).createClient();
        Client client3 = new Client.Builder().setName("Patient3Name").setSurname("Patient3Surname")
                .setBirthday(calendar).setId(231).setPhoneNumber("+1111111111")
                .setOrderID(23).createClient();

        Worker worker1 = new Worker.Builder().setName("Doctor1Name").setSurname("Doctor1Surname")
                .setBirthday(calendar).setId(311).setPhoneNumber("+1111111111")
                .setClients(Arrays.asList(client2, client1)).setOfficeNumber(1)
                .setSalary(12345).createWorker();

        Worker worker2 = new Worker.Builder().setName("Doctor2Name").setSurname("Doctor2Surname")
                .setBirthday(calendar).setId(321).setPhoneNumber("+1111111111")
                .setClients(Arrays.asList(client1, client2, client3)).setOfficeNumber(2)
                .setSalary(4321).createWorker();

        OfficeBuilding officeBuilding = new OfficeBuilding.Builder().setAddress("address").setNumber(1)
                .setWorkers(Arrays.asList(worker1, worker2)).createOfficeBuilding();

        System.out.println(worker1);

        worker1.sortClientsByNameAndSurname();
        System.out.println(worker1);

        worker1.sortClientsByOrderId();
        System.out.println(worker1);

        System.out.println(officeBuilding);

        officeBuilding.sortWorkersByNumberOfClients();
        System.out.println(officeBuilding);
    }
}
