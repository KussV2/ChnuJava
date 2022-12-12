package lab4;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

public class Worker extends Human implements Comparable<Worker> {
    private String phoneNumber;
    private final List<Client> clients = new ArrayList<>();
    private int officeNumber;
    private int salary;

    public Worker(Builder builder) {
        super(builder);
        phoneNumber = builder.phoneNumber;
        clients.addAll(builder.clients);
        officeNumber = builder.officeNumber;
        salary = builder.salary;
    }

    /**
     * Set worker phone number
     *
     * @param phoneNumber phone number
     * @throws IllegalArgumentException if number is not a phone number
     */
    public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
        if (!phoneNumber.matches("^[+][1-9][0-9]{9,11}"))
            throw new IllegalArgumentException("Wrong number");
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Erase client from worker's client list
     *
     * @param client client whom need to erase
     */
    public void eraseClient(Client client) {
        clients.remove(client);
    }

    /**
     * Add client to worker's client list
     *
     * @param client client whom need to add
     */
    public void setClient(Client client) {
        clients.add(client);
    }

    /**
     * Add clients to worker's client list
     *
     * @param clients clients who need to be added
     */
    public void setClients(List<Client> clients) {
        this.clients.addAll(clients);
    }

    /**
     * Return all worker's client
     *
     * @return list of worker's client
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Return worker's client with specified name
     *
     * @param name clients name
     * @return list of worker's client with specified name
     */
    public List<Client> getClientsByNameStream(String name) {
        return clients.stream().filter(client -> Objects.equals(client.getName(), name)).collect(Collectors.toList());
    }

    public List<Client> getClientsByName(String name) {
        List<Client> result = new ArrayList<>();
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                result.add(client);
            }
        }
        return result;
    }

    /**
     * Return worker's client with specified surname
     *
     * @param surname clients surname
     * @return list of worker's client with specified surname
     */
    public List<Client> Client(String surname) {
        return clients.stream().filter(client -> Objects.equals(client.getName(), name)).collect(Collectors.toList());
    }

    public List<Client> getClientsBySurname(String surname) {
        List<Client> result = new ArrayList<>();
        for (Client client : clients) {
            if (client.getSurname().equals(surname)) {
                result.add(client);
            }
        }
        return result;
    }

    /**
     * Return worker's client with specified id
     *
     * @param id client id
     * @return client with specified id
     */
    public Client getClientsByIdStream(int id) {
        return clients.stream().filter(client -> Objects.equals(client.getId(), id)).findFirst().get();
    }

    public Client getClientsById(int id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    /**
     * Return worker's client with specified order id
     *
     * @param orderId client order id
     * @return client with specified order id
     */
    public Client getClientsByOrderIdStream(int orderId) {
        return clients.stream().filter(client -> Objects.equals(client.getOrderId(), orderId))
                .findFirst().get();
    }


    public Client getClientsByOrderId(int orderId) {
        for (Client client : clients) {
            if (client.getOrderId() == orderId) {
                return client;
            }
        }
        return null;
    }

    public List<Integer> getClientsOrderId() {
        List<Integer> result = new ArrayList<>();
        for (Client client : clients) {
            result.add(client.getOrderId());
        }
        return result;
    }

    public List<Integer> getClientsOrderIdStream() {
        return clients.stream().map(Client::getOrderId).collect(Collectors.toList());
    }

    public void sortClientsByNameAndSurname() {
        Collections.sort(clients);
    }

    public void sortClientsByOrderId() {
        clients.sort(new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                if (o1.getOrderId() < o2.getOrderId())
                    return -1;
                else if (o1.getOrderId() == o2.getOrderId())
                    return 0;
                return 1;
            }
        });
    }

    public void sortClientsByAge() {
        clients.sort(Comparator.comparing(Client::getBirthday));
    }

    /**
     * Set worker office number
     *
     * @param officeNumber office number
     * @throws IllegalArgumentException if office number less than zero
     */
    public void setOfficeNumber(int officeNumber) throws IllegalArgumentException {
        if (officeNumber < 0)
            throw new IllegalArgumentException("Wrong office number");
        this.officeNumber = officeNumber;
    }

    /**
     * @return office number
     */
    public int getOfficeNumber() {
        return officeNumber;
    }

    /**
     * Set worker salary
     *
     * @param salary salary
     * @throws IllegalArgumentException if salary less than zero
     */
    public void setSalary(int salary) throws IllegalArgumentException {
        if (salary < 0)
            throw new IllegalArgumentException("Wrong salary");
        this.salary = salary;
    }

    /**
     * @return worker salary
     */
    public int getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Worker o) {
        return (this.name + this.surname).compareTo(o.name + o.surname);
    }

    /**
     * Build instance of Worker
     */
    public static class Builder extends Human.Builder {
        @Size(min = 11, max = 13, message = "Wrong phone number")
        private String phoneNumber;
        private final List<Client> clients = new ArrayList<>();
        @Positive(message = "Office number must be greater than zero")
        private int officeNumber;
        @Positive(message = "Salary must be greater than zero")
        private int salary;

        /**
         * Check number and set it as client phone number
         *
         * @param phoneNumber phone number
         * @return Builder instance
         * @throws IllegalArgumentException if number is not a phone number
         */
        public Builder setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
            if (!phoneNumber.matches("^[+][1-9][0-9]{9,11}"))
                throw new IllegalArgumentException("Wrong number");
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Set list of worker's client
         *
         * @param clients list of clients
         * @return Builder instance
         */
        public Builder setClients(List<Client> clients) {
            this.clients.addAll(clients);
            return this;
        }

        /**
         * Check number and set it as worker office number
         *
         * @param officeNumber office number
         * @return Builder instance
         * @throws IllegalArgumentException if office number less than zero
         */
        public Builder setOfficeNumber(int officeNumber) throws IllegalArgumentException {
            if (officeNumber < 0)
                throw new IllegalArgumentException("Wrong office number");
            this.officeNumber = officeNumber;
            return this;
        }

        /**
         * Check number and set it as worker salary
         *
         * @param salary salary
         * @return Builder instance
         * @throws IllegalArgumentException if salary less than zero
         */
        public Builder setSalary(int salary) throws IllegalArgumentException {
            if (salary < 0)
                throw new IllegalArgumentException("Wrong salary");
            this.salary = salary;
            return this;
        }

        @Override
        public Builder setName(String name) {
            return (Builder) super.setName(name);
        }

        @Override
        public Builder setSurname(String surname) {
            return (Builder) super.setSurname(surname);
        }

        @Override
        public Builder setBirthday(Calendar birthday) throws IllegalArgumentException {
            return (Builder) super.setBirthday(birthday);
        }

        @Override
        public Builder setId(int id) throws IllegalArgumentException {
            return (Builder) super.setId(id);
        }

        /**
         * Create new Worker object
         *
         * @return Worker instance
         */
        public Worker createWorker() {
            return new Worker(this);
        }
    }

    /**
     * Generate hash code for Worker
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(officeNumber + ((Human) this).hashCode());
    }

    /**
     * Generate string from Worker object
     *
     * @return string representation of Worker
     */
    @Override
    public String toString() {
        String human = super.toString();

        return human.substring(0, human.lastIndexOf('}')) + ",\"phoneNumber\":\"" + phoneNumber + "\",\"clients\":" + clients + ",\"officeNumber\":\""
                + officeNumber + "\",\"salary\":\"" + salary + "\"}";
    }

    /**
     * Compare workers objects
     *
     * @param obj object to compare
     * @return are two objects equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        if (this == obj)
            return true;
        return super.equals(obj) && Objects.equals(phoneNumber, ((Worker) obj).phoneNumber)
                && Objects.equals(officeNumber, ((Worker) obj).officeNumber)
                && Objects.equals(salary, ((Worker) obj).salary)
                && Objects.equals(clients, ((Worker) obj).clients);
    }
}
