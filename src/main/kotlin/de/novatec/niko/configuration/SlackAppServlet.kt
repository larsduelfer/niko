package de.novatec.niko.configuration

import com.slack.api.bolt.App
import com.slack.api.bolt.servlet.SlackAppServlet
import javax.servlet.annotation.WebServlet

@WebServlet("/slack/events") class SlackAppServlet(app: App) : SlackAppServlet(app)
