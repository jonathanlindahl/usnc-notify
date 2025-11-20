Small Spring application intended to be used with https://github.com/jonathanlindahl/dt-ultrasonic to get notified via Discord when a measurement has changed.

For the complete functionality, a user space app is required for the driver to send signals to. The user space app then sends a request to this api which, provided a discord app (bot) token and channel id through application.properties, will send a message via the given discord bot to the given discord channel.
