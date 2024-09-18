pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/samuelamo001/devops-docker.git'
            }
        }

/*         stage('Build') {
            steps {

                sh '''
                    mvn -v &&
                    mvn clean package
                '''
            }
        } */

  /*       stage('Test') {
            steps {

                sh 'mvn test'
            }
        } */

        stage('Build Docker Image') {
            steps {

                sh 'docker build -t spring-boot-app:latest .'
            }
        }

        stage('Deploy') {
            steps {

                sh 'docker compose up --build -d'
            }
        }

        stage('Success'){
            steps {
                sh 'echo successfully deployed'
           }
        }


    }
}
