package lab2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(builder = OfficeBuilding.Builder.class)
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
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @return office building number
     */
    public int getNumber() {
        return number;
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

    @JsonPOJOBuilder(buildMethodName = "createOfficeBuilding", withPrefix = "set")
    public static class Builder {
        private String address;
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
        public Builder setNumber(int number) {
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
