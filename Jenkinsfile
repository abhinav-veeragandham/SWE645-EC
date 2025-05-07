// TEAM MEMBERS:

// Abhinav Veeragandham - G01515455
// Pranav Vangavety - G01511443
// Charan Sri Sai Devalla - G01504177
// Bhogeswara Pathakamudi - G01507114
// Durga Shankar Kondaveeti - G01510533

// This file is used to automatically create a Pipeline build process for all branches and pull requests.

pipeline {
    agent any

    environment {
        FRONTEND_IMAGE = 'abhinav31714/extra_credit-frontend:latest'
        BACKEND_IMAGE = 'abhinav31714/extra_credit-backend:v1'
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/abhinav-veeragandham/SWE645-EC.git'
            }
        }

        stage('Build Backend') {
            dir('backend') {
                steps {
                    script {
                        sh 'chmod +x mvnw'
                        sh './mvnw clean package -DskipTests'
                        sh 'docker build -t $BACKEND_IMAGE .'
                    }
                }
            }
        }

        stage('Build Frontend') {
            dir('frontend') {
                steps {
                    sh 'python3 manage.py collectstatic --noinput || true'
                    sh 'docker build -t $FRONTEND_IMAGE .'
                }
            }
        }

        stage('Push Docker Images') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh """
                        echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                        docker push $BACKEND_IMAGE
                        docker push $FRONTEND_IMAGE
                    """
                }
            }
        }

        stage('Deploy to Kubernetes') {
            when {
                expression { fileExists('k8s/deployment.yaml') }
            }
            steps {
                sh 'kubectl apply -f k8s/'
            }
        }
    }

    post {
        success {
            echo 'Build and deployment succeeded!'
        }
        failure {
            echo 'Build or deployment failed.'
        }
    }
}
