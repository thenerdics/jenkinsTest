#!/usr/bin/env groovy

def gitUrl = 'https://github.com/thenerdics/jenkinsTest.git'

pipeline {
agent any
  stages {
     stage('hello world') {
        
        steps {
        
        git branch: 'gitUpdateTest',
        credentialsId: 'thenerdics',
        url: "${gitUrl}"
        
        sh 'git checkout gitUpdateTest'
        sh 'rm -rf ./*'
        sh 'touch hello213.txt'
        sh 'echo "hello world2"'
        sh 'git add hello213.txt'
        sh 'git commit -m "jenkinsPush"'
        sh 'git push origin gitUpdateTest'
        }
     }
     stage('second'){
        steps{
            sh 'cat hello.txt'
        }
     }

  }
  post {
    success {
        setBuildStatus("Build succeeded", "SUCCESS");
    }
    failure {
        setBuildStatus("Build failed", "FAILURE");
    }
  }
}