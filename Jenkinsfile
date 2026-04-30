pipeline {
    agent any
    environment {
        APP_VERSION = '1.0.0'
    }
    stages {
        stage('Build') {
            steps {
                echo "Building version ${APP_VERSION}.."
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo "Deploying version ${APP_VERSION}...."
            }
        }
    }
}
