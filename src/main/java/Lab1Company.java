import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import lab1.*;

public class Lab1Company {
    public static void main(String[] args) {
        Human human1 = new Human.Builder().setName("HumanName1").setSurname("HumanSurname1").setBirthday(LocalDate.now())
                .setId(654789).createHuman();
        Human human2 = new Human.Builder().setName("HumanName2").setSurname("HumanSurname2").setBirthday(LocalDate.now())
                .setId(65444789).createHuman();

        System.out.println(human1.equals(human2));

        System.out.println(human1.getName());
        System.out.println(human1.getSurname());
        System.out.println(human1);

        Client client1 = new Client.Builder().setName("ClientName1").setSurname("ClientSurname1")
                .setBirthday(LocalDate.of(1999, 12, 5)).setId(66)
                .setPhoneNumber("+1111111111").setOrderID(951).createPatient();
        Client client2 = new Client.Builder().setName("ClientName2").setSurname("ClientSurname2")
                .setBirthday(LocalDate.of(1979, 12, 5)).setId(96)
                .setPhoneNumber("+1111111111").setOrderID(951).createPatient();
        Client client3 = new Client.Builder().setName("ClientName3").setSurname("ClientSurname3")
                .setBirthday(LocalDate.of(1879, 12, 5)).setId(90)
                .setPhoneNumber("+1111111111").setOrderID(951).createPatient();

        System.out.println(client1.getName());
        System.out.println(client1);

        List<Client> clientList = Arrays.asList(client1, client2);

        List<Client> clientList1 = List.of(client3);

        Worker worker1 = new Worker.Builder().setName("WorkerName1").setSurname("WorkerSurname1")
                .setBirthday(LocalDate.of(1955, 6, 9))
                .setId(45445).setOfficeNumber(66).setSalary(5453).setPhoneNumber("+1111111111")
                .setClients(clientList).createDoctor();

        Worker worker2 = new Worker.Builder().setName("WorkerName2").setSurname("WorkerSurname2")
                .setBirthday(LocalDate.of(1985, 6, 9))
                .setId(4445).setOfficeNumber(46).setSalary(553).setPhoneNumber("+1111111111")
                .setClients(clientList1).createDoctor();

        System.out.println(worker1);

        List<Worker> workerList = Arrays.asList(worker1, worker2);

        OfficeBuilding officeBuilding = new OfficeBuilding("Address", 1, workerList);

        System.out.println(officeBuilding);
    }
}
