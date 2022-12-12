package lab2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(builder = Worker.Builder.class)
public class Worker extends Human {
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
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Add client to worker's client list
     *
     * @param client client who need to be added
     */
    public void setClient(Client client) {
        clients.add(client);
    }

    /**
     * Add clients to worker's client list
     *
     * @param clients clients who need to be added
     */
    public void setClient(List<Client> clients) {
        this.clients.addAll(clients);
    }

    /**
     * Return all worker's client
     *
     * @return list of worker's clients
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Set worker office number
     *
     * @param officeNumber office number
     */
    public void setOfficeNumber(int officeNumber) {
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
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * @return worker salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Build instance of Worker
     */
    @JsonPOJOBuilder(buildMethodName = "createWorker", withPrefix = "set")
    public static class Builder extends Human.Builder {
        private String phoneNumber;
        private final List<Client> clients = new ArrayList<>();
        private int officeNumber;
        private int salary;

        /**
         * Check number and set it as client phone number
         *
         * @param phoneNumber phone number
         * @return Builder instance
         */
        public Builder setPhoneNumber(String phoneNumber) {
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
         * Check number and set it as worker's office number
         *
         * @param officeNumber office number
         * @return Builder instance
         */
        public Builder setOfficeNumber(int officeNumber) {
            this.officeNumber = officeNumber;
            return this;
        }

        /**
         * Check number and set it as worker salary
         *
         * @param salary salary
         * @return Builder instance
         */
        public Builder setSalary(int salary) throws IllegalArgumentException {
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
        public Builder setBirthday(Calendar birthday) {
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
        return Objects.hash(officeNumber + ((lab2.Human) this).hashCode());
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
     * Compare Worker objects
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
