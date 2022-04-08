-- select * from product;
-- SELECT name, p.id as product_id, title, cost, MANUFACTURE_DATE, MANUFACTURER_ID
-- FROM MANUFACTURER m
--          INNER JOIN PRODUCT p on m.ID = p.MANUFACTURER_ID
-- WHERE m.id = 3;
select p from Product p where p.id =33;
select p.title from Product p where p.id = 44;
