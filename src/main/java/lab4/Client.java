package lab4;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Objects;

public class Client extends Human implements Comparable<Client> {
    private String phoneNumber;
    private final int orderId;

    public Client(Builder builder) {
        super(builder);
        phoneNumber = builder.phoneNumber;
        orderId = builder.orderId;
    }

    /**
     * Set client phone number
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
     * @return client phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return order id
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Build instance of Client
     */
    public static class Builder extends Human.Builder {
        @Size(min = 11, max = 13, message = "Wrong phone number")
        protected String phoneNumber;
        @Positive(message = "Order id must be greater than zero")
        protected int orderId;

        /**
         * Check number and set it as Client phone number
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
         * Check number and set it as client order id
         * @param orderId order card id
         * @return Builder instance
         * @throws IllegalArgumentException if number less than zero
         */
        public Builder setOrderId(int orderId) throws IllegalArgumentException {
            if (orderId < 0)
                throw new IllegalArgumentException("Wrong morder id");
            this.orderId = orderId;
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
         * Create new Client object
         *
         * @return Client instance
         */
        public Client createClient() {
            return new Client(this);
        }
    }

    /**
     * Generate hash code for Client
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(orderId + ((Human) this).hashCode());
    }

    /**
     * Generate string from Client object
     *
     * @return string representation of Client
     */
    @Override
    public String toString() {
        String human = super.toString();

        return human.substring(0, human.lastIndexOf('}')) + ",\"phoneNumber\":\"" + phoneNumber + "\",\"orderId\":\"" + orderId + "\"}";
    }

    /**
     * Compare Client objects
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

        return super.equals(obj) && Objects.equals(phoneNumber, ((Client) obj).phoneNumber)
                && Objects.equals(orderId, ((Client) obj).orderId);
    }

    @Override
    public int compareTo(Client p) {
        return (this.name + this.surname).compareTo(p.name + p.surname);
    }
}
