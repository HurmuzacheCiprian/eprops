package com.eprops.eprops.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@Getter
public class PropertyFile {
    private Map<String, String> file = new HashMap<>();
}
