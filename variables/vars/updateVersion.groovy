#!/usr/bin/env groovy

def increment(){
    sh '''
    echo "Incrementing"
        git checkout mavenTest
        mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.majorVersion}.\\${parsedVersion.nextMinorVersion}.\\${parsedVersion.nextIncrementalVersion} versions:commit
    ''' 
}
return this