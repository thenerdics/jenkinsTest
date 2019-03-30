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
            when { branch 'groovy' }
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