package de.novatec.niko.registration.handler

import com.slack.api.bolt.context.builtin.SlashCommandContext
import com.slack.api.bolt.handler.builtin.SlashCommandHandler
import com.slack.api.bolt.request.builtin.SlashCommandRequest
import de.novatec.niko.registration.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class JoinCommandHandler(val userRepository: UserRepository) : SlashCommandHandler {

  override fun apply(req: SlashCommandRequest, context: SlashCommandContext) =
      context.ack(join(req))

  private fun join(req: SlashCommandRequest) =
      if (userRepository.isRegistered(req.payload.userId)) {
        "Hey ${req.payload.userName}! Remember? You already joined :grinning:"
      } else {
        userRepository.registerUser(req.payload.userId)
        "Hi ${req.payload.userName}! Welcome to Niko Niko :grinning:"
      }
}
