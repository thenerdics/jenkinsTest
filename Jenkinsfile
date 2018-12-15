#!/usr/bin/env groovy 
 

pipeline {
        agent any
            stages {
                    stage('build') {
                        steps {
                            catchError {
                                script { 
                                    echo 'pipelineJobTryTest'
                                    sh '''
                                    GIT_AUTHOR=$(git log | grep -v1 "$GIT_COMMIT" | grep -m1 -e "Author" | tr -d ":,<,>")
                                    ./test1.sh "$GIT_AUTHOR"
                                    '''
                                    env.message = "The build worked, oay!\nWell done ${env.GIT_AUTHOR}"
                                }
                            }
                        }
                    }
                    stage('test1') {
                            steps {
                                catchError {
                                    script {
                                        echo "JOB NAME: ${env.JOB_NAME}"
                                        if (env.message =~ "Yay"){
                                            echo "The message contains the correct words"
                                        } else {
                                            env.message = "The message has unknown syntax??"
                                            echo env.message
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
                            echo "${env.JOB_NAME}'s status is a ${currentBuild.currentResult}"
                            echo "${env.JOB_NAME} status is: '${currentBuild.currentResult}'\nMessage is: \n'${env.message}'"
                    } else {
                            echo "${env.BUILD_NAME}'s status is a ${currentBuild.currentResult}"
                            echo "${env.JOB_NAME} error: ${env.message}"
                            sh 'printenv'
                    }
            }
        }
    }
}




