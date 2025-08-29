package com.vit.bfhl.controller;

import com.vit.bfhl.model.ApiRequest;
import com.vit.bfhl.model.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/bfhl")
public class BFHLController {

    @PostMapping
    public ApiResponse handleData(@RequestBody ApiRequest request) {
        ApiResponse response = new ApiResponse();

        try {
            List<String> data = request.getData();

            List<String> evenNumbers = new ArrayList<>();
            List<String> oddNumbers = new ArrayList<>();
            List<String> alphabets = new ArrayList<>();
            List<String> specialChars = new ArrayList<>();

            int sum = 0;
            StringBuilder alphaConcat = new StringBuilder();

            for (String item : data) {
                if (item.matches("-?\\d+")) { 
                    int num = Integer.parseInt(item);
                    sum += num;
                    if (num % 2 == 0) {
                        evenNumbers.add(item);
                    } else {
                        oddNumbers.add(item);
                    }
                } else if (item.matches("[a-zA-Z]+")) { 
                    alphabets.add(item.toUpperCase());
                    alphaConcat.append(item);
                } else { 
                    specialChars.add(item);
                }
            }

            // Alternating caps reverse
            StringBuilder altCaps = new StringBuilder();
            String allAlpha = alphaConcat.toString();
            boolean upper = true;
            for (int i = allAlpha.length() - 1; i >= 0; i--) {
                char ch = allAlpha.charAt(i);
                if (upper) altCaps.append(Character.toUpperCase(ch));
                else altCaps.append(Character.toLowerCase(ch));
                upper = !upper;
            }

            // Fill response
            response.setSuccess(true);
            response.setUserId("Prabalbansal");
            response.setEmail("prabal.bansal2004@gmail.com");
            response.setRollNumber("22BEC0896");
            response.setOddNumbers(oddNumbers);
            response.setEvenNumbers(evenNumbers);
            response.setAlphabets(alphabets);
            response.setSpecialCharacters(specialChars);
            response.setSum(String.valueOf(sum));
            response.setConcatString(altCaps.toString());

        } catch (Exception e) {
            response.setSuccess(false);
        }
        return response;
    }
}
