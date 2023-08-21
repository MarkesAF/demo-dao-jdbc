package application;


import model.dao.DepartmentDao;
import model.dao.DaoFactory;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);

        DepartmentDao depDao = DaoFactory.CreateDepartmentDao();

        System.out.println("==== TEST1 Department FindById ====");
        Department dep = depDao.findById(3);
        System.out.println(dep);


        System.out.println("\n==== TEST2 Department FindAll ====\n");
        List<Department> list = depDao.findAll();
        for(Department obj : list){
            System.out.println(obj);
        }


        System.out.println("\n==== TEST3 Department Update ====\n");
        Department dep2 = depDao.findById(1);
        dep2.setName("Food");
        depDao.update(dep2);
        System.out.println("Update Completed");


        System.out.println("\n==== TEST4 Department Insert ====\n");
        Department newDep = new Department(null,"Employees");
        depDao.insert(newDep);
        System.out.println("Inserted! New Id= "+newDep.getId());

        System.out.println("\n==== TEST5 Department DeleteById ====\n");
        System.out.print("Enter Id for delete Test: ");
        int id = in.nextInt();
        depDao.deleteById(id);
        System.out.println("Delete test Completed");
    }
}
