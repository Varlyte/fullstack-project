DROP TABLE IF EXISTS articles;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS category_article;
CREATE TABLE products (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  author_name VARCHAR(250) NOT NULL,
  contenu VARCHAR(250) NOT NULL;
  date DATE NOT NULL

);
CREATE TABLE categories (
  category_id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  categoryname VARCHAR(250) NOT NULL
);
CREATE TABLE category_article (
    category_id BIGINT NOT NULL,
    article_id BIGINT NOT NULL