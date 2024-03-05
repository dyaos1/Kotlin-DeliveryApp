package dev.be.websocketpractice

import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

class HelloWebsocketHandler: TextWebSocketHandler() {
    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        // super.afterConnectionClosed(session, status)
        println(">>> Connection Closed: ${session.id}")
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println(">>> Received Message ${message}")
        super.handleTextMessage(session, message)
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        println(">>> Client Connected: ${session.id}")
        // super.afterConnectionEstablished(session)
    }

    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        println(">>> Error: ${session.id}, ${exception.message}")
        // super.handleTransportError(session, exception)
    }
}