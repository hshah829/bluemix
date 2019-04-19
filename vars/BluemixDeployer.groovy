def call(environment) {
deploymentCommand = deploymentCommand + 'cf push -f ' + '$WORKSPACE/config/dev/manifest.yml '
}
