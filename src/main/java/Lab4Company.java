import lab4.Client;

import java.util.Calendar;

public class Lab4Company {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, 2, 5);
        try {
            Client patient = new Client.Builder().setName("Name").setSurname("Surname").setId(5).setBirthday(calendar)
                    .setPhoneNumber("+380501111111").setOrderId(2).createClient();
            System.out.println(patient);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
