pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            label 'my-defined-label'
            args  '-v /tmp:/tmp'
        }
    }
    stage('initialise'){
        echo "hello world"
        sh '''
            mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.nextMajorVersion}.0.0 versions:commit
        '''
    }
}