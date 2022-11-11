package com.masai.exception;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

 private LocalDateTime timestamp;
 private String message;
 private String details;

}