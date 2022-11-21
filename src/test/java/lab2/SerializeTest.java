package lab2;

import lab2.JsonSerializer;
import lab2.TxtSerializer;
import lab2.XmlSerializer;
import lab2.Worker;
import lab2.OfficeBuilding;
import lab2.Human;
import lab2.Client;

import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.Calendar;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SerializeTest {
    Calendar calendar = Calendar.getInstance();

    {
        calendar.set(1999, Calendar.DECEMBER, 11);
    }

    Human human = new Human.Builder().setName("HumanName").setSurname("HumanSurname")
            .setBirthday(calendar).setId(111).createHuman();

    Client client1 = new Client.Builder().setName("ClientName1").setSurname("ClientSurname1")
            .setBirthday(calendar).setId(211).setPhoneNumber("+1111111111")
            .setId(21).createClient();
    Client client2 = new Client.Builder().setName("ClientName2").setSurname("ClientSurname2")
            .setBirthday(calendar).setId(221).setPhoneNumber("+1111111111")
            .setId(22).createClient();
    Client client3 = new Client.Builder().setName("ClientName3").setSurname("ClientSurname3")
            .setBirthday(calendar).setId(231).setPhoneNumber("+1111111111")
            .setId(23).createClient();

    Worker worker1 = new Worker.Builder().setName("WorkerName1").setSurname("WorkerSurname1")
            .setBirthday(calendar).setId(311).setPhoneNumber("+1111111111")
            .setClients(Arrays.asList(client1, client2)).setOfficeNumber(1)
            .setSalary(12345).createWorker();

    Worker worker2 = new Worker.Builder().setName("WorkerName2").setSurname("WorkerSurname2")
            .setBirthday(calendar).setId(321).setPhoneNumber("+1111111111")
            .setClients(Arrays.asList(client1, client3)).setOfficeNumber(2)
            .setSalary(4321).createWorker();

    OfficeBuilding officeBuilding = new OfficeBuilding.Builder().setAddress("address").setNumber(1)
            .setWorkers(Arrays.asList(worker1, worker2)).createOfficeBuilding();

    @Test
    public void testJsonSerialization() {
        JsonSerializer json = new JsonSerializer();

        json.serialize(human, "Human.json");
        Human deserializedHuman = json.deserialize(Human.class, "Human.json");
        assertEquals(human, deserializedHuman);

        json.serialize(client1, "Client.json");
        Client deserializedClient = json.deserialize(Client.class, "Client.json");
        assertEquals(client1, deserializedClient);

        json.serialize(worker1, "Worker.json");
        Worker deserializedWorker = json.deserialize(Worker.class, "Worker.json");
        assertEquals(worker1, deserializedWorker);

        json.serialize(officeBuilding, "OfficeBuilding.json");
        OfficeBuilding deserializedOfficeBuilding = json.deserialize(OfficeBuilding.class, "OfficeBuilding.json");
        assertEquals(officeBuilding, deserializedOfficeBuilding);
    }

    @Test
    public void testXmlSerialization() {
        XmlSerializer xml = new XmlSerializer();

        xml.serialize(human, "Human.xml");
        Human deserializedHuman = xml.deserialize(Human.class, "Human.xml");
        assertEquals(human, deserializedHuman);

        xml.serialize(client1, "Client.xml");
        Client deserializedClient = xml.deserialize(Client.class, "Client.xml");
        assertEquals(client1, deserializedClient);

        xml.serialize(worker1, "Worker.xml");
        Worker deserializedWorker = xml.deserialize(Worker.class, "Worker.xml");
        assertEquals(worker1, deserializedWorker);

        xml.serialize(officeBuilding, "OfficeBuilding.xml");
        OfficeBuilding deserializedOfficeBuilding = xml.deserialize(OfficeBuilding.class, "OfficeBuilding.xml");
        assertEquals(officeBuilding, deserializedOfficeBuilding);
    }

    @Test
    public void testTxtSerialization() {
        TxtSerializer txt = new TxtSerializer();

        txt.serialize(human, "Human.txt");
        Human deserializedHuman = txt.deserialize(Human.class, "Human.txt");
        assertEquals(human, deserializedHuman);

        txt.serialize(client1, "Client.txt");
        Client deserializedClient = txt.deserialize(Client.class, "Client.txt");
        assertEquals(client1, deserializedClient);

        txt.serialize(worker1, "Worker.txt");
        Worker deserializedWorker = txt.deserialize(Worker.class, "Worker.txt");
        assertEquals(worker1, deserializedWorker);

        txt.serialize(officeBuilding, "OfficeBuilding.txt");
        OfficeBuilding deserializedOfficeBuilding = txt.deserialize(OfficeBuilding.class, "OfficeBuilding.txt");
        assertEquals(officeBuilding, deserializedOfficeBuilding);
    }
}
