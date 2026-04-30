pipeline {
    agent any
    tools {
        maven 'Maven'   // must match the name in Manage Jenkins → Tools
    }
    environment {
        APP_VERSION = '1.0.0'
    }
    stages {
        stage('Build') {
            steps {
                echo "Building version ${APP_VERSION}.."
                bat 'mvn --version'   // Windows — use bat instead of sh
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
