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

        stage('Example') {
            steps {
                echo "Hello ${params.PERSON}"

                echo "Biography: ${params.BIOGRAPHY}"

                echo "Toggle: ${params.TOGGLE}"

                echo "Choice: ${params.CHOICE}"

                echo "Password: ${params.PASSWORD}"
            }
        }

        stage('git status') {
            steps{
                mkdir -p ./test
            }
            dir('test') { 
                steps {
                    echo "Hello ${params.PERSON}" >> hello.txt

                    echo "Biography: ${params.BIOGRAPHY}" >> hello.txt

                    echo "Toggle: ${params.TOGGLE}" >> hello.txt

                    echo "Choice: ${params.CHOICE}" >> hello.txt

                    echo "Password: ${params.PASSWORD}" >> hello.txt
                }
            }
        }

    }
}