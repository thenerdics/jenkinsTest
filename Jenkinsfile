#!/usr/bin/env groovy

pipeline {
        agent any 

    stages {
        stage('build') {
            steps {
                script {
                    sh '''
                    ls /
                    '''
                }
            }
            echo currentBuild.currentResult
        }


        stage('Job Info') {
            steps {
                echo env.JOB_NAME
            }
        }

        stage('notify') {
            steps {
                echo "${env.JOB_NAME}'s status is: ${currentBuild.currentResult}"
            }
        }

    }

}



/*
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
*/

