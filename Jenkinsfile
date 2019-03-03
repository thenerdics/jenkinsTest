pipeline {
    agent any
    tools { 
        maven 'jenkins-mani' 
        
    }
    stages {
        stage ('Initialize') {
            steps {
                checkout scm
                def version = sh( script: 'mvn build-helper:parse-version | grep Building | grep -e "[0-9].[0-9].[0-9]" | cut -d " " -f4')
                sh '''
                    mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.majorVersion}.\\${parsedVersion.nextMinorVersion}.\\${parsedVersion.nextIncrementalVersion} versions:commit
                    echo "Version has been updated to $version"
                    echo "M2_HOME = ${M2_HOME}"
                    mvn -version
                ''' 
            }
        }

        stage ('Build') {
            steps {
                echo 'This is a minimal pipeline.'
            }
        }
    }
}