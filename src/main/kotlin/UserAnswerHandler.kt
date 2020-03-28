import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message
import org.telegram.telegrambots.meta.api.objects.Update

class UserAnswerHandler {

    fun processAnswer(answer: Update, bot: TheBot) {
        val text = answer.message.text
        if (text.startsWith("/")) processCommand(answer.message, bot)
        else
    }
    
    fun processCommand(message: Message, bot: TheBot) {
        val chatId = message.chatId
        when (message.text) {
            "/start" -> bot.execute(
                SendMessage(chatId, "")
            )
        }
    }
}