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
                    version=\${mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate \
                        -Dexpression=project.version | grep Building | grep -e "[0-9].[0-9].[0-9]" | cut -d " " -f4}
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