    node {
      stage('Checkout') {
          sh 'git checkout $GIT_BRANCH'
          sh 'touch helloWorld.txt'
          sh 'git add .'
          sh 'git commit -m "test1"'
          sh 'git push origin gitUpdateTest'
   }
    }