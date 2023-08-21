package application;

import model.dao.DaoFactory;
import model.entities.Department;
import model.entities.Seller;
import java.util.Date;
import model.dao.SellerDao;

import java.util.Scanner;
import java.util.List;

public class Program {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.CreateSellerDao();

        System.out.println("===== TEST 1: seller findById =====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n===== TEST 2: seller findByDepartment =====\n");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n===== TEST 3: seller findAll =====\n");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }


        System.out.println("\n===== TEST 4: seller Insert =====\n");
        Seller newSeller = new Seller(null,"Greg", "greg@gmail.com",new Date(), 4000.0,department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id=  "+newSeller.getId());


        System.out.println("\n===== TEST 5: seller Update =====\n");
        seller = sellerDao.findById(1);
        seller.setName("Augusto");
        sellerDao.update(seller);
        System.out.println("Update completed");


        System.out.println("\n===== TEST 6: seller DELETE =====\n");
        System.out.println("Enter idd for delete test:");
        int id = in.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completede");

        in.close();
    }
}
