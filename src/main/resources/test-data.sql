select * from manufacturer;
SELECT name, p.id as product_id, title, cost, MANUFACTURE_DATE, MANUFACTURER_ID
FROM MANUFACTURER m
         INNER JOIN PRODUCT p on m.ID = p.MANUFACTURER_ID
WHERE m.id = 3;