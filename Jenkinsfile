#!/usr/bin/env groovy

pipeline {
            agent { label 'Steps-runner'}

            stages {
                    stage('build') {
                        steps {
                            script { 
                                try {
                                    echo "${currentBuild.currentResult}"
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
                                                    echo "${env.JOB_NAME}: '${currentBuild.currentResult}'"
                                            } else {
                                                    echo 'Build status is unknown'
                                            }
                                    }
                            }
                    }
            }
    }