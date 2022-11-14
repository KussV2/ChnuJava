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
     * Set hospital number
     *
     * @param number hospital number
     */
    public void setNumber(int number){
        this.number = number;
    }

    /**
     * @return hospital number
     */
    public int getNumber(){
        return number;
    }

    /**
     * Erase doctor from hospital's doctor list
     *
     * @param worker doctor whom need to erase
     */
    public void eraseWorker(Worker worker){
        workers.remove(worker);
    }

    /**
     * Add doctor to hospital's doctor list
     *
     * @param worker doctor whom need to add
     */
    public void addWorker(Worker worker){
        workers.add(worker);
    }

    /**
     * Add doctors to hospital's doctor list
     *
     * @param workers doctors whoms need to add
     */
    public void addWorkers(List<Worker> workers){
        this.workers.addAll(workers);
    }

    /**
     * Get all doctors from hospital's doctor list
     *
     * @return list of doctors
     */
    public List<Worker> getAllWorkers(){
        return workers;
    }

    /**
     * Generate hash code for Hospital
     *
     * @return hash code
     */
    @Override
    public int hashCode(){
        return Objects.hash(number + super.hashCode());
    }

    /**
     * Generate string from Hospital object
     *
     * @return string representation of Hospital
     */
    @Override
    public String toString(){
        return "{ " + super.toString() + ", number: " + number + ", workers: " + workers + " }";
    }

    /**
     * Compare hospitals objects
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
