package application;

import model.dao.DaoFactory;
import model.entities.Department;
import model.entities.Seller;
import java.util.Date;
import model.dao.SellerDao;

import java.util.List;

public class Program {
    public static void main(String[]args){

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
    }
}
