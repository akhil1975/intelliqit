pipeline {
    agent any

    stages {
        stage('CodeDownload') {
            steps {
                git 'https://github.com/intelliqittrainings/maven.git'
            }
        }
        stage('CodeBuild') {
            steps {
                sh '''
                    export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
                    export PATH=$JAVA_HOME/bin:$PATH
                    mvn clean install
                '''
            }
        }
        stage('CodeDeploy') {
            steps {
                deploy adapters: [tomcat9(
                    credentialsId: 'c0c26461-b04b-480f-9946-2c4cd2055747', 
                    path: '', 
                    url: 'http://172.31.34.55:8080'
                )], contextPath: '/testapp1', war: '**/*.war'
            }
        }
        stage('CodeTest') {
            steps {
                git 'https://github.com/intelliqittrainings/FunctionalTesting.git'
                sh 'java -jar testing.jar'
            }
        }
        stage('CodeDeliver') {
            steps {
                deploy adapters: [tomcat9(
                    credentialsId: 'c0c26461-b04b-480f-9946-2c4cd2055747', 
                    path: '', 
                    url: 'http://172.31.34.55:8080'
                )], contextPath: '/prodapp1', war: '**/*.war'
            }
        }
    }
}


