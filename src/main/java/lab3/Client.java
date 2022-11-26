package lab3;

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
     * @return Client phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set Client phone number
     *
     * @param phoneNumber phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return order Id
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Build instance of Client
     */
    public static class Builder extends Human.Builder {
        protected String phoneNumber;
        protected int orderId;

        /**
         * Set Client phone number
         *
         * @param phoneNumber phone number
         */
        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Check number and set it as client's order Id
         *
         * @param orderId order Id
         * @return Builder instance
         */
        public Builder setOrderID(int orderId) throws IllegalArgumentException {
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
        public Builder setBirthday(Calendar birthday) {
            return (Builder) super.setBirthday(birthday);
        }

        @Override
        public Builder setId(int id) {
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
    public int compareTo(Client c) {
        return (this.name + this.surname).compareTo(c.name + c.surname);
    }
}
