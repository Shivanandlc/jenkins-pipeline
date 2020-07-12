FROM tomcat:8

COPY /var/lib/jenkins/workspace/jenkins-pipeline/target/*.war /usr/local/tomcat/webapps/