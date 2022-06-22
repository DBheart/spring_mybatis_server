mybatis를 무시할수는 없어서 정리를 해본다.
sql을 자유자재로 다룰수 있는 것에는 필요하다.

필요사항 
  - 실행 query가 깔끔하게 나오게 하자.
  - 프로파일에 따른 DB정보 변경
  - mybatis와 JPA를 같이 쓰는 방법
    - 두개를 쓰면.. DBCP가 두개가 생기는데.. 낭비아닐까? 둘중 하나 선택이 나을 것 같다.
    - mybatis에서도 generic 코드가 가능할 것 같다. 
      - ibatis가 아닐것 같다.
  - 트랜잭션 확인

---

위와 같이 스프링 부트 프로젝트를 만들 때 H2 Database 의존성을 추가하면 간단히 사용할 수 있다.
스프링 부트가 지원하는 인메모리 데이터베이스는 H2, HSQL, Derby가 있다.
이 중 H2가 자주 사용되고 추천되는 이유는 콘솔이 제공되기 때문이다.

schema.sql(DML), data.sql(데이터생성) 을하는 것은 spring boot의 능력이다.
  - 운영에서 끄는 옵션을 보자.
  - `spring.sql.init.mode=never`이 끄는 옵션이다. 

``` text
위와 같이 스프링 부트 프로젝트를 만들 때 H2 Database 의존성을 추가하면 간단히 사용할 수 있다.
스프링 부트가 지원하는 인메모리 데이터베이스는 H2, HSQL, Derby가 있다.
이 중 H2가 자주 사용되고 추천되는 이유는 콘솔이 제공되기 때문이다.
```

``` text
9.3. Initialize a Database Using Basic SQL Scripts
Spring Boot can automatically create the schema (DDL scripts) of your JDBC DataSource or R2DBC ConnectionFactory and initialize it (DML scripts). It loads SQL from the standard root classpath locations: schema.sql and data.sql, respectively. In addition, Spring Boot processes the schema-${platform}.sql and data-${platform}.sql files (if present), where platform is the value of spring.sql.init.platform. This allows you to switch to database-specific scripts if necessary. For example, you might choose to set it to the vendor name of the database (hsqldb, h2, oracle, mysql, postgresql, and so on). By default, SQL database initialization is only performed when using an embedded in-memory database. To always initialize an SQL database, irrespective of its type, set spring.sql.init.mode to always. Similarly, to disable initialization, set spring.sql.init.mode to never. By default, Spring Boot enables the fail-fast feature of its script-based database initializer. This means that, if the scripts cause exceptions, the application fails to start. You can tune that behavior by setting spring.sql.init.continue-on-error.

Script-based DataSource initialization is performed, by default, before any JPA EntityManagerFactory beans are created. schema.sql can be used to create the schema for JPA-managed entities and data.sql can be used to populate it. While we do not recommend using multiple data source initialization technologies, if you want script-based DataSource initialization to be able to build upon the schema creation performed by Hibernate, set spring.jpa.defer-datasource-initialization to true. This will defer data source initialization until after any EntityManagerFactory beans have been created and initialized. schema.sql can then be used to make additions to any schema creation performed by Hibernate and data.sql can be used to populate it.
```

Spring JDBC와 인메모리 데이터베이스가 클래스패스에 있으면(= 의존성 설정이 되어있으면) 스프링 부트가 DataSource, JdbcTemplate 빈을 자동으로 설정해준다.
  - 안되는데? DataSource가 저절로 안들어가지자나...