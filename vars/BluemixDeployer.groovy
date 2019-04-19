def call(environment) {
deploymentCommand = 'cf push -f ' + '$WORKSPACE/config/dev/manifest.yml '
sh deploymentCommand
}
