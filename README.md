# Task management app

## How to run
```bash
mvn spring-boot:run
```
### Access app
```bash
http://localhost:18080
```
### Access mem DB
```
http://localhost:18080/h2-console

enter:
jdbc:h2:mem:taskdb
```

+-------------------+          +-----------+          +---------------+
| External Client   |          |   CMS     |          |   Database    |
| (Web/Mobile App)  |<---JSON--| (Backend) |---SQL--->| (e.g., MySQL) |
+-------------------+  (REST)  +-----------+ (Query)  +---------------+
│                              ▲
│                              │
└--------JSON Data-------------┘
(Read/Write Operations)