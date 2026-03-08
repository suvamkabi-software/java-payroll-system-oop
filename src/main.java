import java.util.ArrayList;
import java.util.List;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id){
    this.name=name;
    this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
   abstract double calculatesalary();
    @Override
    public String toString(){
        return "Employee [name="+name+",id="+id+",salary="+calculatesalary()+"]";
    }
}
class FullTimeEmployee extends Employee{
    private double monthlysalary;

    public FullTimeEmployee(String name, int id,double monthlysalary) {
        super(name,id);
        this.monthlysalary=monthlysalary;

    }
    @Override
    public double calculatesalary() {
        return monthlysalary;
    }
}
class parttimeemployee extends Employee{
   private int hoursworked;
   private double hourlyrate;
    public parttimeemployee(String name, int id,int hoursworked,double hourlyrate) {
        super(name, id);
        this.hoursworked=hoursworked;
        this.hourlyrate=hourlyrate;
    }
    @Override
    double calculatesalary() {
        return hoursworked * hourlyrate;
    }
}
class payrollsystem{
    private ArrayList<Employee> employeeList;
    public payrollsystem(){
        employeeList =new ArrayList<>();
    }
    public void addemployee(Employee employee){
        employeeList.add(employee);
    }
    public  void removeemployee(int id){
        Employee employeetoremove =null;
        for (Employee employee :employeeList){
            if (employee.getId()==id){
                employeetoremove =employee;
                break;
            }
        }
        if (employeetoremove !=null){
            System.out.println("Removed Employee ID: " + employeetoremove.getId() +", Name: " + employeetoremove.getName());
            employeeList.remove(employeetoremove);
        }else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }
    public void displayemployee(){
        for (Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}

public class main {
  public static void main(String[] args) {
     payrollsystem payrollsystem=new payrollsystem();
     FullTimeEmployee employee1=new FullTimeEmployee("rohan",1,20000);
      FullTimeEmployee employee2=new FullTimeEmployee("vikas",2,30000);
     parttimeemployee employee3=new parttimeemployee("mohan",3,30,100);
     payrollsystem.addemployee(employee1);
     payrollsystem.addemployee(employee2);
     payrollsystem.addemployee(employee3);
     System.out.println("Initial Employee Details: ");
     payrollsystem.displayemployee();
     payrollsystem.removeemployee(2);
      System.out.println("Remove Employee");
      System.out.println("Remaining Employee Details:");
        payrollsystem.displayemployee();
    }
}
