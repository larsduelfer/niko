package de.novatec.niko.configuration

import com.slack.api.bolt.App
import com.slack.api.methods.MethodsClient
import de.novatec.niko.registration.handler.JoinCommandHandler
import de.novatec.niko.registration.handler.LeaveCommandHandler
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SlackAppConfiguration(
    val joinCommandHandler: JoinCommandHandler,
    val leaveCommandHandler: LeaveCommandHandler
) {

  @Bean
  fun initSlackApp(): App {
    val app = App()
    app.command("/join-niko", joinCommandHandler)
    app.command("/leave-niko", leaveCommandHandler)
    return app
  }

  @Bean
  fun initSlackMethodsClient(app: App): MethodsClient {
    return app.slack().methods(app.config().singleTeamBotToken)
  }
}
