DELETE FROM product where id in (1, 2, 3, 4);
DELETE FROM cart where user_id=1;
DELETE FROM brand where id in (1, 2, 3);
DELETE FROM user where id=1;
DELETE FROM category where id in (1, 2, 3);

INSERT INTO brand VALUES (1, 'Pepsi') , (2, 'Cocacola'), (3, 'Apple');
INSERT INTO user VALUES (1, 'admin');
INSERT INTO cart VALUES (1);
INSERT INTO category VALUES ( 1, 'beverage' ), (2, 'food'), (3, 'electronics device');
INSERT INTO product VALUES (1, 1, 'Pepsi Light', 10000, 1, 1),
                                     (2, 0, 'Cocacola Zero', 10000, 2, 1),
                                     (3, 1, 'Pepsi Poca', 5000, 1, 2),
                                     (4, 2, 'Iphone', 40000000, 3, 3);