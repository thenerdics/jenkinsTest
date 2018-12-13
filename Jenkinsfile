job('example') {
    notifications {
        endpoint( 'http://localhost:8080/monitor', 'TCP', 'XML') {
            event('started')
            timeout(60000)
            logLines(100)
        }
    }
}