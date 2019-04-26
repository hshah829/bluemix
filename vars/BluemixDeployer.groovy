def call(environment) {
   
sh 'cf cups slog_2_splunk -l syslog://172.00.74.78:9733'
sh 'cf uups slog_2_splunk -l syslog://100.16.74.78:4444'
deploymentCommand = 'cf push -f ' + '$WORKSPACE/config/dev/manifest.yml '
sh deploymentCommand
sh 'cf bind-service h123test slog_2_splunk'
sh 'cf set-env h123test CONFIG_OAUTH_PROFILE uat'
sh 'cf add-plugin-repo CF-Community https://plugins.cloudfoundry.org/'
sh 'cf map-route h123test     kp-cdo-cfee-sandbox-clus.us-south.containers.appdomain.cloud -n  dev-h123test'
sh 'cf restage h123test'
sh 'cf stop h123test'
sh 'cf start h123test'
sh 'unbind-service h123test slog_2_splunk -f'
sh 'delete-service h123test slog_2_splunk -f'  
sh 'cf delete-route kp-cdo-cfee-sandbox-clus.us-south.containers.appdomain.cloud  -n dev-h123test -f'
sh 'cf delete h123test -f'  
}
