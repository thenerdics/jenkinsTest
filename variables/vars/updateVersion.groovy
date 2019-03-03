#!/usr/bin/env groovy

def mavenIncrement(choice){
    echo "================ Incrementing maven pom file ================"
    if (choice == 'major'){
        mvnIncrement "nextMajorVersion" "0" "0"
    }else if (choice == 'minor'){
        sh 'mvnIncrement("majorVersion","nextMinorVersion","0")'
    }else if (choice == 'patch'){
        sh 'mvnIncrement("majorVersion","nextMinorVersion","nextIncrementVersion")'
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

def mvnIncrement(){
        sh '''
            mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.$1}.\\${parsedVersion.$2}.\\${parsedVersion.$3} versions:commit
        ''' 
}

return this