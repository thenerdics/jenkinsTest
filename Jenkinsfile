#!/usr/bin/env groovy

pipeline {
    agent any
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
                '''
                println "The build url is: $BUILD_URL"
            }
        }
    }
}