#!/usr/bin/env groovy

node {
    
    
        try {
                stage('Build') {
                    sh '''
                BUILD=$(curl http://localhost:8080/api/json?tree=result | grep -i "success")
                echo $BUILD
                '''
                } 
            } catch (exc) {
                echo 'Something failed, I should sound the klaxons!'
                currentBuild.result = 'FAILEDZZZZ'
            }
        stage('Test') {
             echo "currentBuild.result1: '${currentBuild.result}'"
        }
}
