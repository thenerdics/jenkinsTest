#!/usr/bin/env groovy 
 

pipeline {
        agent any
            stages {
                    stage('build') {
                        steps {
                            catchError {
                                script { 
                                    echo 'pipelineJobTryTest'
                                    env.message = "The build worked\nYay!"
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
                                        if (env.message =~ "Yay"){
                                            echo "The message contains the correct words"
                                        } else {
                                            echo "The message has unknown syntax??"
                                            currenBuild.result = 'FAIL'
                                        }
                                    }
                                }
                            }
                    }
            }

    post {
        failure {
            echo 'Something failed'
        }
        always {
            script {
                    if (currentBuild.currentResult == 'SUCCESS') {
                            echo "${BUILD_NAME}'s status is a ${currentBuild.currentResult}"
                            echo "${env.JOB_NAME} status is: '${currentBuild.currentResult}'\nMessage is: \n'${env.message}'"
                    } else {
                            echo "${BUILD_NAME}'s status is a ${currentBuild.currentResult}"
                            echo "${env.JOB_NAME} status is unknown"
                    }
            }
        }
    }
}




