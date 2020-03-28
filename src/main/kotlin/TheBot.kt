import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.objects.Update

class TheBot(private val handler: UserAnswerHandler): TelegramLongPollingBot() {

    override fun getBotUsername(): String {
        return "SenyaTheBot"
    }

    override fun getBotToken(): String {
        return Settings.botToken
    }

    override fun onUpdateReceived(update: Update) {
        handler.processAnswer(update, this)
    }
}