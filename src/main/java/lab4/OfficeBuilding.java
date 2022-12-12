package lab4;

import javax.validation.constraints.Positive;
import java.util.*;
import java.util.stream.Collectors;

public class OfficeBuilding extends Building {
    private int number;
    private final List<Worker> workers = new ArrayList<>();

    public OfficeBuilding(Builder builder) {
        super(builder.address);
        this.number = builder.number;
        this.workers.addAll(builder.workers);
    }

    /**
     * Set office building number
     *
     * @param number office building number
     */
    public void setNumber(int number) throws IllegalArgumentException {
        if (number < 0)
            throw new IllegalArgumentException("Wrong number");
        this.number = number;
    }

    /**
     * @return office building number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Erase worker from office building's worker list
     *
     * @param worker worker whom need to erase
     */
    public void eraseWorker(Worker worker) {
        workers.remove(worker);
    }

    /**
     * Add worker to office building's worker list
     *
     * @param worker worker whom need to add
     */
    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    /**
     * Add workers to office building's worker list
     *
     * @param workers workers whoms need to add
     */
    public void addWorkers(List<Worker> workers) {
        this.workers.addAll(workers);
    }

    /**
     * Get all workers from office building's worker list
     *
     * @return list of workers
     */
    public List<Worker> getWorkers() {
        return workers;
    }

    /**
     * Get workers with the specified name from office building worker list
     *
     * @param name worker name
     * @return list of office building worker with specified name
     */
    public List<Worker> getWorkersByName(String name) {
        return workers.stream().filter(worker -> Objects.equals(worker.getName(), name)).collect(Collectors.toList());
    }

    /**
     * Get workers with the specified surname from office building worker list
     *
     * @param surname worker surname
     * @return list of office building worker with specified surname
     */
    public List<Worker> getWorkersBySurname(String surname) {
        return workers.stream().filter(worker -> Objects.equals(worker.getSurname(), surname)).collect(Collectors.toList());
    }

    /**
     * Get worker with the specified id from office building worker list
     *
     * @param id worker id
     * @return worker with the specified id
     */
    public Worker getWorkersById(int id) {
        return workers.stream().filter(worker -> Objects.equals(worker.getId(), id)).findFirst().get();
    }

    public void sortWorkersByNameAndSurname() {
        Collections.sort(workers);
    }

    public void sortWorkersByNumberOfPatients() {
        workers.sort((o1, o2) -> {
            if (o1.getClients().size() > o2.getClients().size())
                return -1;
            else if (o1.getClients().size() == o2.getClients().size())
                return 0;
            return 1;
        });
    }

    public static class Builder {
        private String address;
        @Positive(message = "Number must be greater than zero")
        private int number;
        private final List<Worker> workers = new ArrayList<>();

        /**
         * Set address of office building
         *
         * @param address office building address
         * @return Builder instance
         */
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        /**
         * Set number of office building
         *
         * @param number office building number
         * @return Builder instance
         */
        public Builder setNumber(int number) throws IllegalArgumentException {
            if (number < 0)
                throw new IllegalArgumentException("Wrong number");
            this.number = number;
            return this;
        }

        /**
         * Set list of office building workers
         *
         * @param workers list of workers
         * @return Builder instance
         */
        public Builder setWorkers(List<Worker> workers) {
            this.workers.addAll(workers);
            return this;
        }

        /**
         * Create new OfficeBuilding object
         *
         * @return OfficeBuilding instance
         */
        public OfficeBuilding createOfficeBuilding() {
            return new OfficeBuilding(this);
        }
    }

    /**
     * Generate hash code for OfficeBuilding
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(number + super.hashCode());
    }

    /**
     * Generate string from OfficeBuilding object
     *
     * @return string representation of OfficeBuilding
     */
    @Override
    public String toString() {
        return "{\"address\":\"" + address + "\",\"number\":\"" + number + "\",\"workers\":" + workers + "}";
    }

    /**
     * Compare OfficeBuilding objects
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
        return Objects.equals(address, ((OfficeBuilding) obj).address)
                && Objects.equals(number, ((OfficeBuilding) obj).number)
                && Objects.equals(workers, ((OfficeBuilding) obj).workers);
    }
}
