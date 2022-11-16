package lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OfficeBuilding extends Building{
    private int number;
    private final List<Worker> workers = new ArrayList<>();

    public OfficeBuilding(String address, int number, List<Worker> workers) {
        super(address);
        this.number = number;
        this.workers.addAll(workers);
    }

    /**
     * Set office building number
     *
     * @param number office building number
     */
    public void setNumber(int number){
        this.number = number;
    }

    /**
     * @return office building number
     */
    public int getNumber(){
        return number;
    }

    /**
     * Erase worker from office building's worker list
     *
     * @param worker worker who need to be erased
     */
    public void eraseWorker(Worker worker){
        workers.remove(worker);
    }

    /**
     * Add worker to office building's worker list
     *
     * @param worker worker who need to be added
     */
    public void addWorker(Worker worker){
        workers.add(worker);
    }

    /**
     * Add workers to office building's worker list
     *
     * @param workers workers who need to be added
     */
    public void addWorkers(List<Worker> workers){
        this.workers.addAll(workers);
    }

    /**
     * Get all workers from office building's worker list
     *
     * @return list of workers
     */
    public List<Worker> getAllWorkers(){
        return workers;
    }

    /**
     * Generate hash code for OfficeBuilding
     *
     * @return hash code
     */
    @Override
    public int hashCode(){
        return Objects.hash(number + super.hashCode());
    }

    /**
     * Generate string from OfficeBuilding object
     *
     * @return string representation of OfficeBuilding
     */
    @Override
    public String toString(){
        return "{ " + super.toString() + ", number: " + number + ", workers: " + workers + " }";
    }

    /**
     * Compare OfficeBuilding objects
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
        return Objects.equals(address, ((OfficeBuilding) obj).address)
                && Objects.equals(number, ((OfficeBuilding) obj).number)
                && Objects.equals(workers, ((OfficeBuilding) obj).workers);
    }
}
