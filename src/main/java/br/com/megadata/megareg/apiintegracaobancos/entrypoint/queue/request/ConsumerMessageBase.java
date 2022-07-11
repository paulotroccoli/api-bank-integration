package br.com.megadata.megareg.apiintegracaobancos.entrypoint.queue.request;

import java.beans.ConstructorProperties;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ConsumerMessageBase<T> {

    @JsonProperty("msg")
    private final T value;

    @ConstructorProperties({"msg"})
    ConsumerMessageBase(final T msg) {

        this.value = msg;
    }
}