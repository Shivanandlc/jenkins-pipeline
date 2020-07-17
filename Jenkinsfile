node{
    stage('SCM'){
        git credentialsId: 'git_credentials', url: 'https://github.com/Shivanandlc/jenkins-pipeline'
    }
    stage('Mvn'){
        def mvnHome = tool name: 'maven-3', type: 'maven'
        def mvnCMD = "${mvnHome}/bin/mvn"
        sh "${mvnCMD} clean package"
    }
    stage('Build Docker Image'){
        sh 'docker build -t shivalc/jenkins-app:2.0.0 .'
    }
    stage('Push Docker Image'){
        withCredentials([string(credentialsId: 'docker-pswd', variable: 'dockerHubPwd')]) {
            sh "docker login -u shivalc -p ${dockerHubPwd}"
        }

        sh 'docker push shivalc/jenkins-app:2.0.0'
    }
    stage('Run Container on Dev Server'){
        sshagent(['dev-server']) {
            def dockrCont = 'docker run -p 9091:8080 -d --name jenkins-app shivalc/jenkins-app:2.0.0'
            sh "ssh -o StrictHostKeyChecking=no ec2-user@172.31.37.91 ${dockrCont}"
        }
    }
}