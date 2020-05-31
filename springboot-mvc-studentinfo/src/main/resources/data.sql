/* https://www.baeldung.com/spring-boot-data-sql-and-schema-sql */
/* https://docs.spring.io/spring-boot/docs/1.5.4.RELEASE/reference/htmlsingle/#howto-database-initialization */
/* https://walkingtechie.blogspot.com/2018/12/execute-schema-and-data-sql-on-startup-spring-boot.html */
/* keeping primary key value higher, so that new records can start with sequence 1 without insert issues */

INSERT INTO STUDENT (STUDENT_ID, AGE, COURSE, EMAIL, FIRST_NAME, LAST_NAME) VALUES (2020, 29, 'Cloud, IoT, Java', 'vjay@cloudexp.com', 'Vijay', 'Konduru');
INSERT INTO STUDENT (STUDENT_ID, AGE, COURSE, EMAIL, FIRST_NAME, LAST_NAME) VALUES (2021, 22, 'Leadership, Advanced AI', 'pjay@cloudexp.com', 'Puranjay', 'Konduru');