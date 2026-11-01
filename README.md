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
| 2 | Spring Beans Deep Dive | ✅ Done |
| 3 | Mastering Spring Boot REST API Development | ✅ Done |
| 4 | Spring Boot Essentials | ✅ Done |
| 5 | Spring Data JPA | ✅ Done |
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

### Section 3 — Mastering Spring Boot REST API Development (`section3/backend`)
First Spring Boot app (Boot 4.1.1, WebMVC only). Four controllers, each one a different
slice of REST request handling.

| Topic | Where |
|-------|-------|
| `@RequestMapping` with explicit `path`/`method`, vs. the `@GetMapping` shorthand | `controller/DemoController` |
| Component scanning boundaries — a second `DemoController` in `com.eazybytes.outside`, picked up only by adding `@ComponentScan(basePackages = "com.eazybytes.outside")` | `outside/DemoController`, `BackendApplication` |
| `@PathVariable`: named, optional, and collected into a `Map` | `controller/UserController` |
| `@RequestParam` into a `Map` | `UserController#searchUserWithQueryParams` |
| `@RequestHeader` three ways: single header, `Map`, and `HttpHeaders` | `controller/UserController` |
| `@RequestBody` bound to a `record` DTO | `UserController#createUser`, `dto/UserDto` |
| `RequestEntity` for headers, body, and URL in one parameter | `UserController#createUserWithRequestEntity` |
| `ResponseEntity` with a custom status and response header | `controller/UserController` |
| Spring 7 native API versioning: `@GetMapping(version = "1.0")` and the `"2.0+"` range | `controller/VersionController` |
| Four ways to resolve the version — path segment, query param, request header, media-type parameter (three kept commented out) | `config/WebConfig` |
| The same versioning by hand, pre-Spring 7 — path suffix, `params =`, `headers =`, `produces =` | `controller/LegacyVersionController` |
| `server.port`, `server.servlet.context-path`, `debug=true` | `application.properties` (commented) |

### Section 4 — Spring Boot Essentials (`section4/jobportal`)
The start of the `jobportal` app that carries through the rest of the course: a Spring Boot
4.1.2 / Java 25 project from start.spring.io with WebMVC, Data JPA, DevTools, and the H2
console.

| Topic | Where |
|-------|-------|
| Coloured console log pattern, overridable by env var | `logging.pattern.console` |
| DevTools and hot-swap on restart | `spring-boot-devtools` (runtime, optional) |
| H2 console at `/h2-console` | `spring.h2.console.*` |
| In-memory vs. file-based H2, and `AUTO_SERVER` | `spring.datasource.url` (alternatives commented) |
| `spring.sql.init.mode`: `embedded` vs. `always` vs. `never` | `application.properties` |
| Schema + seed scripts run at startup | `sql/jobportal-schema.sql`, `sql/jobportal-data.sql` |
| API versioning by media-type parameter (`application/vnd.eazyapp+json;v=1.0`) | `config/web/WebConfig` |
| A global `/api` prefix for every controller | `WebConfig#configurePathMatch` |

`CompanyController` is still a stub here — `GET /api/companies` returns a hard-coded string.
It grows a real entity, repository, and service in Section 5.

### Section 5 — Spring Data JPA (`section5/jobportal`, `section5/job-portal-ui`)
`GET /api/companies` becomes a real end-to-end slice, reading from H2 through every layer:
`Company` entity → `CompanyRepository` → `CompanyServiceImpl` → `CompanyDto` →
`CompanyController`.

| Topic | Where |
|-------|-------|
| `@Entity`, `@Table`, `@Id`, `@GeneratedValue(IDENTITY)`, column constraints, `@Lob` | `entity/Company` |
| Audit columns (`createdAt`/`createdBy`, `updatedAt`/`updatedBy`) mapped by hand | `entity/Company` |
| `JpaRepository<Company, Long>` and the `findAll()` it provides for free | `repository/CompanyRepository` |
| A service layer behind an interface | `service/ICompanyService`, `service/impl/CompanyServiceImpl` |
| Entity → DTO mapping, written out explicitly | `CompanyServiceImpl#transformToDto` |
| A `record` as the DTO | `dto/CompanyDto` |
| Lombok `@Getter`/`@Setter` replacing hand-written accessors | `entity/Company` |
| Lombok `@RequiredArgsConstructor` for constructor injection, so no `@Autowired` is needed | `CompanyController`, `CompanyServiceImpl` (manual constructors kept commented) |
| File-based H2 (`jdbc:h2:file:~/jobportal`) with `sql.init.mode=never`, so data survives restarts | `application.properties` |
| `spring.jpa.show-sql` behind a `SHOW_SQL` env var | `application.properties` |
| CORS two ways: `@CrossOrigin` on the controller vs. `addCorsMappings` in the config — the config is the active one, the annotation is commented out | `CompanyController`, `config/web/WebConfig` |

`section5/job-portal-ui` is the instructor's React + Vite front end, dropped in as-is so the
API has a real client. It runs on `http://localhost:5173`, the one origin the backend's CORS
config allows.

## Stack

- Java 25
- Maven, IntelliJ IDEA
- Sections 1–2: Spring Framework 7 standalone (`spring-context` 7.0.3)
- Sections 3+: Spring Boot 4 (4.1.1 in Section 3, 4.1.2 from Section 4), Spring WebMVC
- Sections 4+: Spring Data JPA / Hibernate, H2
- Sections 5+: Lombok; React + Vite front end (`section5/job-portal-ui`)

## Running an example

Each section folder holds a standalone Maven project. Open it in IntelliJ IDEA, let Maven
import, then run the `main` method of the example you want, such as
`section2/demo/src/main/java/com/eazybytes/ex7/config/Example7.java`.

From Section 3 on, each section is a Spring Boot app instead: run its `*Application` class
(or `./mvnw spring-boot:run`) and call the endpoints on `http://localhost:8080`. Section 5
also has a front end — `cd section5/job-portal-ui && npm install && npm run dev` serves it
on `http://localhost:5173`.

Package names stay `com.eazybytes.*` to match the course, so my code lines up with the
lectures.

## What I'm taking from this

*(Updated as I finish each section.)*
