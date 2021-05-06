package de.novatec.niko.survey.controller

import de.novatec.niko.survey.SurveySender
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SurveyController(val surveySender: SurveySender) {

  @PostMapping("/survey")
  fun sendSurvey(): ResponseEntity<Void> {
    surveySender.send()
    return ResponseEntity.noContent().build()
  }
}
