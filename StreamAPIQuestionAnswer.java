import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPIQuestionAnswer {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));

        // How many male and female employees are there in the organization?
        long maleCount = employeeList.stream().filter(e -> e.getGender().equals("Male")).count();
        long femaleCount = employeeList.stream().filter(e -> e.getGender().equals("Female")).count();
        System.out.println("Male and Female count is " + maleCount + " " + femaleCount + " respectively");

        // Print the name of all departments in the organization?
        System.out.println("name of all departments");
        employeeList.stream().map(e -> e.getDepartment()).distinct().forEach(System.out::println);

        // What is the average age of male and female employees?
        double avgMaleEmpAge = employeeList.stream().filter(e -> e.getGender().equals("Male")).mapToInt(e -> e.getAge())
                .average().orElse(0.0);

        double avgFemaleEmpAge = employeeList.stream().filter(e -> e.getGender().equals("Female"))
                .mapToInt(e -> e.getAge()).average().orElse(0.0);

        System.out.println("Average Male and Female age is " + avgMaleEmpAge + " " + avgFemaleEmpAge + " respectively");

        // Get the details of highest paid employee in the organization?

        Employee highestPiadEmp = employeeList.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .orElse(null);
        System.out.println("details of highest paid employee " + highestPiadEmp);

        // Get the names of all employees who have joined after 2015?
        System.out.println("names of all employees who have joined after 2015");
        employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(e -> e.getName())
                .forEach(System.out::println);

        // Count the number of employees in each department?
        Map<String, Long> empCountByDept = employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()));
        System.out.println("Employee count by department:");
        empCountByDept.forEach((dept, count) -> System.out.println(dept + " : " + count));

        // What is the average salary of each department?
        Map<String, Double> empAvgSalaryByDept = employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.averagingDouble(e -> e.getSalary())));
        System.out.println("Average salary by department:");
        empAvgSalaryByDept.forEach((dept, avgSalary) -> System.out.printf("%s : $%.2f%n", dept, avgSalary));

        // Get the details of youngest male employee in the product development
        // department?

        Employee youngestEmpDetails = employeeList.stream()
                .filter(e -> e.getDepartment().equals("Product Development")).filter(e -> e.getGender().equals("Male"))
                .min((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).orElse(null);

        System.out.println("Youngest Male in Product Development:\n" + youngestEmpDetails);

        // Who has the most working experience in the organization?

        Employee experiencedEmp = employeeList.stream().min(Comparator.comparingInt(e -> e.getYearOfJoining()))
                .orElse(null);
        System.out.println("Most Experienced Employee: " + experiencedEmp);

        // How many male and female employees are there in the sales and marketing team?
        Map<String, Long> countByGenderSales = employeeList.stream()
                .filter(e -> e.getDepartment().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting()));

        System.out.println("Sales & Marketing count by gender: " + countByGenderSales);

        // Map question with integer ans key and string as value
        Map<Integer, String> mp = employeeList.stream()
                .collect(Collectors.toMap(
                        emp -> emp.getName().length(),
                        emp -> emp.getName(),
                        (existing, replacement) -> existing.hashCode() > replacement.hashCode() ? existing
                                : replacement));

        System.out.println(mp);
    }

}

class Employee {
    int id;

    String name;

    int age;

    String gender;

    String department;

    int yearOfJoining;

    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id
                + ", Name : " + name
                + ", age : " + age
                + ", Gender : " + gender
                + ", Department : " + department
                + ", Year Of Joining : " + yearOfJoining
                + ", Salary : " + salary;
    }
}
