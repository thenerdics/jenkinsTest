job('example') {
    stage('notifications') {
            notifications {
                endpoint( 'http://localhost', 'TCP', 'XML') {
                    event('started')
                    timeout(60)
                    logLines(100)
                }
            }
    }
}