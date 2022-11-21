package lab2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.Calendar;
import java.util.Objects;

@JsonDeserialize(builder = Client.Builder.class)
public class Client extends Human {
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
    public void setPhoneNumber(String phoneNumber) {
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
    @JsonPOJOBuilder(buildMethodName = "createClient", withPrefix = "set")
    public static class Builder extends Human.Builder {
        protected String phoneNumber;
        protected int orderId;

        /**
         * Check number and set it as client phone number
         *
         * @param phoneNumber phone number
         * @return Builder instance
         * @throws IllegalArgumentException if number is not a phone number
         */
        public Builder setPhoneNumber(String phoneNumber) {

            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         * Check number and set it as client order id
         *
         * @param orderId order id
         * @return Builder instance
         * @throws IllegalArgumentException if number less than zero
         */
        public Builder setOrderId(int orderId) {
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
}
