job('Aplicacion Node.js Docker DSL') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins')
    scm {
        git('https://github.com/Juan9507/nodejsapp.git', 'master') { node ->
            node / gitConfigName('juan9507')
            node / gitConfigEmail('juandavidnaranjo75@gmail.com')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('juan9507/nodejsapp')
            tag('${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
