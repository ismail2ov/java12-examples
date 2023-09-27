# Java 12 Examples

## Purpose

This project provides a set of Java code examples illustrating the subset of new language features and APIs that were
introduced in Java 12 that are of interest to developers

The examples are implemented as a set of easy to run tests, using JUnit (5).

## Source Code

The source code for the examples can be found in the src/test/java folder.

## Building and Running the Examples

You will need to install a Java 12 JDK.

Support is provided for building and running the project using either Gradle or Maven as described in the sections
below.

### Gradle

The minimum required version of Gradle will be installed if you execute the build using the supplied Gradle wrapper
script (./gradlew).

To compile and run all the example tests, enter the following command in the project’s root folder:

`./gradlew clean test`

For more details of Gradle build support see build.gradle in the project’s root folder.

### Maven

The minimum required version of Maven will be installed if you execute the build using the supplied Maven wrapper
script (./mvnw).

To compile and run all the example tests, enter the following command in the project’s root folder:

`./mvnw clean test`

For more details of Maven build support see pom.xml in the project’s root folder.
