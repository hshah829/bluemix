import groovy.json.JsonSlurperClassic

def deploy() {
deploymentCommand = deploymentCommand + 'cf push -f ' + '$WORKSPACE/config/dev/manifest.yml '
}