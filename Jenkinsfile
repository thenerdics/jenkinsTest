#!/usr/bin/env groovy

pipeline {
            agent any

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
                                    echo "${currentBuild.result}"
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