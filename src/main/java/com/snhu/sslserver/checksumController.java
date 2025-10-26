package com.snhu.sslserver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class checksumController {

    private static final Pattern SHA256_PATTERN = Pattern.compile("^[a-fA-F0-9]{64}$");

    @GetMapping("/checksum")
    public String getChecksum() {
        String data = "Lance Tran";
        return generateSha256Hash(data);
    }
    
    @GetMapping("/hash")
    public String myHash(@RequestParam(required = false) String expectedHash) {
        String data = "Lance Tran";
        String hexHash = generateSha256Hash(data);
        
        StringBuilder response = new StringBuilder();
        response.append("<p>data: ").append(data).append("</p>");
        response.append("<p>Name of Cipher Used: SHA-256 </p>"
        		+ "<p> Value: ").append(hexHash).append("</p>");
        
        if (expectedHash != null) {
            if (!SHA256_PATTERN.matcher(expectedHash).matches()) {
                response.append("<h3>External Hash Match Status:</h3>");
                response.append("<p>Error: Invalid hash format provided. Please enter a valid 64-character hexadecimal string.</p>");
            } else {
                boolean matches = hexHash.equalsIgnoreCase(expectedHash);
                response.append("<h3>External Hash Match Status:</h3>");
                response.append("<p>")
                        .append(matches ? "Hashes MATCH!" : "Hashes DO NOT MATCH!")
                        .append("</p>");
            }
        }
        
        return response.toString();
    }
    
    private String generateSha256Hash(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes());
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            // Internal error report
            System.err.println("SHA-256 algorithm not available: " + e.getMessage());
            // User-readable error
            return "Error: Unable to generate hash. Please contact support.";
        }
    }
    
    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}