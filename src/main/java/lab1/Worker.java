package lab1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Worker extends Human{
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
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return phone number
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * Add client to worker's client list
     *
     * @param client client who needs to be added
     */
    public void setClient(Client client){
        clients.add(client);
    }

    /**
     * Add client to worker's client list
     *
     * @param clients client who needs to be added
     */
    public void setClients(List<Client> clients){
        this.clients.addAll(clients);
    }

    /**
     * Return all worker's clients
     *
     * @return list of worker's clients
     */
    public List<Client> getAllClients(){
        return clients;
    }

    /**
     * Set worker's office number
     *
     * @param officeNumber office number
     */
    public void setOfficeNumber(int officeNumber){
        this.officeNumber = officeNumber;
    }

    /**
     * @return office number
     */
    public int getOfficeNumber(){
        return officeNumber;
    }

    /**
     * Set worker salary
     *
     * @param salary salary
     */
    public void setSalary(int salary){
        this.salary = salary;
    }

    /**
     * @return worker salary
     */
    public int getSalary(){
        return salary;
    }

    /**
     * Build instance of Worker
     */
    public static class Builder extends Human.Builder{
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
        public Builder setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Set list of worker's clients
         *
         * @param clients list of clients
         * @return Builder instance
         */
        public Builder setClients(List<Client> clients){
            this.clients.addAll(clients);
            return this;
        }

        /**
         * Check number and set it as worker's office number
         *
         * @param officeNumber office number
         * @return Builder instance
         */
        public Builder setOfficeNumber(int officeNumber){
            this.officeNumber = officeNumber;
            return this;
        }

        /**
         * Check number and set it as worker salary
         *
         * @param salary salary
         * @return Builder instance
         */
        public Builder setSalary(int salary){
            this.salary = salary;
            return this;
        }

        @Override
        public Builder setName(String name){
            return (Builder) super.setName(name);
        }

        @Override
        public Builder setSurname(String surname){
            return (Builder) super.setSurname(surname);
        }

        @Override
        public Builder setBirthday(LocalDate birthday){
            return (Builder) super.setBirthday(birthday);
        }

        @Override
        public Builder setId(int id){
            return (Builder) super.setId(id);
        }

        public Worker createWorker(){
            return new Worker(this);
        }
    }

    /**
     * Generate hash code for Worker
     *
     * @return hash code
     */
    @Override
    public int hashCode(){
        return Objects.hash(officeNumber + ((Human) this).hashCode());
    }

    /**
     * Generate string from Worker object
     *
     * @return string representation of Worker
     */
    @Override
    public String toString(){
        return "{name: " + name + ", surname: " + surname + ", birthday: " + birthday + ", ID: " + id + ", phone number: "
                + phoneNumber + ", clients: " + clients + ", office number: " + officeNumber + ", salary: "
                + salary + "}";
    }

    /**
     * Compare workers objects
     *
     * @param obj object to compare
     * @return are two objects equal
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null || getClass() != obj.getClass())
            return false;
        if (this == obj)
            return true;
        return Objects.equals(name, ((Worker) obj).name)
                && Objects.equals(surname, ((Worker) obj).surname)
                && Objects.equals(birthday, ((Worker) obj).birthday)
                && Objects.equals(id, ((Worker) obj).id)
                && Objects.equals(phoneNumber, ((Worker) obj).phoneNumber)
                && Objects.equals(officeNumber, ((Worker) obj).officeNumber)
                && Objects.equals(salary, ((Worker) obj).salary)
                && Objects.equals(clients, ((Worker) obj).clients);
    }
}
