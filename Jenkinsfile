pipeline {
    agent any
    tools { 
        maven 'jenkins-mani' 
        
    }
    stages {
        stage ('Initialize') {
            steps {
                checkout scm
                sh '''
                    mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.majorVersion}.\\${parsedVersion.nextMinorVersion}.\\${parsedVersion.nextIncrementalVersion} versions:commit
                ''' 
                version = sh "mvn build-helper:parse-version | grep Building | cut -d ' ' -f4"
                println "Updated to version: ${version}"
            }
        }

        stage ('Build') {
            steps {
                echo 'This is a minimal pipeline.'
            }
        }
    }
}