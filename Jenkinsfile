node {
    stage('Install Maven'){
        echo "Hello World"
        sh '''
        curl -O http://mirrors.ibiblio.org/apache/maven/maven-3/3.2.5/binaries/apache-maven-3.2.5-bin.tar.gz
        sudo tar xzf apache-maven-3.2.5-bin.tar.gz -C /usr/local
        cd /usr/local
        ln -s apache-maven-3.2.5 maven
        cd $HOME
        '''
    }
    stage('Maven test'){
        dir('usr/local')
        checkout scm
        sh( script: 'printenv', returnStdout: true )
        sh( script: 'mvn -version', returnStdout: true )
    }
}