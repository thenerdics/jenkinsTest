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
                sh 'printenv'
                sh 'git clone https://github.com/thenerdics/jenkinsTest.git ||  git pull'
                sh 'git fetch'
                sh "echo $GIT_BRANCH"
                sh 'touch hello.txt'
                sh 'ls'
                sh 'echo "Hello" >> hello.txt'
                sh '''
                    ls
                    git config user.email "manvirbrar1988@gmail.com"
                    git config user.name "thenerdics"
                    '''
                    sh 'git add .'
                sh 'git commit -am "test jenkins 2"'
                sh 'git push origin jenkinsTest:$GIT_BRANCH || git push origin:$GIT_BRANCH HEAD:$GIT_BRANCH'
            }
        }
    }
}