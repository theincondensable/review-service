use review_system;
SET SQL_SAFE_UPDATES = 0;

create table comment_status(
	code TINYINT NOT NULL PRIMARY KEY,
    title VARCHAR(50)
);

create table vote_status(
	code TINYINT NOT NULL PRIMARY KEY,
    title VARCHAR(50)
);

create table manager(
	id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    
    PRIMARY KEY (id)
);

create table product(
	id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    manager_id BIGINT NOT NULL,
    
    PRIMARY KEY (id),
    FOREIGN KEY (manager_id) REFERENCES manager(id)
);

ALTER TABLE product ADD COLUMN is_review_available_for_all BOOLEAN NOT NULL AFTER name;

create table comment(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    context VARCHAR(1000),
    status TINYINT NOT NULL,
    product_id BIGINT NOT NULL,
    
    FOREIGN KEY (status) REFERENCES comment_status(code),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

create table vote(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    score TINYINT NOT NULL,
    status TINYINT NOT NULL,
    product_id BIGINT NOT NULL,
    
    FOREIGN KEY (status) REFERENCES vote_status(code),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

ALTER TABLE vote ADD COLUMN user_id BIGINT;
ALTER TABLE vote ADD FOREIGN KEY (user_id) REFERENCES user(id);

ALTER TABLE comment ADD COLUMN user_id BIGINT;
ALTER TABLE comment ADD FOREIGN KEY (user_id) REFERENCES user(id);

create table user_purchased_products(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

create table user(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(150),
    last_name VARCHAR(150)
);

#inserting data for USER table
INSERT INTO user(first_name, last_name) VALUE("someone", "someoneE");
INSERT INTO user(first_name, last_name) VALUE("another", "anoteherE");
INSERT INTO user(first_name, last_name) VALUE("else", "elseE");

#inserting data for COMMENT_STATUS table
INSERT INTO comment_status(code, title) VALUE(1, "Comment is not approved");
INSERT INTO comment_status(code, title) VALUE(2, "Comment is approved");

#inserting data for VOTE_STATUS table
INSERT INTO vote_status(code, title) VALUE(1, "Vote is not approved");
INSERT INTO vote_status(code, title) VALUE(2, "Vote is approved");

#inserting data for MANAGER table
INSERT INTO manager(name) VALUE("John");
INSERT INTO manager(name) VALUE("Joe");
INSERT INTO manager(name) VALUE("Mary");

#inserting data for PRODUCT table
INSERT INTO product(name, manager_id, is_review_available_for_all) VALUE("iPhone 8", 1, true);
INSERT INTO product(name, manager_id, is_review_available_for_all) VALUE("iPhone 8 plus", 1, true);
INSERT INTO product(name, manager_id, is_review_available_for_all) VALUE("iPhone X", 1, true);
INSERT INTO product(name, manager_id, is_review_available_for_all) VALUE("iPhone XS", 2, true);
INSERT INTO product(name, manager_id, is_review_available_for_all) VALUE("iPhone XS plus", 2, true);
INSERT INTO product(name, manager_id, is_review_available_for_all) VALUE("iPhone XR", 2, true);
INSERT INTO product(name, manager_id, is_review_available_for_all) VALUE("iPhone 11", 3, false);
INSERT INTO product(name, manager_id, is_review_available_for_all) VALUE("iPhone 12", 3, false);
INSERT INTO product(name, manager_id, is_review_available_for_all) VALUE("iPhone 13", 3, false);

#inserting sample comments for COMMENT table for product_id of 1 (iphone 8) note that status of 2 is APPROVED
INSERT INTO comment(context, status, product_id, user_id) VALUE("This is a test comment for iphone 8, this phone is way beyond better than what you would think", 2, 1, 1);
INSERT INTO comment(context, status, product_id, user_id) VALUE("This is a test comment for iphone 8, this phone is fantastic", 2, 1, 1);
INSERT INTO comment(context, status, product_id, user_id) VALUE("This is a test comment for iphone 8, this phone is astonishing", 2, 1, 1);
INSERT INTO comment(context, status, product_id, user_id) VALUE("This is a test comment for iphone 8, great choice for all my tasks", 2, 1, 1);
INSERT INTO comment(context, status, product_id, user_id) VALUE("This is a test comment for iphone 8, I bought this phone and it does not work", 1, 1, 1);
INSERT INTO comment(context, status, product_id, user_id) VALUE("This is a test comment for iphone 8, I love this phone", 2, 1, 1);
INSERT INTO comment(context, status, product_id, user_id) VALUE("This is a test comment for iphone 8, this phone is refurbished and the provider does not respond", 1, 1, 1);
INSERT INTO comment(context, status, product_id, user_id) VALUE("This is a test comment for iphone 8, I suggest you not to think about this phone", 1, 1, 1);

#inserting sample comments for VOTE table for product_id of 1 (iphone 8) note that status of 2 is APPROVED
INSERT INTO vote(score, status, product_id, user_id) VALUE(10, 2, 1, 1);
INSERT INTO vote(score, status, product_id, user_id) VALUE(6, 2, 1, 1);
INSERT INTO vote(score, status, product_id, user_id) VALUE(9, 2, 1, 1);
INSERT INTO vote(score, status, product_id, user_id) VALUE(5, 2, 1, 1);
INSERT INTO vote(score, status, product_id, user_id) VALUE(2, 1, 1, 1);
INSERT INTO vote(score, status, product_id, user_id) VALUE(1, 1, 1, 1);