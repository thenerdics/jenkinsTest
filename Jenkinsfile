#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'jenkins-mani' 
    }
    triggers {
        pollSCM('* 9-17 * * *')
    }
    stages {
        stage('Build') {
            when { branch 'groovy' }
            steps {
                try {
                    test.test
                } catch (e) {
                    println e
                }
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