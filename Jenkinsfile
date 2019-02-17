#!/usr/bin/env groovy

pipeline {
    agent any
    parameters {
        string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')

        text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')

        booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')

        choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')

        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')

        file(name: "FILE", description: "Choose a file to upload")
    }
    stages {
        stage('Checkout') {
            git branch: "${GIT_BRANCH}", credentialsId: '82aa2d26-ef4b-4a6a-a05f-2e1090b9ce17', url: 'https://github.com/thenerdics/jenkinsTest.git'
        }
        stage('git status') {
            steps {
                sh 'printenv'
                sh "echo $GIT_BRANCH"
                dir('jenkinsTest'){
                sh 'touch hello.txt'
                sh 'echo "Hello" >> hello.txt'
                sh '''
                    git config user.email "$GIT_AUTHOR_EMAIL"
                    git config user.name "thenerdics"
                    git config user.password "$PASSWORD"
                    '''
                    sh 'git add .'
                sh 'git commit -am "test jenkins 2"'
                sh 'git push jenkinsTest refs/head/$GIT_BRANCH'
                }
            }
        }
    }
}