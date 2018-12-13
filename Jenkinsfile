#!/usr/bin/env groovy

try {
    pipeline {
            agent any
                stages {
                        stage('build') {
                            steps {
                                try {
                                    script { 
                                        echo 'pipelineJobTryTest'
                                    }
                                } catch(exc) {
                                    echo 'Build stage failed'
                                }
                            }
                        }
                        stage('test1') {
                                steps {
                                    try {
                                        script {
                                            echo "JOB NAME: ${env.JOB_NAME}"
                                            echo "WORKSPACE: ${env.WORKSPACE}"
                                        }
                                    } catch(exc) {
                                        echo 'test stage failed'
                                    }
                                }
                        }
                }
        }
} catch (exc) {
    echo 'Something failed'
    currentBuild.result = 'FAILEDZZZZ'
    stage('notify') {          
            script {
                    if (currentBuild.currentResult) {
                            echo "${env.JOB_NAME} status is: '${currentBuild.currentResult}'\nMessage is: '${env.message}'"
                    } else {
                            echo "${env.JOB_NAME} status is unknown"
                    }
            }
    }
}