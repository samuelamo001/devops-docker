pipeline {
    agent any


    /* stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/samuelamo001/devops-docker.git'
            }
        } */

        stage('Build') {
            steps {
                script {
                    sh './mvnw clean package'
                }
            }
        }

        stage('Deploy with Docker Compose') {
            steps {
                script {

                    sh 'docker compose down'
                    sh 'docker compose build'
                    sh 'docker compose up -d'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }

        failure {
            echo 'Pipeline failed.'
        }
    }
}
