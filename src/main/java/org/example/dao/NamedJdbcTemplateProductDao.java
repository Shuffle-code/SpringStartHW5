package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.entity.Manufacturer;
import org.example.entity.Product;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//@Component
@RequiredArgsConstructor
public class NamedJdbcTemplateProductDao implements ProductDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Iterable<Product> findAll() {
        String sql = "SELECT * FROM product";
        return namedParameterJdbcTemplate.query(sql, new NamedJdbcTemplateProductDao.ProductMapper());
    }


    @Override
    public String findNameById(Long id) {
        String sql = "SELECT title FROM product where id = :productId";
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
    }

    @Override
    public Product findById(Long id) {
        String sql = "SELECT name, p.id as product_id, title, cost, MANUFACTURE_DATE, MANUFACTURER_ID\n" +
                "FROM MANUFACTURER m\n" +
                "INNER JOIN PRODUCT p on m.ID = p.MANUFACTURER_ID\n" +
                "WHERE p.id = :product_id;";
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("product_id", id);
        return namedParameterJdbcTemplate.query(sql, namedParameters, new ProductWithManufacturerExtractor());
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }

    private static class ProductMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            return org.example.entity.Product.builder()
                    .id(rs.getLong("id"))
                    .title(rs.getString("title"))
                    .cost(rs.getBigDecimal("cost"))
                    .date(rs.getDate("manufacture_date").toLocalDate())
                    .build();
        }
    }

    private static class ProductWithManufacturerExtractor implements ResultSetExtractor<Product> {

        @Override
        public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
            Product product = null;
//            Manufacturer manufacturer = null;
            while (rs.next()) {
                if (product == null) {
                    product = Product.builder()
                            .id(rs.getLong("product_id"))
                            .title(rs.getString("title"))
                            .cost(rs.getBigDecimal("cost"))
                            .date(rs.getDate("manufacture_date").toLocalDate())
                            .build();
                }
                final Manufacturer manufacturer = Manufacturer.builder()
                        .id(rs.getLong("manufacturer_id"))
                        .name(rs.getString("name"))
                        .build();
//                        .id(rs.getLong("product_id"))
//                        .title(rs.getString("title"))
//                        .cost(rs.getBigDecimal("cost"))
//                        .date(rs.getDate("manufacture_date").toLocalDate())
//                        .build();
                product.addManufacturer(manufacturer);
            }

            return product;
        }
    }
}
