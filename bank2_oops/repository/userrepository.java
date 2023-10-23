package bank2_oops.repository;

//imp
//set , list - add
//map - put
import bank2_oops.entity.transaction;
import bank2_oops.entity.user;
import java.time.LocalDate;
import java.util.*;

public class userrepository {

  private static Set<user> users = new Hashset<>();
  private static List<transaction> transactions = new ArrayList<>();
  Map<String, Boolean> chequeBookRequest = new Hashmap<>();

  static {
    user user1 = new user("admin", "admin", "0123456", "admin", "0.0");
    user user2 = new user("user2", "user2", "4567893", "user", "1000.0");
    user user3 = new user("user3", "user3", "45613593", "user", "2000.0");
    user user4 = new user("user4", "user4", "6828284", "user", "3000.0");
    users.add(user1);
    users.add(user2);
    users.add(user3);
    users.add(user4);
  }

  public void approveChequeBookRequest(String userId) {
    if (chequeBookRequest.contains(userId)) {
      chequeBookRequest.put(userId, true);
    }
  }

  public List<String> getUserIdForChequeBookRequest() {
    List<String> userIds = new ArrayList<>();
    //imp
    for (Map.Entry<String, Boolean> entry : chequeBookRequest.entrySet()) {
      if (!entry.getValue()) {
        userid.add(entry.getKey());
      }
    }
    return userIds;
  }

  public void raiseChequeBookRequest(String userId) {
    //imp

    chequeBookRequest.put(userId, false);
  }

  public Map<string, Boolean> getAllChequeBookRequests() {
    return chequeBookRequest;
  }

  public user getUser(String userId) {
    for (user user1 : users) {
      if (user1.getUsername.equals(userId)) {
        return user1;
      }
    }
    return null;
  }

  public user checkBankBalance(String userId) {
    for (user user1 : users) {
      if (user1.getUsername.equals(userId)) {
        return user1.getAccountBalance();
      }
    }
    return null;
  }

  public boolean transferAmount(String userid, String PayeeId, Double Amount) {
    boolean isDebit = Debit(userid, PayeeId, Amount);
    boolean isCredit = Credit(PayeeId, userid, Amount);
    return isDebit && isCredit;
  }

  public boolean Debit(String UserId, String PayeeId, Double Amount) {
    user user1 = new getUser(UserId);
    users.remove(user1);
    Double accountBalance = user1.getAccountBalance();
    Double finalBalance = accountBalance - Amount;
    user1.setAccountBalance(finalBalance);
    Transaction transaction = new Transaction(
      LocalDate.now(),
      PayeeId,
      Amount,
      "Debit",
      accountBalance,
      finalBalance,
      UserId
    );
    transactions.add(transaction);
    return users.add(user1);
  }

  public boolean Credit(string PayeeId, String UserId, double Amount) {
    user payee = new getUser(PayeeId);
    users.remove(payee);
    Double accountBalance = payee.getAccountBalance();
    Double finalBalance = accountBalance + Amount;
    payee.setAccountBalance(finalBalance);
    Transaction transaction = new Transaction(
      LocalDate.now(),
      UserId,
      Amount,
      "Debit",
      accountBalance,
      finalBalance,
      PayeeId
    );
    transactions.add(transaction);
    return users.add(payee);
  }

  public user Login(String username, String password) {
    for (user user1 : users) {
      if (
        user1.getUser().equals(username) && user1.getPassword().equals(password)
      ) {
        return user1;
      }
    }
    return null;
  }

  public void Printusers() {
    System.out.println(users);
  }

  public void printTransactions(String userId) {
    System.out.println(
      "Date \t User Id \t Amount \t Type \t Initial Balance \t Final Balance"
    );
    System.out.println(
      "-----------------------------------------------------------------------"
    );

    for (Transaction t : transactions) {
      if (t.getTransactionPerformedBy().equals(userId)) {
        System.out.println(
          t.getTransactionDate() +
          "\t" +
          t.getTransactionUserId() +
          "\t" +
          t.getTransactionAmount() +
          "\t\t" +
          t.getTransactionType() +
          "\t\t" +
          t.getInitialBalance() +
          "\t\t" +
          t.getFinalBalance()
        );
      }
    }

    System.out.println(
      "-----------------------------------------------------------------------"
    );
  }

  public boolean addNewCustomer(
    String username,
    String password,
    String contact
  ) {
    User user = new User(username, password, contact, "user", 500.0);
    return users.add(user);
  }
}
