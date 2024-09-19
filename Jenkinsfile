pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'spring-boot-app:1.0.0'
        CONTAINER_NAME = 'spring-boot-app-container-v1'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/samuelamo001/devops-docker.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    sh './mvnw clean package' // Adjust if you're using a different build tool
                }
            }
        }

        stage('Build and Deploy with Docker Compose') {
            steps {
                script {
                    // Use docker compose instead of docker-compose
                    sh 'docker compose down' // Stop any running containers
                    sh 'docker compose build' // Build the Docker image defined in the docker-compose.yml
                    sh 'docker compose up -d' // Start the application container in detached mode
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
