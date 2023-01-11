job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
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
        shell("npm install")
    }
    publishers {
	mailer('juandavidnaranjo75@gmail.com', true, true)
    }
}
