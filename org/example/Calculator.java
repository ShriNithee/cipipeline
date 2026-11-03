package org.example;

public class Calculator
{
    public int add(int a, int b)
    {
        return a+b;
    }
}\

pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh 'javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar Main.java MainTest.java'
                echo 'Compilation successful'
            }
        }

        stage('Test') {
            steps {
                sh 'java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore MainTest'
            }
        }

        stage('CI Complete') {
            steps {
                echo 'CI Pipeline executed successfully!'
            }
        }
    }

    post {
        success {
            echo 'Build and Tests Passed!'
        }

        failure {
            echo 'CI Pipeline Failed!'
        }
    }
}

wget https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar
wget https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar Main.java MainTest.java
java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore MainTest
