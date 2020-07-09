#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'jenkins-mani' 
    }
    triggers {
        cron('*/53 * * * * \n */58 * * * *')
    }
    parameters { 
        string(name: 'TEST_VAR', defaultValue: 'staging', description: '') 
    }
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        github('thenerdic/jenkinsTest', 'ssh')
                        credentials('blah')
                    }
                }
            }   
        }
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
        stage('call') {
            def body = {}
            body['projectName'] = 'manvir'
            body['serverDomain'] = 'serverDomain'
            test.call()
        }
    }
}