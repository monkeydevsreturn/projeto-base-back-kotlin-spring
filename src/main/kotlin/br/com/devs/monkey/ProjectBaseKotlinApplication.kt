package br.com.devs.monkey

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProjectBaseKotlinApplication

fun main(args: Array<String>) {
	runApplication<ProjectBaseKotlinApplication>(*args)
}
