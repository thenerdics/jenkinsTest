#!/usr/bin/env groovy

node {
    
    
        try {
                stage('Build') {
                    steps {
                            script {
                                    if (env.BRANCH_NAME == 'master') {
                                            echo 'I only execute on the master branch'
                                    } else {
                                            echo 'I execute elsewhere'
                                    }
                            }
                    }
                } 
            } catch (exc) {
                echo 'Something failed, I should sound the klaxons!'
                currentBuild.result = 'FAILEDZZZZ'
            }
        stage('Test') {
             echo "currentBuild.result1: '${currentBuild.result}'"
        }
}
