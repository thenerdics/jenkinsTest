node {
    tools {
        maven 'jenkins-mani' 
        nodejs 'nodejs-mani'
    }
    stage('initialise'){
        dir('maven'){
            echo "hello world"
            sh '''
                mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.nextMajorVersion}.0.0 versions:commit
            '''
        }
    }
}