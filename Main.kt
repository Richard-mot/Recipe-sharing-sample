import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.features.StatusPages.Configuration
import io.ktor.features.StatusPages.StatusPageException
import io.ktor.features.StatusPages.status
import io.ktor.http.HttpStatusCode
import io.ktor.jackson.jackson
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun Application.module() {
    install(ContentNegotiation) {
        jackson { }
    }

    install(StatusPages) {
        exception<StatusPageException> { cause ->
            call.respond(cause.statusCode, cause.localizedMessage)
        }
    }

    routing {
        route("/users") {
            post {
                val user = call.receive<User>()
                Database.users.add(user)
                call.respond(HttpStatusCode.Created, "User created successfully")
            }
        }

        route("/recipes") {
            post {
                val recipe = call.receive<Recipe>()
                Database.recipes.add(recipe)
                call.respond(HttpStatusCode.Created, "Recipe created successfully")
            }

            get {
                call.respond(Database.recipes)
            }
        }
    }
}

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}
