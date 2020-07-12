FROM tomcat:8

COPY /var/lib/jenkins/workspace/jenkins-pipeline/target/*.jar /usr/local/tomcat/webapps/