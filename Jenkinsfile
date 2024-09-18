pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Clone the Git repository
                git branch: 'cI-CDPipeline-with-Jenkins', url: 'https://github.com/samuelamo001/springdat-data-week1/tree/cI-CDPipeline-with-Jenkins'
            }
        }

        stage('Build') {
            steps {

                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {

                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {

                sh 'docker build -t spring-boot-app:latest .'
            }
        }

        stage('Deploy') {
            steps {

                sh 'docker-compose up -d'

            }
        }
    }

    post {
        always {
            // Clean up Docker containers after the build
            sh 'docker-compose down'
        }
    }
}
