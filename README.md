# Udemy: Master Spring 7, Spring Boot 4 — my code-along

> **This is course work, not an original project.** I'm working through
> [Master Spring 7, Spring Boot 4, REST, JPA, Spring Security](https://www.udemy.com/course/spring-springboot-jpa-hibernate-zero-to-master/)
> by EazyBytes on Udemy, typing out each example myself in IntelliJ IDEA as I go.
> The instructor's official code lives at [eazybytes/spring](https://github.com/eazybytes/spring).
> This repo tracks **my** progress through the course, one commit at a time.

I'm a Java developer moving deeper into backend work, and I'm using this course to build a
solid foundation in the Spring ecosystem: core container, Spring Boot, REST APIs, Spring Data
JPA, Spring Security, and deploying to AWS.

## Progress

| # | Section | Status |
|---|---------|--------|
| 1 | Spring Core & Maven: The Fast-Track Foundation | ✅ Done |
| 2 | Spring Beans Deep Dive | 🟡 In progress |
| 3 | Mastering Spring Boot REST API Development | ⬜ |
| 4 | Spring Boot Essentials | ⬜ |
| 5 | Spring Data JPA | ⬜ |
| 6 | Databases with Docker | ⬜ |
| 7 | Building Real Backend Features | ⬜ |
| 8 | Essential Backend Skills | ⬜ |
| 9 | Mastering JPA Relationships | ⬜ |
| 10 | Spring Security Essentials | ⬜ |
| 11 | Authentication: From Passwords to JWT | ⬜ |
| 12 | Database Authentication & CSRF Protection | ⬜ |
| 13 | Logging in Spring Boot | ⬜ |
| 14 | Aspect-Oriented Programming (AOP) | ⬜ |
| 15 | Advanced Queries in Spring Data JPA | ⬜ |
| 16 | Authorization, Sorting & Pagination | ⬜ |
| 17 | Mastering Transactions | ⬜ |
| 18 | Spring Cache & Performance Optimization | ⬜ |
| 19 | Real Feature Development | ⬜ |
| 20 | Configuration & Profiles | ⬜ |
| 21 | Production-Ready Observability | ⬜ |
| 22 | Consuming REST APIs | ⬜ |
| 23 | Deploying to AWS | ⬜ |

## What's in each section

### Section 1 — Spring Core & Maven (`section1/demo`)
A first Spring application: a `@Configuration` class declaring a `@Bean`, loaded into an
`ApplicationContext` and retrieved with `getBean`.

### Section 2 — Spring Beans Deep Dive (`section2/demo`)
Each `exN` package is a self-contained example with its own `ExampleN` main class.

| Example | Topic |
|---------|-------|
| `ex1` | Declaring multiple beans of one type; `@Primary` and `@Description` |
| `ex2` | Splitting configuration across classes with `@Import` |
| `ex3` | `@Component` + `@ComponentScan`; lifecycle hooks (`@PostConstruct`, `@PreDestroy`, `InitializingBean`) |
| `ex4` | Wiring beans together with `@Autowired` |
| `ex5` | Choosing between implementations of an interface with `@Primary` and `@Qualifier` |
| `ex6` | Registering beans programmatically with Spring 7's `BeanRegistrar` |
| `ex7` | Bean scopes (`@Scope`) and lazy initialization (`@Lazy`) |

## Stack

- Java 25
- Spring Framework 7 (`spring-context` 7.0.3)
- Maven
- IntelliJ IDEA

## Running an example

Each section folder holds a standalone Maven project. Open it in IntelliJ IDEA, let Maven
import, then run the `main` method of the example you want, such as
`section2/demo/src/main/java/com/eazybytes/ex7/config/Example7.java`.

Package names stay `com.eazybytes.*` to match the course, so my code lines up with the
lectures.

## What I'm taking from this

*(Updated as I finish each section.)*

- **Section 1:**
- **Section 2:**
