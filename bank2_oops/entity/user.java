package bank2_oops.entity;

public class user {

  private String username;
  private String password;
  private String contactNumber;
  private String role;
  private Double accountBalance;

  public user(
    String username,
    String password,
    String contactNumber,
    String role,
    Double accountBalance
  ) {
    this.username = username;
    this.password = password;
    this.contactNumber = contactNumber;
    this.role = role;
    this.accountBalance = accountBalance;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public string getUsername() {
    return username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public string getPassword() {
    return password;
  }

  public void setContactNumber(String contactnumber) {
    this.contactNumber = contactnumber;
  }

  public string getContactNumber() {
    return contactNumber;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public string getRole() {
    return role;
  }

  public Double getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(Double accountBalance) {
    this.accountBalance = accountBalance;
  }

  @Override
  public String toString() {
    return (
      "User{" +
      "username='" +
      username +
      '\'' +
      ", password='" +
      password +
      '\'' +
      ", contactNumber='" +
      contactNumber +
      '\'' +
      ", role='" +
      role +
      '\'' +
      ", accountBalance=" +
      accountBalance +
      '}'
    );
  }
}
