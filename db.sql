CREATE TABLE users (username VARCHAR(100) NOT NULL, 
    name VARCHAR(100),
    surname VARCHAR(100), 
    email VARCHAR(100) NOT NULL, 
    password VARCHAR(100) NOT NULL, 
    iconpath VARCHAR(100),
    phonenumber VARCHAR(100),
    role VARCHAR(100),
    PRIMARY KEY (username));

CREATE TABLE categories (name VARCHAR(100) NOT NULL, 
    description VARCHAR(400),
    PRIMARY KEY (name));

CREATE TABLE events (id INT NOT NULL AUTO_INCREMENT, 
    checkinDate VARCHAR(100),
    description VARCHAR(400), 
    iconpath VARCHAR(100),
    PRIMARY KEY (id));

CREATE TABLE objects (name VARCHAR(100) NOT NULL, 
    address VARCHAR(100) NOT NULL,
    town VARCHAR(100) NOT NULL, 
    phone VARCHAR(100), 
    email VARCHAR(100), 
    website VARCHAR(100), 
    iconpath VARCHAR(100) NOT NULL,
    tin VARCHAR(100) NOT NULL,
    bankAccount VARCHAR(100) NOT NULL,
    manager VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    PRIMARY KEY (tin));

CREATE TABLE reviews (id INT NOT NULL AUTO_INCREMENT, 
    created VARCHAR(100) NOT NULL,
    reviewText VARCHAR(400) NOT NULL, 
    rate INT NOT NULL,
    userID VARCHAR(100) NOT NULL,
    objectTIN VARCHAR(100) NOT NULL,
    PRIMARY KEY (id));


INSERT INTO users values ('customer', 'John', 'Smith', 'customer@email.com','password', 'http://userproplugin.com/userpro/wp-content/plugins/userpro/img/default_avatar_male.jpg', '11111111', 'customer');
INSERT INTO users values ('manager', 'Anna', 'Frank', 'manager@email.com','password', 'http://userproplugin.com/userpro/wp-content/plugins/userpro/img/default_avatar_male.jpg', '11111111', 'manager');

INSERT INTO objects values ('Borsalino', 'Vojvodjanska 30', 'Novi Sad', '02111111','borsalino@mail.com', '', 'https://s-media-cache-ak0.pinimg.com/736x/0f/2b/e9/0f2be9588eb432e636344691f1cc6a72.jpg', 'tin1', 'ba1', 'manager', 'food');
INSERT INTO objects values ('Evropa', 'Bulevar oslobodjenja 11', 'Novi Sad', '','', 'www.minuta.rs', 'http://static.rs.n1info.com/Picture/3218/jpeg/Evropa.jpg', 'tin2', 'ba2', 'manager', 'food');
INSERT INTO objects values ('Minuta', 'Sutjeska 2', 'Novi Sad', '','', 'www.minuta.rs', 'http://www.minuta.rs/wp-min_uta/uploads/Nasa_prica.jpg', 'tin3', 'ba3', 'manager', 'food');

