package br.com.letscode.config.validation;

public class ValidationErrorHandler {

    // @Autowired
    // private MessageSource messageSource;

    // @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public List<FormErrorDto> handle(MethodArgumentNotValidException exception) {
    // List<FormErrorDto> dto = new ArrayList<>();
    // List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

    // fieldErrors.forEach(e -> {
    // String message = messageSource.getMessage(e,
    // LocaleContextHolder.getLocale());
    // FormErrorDto error = new FormErrorDto(e.getField(), message);
    // dto.add(error);
    // });
    // return dto;
    // }

}