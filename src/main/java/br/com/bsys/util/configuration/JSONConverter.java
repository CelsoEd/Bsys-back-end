package br.com.bsys.util.configuration;

import br.com.bsys.util.Mensagem;
import br.com.bsys.util.exception.InfraestruturaException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JSONConverter implements ContextResolver<ObjectMapper> {

    private static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";
    private static final String FORMATO_DATA = "dd/MM/yyyy";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public JSONConverter() {
        MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_DATA_HORA);
        sdf.setTimeZone(TimeZone.getDefault());

        MAPPER.setDateFormat(sdf);
        MAPPER.setTimeZone(TimeZone.getDefault());

        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addDeserializer(LocalDate.class,
                new LocalDateDeserializer(DateTimeFormatter.ofPattern(FORMATO_DATA)));
        timeModule.addSerializer(LocalDate.class, //
                new LocalDateSerializer(DateTimeFormatter.ofPattern(FORMATO_DATA)));

        timeModule.addDeserializer(LocalDateTime.class,
                new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(FORMATO_DATA_HORA)));
        timeModule.addSerializer(LocalDateTime.class,
                new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(FORMATO_DATA_HORA)));

        MAPPER.registerModule(timeModule);

        MAPPER.registerModule(new Jdk8Module());
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return MAPPER;
    }

    public static String toJSONFromObject(Object object) throws InfraestruturaException {
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new InfraestruturaException(Mensagem.ERRO_CONVERSAO_JSON);
        }
    }
}
