/* https://www.baeldung.com/spring-boot-data-sql-and-schema-sql */
/* https://docs.spring.io/spring-boot/docs/1.5.4.RELEASE/reference/htmlsingle/#howto-database-initialization */
/* https://walkingtechie.blogspot.com/2018/12/execute-schema-and-data-sql-on-startup-spring-boot.html */

INSERT INTO STUDENT (STUDENT_ID, AGE, COURSE, EMAIL, FIRST_NAME, LAST_NAME) VALUES (1, 29, 'Cloud Expert', 'vijay@cloudee.com', 'Vijay', 'Konduru');
INSERT INTO STUDENT (STUDENT_ID, AGE, COURSE, EMAIL, FIRST_NAME, LAST_NAME) VALUES (2, 32, 'Advanced AI', 'tom@aiee.com', 'Tom', 'White');