pipeline {
    agent any {
        stages {
            stage('initialise'){
                steps {    
                    echo "hello world"
                    sh '''
                        mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.nextMajorVersion}.0.0 versions:commit
                    '''
                }
            }
        }
    }
}