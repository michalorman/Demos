# Spring Data JPA demo

Demo application using the Spring Data JPA support.

## Example Requests

List competences:

* curl http://localhost:8080/springdata-jpa-demo/competences
* curl http://localhost:8080/springdata-jpa-demo/competences?size=3\&page=0
* curl http://localhost:8080/springdata-jpa-demo/competences?name=J2EE
* curl http://localhost:8080/springdata-jpa-demo/competences?name=J*

Create competence:

* curl http://localhost:8080/springdata-jpa-demo/competences -d "name=J2EE"

List applicants:

* curl http://localhost:8080/springdata-jpa-demo/applicants

Create applicant:

* curl http://localhost:8080/springdata-jpa-demo/applicants -d "firstName=Dave&lastName=Developer"

Adding competence:

* curl http://localhost:8080/springdata-jpa-demo/applicants/1/competences/add -d "competenceId=1"