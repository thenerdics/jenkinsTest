#!/usr/bin/env groovy

def mavenIncrement(choice){
    echo "================ Incrementing maven pom file ================"
    if (choice == 'major'){
        sh 'mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.nextMajorVerion}.0.0} versions:commit'
    }else if (choice == 'minor'){
        sh 'mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.majorVerion}.\\${parsedVersion.nextMinorVersion}.0} versions:commit'
    }else if (choice == 'patch'){
        sh 'mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.majorVerion}.\\${parsedVersion.minorVersion}.\\${parsedVersion.nextIncrementalVersion}} versions:commit'
    }
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
    sh 'cat ./package.json'
}

def mvnIncrement(major,minor,patch){
        sh '''
            mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.major}.\\${parsedVersion.minor}.\\${parsedVersion.patch} versions:commit
        ''' 
}

return this