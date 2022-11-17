package lab1;
import lab1.*;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompanyTest {
    Client client0 = new Client.Builder().setName("Name0").setSurname("Surname0")
            .setBirthday(LocalDate.of(1950, 5, 5)).setId(0)
            .setPhoneNumber("+1111111111").setOrderID(1).createClient();
    Client client1 = new Client.Builder().setName("Name1").setSurname("Surname1")
            .setBirthday(LocalDate.of(1960, 6, 6)).setId(1)
            .setPhoneNumber("+1111111111").setOrderID(2).createClient();
    Client client2 = new Client.Builder().setName("Name2").setSurname("Surname2")
            .setBirthday(LocalDate.of(1970, 7, 7)).setId(2)
            .setPhoneNumber("+1111111111").setOrderID(3).createClient();

    Worker worker0 = new Worker.Builder().setName("Name0").setSurname("Surname0")
            .setBirthday(LocalDate.of(1950, 5, 5)).setId(0)
            .setPhoneNumber("+1111111111").setClients(Arrays.asList(client0, client1, client2))
            .setOfficeNumber(0).setSalary(12345).createWorker();
    Worker worker1 = new Worker.Builder().setName("Name1").setSurname("Surname1")
            .setBirthday(LocalDate.of(1955, 5, 5)).setId(1)
            .setPhoneNumber("+1111111111").setClients(Arrays.asList(client0, client2))
            .setOfficeNumber(2).setSalary(1256).createWorker();
    Worker worker2 = new Worker.Builder().setName("Name2").setSurname("Surname2")
            .setBirthday(LocalDate.of(1954, 5, 5)).setId(2)
            .setPhoneNumber("+1111111111").setClients(Arrays.asList(client1, client2))
            .setOfficeNumber(4).setSalary(345).createWorker();

    @DataProvider(name = "HumanProvider")
    public Object[][] dpHuman() {
        return new Object[][]{{"Name0", "Surname0", LocalDate.of(1950, 5, 5), 0},
                {"Name1", "Surname1", LocalDate.of(1960, 6, 6), 1},
                {"Name2", "Surname2", LocalDate.of(1970, 7, 7), 2}};
    }

    @Test(dataProvider = "HumanProvider")
    public void testHumanBuilding(String name, String surname, LocalDate date, int id) {
        Human human = new Human.Builder().setName(name).setSurname(surname).setBirthday(date).setId(id).createHuman();
        assertEquals(human.getName(), name);
        assertEquals(human.getSurname(), surname);
        assertEquals(human.getBirthday(), date);
        assertEquals(human.getId(), id);

        human.setName("name");
        assertEquals(human.getName(), "name");

        human.setSurname("surname");
        assertEquals(human.getSurname(), "surname");
    }

    @Test(dataProvider = "HumanProvider")
    public void testHumanEquals(String name, String surname, LocalDate date, int id) {
        Human human0 = new Human.Builder().setName(name).setSurname(surname).setBirthday(date).setId(id).createHuman();
        Human human1 = new Human.Builder().setName(name).setSurname(surname).setBirthday(date).setId(id).createHuman();
        Human human2 = new Human.Builder().setName(name).setSurname(surname).setBirthday(date).setId(7).createHuman();

        assertEquals(human1, human0);
        assertEquals(human0, human1);

        assertNotEquals(human2, human0);
        assertNotEquals(human0, human2);
    }

    @Test(dataProvider = "HumanProvider")
    public void testHumanHash(String name, String surname, LocalDate date, int id) {
        Human human0 = new Human.Builder().setName(name).setSurname(surname).setBirthday(date).setId(id).createHuman();
        Human human1 = new Human.Builder().setName(name).setSurname(surname).setBirthday(date).setId(id).createHuman();
        Human human2 = new Human.Builder().setName(name).setSurname(surname).setBirthday(date).setId(9).createHuman();

        assertEquals(human0.hashCode(), human1.hashCode());
        assertNotEquals(human0.hashCode(), human2.hashCode());
    }

    @Test
    public void testHumanToString() {
        Human human = new Human.Builder().setName("name").setSurname("surname")
                .setBirthday(LocalDate.of(1950, 12, 12)).setId(1).createHuman();
        String str = "{name: name, surname: surname, birthday: 1950-12-12, ID: 1}";

        assertEquals(human.toString(), str);
    }

    @DataProvider(name = "ClientProvider")
    public Object[][] dpClient() {
        return new Object[][]{{"Name0", "Surname0", LocalDate.of(1950, 5, 5), 0, "+1111111111", 1},
                {"Name1", "Surname1", LocalDate.of(1960, 6, 6), 1, "+1111111111", 1},
                {"Name2", "Surname2", LocalDate.of(1970, 7, 7), 2, "+1111111111", 1}};
    }

    @Test(dataProvider = "ClientProvider")
    public void testClientBuilding(String name, String surname, LocalDate date, int id, String number, int orderId) {
        Client client = new Client.Builder().setName(name).setSurname(surname).setBirthday(date).setId(id)
                .setPhoneNumber(number).setOrderID(orderId).createClient();

        assertEquals(client.getName(), name);
        assertEquals(client.getSurname(), surname);
        assertEquals(client.getBirthday(), date);
        assertEquals(client.getId(), id);
        assertEquals(client.getPhoneNumber(), number);
        assertEquals(client.getOrderId(), orderId);

        client.setName("name");
        assertEquals(client.getName(), "name");

        client.setSurname("surname");
        assertEquals(client.getSurname(), "surname");

        client.setPhoneNumber("+1111111112");
        assertEquals(client.getPhoneNumber(), "+1111111112");
    }

    @DataProvider(name = "WorkerProvider")
    public Object[][] dpWorker() {
        return new Object[][]{{"Name0", "Surname0", LocalDate.of(1950, 5, 5), 0, "+1111111111",
                Arrays.asList(client1, client2), 0, 4554},
                {"Name1", "Surname1", LocalDate.of(1960, 6, 6), 1, "+1111111111",
                        Arrays.asList(client0, client1), 1, 4654},
                {"Name2", "Surname2", LocalDate.of(1970, 7, 7), 2, "+1111111111",
                        Arrays.asList(client2, client0), 3, 4554}};
    }

    @Test(dataProvider = "WorkerProvider")
    public void testWorkerBuilding(String name, String surname, LocalDate date, int id, String number,
                                   List<Client> clients, int officeNumber, int salary) {
        Worker worker = new Worker.Builder().setName(name).setSurname(surname).setBirthday(date).setId(id)
                .setPhoneNumber(number).setClients(clients).setOfficeNumber(officeNumber).setSalary(salary).createWorker();

        assertEquals(worker.getName(), name);
        assertEquals(worker.getSurname(), surname);
        assertEquals(worker.getBirthday(), date);
        assertEquals(worker.getId(), id);
        assertEquals(worker.getPhoneNumber(), number);
        assertEquals(worker.getAllClients(), clients);
        assertEquals(worker.getOfficeNumber(), officeNumber);
        assertEquals(worker.getSalary(), salary);


        worker.setName("name");
        assertEquals(worker.getName(), "name");

        worker.setSurname("surname");
        assertEquals(worker.getSurname(), "surname");

        worker.setPhoneNumber("+1111111112");
        assertEquals(worker.getPhoneNumber(), "+1111111112");

        worker.setOfficeNumber(7);
        assertEquals(worker.getOfficeNumber(), 7);

        worker.setSalary(27536);
        assertEquals(worker.getSalary(), 27536);
    }

    @DataProvider(name = "BuildingProvider")
    public Object[][] dpBuilding() {
        return new Object[][]{{"address0"}, {"address1"}, {"address2"}};
    }

    @Test(dataProvider = "BuildingProvider")
    public void testBuilding(String address) {
        Building building = new Building(address);

        assertEquals(building.getAddress(), address);

        building.setAddress("address");
        assertEquals(building.getAddress(), "address");
    }

    @DataProvider(name = "OfficeBuildingProvider")
    public Object[][] dpOfficeBuilding() {
        return new Object[][]{{"address0", 0, Arrays.asList(worker0, worker2)},
                {"address1", 1, Arrays.asList(worker1, worker2)},
                {"address2", 2, Arrays.asList(worker0, worker1)}};
    }

    @Test(dataProvider = "OfficeBuildingProvider")
    public void testOfficeBuilding(String address, int number, List<Worker> workers) {
        OfficeBuilding officeBuilding = new OfficeBuilding(address, number, workers);

        assertEquals(officeBuilding.getAddress(), address);
        assertEquals(officeBuilding.getNumber(), number);
        assertEquals(officeBuilding.getAllWorkers(), workers);

        officeBuilding.setAddress("address");
        assertEquals(officeBuilding.getAddress(), "address");

        officeBuilding.setNumber(5);
        assertEquals(officeBuilding.getNumber(), 5);

        Worker worker = new Worker.Builder().setName("name").setSurname("surname")
                .setBirthday(LocalDate.of(1950, 5, 5)).setId(7)
                .setPhoneNumber("+1111111111").setClients(List.of(client0, client2)).setOfficeNumber(55)
                .setSalary(15441).createWorker();

        List<Worker> workerList = new ArrayList<>(workers);

        officeBuilding.addWorker(worker);
        workerList.add(worker);
        assertEquals(officeBuilding.getAllWorkers(), workerList);

        officeBuilding.eraseWorker(worker);
        workerList.remove(worker);
        assertEquals(officeBuilding.getAllWorkers(), workerList);

        List<Worker> workrs = Arrays.asList(worker, worker2);
        officeBuilding.addWorkers(workrs);
        workerList.addAll(workrs);
        assertEquals(officeBuilding.getAllWorkers(), workerList);
    }

}
