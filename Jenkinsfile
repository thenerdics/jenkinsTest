#!/usr/bin/env groovy

pipeline {
            agent any

            stages {
                    stage('build') {
                        steps {
                            script { 
                                try {
                                    echo currentBuild.rawBuild.log
                                } catch (exc) {
                                    echo 'Something failed, I should sound the klaxons!'
                                    currentBuild.result = 'FAILEDZZZZ'
                                }
                            }
                        }
                    }
                    stage('test1') {
                            steps {
                                    echo currentBuild.result
                            }
                    }
                    stage('notify') {
                            steps {
                                    script {
                                            if (currentBuild.result) {
                                                    echo "currentBuild.result1: '${currentBuild.result}'"
                                            } else {
                                                    echo 'Build status is unknown'
                                            }
                                    }
                            }
                    }
            }
    }