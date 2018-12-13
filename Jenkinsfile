#!/usr/bin/env groovy

pipeline {
            agent any

            stages {
                try {
                    stage('build') {
                        steps {
                                sh 'curl '
                        }
                    }
                } catch (exc) {
                    echo 'Something failed, I should sound the klaxons!'
                    currentBuild.result = 'FAILEDZZZZ'
                }
                    stage('test1') {
                            steps {
                                    sh 'echo $TEST'
                            }
                    }
                    stage('notify') {
                            steps {
                                    script {
                                            if (currentBuild.result == 'FAILEDZZZZ') {
                                                    echo "currentBuild.result1: '${currentBuild.result}'"
                                            } else {
                                                    echo 'Build status is unknown'
                                            }
                                    }
                            }
                    }
            }
    }