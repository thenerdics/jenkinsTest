#!/usr/bin/env groovy

pipeline {
            agent any

            stages {
                    stage('build') {
                        steps {
                            script { 
                                try {
                                    env.message = "HELLO MARC MATE,\n IT'S FERDI"
                                    echo "${message}"
                                } catch (exc) {
                                    echo 'Something failed, I should sound the klaxons!'
                                    currentBuild.result = 'FAILEDZZZZ'
                                }
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
                    stage('notify') {
                            steps {
                                    script {
                                            if (currentBuild.currentResult) {
                                                    echo "${env.JOB_NAME} status is: '${currentBuild.currentResult}'"
                                                    echo "Message is is: '${env.message}'"
                                            } else {
                                                    echo "${env.JOB_NAME} status is unknown"
                                            }
                                    }
                            }
                    }
            }
    }