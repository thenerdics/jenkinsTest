node {
    stage('Install Maven'){
        echo "Hello World"
        sh '''
        mvn -version
        '''
    }
    stage('Maven test'){
        dir('usr/local')
        checkout scm
        sh( script: 'printenv', returnStdout: true )
        sh( script: 'mvn -version', returnStdout: true )
    }
}