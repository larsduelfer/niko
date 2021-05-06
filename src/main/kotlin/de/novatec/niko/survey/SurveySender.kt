package de.novatec.niko.survey

import com.slack.api.methods.MethodsClient
import com.slack.api.methods.kotlin_extension.request.chat.blocks
import com.slack.api.methods.request.chat.ChatPostMessageRequest
import de.novatec.niko.registration.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class SurveySender(val methodsClient: MethodsClient, val userRepository: UserRepository) {

  fun send() {
    userRepository.getUsers().forEach { methodsClient.chatPostMessage(surveyMessage(it)) }
  }

  fun surveyMessage(userId: String): ChatPostMessageRequest =
      ChatPostMessageRequest.builder().channel(userId).surveyMessage().build()

  private fun ChatPostMessageRequest.ChatPostMessageRequestBuilder.surveyMessage() = blocks {
    section { markdownText("*How is your mood today?*") }
    divider()
    actions {
      button {
        actionId("survey-answer-happy")
        text("Happy", emoji = true)
        value("1")
      }
      button {
        actionId("survey-answer-neutral")
        text("Neutral", emoji = true)
        value("2")
      }
      button {
        actionId("survey-answer-sad")
        text("Sad :sad:", emoji = true)
        value("3")
      }
    }
  }
}
