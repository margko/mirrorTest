/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Hello World!") {
    container(displayName = "Say Hello", image = "hello-world")
}
job("Notification on developer branch updte") {
    container() {
        kotlinScript { api ->
            val recipient = MessageRecipient.Channel(ChatChannel.FromName("devs"))
            val content = ChatMessage.Text("Some message text!")
            api.space().chats.messages.sendMessage(recipient, content)

        }
    }
}
