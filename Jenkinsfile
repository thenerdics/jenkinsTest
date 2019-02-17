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

        stage('git status') {
            steps {
                sh "echo $GIT_BRANCH"
                sh 'git status'
                sh 'touch hello.txt'
                sh 'echo "Hello" >> hello.txt'
                sh '''
                    git config user.email "manvirbrar1988@gmail.com"
                    git config user.name "thenerdics"
                    '''
                    sh 'git add .'
                sh 'git commit -am "test"'
                sh 'git push origin gitUpdateTest'
            }
        }
    }
}