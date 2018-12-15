#!/usr/bin/env groovy 
 

pipeline {
        agent any
            stages {
                    stage('build') {
                        steps {
                            catchError {
                                script { 
                                    echo 'pipelineJobTryTest'
                                    sh 'GIT_AUTHOR=$(git log | grep -v1 "$GIT_COMMIT" | grep -m1 -e "Author" | tr -d ":,<,>")'
                                    sh 'export GIT_AUTHOR=$GIT_AUTHOR'
                                    sh './test1.sh "$GIT_AUTHOR"'
                                    sh 'ruby --version'
                                    message="The build worked, Yay!\nWell done ${env.GIT_AUTHOR}"
                                }
                            }
                        }
                    }
                    stage('test1') {
                            steps {
                                catchError {
                                    retry (2) {
                                        script {
                                            echo "JOB NAME: ${env.JOB_NAME}"
                                            if (env.message =~ "Yay"){
                                                echo "The message contains the correct words"
                                            } else {
                                                message = "The message has unknown syntax??"
                                                echo message
                                                currentBuild.result = 'FAIL'
                                            }
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
                            echo "${env.JOB_BASE_NAME} status is: '${currentBuild.currentResult}'\nMessage is: \n'${message}'"
                    } else {
                            sh 'git log | grep -v1 "$GIT_COMMIT" | grep -m1 -e "Author" | tr -d ":,<,>"'
                            echo "${env.JOB_BASE_NAME}'s status is a ${currentBuild.currentResult}"
                            echo "${env.JOB_BASE_NAME} error: ${message}"
                            sh 'printenv'
                    }
            }
        }
    }
}




