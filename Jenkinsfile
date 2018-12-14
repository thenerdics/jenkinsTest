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
                    script {
                        env.buildmessage = 'The build was unsuccessful!\n'
                    }

                }
                success {
                    script {
                        env.buildmessage = 'The build was a success!\n'
                    }
                }
            }
        }
        
        stage('Test') {
            steps {
                    echo env.JOB_NAME
                    sh 'cd /hiht'
                
            }
            post {
            failure {
                echo "test job failed"
                env.message = 'The test was unsuccessful!\n'
                    
            }
            success {
                script {
                    env.message = "${env.buildmessage}The testing stage was a success!"
                }
                
            }
        }
        }
        
        
    }
    post {
        always {
            echo "${env.JOB_NAME} status is: '${currentBuild.currentResult}'\nMessage is:\n '${env.message}'"
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

