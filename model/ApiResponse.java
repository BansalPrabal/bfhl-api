package com.vit.bfhl.model;

import lombok.Data;
import java.util.List;

@Data
public class ApiResponse {
    private boolean is_success;
    private String user_id;
    private String email;
    private String roll_number;
    private List<String> odd_numbers;
    private List<String> even_numbers;
    private List<String> alphabets;
    private List<String> special_characters;
    private String sum;
    private String concat_string;

    
    public void setSuccess(boolean success) { this.is_success = success; }
    public void setUserId(String userId) { this.user_id = userId; }
    public void setEmail(String email) { this.email = email; }
    public void setRollNumber(String rollNumber) { this.roll_number = rollNumber; }
    public void setOddNumbers(List<String> oddNumbers) { this.odd_numbers = oddNumbers; }
    public void setEvenNumbers(List<String> evenNumbers) { this.even_numbers = evenNumbers; }
    public void setAlphabets(List<String> alphabets) { this.alphabets = alphabets; }
    public void setSpecialCharacters(List<String> specialChars) { this.special_characters = specialChars; }
    public void setSum(String sum) { this.sum = sum; }
    public void setConcatString(String concatString) { this.concat_string = concatString; }
}
