Java Encapsulation Documentation


---

What is Encapsulation?

Encapsulation is one of the fundamental principles of Object-Oriented Programming (OOP). It involves bundling the data (variables) and methods (functions) that operate on the data into a single unit, called a class. Encapsulation restricts direct access to certain components of an object and ensures controlled access through methods.


---

Key Concepts of Encapsulation

1. Data Hiding:

Internal details of the class are hidden from the outside world.

Only specific methods (getters and setters) are provided to access or modify the data.



2. Controlled Access:

Access to the class variables is controlled using methods.

Ensures that data integrity and validation can be maintained.



3. Improves Modularity:

Changes to the internal implementation do not affect the code that uses the class.





---

Advantages of Encapsulation

1. Increased Security:

Sensitive data can be hidden and only accessed through controlled mechanisms.



2. Ease of Maintenance:

Changes in one part of the code (class internals) do not affect external code.



3. Improved Code Readability:

By using methods like getters and setters, the intent of accessing or modifying a field is clear.



4. Validation and Data Integrity:

Allows adding validation logic inside setters before updating the value of a variable.





---

Steps to Implement Encapsulation

1. Declare Class Variables as private:

Restricts direct access to the variables.



2. Provide Public Methods (get and set):

Use getters to retrieve variable values.

Use setters to update variable values, adding validation logic if necessary.



3. Access Variables Through Methods:

Use the public getter and setter methods to interact with the private data.





class BankAccount {
    // Private data members (data hiding)
    private String accountHolderName;
    private double balance;

    // Constructor to initialize account
    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        setBalance(initialBalance); // Use setter for balance to apply validation
    }

    // Getter for accountHolderName
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Setter for accountHolderName
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance (with validation)
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance must be non-negative. Setting balance to $0.0.");
            this.balance = 0.0;
        }
    }

    // Method to deposit money (with validation)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money (with validation)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        // Creating a BankAccount object using constructor
        BankAccount account = new BankAccount("John Doe", 500.0);

        // Using setters to modify data
        account.setAccountHolderName("Jane Smith");
        account.setBalance(1000.0);

        // Displaying data using getters
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Current Balance: $" + account.getBalance());

        // Deposit money
        account.deposit(200.0);
        System.out.println("Updated Balance: $" + account.getBalance());

        // Withdraw money
        account.withdraw(150.0);
        System.out.println("Updated Balance: $" + account.getBalance());

        // Try invalid deposit and withdrawal
        account.deposit(-50.0);
        account.withdraw(2000.0);
    }
}

Output
  
Account Holder: Jane Smith
Current Balance: $1000.0
Successfully deposited: $200.0
Updated Balance: $1200.0
Successfully withdrew: $150.0
Updated Balance: $1050.0
Deposit amount must be positive.
Insufficient balance.


Key Features in the Example

1. Private Data Members:

The accountHolderName and balance variables are declared as private.



2. Getters and Setters:

getAccountHolderName() and setAccountHolderName() provide controlled access to the accountHolderName.

The balance is only accessed via getBalance(), while updates happen through deposit() and withdraw().



3. Validation:

Deposit and withdrawal amounts are validated inside the methods.



4. Data Hiding:

The internal state of the object (balance) is not exposed directly to the user, ensuring better security and control.





---

When to Use Encapsulation?

Encapsulation is ideal for scenarios where:

1. Sensitive or critical data needs to be protected (e.g., financial or personal data).


2. You want to enforce specific rules for accessing or modifying data.


3. You need to maintain flexibility by hiding implementation details and exposing only necessary functionality.




---

Key Takeaway

Encapsulation enhances the security, readability, and maintainability of your code by hiding sensitive data and controlling its access through well-defined methods.

