pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'spring-boot-app:1.0.0'
        CONTAINER_NAME = 'spring-boot-app-container-v2' // New container name
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
                    // Attempt to stop and remove the container with the old name, if it exists
                    sh """
                    existing_container_id=\$(docker ps -a -q -f name=spring-boot-app-container)
                    if [ -n "\$existing_container_id" ]; then
                        echo "Stopping and removing existing container..."
                        docker stop \$existing_container_id || true
                        docker rm \$existing_container_id || true
                    else
                        echo "No existing container found."
                    fi
                    """

                    // Run the new Docker container with the new name
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
