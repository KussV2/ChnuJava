import lab2.JsonSerializer;
import lab2.TxtSerializer;
import lab2.XmlSerializer;
import lab2.Worker;
import lab2.OfficeBuilding;
import lab2.Client;

import java.util.Arrays;
import java.util.Calendar;

public class Lab2Company {
    public static void main(String[] args)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1999, Calendar.DECEMBER, 11);

        Client client1 = new Client.Builder().setName("ClientName1").setSurname("ClientSurname1")
                .setBirthday(calendar).setId(211).setPhoneNumber("+1111111111")
                .setOrderId(21).createClient();
        Client client2 = new Client.Builder().setName("ClientName2").setSurname("ClientSurname2")
                .setBirthday(calendar).setId(221).setPhoneNumber("+1111111111")
                .setOrderId(22).createClient();
        Client client3 = new Client.Builder().setName("ClientName3").setSurname("ClientSurname3")
                .setBirthday(calendar).setId(231).setPhoneNumber("+1111111111")
                .setOrderId(23).createClient();

        Worker worker1 = new Worker.Builder().setName("WorkerName1").setSurname("WorkerSurname1")
                .setBirthday(calendar).setId(311).setPhoneNumber("+1111111111")
                .setClients(Arrays.asList(client1, client2)).setOfficeNumber(1)
                .setSalary(12345).createWorker();

        Worker worker2 = new Worker.Builder().setName("WorkerName2").setSurname("DoctorSurname2")
                .setBirthday(calendar).setId(321).setPhoneNumber("+1111111111")
                .setClients(Arrays.asList(client1, client3)).setOfficeNumber(2)
                .setSalary(4321).createWorker();

        OfficeBuilding officeBuilding = new OfficeBuilding.Builder().setAddress("address").setNumber(1)
                .setWorkers(Arrays.asList(worker1,worker2)).createOfficeBuilding();

        TxtSerializer txt = new TxtSerializer();
        txt.serialize(client1, "Client.txt");
        System.out.println(client1.equals(txt.deserialize(Client.class, "Client.txt")));

        XmlSerializer xml = new XmlSerializer();
        xml.serialize(worker1, "Worker.xml");
        System.out.println(worker1.equals(xml.deserialize(Worker.class, "Worker.xml")));

        JsonSerializer json = new JsonSerializer();
        json.serialize(officeBuilding,"OfficeBuilding.json");
        System.out.println(officeBuilding.equals(json.deserialize(OfficeBuilding.class, "OfficeBuilding.json")));
    }
}
