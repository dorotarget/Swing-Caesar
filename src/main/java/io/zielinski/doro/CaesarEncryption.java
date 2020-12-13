package io.zielinski.doro;

public class CaesarEncryption {
    
   public static String encrypt(String message, Integer offset){
        String encryptedMessage = "";
        StringBuilder encryptedMessageStringBuilder = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                encryptedMessageStringBuilder.append(newCharacter);
            } else {
                encryptedMessageStringBuilder.append(character);
            }
            
        }
        encryptedMessage = encryptedMessageStringBuilder.toString();
        return encryptedMessage;
    }
    
}
