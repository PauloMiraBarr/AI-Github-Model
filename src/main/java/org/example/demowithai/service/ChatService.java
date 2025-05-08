package org.example.demowithai.service;

import com.azure.ai.inference.ChatCompletionsClient;
import com.azure.ai.inference.ChatCompletionsClientBuilder;
import com.azure.ai.inference.models.*;
import com.azure.core.credential.AzureKeyCredential;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ChatService {

    private final ChatCompletionsClient client;

    public ChatService() {
        String key = System.getenv("AZURE_KEY");
        String endpoint = "https://models.github.ai/inference";

        this.client = new ChatCompletionsClientBuilder()
                .credential(new AzureKeyCredential(key))
                .endpoint(endpoint)
                .buildClient();
    }

    public String chat(String userPrompt, String modelName) {
        List<ChatRequestMessage> messages = Arrays.asList(
                new ChatRequestSystemMessage("You are a helpful assistant."),
                new ChatRequestUserMessage(userPrompt)
        );

        ChatCompletionsOptions options = new ChatCompletionsOptions(messages);
        options.setModel(modelName);

        /* Ahora imagine que por default quieres que sea gpt la que responda,
        * La linea de arriba lo cambiamos por lo siguiente:
        * String selectedModel = (modelName == null || modelName.isBlank())
        *       ? "openai/gpt-4.1-nano"
        *       : modelName;
        * */

        ChatCompletions completions = client.complete(options);

        if (completions.getChoices() != null && !completions.getChoices().isEmpty()) {
            return completions.getChoices().get(0).getMessage().getContent();
        } else {
            return "No se recibió respuesta del modelo.";
        }
    }
}
