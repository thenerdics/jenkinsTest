node {
    stage('hello world'){
        echo "Hello World"
        sh """
         mvn build-helper:parse-version versions:set -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.nextMinorVersion}.0 versions:commit
        """
    }
}