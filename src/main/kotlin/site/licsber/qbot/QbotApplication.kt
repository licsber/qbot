package site.licsber.qbot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class QbotApplication

fun main(args: Array<String>) {
    runApplication<QbotApplication>(*args)
}
