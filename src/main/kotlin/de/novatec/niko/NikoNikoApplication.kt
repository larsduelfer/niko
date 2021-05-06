package de.novatec.niko

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication @ServletComponentScan @EnableScheduling class NikoApplication

fun main(args: Array<String>) {
  runApplication<NikoApplication>(*args)
}
