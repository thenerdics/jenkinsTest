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
                    echo "Version has been updated to $version"
                    echo "M2_HOME = ${M2_HOME}"
                    mvn -version
                ''' 
                sh 'version=\${ mvn build-helper:parse-version | grep Building | cut -d " " -f4 }'
            }
        }

        stage ('Build') {
            steps {
                echo 'This is a minimal pipeline.'
            }
        }
    }
}