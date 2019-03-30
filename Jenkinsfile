#!/usr/bin/env groovy

node {
    stage('Build') {
        sh '''
            BUILD=$(curl http://localhost:8080/api/json?tree=result )
            echo $BUILD
        '''
    } 
}