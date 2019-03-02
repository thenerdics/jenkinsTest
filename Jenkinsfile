node {
    def 
    stage('Hello world test'){
        echo "Hello ${name}"
    }
    stage('Maven test'){
        checkout scm
        sh( script: 'ls', returnStdout: true )
        sh( script: 'mvn -version', returnStdout: true )

    }
}