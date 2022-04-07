package org.example;

//import org.example.config.DbConfig;
import org.example.config.HibernateConfig;
import org.example.dao.ManufacturerDao;
import org.example.dao.OldJdbcManufacturerDao;
import org.example.entity.Manufacturer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ShopApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
//        ManufacturerDao manufacturerDao = new OldJdbcManufacturerDao();
//        OldJdbcManufacturerDao oldJdbcManufacturerDao = new OldJdbcManufacturerDao();
        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
//        System.out.println(manufacturerDao.findNameById(5l));
        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
            System.out.println(manufacturer);
        }
        System.out.println(manufacturerDao.findNameById(3L));
        System.out.println(manufacturerDao.findById(4L));

    }
}
