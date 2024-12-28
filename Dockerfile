FROM openjdk:18-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the Makefile and source code
COPY *.java .

# Build the project

RUN javac BankingSystemManagement.java
RUN javac BankingSystemManagementTest.java

# Specify the command to run when the container starts
CMD ["java", "BankingSystemManagementTest"]