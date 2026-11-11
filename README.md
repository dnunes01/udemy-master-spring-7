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
| 6 | Databases with Docker | ✅ Done |
| 7 | Building Real Backend Features | ✅ Done |
| 8 | Essential Backend Skills | ✅ Done |
| 9 | Mastering JPA Relationships | 🟡 In progress |
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
config allows. No UI folder gets copied into the later sections, so this stays the front end
for Sections 6+ as well.

### Section 6 — Databases with Docker (`section6/jobportal`)
H2 comes out, MySQL goes in, and Docker Compose runs it. The Java here is byte-identical to
Section 5 — every change in this section is infrastructure.

| Topic | Where |
|-------|-------|
| H2 dropped (`spring-boot-h2console`, `com.h2database:h2`) in favour of `com.mysql:mysql-connector-j` (runtime) | `pom.xml` |
| `spring-boot-docker-compose` (runtime), so Boot drives the Compose stack itself | `pom.xml` |
| A `mysql:latest` service named `dbservice`, running as container `jobportaldb` on `3306:3306`, with `MYSQL_ROOT_PASSWORD` and `MYSQL_DATABASE` | `compose.yml` |
| The named volume `jobportal-data` mounted at `/var/lib/mysql`, pinned with `name:` and with `#external: true` left commented — so Compose creates and owns it | `compose.yml` |
| A MySQL datasource with every part behind an env var (`DATABASE_HOST`, `DATABASE_PORT`, `DATABASE_NAME`, `DATABASE_USERNAME`, `DATABASE_PASSWORD`) | `spring.datasource.*` |
| `spring.docker.compose.lifecycle-management=start-and-stop`, plus `spring.docker.compose.file` tried and left commented | `application.properties` |
| Readable SQL in the console via `hibernate.format_sql`, behind `HIBERNATE_FORMAT_SQL` | `application.properties` |

Worth remembering: with the `spring.sql.init.*` lines gone, `src/main/resources/sql/*.sql` are
**no longer run at startup** — the default `embedded` init mode doesn't cover MySQL. From here on
they're reference DDL and seed data, applied by hand once per machine, and the `jobportal-data`
volume is what makes the rows survive a restart.

### Section 7 — Building Real Backend Features (`section7/jobportal`)
The first feature built rather than followed along: a contacts endpoint, end to end, plus the
beginnings of a global error-handling layer. The entity, repository and DTO were scaffolded with
JPA Buddy / JPA Designer from the table, then tidied by hand.

| Topic | Where |
|-------|-------|
| Feature packages: the company service moves out of `service/` to sit beside its controller | `company/service/ICompanyService`, `company/service/impl/CompanyServiceImpl` |
| A second entity on the `contacts` table — `@Lob` message, `@ColumnDefault("'NEW'")` status, its own hand-mapped audit columns | `entity/Contact` |
| A second `JpaRepository`, service interface and implementation | `repository/ContactRepository`, `contact/service/IContactService`, `contact/service/impl/ContactServiceImpl` |
| A `record` request DTO for a write endpoint | `dto/ContactRequestDto` |
| `POST /api/contacts` at `version = "1.0"` — 201 on success, 500 on failure | `contact/controller/ContactController` |
| `BeanUtils.copyProperties` for DTO → entity, with `createdAt`, `createdBy = "System"` and `status = "NEW"` set by hand | `ContactServiceImpl#transformToEntity` |
| `spring.jpa.hibernate.ddl-auto=update` — how the `contacts` table got created without writing DDL | `application.properties` |
| The `companies` DDL corrected to what `ddl-auto=validate` complained about (`description TEXT` → `TINYTEXT`) | `sql/jobportal-schema.sql` |
| `@RestControllerAdvice` with handlers for `Exception` and `NullPointerException` | `exception/GlobalExceptionHandler` |
| An error-response `record` built from `WebRequest#getDescription(false)` — `apiPath`, `errorCode`, `errorMessage`, `errorTime` | `dto/ErrorResponseDto` |
| The volume switched to `external: true`, so it has to exist before the app starts | `compose.yml` |

### Section 8 — Essential Backend Skills (`section8/jobportal`)
Four things the contacts API was missing: validation on the way in, proper validation errors on
the way out, audit columns that fill themselves in, and web-aware bean scopes.

| Topic | Where |
|-------|-------|
| `spring-boot-starter-validation` | `pom.xml` |
| `@NotBlank`, `@Email`, `@Size`, and a `@Pattern` on `userType`, each with its own message | `dto/ContactRequestDto` |
| `@Valid` on the `@RequestBody` | `ContactController#saveContactMsg` |
| Constraints on a `@RequestParam` instead of a body — `@Validated` + `@NotBlank` + `@Size` on the new `GET /api/contacts` | `ContactController#fetchOpenContacts` |
| `MethodArgumentNotValidException` → a `Map` of field → message with 400, from `getBindingResult().getFieldErrors()` | `exception/GlobalExceptionHandler` |
| `HandlerMethodValidationException` → the same shape for parameter-level failures, walking `getParameterValidationResults()` | `exception/GlobalExceptionHandler` |
| A `@MappedSuperclass` with `@EntityListeners(AuditingEntityListener.class)`, holding all four audit columns in one place | `entity/BaseEntity` |
| `@CreatedDate`/`@CreatedBy`/`@LastModifiedDate`/`@LastModifiedBy` next to Hibernate's `@CreationTimestamp`/`@UpdateTimestamp`, with `updatable = false` / `insertable = false` guards | `entity/BaseEntity` |
| Both entities cut down to their own columns by extending the base class | `entity/Company`, `entity/Contact` |
| `@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")` and an `AuditorAware<String>` returning `"Anonymous User"` | `JobportalApplication`, `audit/AuditorAwareImpl` |
| Auditing taking over from hand-set fields — the old `setCreatedAt`/`setCreatedBy` lines kept commented for contrast | `ContactServiceImpl#transformToEntity` |
| `@RequestScope`, `@SessionScope` and `@ApplicationScope` beans, each logging on construction | `scopes/RequestScopedBean`, `scopes/SessionScopedBean`, `scopes/ApplicationScopedBean` |
| `/api/scope/request`, `/session`, `/application` and `/test` — tested in Postman, watching the session cookie decide which bean gets reused and the application-scoped counter keep climbing | `scopes/ScopeController` |
| `springdoc-openapi-starter-webmvc-ui` 3.2.0 added | `pom.xml` |
| `ddl-auto` commented back out; explicit `spring.docker.compose.start.command=up` and `stop.command=stop` | `application.properties` |

### Section 9 — Mastering JPA Relationships (`section9/jobportal`)
Scaffolded only — a straight copy of Section 8, waiting on the first relationship lecture.

## Stack

- Java 25
- Maven, IntelliJ IDEA
- Sections 1–2: Spring Framework 7 standalone (`spring-context` 7.0.3)
- Sections 3+: Spring Boot 4 with Spring WebMVC — 4.1.1 in Section 3, 4.1.2 in Sections 4–7,
  4.0.9 in Sections 8–9
- Sections 4+: Spring Data JPA / Hibernate
- Sections 4–5: H2, file-based, with the H2 console
- Sections 6+: MySQL (`mysql:latest`) in Docker, started and stopped by Boot through
  `spring-boot-docker-compose`
- Sections 5+: Lombok; React + Vite front end (`section5/job-portal-ui`)
- Sections 8+: Jakarta Bean Validation, Spring Data JPA auditing, springdoc-openapi

## Running an example

Each section folder holds a standalone Maven project. Open it in IntelliJ IDEA, let Maven
import, then run the `main` method of the example you want, such as
`section2/demo/src/main/java/com/eazybytes/ex7/config/Example7.java`.

From Section 3 on, each section is a Spring Boot app instead: run its `*Application` class
(or `./mvnw spring-boot:run`) and call the endpoints on `http://localhost:8080`. Section 5
also has a front end — `cd section5/job-portal-ui && npm install && npm run dev` serves it
on `http://localhost:5173`, and it keeps working against the later sections' backends too.

From Section 6 on the database is MySQL in Docker, so Docker Desktop has to be running first.
Boot brings the Compose stack up and down itself
(`spring.docker.compose.lifecycle-management=start-and-stop`), so there's no `docker compose up`
to run by hand — but there's no H2 console any more either, so use IntelliJ's database tool or
another SQL client against `localhost:3306` (`root`/`root`, database `jobportal`). Two one-time
chores on a fresh machine: apply `sql/jobportal-schema.sql` and `sql/jobportal-data.sql` by hand,
since they're no longer run at startup, and create the volume up front for Sections 7–9
(`docker volume create jobportal-data`), because their `compose.yml` declares it `external: true`.

Package names stay `com.eazybytes.*` to match the course, so my code lines up with the
lectures.
