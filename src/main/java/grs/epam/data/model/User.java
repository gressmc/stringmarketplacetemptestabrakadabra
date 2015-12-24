package grs.epam.data.model;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@NamedQuery(name = "User.getAll", query = "SELECT u FROM User u")
public class User extends AbstractModel<Integer> implements Identified<Integer> {

    @Id
    @SequenceGenerator(name = "USERS_SEQ", sequenceName = "PK_USERS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "BILLING_ADDRESS")
    private String billingAddress;

    private String login;
    private String pass;
    private String email;
    private String message = "";

    public User(String fullName, String login, String pass, String email, String billingAddress){
        this.fullName = fullName;
        this.login = login;
        this.pass = pass;
        this.email = email;
        this.billingAddress = billingAddress;
    }

    public User(){}

    public void setBids(Item item, double amount) {
        Bid bid = new Bid(amount);
        bid.setUser(this);
        item.addBid(bid);
    }

    public Item.Builder createItem() {
        return Item.newBuilder();
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Builder newBuilder() {
        return new User().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder setUserFullName(String fullName) {
            User.this.fullName = fullName;
            return this;
        }

        public Builder setUserAddress(String address) {
            User.this.billingAddress = address;
            return this;
        }

        public Builder setUserLogin(String login) {
            User.this.login = login;
            return this;
        }

        public Builder setUserPass(String pass) {
            User.this.pass = pass;
            return this;
        }

        public Builder setUserEmail(String email) {
            User.this.email = email;
            return this;
        }

        public User build() {
            return User.this;
        }

    }
}
