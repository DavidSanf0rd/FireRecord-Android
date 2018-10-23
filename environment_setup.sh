#
#           Circle CI & gradle.properties live in harmony
#
# Android convention is to store your API keys in a local, non-versioned
# gradle.properties file. Circle CI doesn't allow users to upload pre-populated
# gradle.properties files to store this secret information, but instead allows
# users to store such information as environment variables.
#
# You must execute this script via your circle.yml as a pre-process dependency,
# so your gradle build process has access to all variables.
#
#   dependencies:
#       pre:
#        - source environmentSetup.sh && copyEnvVarsToGradleProperties

#!/usr/bin/env bash

function copyEnvVarsToGradleProperties {
    GRADLE_PROPERTIES=$HOME"/.gradle/gradle.properties"
    export GRADLE_PROPERTIES
    echo "Gradle Properties should exist at $GRADLE_PROPERTIES"

    if [ ! -f "$GRADLE_PROPERTIES" ]; then
        echo "Gradle Properties does not exist"

        mkdir -p $HOME"/.gradle/"
        echo "Creating Gradle Properties file..."
        touch $GRADLE_PROPERTIES

        echo "Writing TEST_API_KEY to gradle.properties..."
        echo "bintray_user=$BINTRAY_USER" >> $GRADLE_PROPERTIES
        echo "bintray_apikey=$BINTRAY_APIKEY" >> $GRADLE_PROPERTIES
        echo "bintray_gpg_pass=$BINTRAY_GPG_PASS" >> $GRADLE_PROPERTIES
    fi
}