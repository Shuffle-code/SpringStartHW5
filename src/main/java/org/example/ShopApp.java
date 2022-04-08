package org.example;

//import org.example.config.DbConfig;
//import org.example.config.DbConfig;
import org.example.config.HibernateConfig;
import org.example.dao.ManufacturerDao;
import org.example.dao.OldJdbcManufacturerDao;
import org.example.dao.OldJdbcProductDao;
import org.example.dao.ProductDao;
import org.example.entity.Manufacturer;
import org.example.entity.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ShopApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
//        ManufacturerDao manufacturerDao = new OldJdbcManufacturerDao();
//        OldJdbcManufacturerDao oldJdbcManufacturerDao = new OldJdbcManufacturerDao();
//        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
//        System.out.println(manufacturerDao.findNameById(5l));
//        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }
//        System.out.println(manufacturerDao.findNameById(3L));
//        System.out.println(manufacturerDao.findById(4L));
//        System.out.println("-----------------------------------------------");
////        ProductDao productDao = new OldJdbcProductDao();
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        for (Product product : productDao.findAll()) {
            System.out.println(product);
        }
//        System.out.println(productDao.findById(33L));
        System.out.println(productDao.findById(33L));
        System.out.println(productDao.findNameById(33L));
    }
}
