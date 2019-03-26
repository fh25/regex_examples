package com.example.validators;

import java.util.Scanner;

public class UsernameValidator {
  /**
   * ^ Assert position at the beginning of the string.
   * (?=...) Is a positive lookahead that ensures that the first character is either in a-z or A-Z
   * (\\w..) 2nd group that checks if the characters are in (a-zA-Z0-9_) shorthand is \w
   * {8,30}  Ensures that the length of the username is minimum of 8 characters to a max of 30 characters that fall within \w
   * $       Assert position at the end of the string.
   */
  private static final String regularExpression = "^(?=[a-zA-Z])(\\w{8,30}$)";

  public static void main(String[] args) {
    final Scanner scan = new Scanner(System.in);
    System.out.println("Username must meet the following requirements:\n" +
            "1. Minimum 8 characters and maximum of 30 characters\n" +
            "2. Must start with alphabet character\n" +
            "3. Can only contain alphanumeric characters and a special character of _ (underscore)");
    System.out.print("Enter number of usernames to check: ");

    int n = Integer.parseInt(scan.nextLine());
    while (n-- != 0) {
      System.out.print("Enter ");
      String userName = scan.nextLine();

      if (checkForValidUsername(userName)) {
        System.out.println("Valid");
      } else {
        System.out.println("Invalid");
      }
    }
  }

  public static Boolean checkForValidUsername(String userName) {
    return userName.matches(regularExpression);
  }
}
