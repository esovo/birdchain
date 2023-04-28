pipeline {
  agent any

  stages {

    stage('init'){
      steps{
        sh "echo init"
      }
    }

    stage('Vue.js Image Build') {
      steps {
        script {
          def frontendDir = "${env.WORKSPACE}/frontend/vue3pwa"
          def dockerfile = "${frontendDir}/Dockerfile"
          docker.build("birdchain-front:${env.BUILD_NUMBER}", "-f ${dockerfile} ${frontendDir}")
        }
      }
    }

    stage('Remove Container') {
      steps {
        script {
          try {
            sh 'docker ps -f name=frontend -q | xargs --no-run-if-empty docker container stop'
            sh 'docker container ls -a -f name=frontend -q | xargs -r docker container rm'
          } catch (err) {
            echo "Failed to stop the container"
          }
        }
      }
    }
    
    stage('Run Container') {
      steps {
        script {
          docker.image("birdchain-front:${env.BUILD_NUMBER}").run("--name frontend -p 3000:80")
        }
      }
    }
  }
}
