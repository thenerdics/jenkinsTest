job('example') {
    stage('notifications') {
            notifications {
                endpoint( 'http://localhost:8080/monitor', 'TCP', 'XML') {
                    event('started')
                    timeout(60)
                    logLines(50)
                }
            }
    }
}