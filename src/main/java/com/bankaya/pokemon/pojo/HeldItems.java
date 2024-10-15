package com.bankaya.pokemon.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HeldItems {
    private Item item;
    @JsonProperty("version_details")
    private VersionDetails[] versionDetails;
}
