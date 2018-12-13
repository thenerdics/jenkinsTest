node {
    stage('Example') {
        try {
            sh '''
            curl http://google.com
            '''
        }
        catch (exc) {
            echo 'Something failed, I should sound the klaxons!'
            throw
        }
    }
}
