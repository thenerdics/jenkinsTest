#!/usr/bin/env groovy
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                   sh ''' 
                   ls /
                   '''
                }
            }
            post {
                failure {
                    echo "build job failed"
                }
                success {
                    env.message = 'The build was a success!\n'
                }
            }
        }
        
        stage('Test') {
            steps {
                
                    echo env.JOB_NAME
                    echo "hello"
                
            }
            post {
            failure {
                echo "test job failed"
            }
            success {
                env.message = env.message + 'The testing stage was a success'
            }
        }
        }
        
        
    }
    post {
        always {
            echo "${env.JOB_NAME} status is: '${currentBuild.currentResult}'\nMessage is: '${env.message}'"
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

