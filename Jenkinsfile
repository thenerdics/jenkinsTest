#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'jenkins-mani' 
    }
    triggers {
        pollSCM('* * * * *')
    }
    stages {
        stage('Build') {
            when { branch 'develop' }
            steps {
                sh '''
                    ls
                    printenv
                    pwd
                    curl $BUILD_URL
                '''
                println "The build url is: $BUILD_URL"
                println "Wow the magic number $BUILD_NUMBER"
            }
        }
    }
}