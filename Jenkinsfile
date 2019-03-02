node {
    stage('Hello world test'){
        echo "This is a test"
    }
    stage('Maven test'){
        checkout scm
        sh( script: 'ls', returnStdout: true )
        sh '''
        cat pom.xml | grep -i "groupid" -A3 | grep -i "version"
        '''
    }
}