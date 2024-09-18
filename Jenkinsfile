pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'spring-boot-app:1.0.0'
        CONTAINER_NAME = 'spring-boot-app-container'
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
                    sh './mvnw clean package' // Adjust if you use a different build tool
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${DOCKER_IMAGE} ."
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Remove any existing container with the same name
                    sh """
                    if [ \$(docker ps -q -f name=${CONTAINER_NAME}) ]; then
                        docker rm -f ${CONTAINER_NAME}
                    fi
                    """

                    // Run the new Docker container
                    sh "docker run -d -p 9191:9191 --name ${CONTAINER_NAME} ${DOCKER_IMAGE}"
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
