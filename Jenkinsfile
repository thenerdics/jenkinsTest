#!/usr/bin/env groovy

node {
    
    
        try {
                stage('Build') {
                    sh '''
                curl http://localhost:8080/api/json?tree=result | grep -i "success"
                '''
                } 
            } catch (exc) {
                echo 'Something failed, I should sound the klaxons!'
            }
        stage('Test') {

}
