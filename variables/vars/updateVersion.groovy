#!/usr/bin/env groovy

def mavenIncrement(){
    echo "================ Incrementing maven pom file ================"
    sh '''
        git checkout mavenTest
        mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.majorVersion}.\\${parsedVersion.nextMinorVersion}.\\${parsedVersion.nextIncrementalVersion} versions:commit
    ''' 
}

def npmIncrement(choice){
    echo "================ Incrementing nodejs package.json ================"
        if (choice == 'major'){
            sh 'npm version major'
        }else if (choice == 'minor'){
            sh 'npm version minor'
        }else if (choice == 'patch'){
            sh 'npm version patch'
        }
}

return this