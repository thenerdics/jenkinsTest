node {
    stage('Example') {
        try {
            curl http://localhost:8080
        }
        catch (exc) {
            echo 'Something failed, I should sound the klaxons!'
            throw
        }
    }
}
