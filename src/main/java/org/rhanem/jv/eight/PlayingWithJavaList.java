package org.rhanem.jv.eight;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayingWithJavaList {

    public static void main(String[] args) {

        List<Employee> employeeList = populateEmployeeList();
/*


        // traditional way
       for (Employee emp: employeeList) {
            System.out.println(emp);


        // java 8 way for iterate a list and print data
        System.out.println("------------java 8 way for iterate----------");
        employeeList.forEach(emp -> System.out.println(emp));



        // Iterate List Using `Stream` API
        System.out.println("\n");
        System.out.println("-----------Iterate List Using `Stream` API -----------\n");

        Employee sara = employeeList.stream().filter(emp -> emp.firstName.equals("sara")).findAny().orElse(null);
        System.out.println(sara);


        System.out.println("\n");
        System.out.println("-----------city sale : ------\n");
        List<Employee> sale = employeeList.stream().filter(emp -> emp.address.city.equals("sale")).collect(Collectors.toList());
        System.out.println(sale);





        System.out.println("\n");
        System.out.println("----------- Java8 - Convert List to Map Using Stream API : ------\n");

        Map<String, Employee> employeeMap = employeeList.stream().collect(Collectors.toMap(emp -> emp.firstName, e-> e));
        // employeeMap.entrySet().forEach(System.out::println);
        // employeeMap.entrySet().forEach(e-> System.out.println(String.format("%s - %s", e.getKey(), e.getValue())));
        Map<String, Employee> sara = employeeMap.entrySet().stream()
                .filter(e-> e.getKey().equals("sara"))
                .collect(Collectors.toMap(e ->e.getKey(), e -> e.getValue()));
        System.out.println(sara);

        System.out.println("\n");

*/

        System.out.println("\n----------- Java8 - Convert List to Map Using Stream API  : ------\n");

        // Map<String, Employee> employeeMap = employeeList.stream().collect(Collectors.toMap(emp-> emp.firstName, emp -> emp));
         Map<String, Employee> employeeMap = employeeList.stream().collect(Collectors.toMap(emp-> emp.firstName, Function.identity()));
         // employeeMap.entrySet().forEach(System.out::println);

        Map<String, Employee> sara = employeeMap.entrySet().stream()
                .filter(e-> e.getKey().equals("sara"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("\n");




    }

    private static List<Employee> populateEmployeeList() {
        List<Employee> employeeList = Arrays.asList(
                createPerson("youssef","rhanem","sale a","sale",3456),
                createPerson("sara","rhanem","sale a","rabat",63456),
                createPerson("saad","rhanem","sale b","sale",3456),
                createPerson("jad","rhanem","sale c","sale",3456),
                createPerson("med","rhanem","sale d","rabat",63456)
        );
        return employeeList;
    }

    private static Employee createPerson(String firstName, String lastName, String streetAddress, String city, int postelCode) {
    return new Employee(firstName, lastName, new Address(streetAddress, city, postelCode));
    }


    // Classes
     static class Employee {
        public String firstName, lastName;
        public Address address;

        public Employee(String firstName, String lastName, Address address) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", address=" + address +
                    '}';
        }
    }

     static class Address {
        public String streetName, city;
        public int postelCode;

        public Address(String streetName, String city, int postelCode) {
            this.streetName = streetName;
            this.city = city;
            this.postelCode = postelCode;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "streetName='" + streetName + '\'' +
                    ", city='" + city + '\'' +
                    ", postelCode=" + postelCode +
                    '}';
        }
    }


}
