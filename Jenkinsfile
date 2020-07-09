pipeline {
    agent any
    tools {
        maven 'Maven_3.6.2'
        jdk "Java8"
    }
    stages {
        stage("Cloning Repo") {
            steps {
                git credentialsId: 'git_credentials', url: 'https://github.com/Shivanandlc/spring-jenkins.git'
            }
        }
        stage("Build Code") {
            steps {
                bat "mvn clean compile"
            }
        }
        stage("Test Code") {
            steps {
                bat "mvn package"
            }
        }
        stage("Artifact") {
            steps {
                archive 'target/*.war'
            }
        }
        stage("Deploy Code") {
            steps {
                bat '''copy C:\\Users\\shiva\\Downloads\\jenkins\\jenkins\\target\\*.war D:\\apache-tomcat-8.5.57\\apache-tomcat-8.5.57\\webapps\\'''
            }
        }
  }
}