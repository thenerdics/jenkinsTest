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
                scm {
                    git url ('git@github.com:thenerdics/jenkinsTest.git') 
                    remote {
                        github('thenerdics/jenkinsTest', 'ssh')
                        credentials('github-ci-key')
                    }
            }
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