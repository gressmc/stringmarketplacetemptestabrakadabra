package grs.epam.data.dto;

public class UserDTO {

    private Integer id;
    private String fullName;
    private String billingAddress;
    private String login;
    private String password;
    private String email;
    private String message = "";

    public UserDTO(Integer id, String fullName, String login, String password, String email, String billingAddress){
        this.id = id;
        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.billingAddress = billingAddress;
    }

    public UserDTO(String login, String pass){
        this.login = login;
        this.password = password
        ;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
