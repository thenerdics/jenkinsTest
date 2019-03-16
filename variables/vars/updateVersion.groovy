#!/usr/bin/env groovy

def mavenIncrement(choice, hotfix){
    echo "================ Incrementing maven pom file ================"
    currentVersion = sh (script: "mvn org.apache.maven.plugins:maven-help-plugin:3.1.0:evaluate -Dexpression=project.version -q -DforceStdout", returnStdout: true)
    echo "The maven project is currently on version ${currentVersion}\nUpdating..."
    if (choice == 'major'){
        sh '''
            mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.nextMajorVersion}.0.0 versions:commit
        '''
    } else if (choice == 'minor'){
        sh '''
            mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.majorVersion}.\\${parsedVersion.nextMinorVersion}.0 versions:commit
        '''
    } else if (choice == 'patch'){
        sh '''
            mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.majorVersion}.\\${parsedVersion.minorVersion}.\\${parsedVersion.nextIncrementalVersion} versions:commit
        '''
    } else if (choice == 'hotfix'){
        def MESSAGE = "${hotfix}"
        sh"""
            mvn build-helper:parse-version versions:set -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.incrementalVersion}-"${MESSAGE}" versions:commit
        """
    }
    echo "================ Incrementing maven pom file complete ================"
}

def npmIncrement(choice){
    echo "================ Incrementing nodejs package.json ================"
        if (choice == 'major'){
            sh 'npm version major'
        }else if (choice == 'minor'){
            sh 'npm version minor'
        }else if (choice == 'patch'){
            sh 'npm version patch'
        }else if (choice == "hotfix"){
            sh 'npm version prepatch'
        }
    echo "================ Incrementing nodejs package.json complete ================"
}

// def mvnIncrement(major,minor,patch){
//         sh '''
//             mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.major}.\\${parsedVersion.minor}.\\${parsedVersion.patch} versions:commit
//         ''' 
// }

return this