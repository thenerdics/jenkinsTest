#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'apache-maven-3.0.1' 
    }
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        stage('Build') {
            steps {
                sh '''
                    ls
                    printenv
                    pwd
                    curl $BUILD_URL
                '''
                println "The build url is: $BUILD_URL"
            }
        }
    }
}