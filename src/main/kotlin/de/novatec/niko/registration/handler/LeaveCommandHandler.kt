package de.novatec.niko.registration.handler

import com.slack.api.bolt.context.builtin.SlashCommandContext
import com.slack.api.bolt.handler.builtin.SlashCommandHandler
import com.slack.api.bolt.request.builtin.SlashCommandRequest
import de.novatec.niko.registration.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class LeaveCommandHandler(val userRepository: UserRepository) : SlashCommandHandler {

  override fun apply(req: SlashCommandRequest, context: SlashCommandContext) =
      context.ack(leave(req))

  private fun leave(req: SlashCommandRequest) =
      if (userRepository.isRegistered(req.payload.userId)) {
        userRepository.deleteUser(req.payload.userId)
        "Hey ${req.payload.userName}! Sad that you are leaving... :cry: Come join us again soon!"
      } else {
        "Hi ${req.payload.userName}! You are not registered with niko niko. Nothing to do here!"
      }
}
