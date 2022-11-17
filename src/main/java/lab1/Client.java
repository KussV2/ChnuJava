package lab1;

import java.time.LocalDate;
import java.util.Objects;

public class Client extends Human{

    private String phoneNumber;
    private final int orderId;

    public Client(Builder builder){
        super(builder);
        phoneNumber = builder.phoneNumber;
        orderId = builder.orderId;
    }
    /**
     * Set client phone number
     *
     * @param phoneNumber phone number
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return client phone number
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * @return order id
     */
    public int getOrderId(){
        return orderId;
    }

    /**
     * Build instance of Client
     */
    public static class Builder extends Human.Builder{
        protected String phoneNumber;
        protected int orderId;

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
         * Check number and set it as order id
         *
         * @param orderId order id
         * @return Builder instance
         */
        public Builder setOrderID(int orderId){
            this.orderId = orderId;
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

        public Client createClient(){
            return new Client(this);
        }
    }

    /**
     * Generate hash code for Client
     *
     * @return hash code
     */
    @Override
    public int hashCode(){
        return Objects.hash(orderId + ((Human) this).hashCode());
    }

    /**
     * Generate string from Client object
     *
     * @return string representation of Client
     */
    @Override
    public String toString(){
        return "{name: " + name + ", surname: " + surname + ", birthday: " + birthday + ", ID: " + id + ", phone number: "
                + phoneNumber + ", order id: " + orderId + "}";
    }

    /**
     * Compare clinets objects
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
        return Objects.equals(name, ((Client) obj).name)
                && Objects.equals(surname, ((Client) obj).surname)
                && Objects.equals(birthday, ((Client) obj).birthday)
                && Objects.equals(id, ((Client) obj).id)
                && Objects.equals(phoneNumber, ((Client) obj).phoneNumber)
                && Objects.equals(orderId, ((Client) obj).orderId);
    }
}
