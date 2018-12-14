#!/usr/bin/env groovy 
 

pipeline {
        agent any
            stages {
                    stage('build') {
                        steps {
                            catchError {
                                script { 
                                    echo 'pipelineJobTryTest'
                                }
                            }
                        }
                    }
                    stage('test1') {
                            steps {
                                catchError {
                                    script {
                                        echo "JOB NAME: ${env.JOB_NAME}"
                                        echo "WORKSPACE: ${env.WORKSPACE}"
                                    }
                                }
                            }
                    }
            }

    post {
        failure {
            echo 'Something failed'
            currentBuild.result = 'FAILEDZZZZ'
        }
        always {
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




