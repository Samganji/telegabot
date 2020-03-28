import com.google.gson.FieldNamingPolicy
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.routing.routing
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.meta.TelegramBotsApi

fun Application.main() {
    install(DefaultHeaders)
    install (ContentNegotiation) {
        gson { setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES) }
    }

    initializeBot()
    val httpClient = HttpClient(Apache) {
        install(JsonFeature) {
            serializer = GsonSerializer {
                setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            }
        }
    }

    routing {

    }
}

fun initializeBot() {
    ApiContextInitializer.init()
    val botsApi = TelegramBotsApi()
    botsApi.registerBot(TheBot())
}
