package lab4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.List;

public class ExceptionTest {
    Calendar calendar = Calendar.getInstance();

    {
        calendar.set(1987, Calendar.DECEMBER, 24);
    }

    Calendar calendar1 = Calendar.getInstance();

    {
        calendar1.set(1234, Calendar.DECEMBER, 24);
    }

    Calendar calendar2 = Calendar.getInstance();

    {
        calendar2.set(2022, Calendar.DECEMBER, 24);
    }

    Calendar calendar3 = Calendar.getInstance();

    {
        calendar3.set(9876, Calendar.DECEMBER, 24);
    }

    Human human1 = new Human.Builder().setName("Name1h").setSurname("Surname1h")
            .setBirthday(calendar).setId(1).createHuman();

    Client client1 = new Client.Builder().setName("Name1p").setSurname("Surname1p").setBirthday(calendar)
            .setId(2).setPhoneNumber("+1111111111").setOrderId(1).createClient();

    Worker worker1 = new Worker.Builder().setName("Name1d").setSurname("Surname1d").setBirthday(calendar)
            .setId(3).setPhoneNumber("+1111111112").setClients(List.of(client1)).setSalary(123456)
            .setOfficeNumber(2).createWorker();

    Building building1 = new Building("Address");

    OfficeBuilding officeBuilding1 = new OfficeBuilding.Builder().setAddress("Address1").setNumber(1)
            .setWorkers(List.of(worker1)).createOfficeBuilding();

    @DataProvider(name = "NameAndSurnameProvider")
    public Object[][] dpNameAndSurname() {
        return new Object[][]{{""}, {"name"}, {"1Surname"}, {"Na6*&@#$%"}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "NameAndSurnameProvider")
    public void testHumanBuilderNameExceptions(String name) {
        Human human = new Human.Builder().setName(name).createHuman();
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "NameAndSurnameProvider")
    public void testHumanBuilderSurnameExceptions(String surname) {
        Human human = new Human.Builder().setSurname(surname).createHuman();
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "NameAndSurnameProvider")
    public void testHumanSetNameExceptions(String name) {
        human1.setName(name);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "NameAndSurnameProvider")
    public void testHumanSetSurnameExceptions(String surname) {
        human1.setName(surname);
    }

    @DataProvider(name = "NumberProvider")
    public Object[][] dpId() {
        return new Object[][]{{-5}, {-100}, {-415154}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "NumberProvider")
    public void testHumanBuilderIdExceptions(int id) {
        Human human = new Human.Builder().setId(id).createHuman();
    }


    @DataProvider(name = "CalendarProvider")
    public Object[][] dpCalendar() {
        return new Object[][]{{calendar1}, {calendar2}, {calendar3}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "CalendarProvider")
    public void testHumanBuilderBirthdayException(Calendar cal) {
        Human human = new Human.Builder().setBirthday(cal).createHuman();
    }

    @DataProvider(name = "PhoneNumberProvider")
    public Object[][] dpPhoneNumber() {
        return new Object[][]{{"abcdefg"}, {"000000000"}, {"+150ad117D7"}, {"+123456"}, {"+1234567890101112"}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "PhoneNumberProvider")
    public void testClientBuilderPhoneNumberException(String phoneNumber) {
        Client client = new Client.Builder().setPhoneNumber(phoneNumber).createClient();
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "PhoneNumberProvider")
    public void testClientSetPhoneNumberException(String phoneNumber) {
        client1.setPhoneNumber(phoneNumber);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "NumberProvider")
    public void testClientBuilderOrderIdException(int orderId) {
        Client client = new Client.Builder().setOrderId(orderId).createClient();
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "PhoneNumberProvider")
    public void testWorkerBuilderPhoneNumberException(String phoneNumber) {
        Worker worker = new Worker.Builder().setPhoneNumber(phoneNumber).createWorker();
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "NumberProvider")
    public void testWorkerBuilderOfficeNumberException(int officeNumber) {
        Worker worker = new Worker.Builder().setOfficeNumber(officeNumber).createWorker();
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "NumberProvider")
    public void testWorkerBuilderSalaryException(int salary) {
        Worker worker = new Worker.Builder().setSalary(salary).createWorker();
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "PhoneNumberProvider")
    public void testWorkerSetPhoneNumberException(String phoneNumber) {
        worker1.setPhoneNumber(phoneNumber);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "NumberProvider")
    public void testWorkerSetOfficeNumberException(int officeNumber) {
        worker1.setOfficeNumber(officeNumber);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "NumberProvider")
    public void testWorkerSetSalaryException(int salary) { worker1.setSalary(salary); }

    @DataProvider(name = "AddressProvider")
    public Object[][] dpAddressProvider() {
        return new Object[][]{{"address"}, {"T%^&"}, {"1address"}, {""}, {"123456"}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "AddressProvider")
    public void testBuildingConstructorException(String address) {
        Building building = new Building(address);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "AddressProvider")
    public void testBuildingSetAddressException(String address) {
        building1.setAddress(address);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "NumberProvider")
    public void testOfficeBuildingBuilderNumberException(int number) {
        OfficeBuilding officeBuilding = new OfficeBuilding.Builder().setNumber(number).createOfficeBuilding();
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "NumberProvider")
    public void testOfficeBuildingSetNumberException(int number) {
        officeBuilding1.setNumber(number);
    }
}
