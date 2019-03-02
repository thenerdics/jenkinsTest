node {
    stage('hello world'){
        echo "Hello World"
        dir('mvn'){
            sh """
                mvn -version
                mvn build-helper:parse-version versions:set -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.nextMinorVersion}.0 versions:commit
            """
        }

    }
}