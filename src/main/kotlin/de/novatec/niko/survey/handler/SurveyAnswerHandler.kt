package de.novatec.niko.survey.handler

import com.slack.api.bolt.context.builtin.ActionContext
import com.slack.api.bolt.handler.builtin.BlockActionHandler
import com.slack.api.bolt.request.builtin.BlockActionRequest
import com.slack.api.bolt.response.Response

//class SurveyAnswerHandler: BlockActionHandler {
//
//    override fun apply(req: BlockActionRequest, context: ActionContext): Response {
//        context.logger.info(req.payload.toString())
//        context.ack("Thanks for sharing your mood today");
//    }
//}