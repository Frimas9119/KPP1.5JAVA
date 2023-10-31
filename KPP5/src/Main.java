import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    String passportSeries;
    String passportNumber;
    String lastName;

    public Employee(String passportSeries, String passportNumber, String lastName) {
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.lastName = lastName;
    }

    public String getFullName() {
        return lastName;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    @Override
    public String toString() {
        return "Passport: " + passportSeries + "-" + passportNumber + ", Last Name: " + lastName;
    }
}

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        
        boolean isAutoMode = false;
        for (String arg : args) {
            if (arg.equalsIgnoreCase("auto")) {
                isAutoMode = true;
                break;
            }
        }

        if (isAutoMode) {
	        String partialLastName = null;
	        String partialPassportSeries = null;
	        String partialPassportNumber = null;
	
	        if (args.length == 4 && args[0].equals("auto")) {
	            partialLastName = args[1];
	            partialPassportSeries = args[2];
	            partialPassportNumber = args[3];
	        } else {
	            System.out.println("Usage: java Main auto [PartialLastName] [PartialPassportSeries] [PartialPassportNumber]");
	            return;
	        }
	
	        Pattern lastNamePattern = Pattern.compile(partialLastName.replace("...", ".*"));
	        Pattern passportSeriesPattern = Pattern.compile(partialPassportSeries.replace("...", ".*"));
	        Pattern passportNumberPattern = Pattern.compile(partialPassportNumber.replace("...", ".*"));
	
	        List<Employee> employees = new ArrayList<>();
	        employees.add(new Employee("АІ", "98765", "Артеменко"));
	        employees.add(new Employee("ФІ", "12345", "Петренко"));
	        employees.add(new Employee("ЙЦ", "67890", "Артюхов"));
	        employees.add(new Employee("МХ", "86123", "Артеменко"));
	
	        List<Employee> potentialMatches = new ArrayList<>();
	
	        for (Employee employee : employees) {
	            String fullName = employee.getFullName();
	            String passportSeries = employee.getPassportSeries();
	            String passportNumber = employee.getPassportNumber();
	
	            Matcher lastNameMatcher = lastNamePattern.matcher(fullName);
	            Matcher passportSeriesMatcher = passportSeriesPattern.matcher(passportSeries);
	            Matcher passportNumberMatcher = passportNumberPattern.matcher(passportNumber);
	
	            if (lastNameMatcher.find() && passportSeriesMatcher.find() && passportNumberMatcher.find()) {
	                potentialMatches.add(employee);
	            }
	        }
	
	        if (!potentialMatches.isEmpty()) {
	            System.out.println("Potential Matches for the damaged passport:");
	            for (Employee match : potentialMatches) {
	                System.out.println(match);
	            }
	        } else {
	            System.out.println("No potential matches found for the damaged passport.");
	        }
        }else {

            System.out.print("Enter a partial last name: ");
            String partialLastName = scanner.nextLine();
            String lastNamePatternString = partialLastName.replace("...", ".*");
            Pattern lastNamePattern = Pattern.compile(lastNamePatternString);

            System.out.print("Enter a partial passport series: ");
            String partialPassportSeries = scanner.nextLine();
            String passportSeriesPatternString = partialPassportSeries.replace("...", ".*");
            Pattern passportSeriesPattern = Pattern.compile(passportSeriesPatternString);

            System.out.print("Enter a partial passport number: ");
            String partialPassportNumber = scanner.nextLine();
            String passportNumberPatternString = partialPassportNumber.replace("...", ".*");
            Pattern passportNumberPattern = Pattern.compile(passportNumberPatternString);

            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee("АІ", "98765", "Артеменко"));
            employees.add(new Employee("ФІ", "12345", "Петренко"));
            employees.add(new Employee("ЙЦ", "67890", "Артюхов"));
            employees.add(new Employee("МХ", "86123", "Артеменко"));

            List<Employee> potentialMatches = new ArrayList();

            for (Employee employee : employees) {
                String fullName = employee.getFullName();
                String passportSeries = employee.getPassportSeries();
                String passportNumber = employee.getPassportNumber();

                Matcher lastNameMatcher = lastNamePattern.matcher(fullName);
                Matcher passportSeriesMatcher = passportSeriesPattern.matcher(passportSeries);
                Matcher passportNumberMatcher = passportNumberPattern.matcher(passportNumber);

                if (lastNameMatcher.find() &&
                    passportSeriesMatcher.find() &&
                    passportNumberMatcher.find()) {
                    potentialMatches.add(employee);
                }
            }

            if (!potentialMatches.isEmpty()) {
                System.out.println("Potential Matches for the damaged passport:");
                for (Employee match : potentialMatches) {
                    System.out.println(match);
                }
            } else {
                System.out.println("No potential matches found for the damaged passport.");
            }

            scanner.close();
	    }
	        
    }
}
