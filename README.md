# udemy-course-catcher
Get Udemy Course Info.


AWS Configration:

We use AWS Lambda Function and benefit from Scheduled Events on AWS which is `CloudWatch Events/EventBridge`.
Although app is spring boot application. We can use scheduled Aws Function on getting courses. 
Actually, there are two ways to do scheduled operations:
  -First one is that we should create only aws lambda function may be it does not need to use Spring Boot. We can only use Java 11 features and necessary dependencies. It sounds okay but our schedule operation needs to many dependencies and it must be hard to handle it. There is also more important thing, `Dependency injection` with Spring can have a significant impact on our function's `cold start time`. AWS needs a ready supply of containers to spin up when functions are invoked.
