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
                def env.name = "${params.name}"
                def env.password = "${params.password}"
                sh 'printenv'
                sh "echo $GIT_BRANCH"
                dir('jenkinsTest'){
                sh 'touch hello.txt'
                sh 'echo "Hello" >> hello.txt'
                sh """
                    git config user.email manvirbrar1988@gmail.com
                    git config user.name $name
                    git config user.password $password
                    """
                    sh 'git add .'
                sh 'git commit -am "test jenkins 2"'
                sh('git push https://${GIT_USERNAME}:${GIT_PASSWORD}@<REPO>')
                }
            }
        }
    }
}