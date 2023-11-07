package Ex5Exceptions;
import java.util.Arrays;
import java.util.Scanner;
class MinorCitizenException extends Exception {
    public String toString() {
        return "Error, the Citizen is Under 18, and can't vote!";
    }
}

class Citizen {
    private String name;
    private int age;
    private String aadharNumber;

    public static final Scanner sc = new Scanner(System.in);

    static void printf(String fmt, Object... args) {
        System.out.printf(fmt, args);
    }

    static void printfn(String fmt, Object... args) {
        printf(fmt + "\n", args);
    }

    public void getInput() throws MinorCitizenException {
        printf("Enter Citizen's name: ");
        name = sc.nextLine();
        printf("Enter Citizen's age: ");
        var ageStr = sc.nextLine();
        age = Integer.parseInt(ageStr);

        // for(char c : ageStr.toCharArray()) {
        //     if(Character.isLetter(c)) throw new NumberFormatException("The age was input as alphabets!");
        // }
        printf("Enter Citizen's aadhar no.: ");
        String tempAadhar = sc.nextLine();
        final String[] validAadhars = {"234567891011", "345678910111", "456789101112", "567891011121", "678910111213"};
        
        if(!Arrays.asList(validAadhars).contains(tempAadhar)) {
            throw new NullPointerException("Aadhar number is incorrect!");
        }
        aadharNumber = tempAadhar;
        if(age < 18) {
            throw new MinorCitizenException();
        }
    }

    public boolean canVote() {
        return age >= 18;
    }

    public boolean hasAadhar() {
        return aadharNumber != null;
    }

    public void display() {
        printf("-----------CITIZEN START-----------\n");
        printf("Name: %s\n", name);
        printf("Age: %d\n", age);
        printf("Aadhar: %s\n", aadharNumber);
        printf("-----------CITIZEN END-------------\n");
    }
}

class Main {
    public static void main(String[] args) {
        Citizen c = new Citizen();
        try {
            c.getInput();
        } catch(MinorCitizenException e) {
            Citizen.printf("Exception thrown, Error, Citizen is a minor!, msg: %s\n", e.toString());
        } catch(NumberFormatException e) {
            Citizen.printf("Exception thrown, Error, you entered some alphabets for the citizen's age!\n");
        } catch(NullPointerException e) {
            Citizen.printf("Exception thrown, Error, you didn't enter a valid Aadhar!\n");
        } finally {
            c.display();
            Citizen.printf("Can Vote: %b\n", c.canVote());
            Citizen.printf("Has Aadhar: %b\n",c.hasAadhar());
        }
    }
}

/*
websites
github
remnote
lms
todoist
*/