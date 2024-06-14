pipeline {
 agent any
 stages {
    stage("build") {
         steps {
             bat 'docker build -t auto09:1.0.0 .'
         }
    }
     stage("test") {
         steps {
             bat 'docker run auto09:1.0.0 clean apiFeatures -Ptags="@Calculator"'
         }
     }
     stage("deploy") {
         steps {
             bat 'echo deploying'
         }
     }
 }
}
