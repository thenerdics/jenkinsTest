#!/usr/bin/env groovy

try {
    pipeline {
                agent any

                stages {
                        stage('build') {
                            steps {
                                script { 
                                    echo 'pipelineJobTryTest'
                                }
                            }
                        }
                        stage('test1') {
                                steps {
                                    script {
                                        echo "JOB NAME: ${env.JOB_NAME}"
                                        echo "WORKSPACE: ${env.WORKSPACE}"
                                    }
                                }
                        }
                }
        }
} catch (exc) {
    echo 'Something failed, I should sound the klaxons!'
    currentBuild.result = 'FAILEDZZZZ'
    stage('notify') {
                                steps {
                                        script {
                                                if (currentBuild.currentResult) {
                                                        echo "${env.JOB_NAME} status is: '${currentBuild.currentResult}'\nMessage is: '${env.message}'"
                                                } else {
                                                        echo "${env.JOB_NAME} status is unknown"
                                                }
                                        }
                                }
                        }
}