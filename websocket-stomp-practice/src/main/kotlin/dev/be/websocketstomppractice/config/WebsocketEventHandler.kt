package dev.be.websocketstomppractice.config

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionConnectEvent
import org.springframework.web.socket.messaging.SessionConnectedEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent
import org.springframework.web.socket.messaging.SessionSubscribeEvent
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent

@Component
class WebsocketEventHandler {
    private val logger = KotlinLogging.logger{}

    @EventListener
    fun handleWebsocketSessionConnectEventListener(event: SessionConnectEvent) {
        logger.info {">>> Received a SessionConnectEvent"}
    }

    @EventListener
    fun handleWebsocketSessionSubscribeEventListener(event: SessionSubscribeEvent) {
        logger.info {">>> Received a SessionSubscribeEvent"}
    }

    @EventListener
    fun handleWebsocketSessionUnsubscribeEventListener(event: SessionUnsubscribeEvent) {
        logger.info {">>> Received a SessionUnsubscribeEvent"}
    }

    @EventListener
    fun handleWebsocketSessionConnectedEventListener(event: SessionConnectedEvent) {
        logger.info {">>> Received a SessionConnectedEvent"}
    }

    @EventListener
    fun handleWebsocketSessionDisconnectedEventListener(event: SessionDisconnectEvent) {
        logger.info {">>> Received a SessionDisconnectEvent"}
    }
}