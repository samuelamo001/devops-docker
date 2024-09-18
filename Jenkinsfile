pipeline {
    agent any

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
                    sh "docker build -t spring-boot-app:1.0.0 ."
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Stop and remove any existing container with the same name
                    sh """
                    if [ \$(docker ps -q -f name=spring-boot-app-container) ]; then
                        docker stop spring-boot-app-container
                        docker rm spring-boot-app-container
                    fi
                    """

                    // Run the new Docker container
                    sh "docker run -d -p 9191:9191 --name spring-boot-app-container spring-boot-app:1.0.0"
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
