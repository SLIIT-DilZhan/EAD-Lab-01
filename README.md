# Student Grade Service

Jakarta EE RESTful web service for the Student Grade Evaluation lab.

## Project Structure

- `src/main/webapp/index.html` - browser form for submitting a student name and mark
- `src/main/java/beans/GradeManager.java` - stateless EJB containing grade rules
- `src/main/java/services/ApplicationConfig.java` - JAX-RS base path configuration
- `src/main/java/services/GradeService.java` - REST endpoints for POST form data, GET query parameters, and GET path parameters

## Run

Open this folder as a Maven web application in Apache NetBeans, configure Payara Server, then run the project.

Expected application URL:

```text
http://localhost:8080/StudentGradeService/
```

## Test URLs

Query parameter endpoint:

```text
http://localhost:8080/StudentGradeService/api/gradeservice/getgrade?name=Kasun&mark=90
```

Path parameter endpoint:

```text
http://localhost:8080/StudentGradeService/api/gradeservice/Kasun/70
```

