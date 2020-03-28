package http

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.telegram.telegrambots.meta.api.objects.ApiResponse
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update


class MessageService(private val httpClient: HttpClient) {

    suspend fun getUpdates(): Array<Update> {
        val url = "${Settings.fullBotApi}getUpdates"
        val response = httpClient.get<ApiResponse<Array<Update>>>(url)

        return if (response.ok) response.result else emptyArray()
    }

    suspend fun sendMessage(text: String, chatId: String): Message {
        val url = "${Settings.fullBotApi}sendMessage"
        val response = httpClient.get<ApiResponse<Message>>(url) {
            parameter("text", text)
            parameter("chat_id", chatId)
        }

        return if (response.ok) response.result else Message()
    }
}