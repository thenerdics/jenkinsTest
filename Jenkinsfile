node {
    name = 'Anaya'
    stage('Hello world test'){
        echo "Hello ${name}"
    }
    stage('Maven test'){
        checkout scm
        sh( script: 'ls', returnStdout: true )
        sh '''
        cat pom.xml | grep -i "my-app" -A1 | grep -i "version" | tr -d "<version>/"
        '''
    }
}