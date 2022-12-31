# mongo-crud
MongoDB app with springboot that expose a restfull API to execute CRUD operations
#Documents
-Student
-Teacher (related to student)

#Properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=spring

#Restfull endpoints:
-localhost:8080/api/student/create
-localhost:8080/api/student/getByTeacherId -> endpoint to get related document
localhost:8080/api/student/getByNameNative?name= -> endpoint to get with native query
