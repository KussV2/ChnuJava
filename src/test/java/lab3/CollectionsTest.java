package lab3;

import lab3.Worker;
import lab3.Client;
import lab3.OfficeBuilding;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CollectionsTest {
    Calendar calendar1 = Calendar.getInstance();
    {
        calendar1.set(1999, Calendar.OCTOBER, 9);
    }

    Calendar calendar2 = Calendar.getInstance();
    {
        calendar1.set(1988, Calendar.SEPTEMBER, 8);
    }

    Calendar calendar3 = Calendar.getInstance();
    {
        calendar1.set(1977, Calendar.AUGUST, 7);
    }

    Client client1 = new Client.Builder().setName("Patient1Name").setSurname("Patient1Surname")
            .setBirthday(calendar1).setId(211).setPhoneNumber("+1111111111")
            .setOrderID(3).createClient();
    Client client2 = new Client.Builder().setName("Patient2Name").setSurname("Patient2Surname")
            .setBirthday(calendar2).setId(221).setPhoneNumber("+1111111111")
            .setOrderID(2).createClient();
    Client client3 = new Client.Builder().setName("Patient3Name").setSurname("Patient3Surname")
            .setBirthday(calendar3).setId(231).setPhoneNumber("+1111111111")
            .setOrderID(1).createClient();

    Worker worker1 = new Worker.Builder().setName("Doctor1Name").setSurname("Doctor1Surname")
            .setBirthday(calendar1).setId(1).setPhoneNumber("+1111111111")
            .setClients(Arrays.asList(client1, client2, client3)).setOfficeNumber(1)
            .setSalary(12345).createWorker();
    Worker worker2 = new Worker.Builder().setName("Doctor2Name").setSurname("Doctor2Surname")
            .setBirthday(calendar1).setId(2).setPhoneNumber("+1111111111")
            .setClients(Arrays.asList(client1, client3)).setOfficeNumber(2)
            .setSalary(12345).createWorker();

    OfficeBuilding officeBuilding1 = new OfficeBuilding.Builder().setAddress("address").setNumber(1)
            .setWorkers(Arrays.asList(worker1, worker2)).createOfficeBuilding();

    @Test
    public void testSortClientsByNameAndSurname() {
        Worker doctor = new Worker.Builder().setName("Name").setSurname("Surname")
                .setBirthday(calendar1).setId(1).setPhoneNumber("+1111111111")
                .setClients(Arrays.asList(client2, client1, client3)).setOfficeNumber(1)
                .setSalary(12345).createWorker();

        doctor.sortClientsByNameAndSurname();

        assertEquals(client1, doctor.getClients().get(0));
        assertEquals(client2, doctor.getClients().get(1));
        assertEquals(client3, doctor.getClients().get(2));
    }

    @Test
    public void testSortClientsByOrderId() {
        Worker doctor = new Worker.Builder().setName("Name").setSurname("Surname")
                .setBirthday(calendar1).setId(1).setPhoneNumber("+1111111111")
                .setClients(Arrays.asList(client1, client2, client3)).setOfficeNumber(1)
                .setSalary(12345).createWorker();

        doctor.sortClientsByOrderId();

        assertEquals(client3, doctor.getClients().get(0));
        assertEquals(client2, doctor.getClients().get(1));
        assertEquals(client1, doctor.getClients().get(2));
    }

    @Test
    public void testSortClientsByAge() {
        Worker doctor = new Worker.Builder().setName("Name").setSurname("Surname")
                .setBirthday(calendar1).setId(1).setPhoneNumber("+1111111111")
                .setClients(Arrays.asList(client2, client1, client3)).setOfficeNumber(1)
                .setSalary(12345).createWorker();

        doctor.sortClientsByAge();

        assertEquals(client1, doctor.getClients().get(0));
        assertEquals(client2, doctor.getClients().get(1));
        assertEquals(client3, doctor.getClients().get(2));
    }

    @Test
    public void testGetClientsOrderId() {
        List<Integer> expected = new ArrayList<>(List.of(3, 2, 1));
        List<Integer> actual = worker1.getClientsOrderId();
        assertEquals(actual, expected);
    }

    @Test
    public void testGetClientsOrderIdStream() {
        List<Integer> expected = new ArrayList<>(List.of(3, 2, 1));
        List<Integer> actual = worker1.getClientsOrderIdStream();
        assertEquals(actual, expected);
    }

    @Test
    public void testGetClientsByOrderId() {
        assertEquals(client1, worker1.getClientsByOrderId(client1.getOrderId()));
    }

    @Test
    public void testGetClientsByOrderIdStream() {
        assertEquals(client2, worker1.getClientsByOrderIdStream(client2.getOrderId()));
    }

    @Test
    public void testGetClientsById() {
        assertEquals(client3, worker1.getClientsById(client3.getId()));
    }

    @Test
    public void testGetClientsByIdStream() {
        assertEquals(client1, worker1.getClientsByIdStream(client1.getId()));
    }

    @Test
    public void testGetClientsBySurname() {
        List<Client> expected = new ArrayList<>();
        expected.add(client2);
        assertEquals(expected, worker1.getClientsBySurname(client2.getSurname()));
    }

    @Test
    public void testGetClientsBySurnameStream() {
        List<Client> expected = new ArrayList<>();
        expected.add(client3);
        assertEquals(expected, worker1.getClientsBySurnameStream(client3.getSurname()));
    }

    @Test
    public void testGetClientsByName() {
        List<Client> expected = new ArrayList<>();
        expected.add(client1);
        assertEquals(expected, worker1.getClientsByName(client1.getName()));
    }

    @Test
    public void testGetClientsByNameStream() {
        List<Client> expected = new ArrayList<>();
        expected.add(client2);
        assertEquals(expected, worker1.getClientsByNameStream(client2.getName()));
    }

    @Test
    public void testSortDoctorsByNameAndSurname() {
        OfficeBuilding officeBuilding = new OfficeBuilding.Builder().setAddress("address").setNumber(1)
                .setWorkers(Arrays.asList(worker2, worker1)).createOfficeBuilding();

        officeBuilding.sortWorkersByNameAndSurname();

        assertEquals(worker1, officeBuilding.getWorkers().get(0));
        assertEquals(worker2, officeBuilding.getWorkers().get(1));
    }

    @Test
    public void testSortDoctorsByNumberOfPatients() {
        OfficeBuilding hospital = new OfficeBuilding.Builder().setAddress("address").setNumber(1)
                .setWorkers(Arrays.asList(worker2, worker1)).createOfficeBuilding();

        hospital.sortWorkersByNameAndSurname();

        assertEquals(worker1, hospital.getWorkers().get(0));
        assertEquals(worker2, hospital.getWorkers().get(1));
    }

    @Test
    public void testGetDoctorsById() {
        assertEquals(worker1, officeBuilding1.getWorkersById(worker1.getId()));
        assertEquals(worker2, officeBuilding1.getWorkersById(worker2.getId()));
    }

    @Test
    public void testGetDoctorsBySurname() {
        List<Worker> expected = new ArrayList<>();
        expected.add(worker1);
        assertEquals(expected, officeBuilding1.getWorkersBySurname(worker1.getSurname()));
    }

    @Test
    public void testGetDoctorsByName() {
        List<Worker> expected = new ArrayList<>();
        expected.add(worker2);
        assertEquals(expected, officeBuilding1.getWorkersByName(worker2.getName()));
    }
}
