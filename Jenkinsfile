#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'jenkins-mani' 
    }
    triggers {
        pollSCM('* * * * *')
    }
    parameters { 
        string(name: 'TEST_VAR', defaultValue: 'staging', description: '') 
    }
    stages {
        stage('Build') {
            when { branch 'groovy' }
            steps {
                sh '''
                git pull
                    ls
                    printenv
                    pwd
                    echo $GIT_PREVIOUS_SUCCESSFUL_COMMIT
                '''
                println "Test var is: ${params.TEST_VAR}"
                println "The build url is: $BUILD_URL"
                println "Wow the magic number $BUILD_NUMBER"
                println "The git branch is:$GIT_BRANCH"
                println params.TEST_VAR
            }
        }
        stage('Test') {
            when { branch 'groovy' }
            steps {
                println "The build url is: $BUILD_URL"
                println "Wow the magic number $BUILD_NUMBER"
                println "The git branch is:$GIT_BRANCH"
            }
        }
    }
}