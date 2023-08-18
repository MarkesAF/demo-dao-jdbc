package application;

import model.dao.DaoFactory;
import model.entities.Department;
import model.entities.Seller;
import java.util.Date;
import model.dao.SellerDao;

public class Program {
    public static void main(String[]args){

        SellerDao sellerDao = DaoFactory.CreateSellerDao();

        System.out.println("===== TEST 1: seller findById =====");
        Seller seller =sellerDao.findById(3);

        System.out.println(seller);
    }
}
