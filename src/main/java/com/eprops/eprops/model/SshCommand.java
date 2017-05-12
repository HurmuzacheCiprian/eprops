package com.eprops.eprops.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SshCommand {
    private String command;
    private String environment;
    private String user;
    private String password;
}
